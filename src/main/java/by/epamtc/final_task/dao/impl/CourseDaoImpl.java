package by.epamtc.final_task.dao.impl;

import by.epamtc.final_task.dao.ColumnName;
import by.epamtc.final_task.dao.CourseDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.pool.ConnectionPool;
import by.epamtc.final_task.dao.pool.exception.PoolException;
import by.epamtc.final_task.entity.Course;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The class contains query`s processing to the database for the course
 */
public class CourseDaoImpl implements CourseDao {

    private static CourseDaoImpl instance;
    private static final String INSERT_COURSE = "INSERT INTO courses (course_title, description) VALUES (?, ?)";
    private static final String INSERT_COURSE_RUN = "INSERT INTO course_run(course_id,start_course,end_course, " +
            "lecturer_id,format) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_COURSES_AVAILABLE_FOR_REGISTRATION = "SELECT course_run_id,course_title," +
            "description,materials_path,start_course,end_course,limit_students,lecturer_id,status,format FROM course_run " +
            "INNER JOIN " +
            "courses ON course_run.course_id=courses.course_id LEFT JOIN users ON course_run.lecturer_id=users.user_id " +
            "WHERE status='NOT_STARTED' LIMIT ? OFFSET ?";
    private static final String SQL_SELECT_ALL_COURSES = "SELECT course_run_id,course_title, " +
            "description,materials_path,start_course,end_course,limit_students,lecturer_id,status,format FROM course_run " +
            "INNER JOIN courses ON course_run.course_id=courses.course_id " +
            "LEFT JOIN users ON course_run.lecturer_id=users.user_id  " +
            "LIMIT ? OFFSET ?";
    private static final String SQL_SELECT_COUNT_COURSES_BY_STATUS = "SELECT course_run_id FROM course_run WHERE status=?";
    private static final String SQL_SELECT_COUNT_ALL_COURSES = "SELECT course_run_id FROM course_run";
    private static final String SQL_SELECT_INFO_BY_ID = "SELECT course_run_id,course_title, " +
            "description,materials_path,start_course,end_course,limit_students,lecturer_id,status,format FROM course_run " +
            "INNER JOIN courses ON course_run.course_id=courses.course_id " +
            "LEFT JOIN users ON course_run.lecturer_id=users.user_id " +
            "WHERE course_run.course_run_id=?";
    private static final String SQL_SELECT_COURSES_USER_BY_ID = "SELECT  lists_students.course_run_id,course_title, "+
          "description,materials_path,start_course,end_course,limit_students,lecturer_id,status,format FROM lists_students INNER JOIN course_run " +
            "ON lists_students.course_run_id=course_run.course_run_id " +
            "INNER JOIN courses ON course_run.course_id=courses.course_id WHERE user_id = ?";
    private static final String UPDATE_STATUS_COURSE = "UPDATE course_run SET status = ? WHERE course_run_id = ?";
    private static final String UPDATE_FORMAT_COURSE = "UPDATE course_run SET format = ? WHERE course_run_id = ?";
    private static final String UPDATE_TITLE_COURSE = "UPDATE courses JOIN course_run ON " +
            "courses.course_id=course_run.course_id SET course_title=? WHERE course_run_id =?";
    private static final String UPDATE_DESCRIPTION_COURSE = "UPDATE courses JOIN course_run ON " +
            "courses.course_id=course_run.course_id SET description=? WHERE course_run_id =?";

    private static final String UPDATE_DATE_COURSE = "UPDATE course_run SET start_course=?, end_course=? " +
            "WHERE course_run_id =?";

    private static final String SQL_SELECT_COURSES_BY_LECTURER_ID = "SELECT course_run_id,course_title," +
            "description,materials_path,start_course,end_course,limit_students,lecturer_id,status,format FROM course_run INNER JOIN " +
            "courses ON course_run.course_id=courses.course_id WHERE lecturer_id = ?";

    private CourseDaoImpl() {
    }

    public static CourseDaoImpl getInstance() {
        if (instance == null) {
            instance = new CourseDaoImpl();
        }
        return instance;
    }

    @Override
    public void create(String title, String description, long lecturerId, LocalDate startDate, LocalDate endDate,
                       String format) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_COURSE,
                     Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new DaoException("Error of creation course, no ID obtained");
            }

            int idNewCourse = generatedKeys.getInt(1);
            Course course = new Course();
            course.setId(idNewCourse);

            createCourseRun(startDate, endDate, lecturerId, format, course.getId());
            connection.commit();

        } catch (SQLException | PoolException e) {
            throw new DaoException("Create course failed", e);
        }
    }


    @Override
    public List<Course> findCoursesAvailableForRegistration(int count, int offset) throws DaoException {
        List<Course> listCourse = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_COURSES_AVAILABLE_FOR_REGISTRATION)) {
            statement.setInt(1, count);
            statement.setInt(2, offset);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Course course = createCourse(resultSet);
                    listCourse.add(course);
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Courses not found", e);
        }
        return listCourse;
    }

    @Override
    public List<Course> findAllCourses(int count, int offset) throws DaoException {
        List<Course> listCourse = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_COURSES)) {
            statement.setInt(1, count);
            statement.setInt(2, offset);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Course course = createCourse(resultSet);
                    listCourse.add(course);
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Courses not found", e);
        }
        return listCourse;
    }

    @Override
    public Course findInfoAboutCourse(long courseId) throws DaoException {
        Course course = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_INFO_BY_ID)) {
            statement.setLong(1, courseId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    course = createCourse(resultSet);
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Course not found", e);
        }
        return course;
    }

    @Override
    public int countCourses(String status) throws DaoException {
        int count = 0;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_COUNT_COURSES_BY_STATUS)
        ) {
            statement.setString(1, status);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    count++;
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while get courses count", e);
        }
        return count;
    }

    @Override
    public int countAllCourses() throws DaoException {
        int count = 0;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_COUNT_ALL_COURSES)
        ) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    count++;
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while get courses count", e);
        }
        return count;
    }

    @Override
    public List<Course> findCoursesUser(long userId) throws DaoException {
        List<Course> listCourse = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_COURSES_USER_BY_ID)) {
            statement.setLong(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Course course = createCourse(resultSet);
                    listCourse.add(course);
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Courses not found", e);
        }
        return listCourse;
    }

    @Override
    public void updateStatusCourse(long courseId, Course.StatusCourse statusCourse) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_COURSE)) {
            statement.setString(1, String.valueOf(statusCourse));
            statement.setLong(2, courseId);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while update status course", e);
        }
    }

    @Override
    public void updateFormat(long courseId, Course.FormatCourse format) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_FORMAT_COURSE)) {
            statement.setString(1, String.valueOf(format));
            statement.setLong(2, courseId);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while update format course", e);
        }
    }

    @Override
    public void updateTitle(long courseId, String title) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TITLE_COURSE)) {
            statement.setString(1, title);
            statement.setLong(2, courseId);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while update title course", e);
        }
    }

    @Override
    public void updateDescription(long courseId, String description) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DESCRIPTION_COURSE)) {
            statement.setString(1, description);
            statement.setLong(2, courseId);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while update title course", e);
        }
    }

    @Override
    public void updateDate(long courseId, LocalDate startDate, LocalDate endDate) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DATE_COURSE)) {
            statement.setDate(1, Date.valueOf(startDate));
            statement.setDate(2, Date.valueOf(endDate));
            statement.setLong(3, courseId);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while update title course", e);
        }
    }

    @Override
    public List<Course> findCoursesByLecturerId(Long lecturerId) throws DaoException {
        List<Course> listCourse = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_COURSES_BY_LECTURER_ID)) {
            statement.setLong(1, lecturerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Course course = createCourse(resultSet);
                    listCourse.add(course);
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Courses not found", e);
        }
        return listCourse;
    }

    private Course createCourse(ResultSet resultSet) throws SQLException {
        Course course = new Course();

        course.setId(resultSet.getLong(ColumnName.COURSE_ID));
        course.setTitle(resultSet.getString(ColumnName.COURSE_TITLE));
        course.setDescripton(resultSet.getString(ColumnName.DESCRIPTION));
        course.setMaterialsPath(resultSet.getString(ColumnName.MATERIALS_PATH));

        course.setStartDate(resultSet.getDate(ColumnName.START_COURSE).toLocalDate());
        course.setEndDate(resultSet.getDate(ColumnName.END_COURSE).toLocalDate());
        course.setLimitStudents(resultSet.getInt(ColumnName.LIMIT_STUDENTS));
        course.setLecturerId(resultSet.getInt(ColumnName.LECTURER_ID));
        course.setStatus(resultSet.getString(ColumnName.STATUS));
        course.setFormat(resultSet.getString(ColumnName.FORMAT));

        return course;
    }

    private void createCourseRun(LocalDate startDate, LocalDate endDate, long lecturerId, String format,
                                 long courseId) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_COURSE_RUN)) {
            statement.setLong(1, courseId);
            statement.setDate(2, Date.valueOf(startDate));
            statement.setDate(3, Date.valueOf(endDate));
            statement.setLong(4, lecturerId);
            statement.setString(5, format);
            statement.executeUpdate();

        } catch (SQLException | PoolException e) {
            throw new DaoException("Create course_run failed", e);
        }
    }
}

package by.epamtc.final_task.dao.impl;

import by.epamtc.final_task.dao.ColumnName;
import by.epamtc.final_task.dao.CourseDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.pool.ConnectionPool;
import by.epamtc.final_task.dao.pool.exception.PoolException;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private static CourseDaoImpl instance;

    private static final String SQL_SELET_COURSES_AVAILABLE_FOR_REGISTRATION = "SELECT * FROM course_run " +
            "INNER JOIN courses ON course_run.course_id=courses.course_id " +
            "LEFT JOIN users ON course_run.lecturer_id=users.user_id  " +
            "WHERE status='NOT_STARTED' LIMIT ? OFFSET ?";

    private static final String SQL_SELET_ALL_COURSES = "SELECT * FROM course_run " +
            "INNER JOIN courses ON course_run.course_id=courses.course_id " +
            "LEFT JOIN users ON course_run.lecturer_id=users.user_id  " +
            "LIMIT ? OFFSET ?";

    private static final String SQL_SELECT_COUNT_COURSES_BY_STATUS = "SELECT * FROM course_run WHERE status=?";

    private static final String SQL_SELECT_COUNT_ALL_COURSES = "SELECT * FROM course_run";

    private static final String SQL_SELECT_INFO_BY_ID = "SELECT * FROM course_run " +
            "INNER JOIN courses ON course_run.course_id=courses.course_id " +
            "LEFT JOIN users ON course_run.lecturer_id=users.user_id " +
            "WHERE course_run.course_run_id=?";
    private static final String SQL_SELET_COURSES_USER_BY_ID = "SELECT * FROM lists_students INNER JOIN course_run ON lists_students.course_run_id=course_run.course_run_id \n" +
            "INNER JOIN courses ON course_run.course_id=courses.course_id WHERE user_id = ?";
   // private static final String SQL_SELECT_STATUS_ON_COURSE = "SELECT status_student_id FROM lists_students WHERE user_id = ? AND course_run_id=?";

    private CourseDaoImpl() {
    }

    public static CourseDaoImpl getInstance() {
        if (instance == null) {
            instance = new CourseDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Course> findCoursesAvailableForRegistration(int count, int offset) throws DaoException {
        List<Course> listCourse = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELET_COURSES_AVAILABLE_FOR_REGISTRATION)) {
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
             PreparedStatement statement = connection.prepareStatement(SQL_SELET_ALL_COURSES)) {
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
             PreparedStatement statement = connection.prepareStatement(SQL_SELET_COURSES_USER_BY_ID)) {
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

   /* @Override
    public User.UserCourseStatus getStatusUserOnCourse(long userId, long courseId) throws DaoException {
        User.UserCourseStatus status = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_STATUS_ON_COURSE)) {
            statement.setLong(1, userId);
            statement.setLong(2,courseId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                   status=User.UserCourseStatus.valueOf(resultSet.getString(ColumnName.STATUS_STUDENT));
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Courses not found", e);
        }
        return status;
    }*/

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
}

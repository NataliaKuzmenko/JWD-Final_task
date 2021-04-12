package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.Course;

import java.time.LocalDate;
import java.util.List;

/**
 * The interface Course dao.
 */
public interface CourseDao {
    /**
     * Create (add) new course
     *
     * @param title       the course title
     * @param description the course description
     * @param lecturerId  the lecturer id of course
     * @param startDate   the date start
     * @param endDate     the date end
     * @param format      the course format
     * @throws DaoException if an dao exception occurred while processing
     */
    void create(String title, String description, long lecturerId, LocalDate startDate, LocalDate endDate, String format) throws DaoException;

    /**
     * Find courses list available for register
     *
     * @param count  limit of courses
     * @param offset offset of courses
     * @return Courses list available for register
     * @throws DaoException if an dao exception occurred while processing
     */
    List<Course> findCoursesAvailableForRegistration(int count, int offset) throws DaoException;

    /**
     * Find all courses list
     *
     * @param count  limit of courses
     * @param offset offset of courses
     * @return All courses list
     * @throws DaoException if an dao exception occurred while processing
     */
    List<Course> findAllCourses(int count, int offset) throws DaoException;

    /**
     * Find info about course by id course
     *
     * @param courseId the course id
     * @return Course object
     * @throws DaoException if an dao exception occurred while processing
     */
    Course findInfoAboutCourse(long courseId) throws DaoException;

    /**
     * Count number of courses in status
     *
     * @param status the course status
     * @return Count courses by status
     * @throws DaoException if an dao exception occurred while processing
     */
    int countCourses(String status) throws DaoException;

    /**
     * Count number of all courses
     *
     * @return Count all courses
     * @throws DaoException if an dao exception occurred while processing
     */
    int countAllCourses() throws DaoException;

    /**
     * Find courses list of user by user id
     *
     * @param userId the user id
     * @return Courses list of user
     * @throws DaoException if an dao exception occurred while processing
     */
    List<Course> findCoursesUser(long userId) throws DaoException;

    /**
     * Update course status
     *
     * @param courseId     the course id
     * @param statusCourse the course status
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateStatusCourse(long courseId, Course.StatusCourse statusCourse) throws DaoException;

    /**
     * Update course format
     *
     * @param courseId the course id
     * @param format   the course format
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateFormat(long courseId, Course.FormatCourse format) throws DaoException;

    /**
     * Update course title
     *
     * @param courseId the course id
     * @param title    the course title
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateTitle(long courseId, String title) throws DaoException;

    /**
     * Update course description
     *
     * @param courseId    the course id
     * @param description the course description
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateDescription(long courseId, String description) throws DaoException;

    /**
     * Update course dates
     *
     * @param courseId  the course id
     * @param startDate the course start
     * @param endDate   the course end
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateDate(long courseId, LocalDate startDate, LocalDate endDate) throws DaoException;

    /**
     * Find courses list by lecturer id
     *
     * @param lecturerId the lecturer id
     * @return Courses list of lecturer
     * @throws DaoException if an dao exception occurred while processing
     */
    List<Course> findCoursesByLecturerId(Long lecturerId) throws DaoException;

    /**
     * Count number of all courses
     *
     * @return number of all courses
     * @throws DaoException if an dao exception occurred while processing
     */

}

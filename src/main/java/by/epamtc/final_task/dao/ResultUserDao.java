package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.ResultUser;

/**
 * The interface Result user dao.
 */
public interface ResultUserDao {

    /**
     * Add student's course result
     *
     * @param studentId the student id
     * @param courseId the course id
     * @param mark the student mark
     * @param comment the student comment
     * @throws DaoException if an dao exception occurred while processing
     */
    void addCourseResult(long studentId, long courseId, int mark, String comment) throws DaoException;

    /**
     * Find user results
     *
     * @param userId the user id
     * @param courseId the course id
     * @return the result user object
     * @throws DaoException if an dao exception occurred while processing
     */
    ResultUser findResultUser(long userId, long courseId) throws DaoException;

    /**
     * Update status student
     *
     * @param userId the user id
     * @param courseId the course id
     * @param status the student status
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateUserCourseStatus(long userId, long courseId, ResultUser.UserCourseStatus status) throws DaoException;

}

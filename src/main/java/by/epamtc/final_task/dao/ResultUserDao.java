package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.ResultUser;

public interface ResultUserDao {

    void addCourseResult(long studentId, long courseId, int mark, String comment) throws DaoException;

    ResultUser findResultUser(long userId, long courseId) throws DaoException;

    void updateUserCourseStatus(long userId, long courseId, ResultUser.UserCourseStatus status) throws DaoException;

}

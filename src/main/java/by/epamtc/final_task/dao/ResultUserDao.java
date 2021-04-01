package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.entity.ResultUser;

import java.util.List;

public interface ResultUserDao {
    ResultUser findResultUser(long userId, long courseId) throws DaoException;
    boolean updateUserCourseStatus(long userId, long courseId, ResultUser.UserCourseStatus status) throws DaoException;
}

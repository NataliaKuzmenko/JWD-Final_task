package by.epamtc.final_task.service;

import by.epamtc.final_task.entity.ResultUser;
import by.epamtc.final_task.service.exception.ServiceException;

public interface ResultUserService {

    void addCourseResult(long studentId, long courseId, int mark, String comment) throws ServiceException;

    ResultUser findResultUser(long userId, long courseId) throws ServiceException;

    boolean updateUserCourseStatus(long userId, long courseId, ResultUser.UserCourseStatus status) throws ServiceException;

}

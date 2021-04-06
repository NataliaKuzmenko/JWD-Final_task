package by.epamtc.final_task.service.impl;

import by.epamtc.final_task.dao.ResultUserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.impl.ResultUserDaoImpl;
import by.epamtc.final_task.entity.ResultUser;
import by.epamtc.final_task.service.ResultUserService;
import by.epamtc.final_task.service.exception.ServiceException;

public class ResultUserServiceImpl implements ResultUserService {

    ResultUserDao resultUserDao = ResultUserDaoImpl.getInstance();
    private static final ResultUserServiceImpl instance = new ResultUserServiceImpl();


    private ResultUserServiceImpl() {
    }

    public static ResultUserServiceImpl getInstance() {
        return instance;
    }


    @Override
    public void addCourseResult(long studentId, long courseId, int mark, String comment) throws ServiceException {
        try {
            resultUserDao.addCourseResult(studentId,courseId,mark,comment);
        } catch (DaoException e) {
            throw new ServiceException("Fail to add course result", e);
        }
    }

    @Override
    public ResultUser findResultUser(long userId, long courseId) throws ServiceException {
        ResultUser resultUser;
        try {
            resultUser = resultUserDao.findResultUser(userId, courseId);
        } catch (DaoException e) {
            throw new ServiceException("Courses not found", e);
        }
        return resultUser;
    }

    @Override
    public boolean updateUserCourseStatus(long userId, long courseId, ResultUser.UserCourseStatus status) throws ServiceException {
        boolean result = false;
        try {
            resultUserDao.updateUserCourseStatus(userId, courseId, status);
            result = true;
        } catch (DaoException e) {
            throw new ServiceException("Fail to update status user", e);
        }
        return result;
    }
}

package by.epamtc.final_task.service.impl;

import by.epamtc.final_task.dao.UserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.impl.UserDaoImpl;
import by.epamtc.final_task.entity.user.User;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.validation.HashPassword;

public class UserServiceImpl implements UserService {

    private static final UserServiceImpl instance = new UserServiceImpl();
    private UserDao userDao = UserDaoImpl.getInstance();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }


    @Override
    public boolean isLoginAndPasswordValid(String enteredLogin, String enteredPassword) throws
            ServiceException {

        String hashPassword = HashPassword.hashPassword(enteredPassword);

        boolean result = false;
        try {
            if (userDao.findUserByLoginAndPassword(enteredLogin, hashPassword)) {

                result = true;
            }
        } catch (DaoException e) {
            throw new ServiceException("User not found", e);
        }
        return result;
    }

    @Override
    public boolean create(String enteredLogin, String enteredPassword) throws ServiceException {
        boolean result = false;

        if (!isLoginExistsForCreationUser(enteredLogin)) {
            String hashPassword = HashPassword.hashPassword(enteredPassword);
            try {
                result = userDao.create(enteredLogin, hashPassword);
            } catch (DaoException e) {
                throw new ServiceException("Creation failed", e);
            }
        }
        return result;
    }

    @Override
    public boolean isLoginExistsForCreationUser(String enteredLogin) throws ServiceException {
        try {
            return userDao.isUserExist(enteredLogin);

        } catch (DaoException e) {
            throw new ServiceException("Select operation failed. Please contact your system administrator", e);
        }
    }

    @Override
    public User findUserWithTheAllInfoByLogin(String email) throws ServiceException {
        try {

            User user = userDao.findUserWithTheAllInfoByLogin(email);
            if (user == null) {
                throw new ServiceException("User not found. Please contact your system administrator");
            }
            return user;
        } catch (DaoException e) {
            throw new ServiceException("User not found", e);
        }
    }

}

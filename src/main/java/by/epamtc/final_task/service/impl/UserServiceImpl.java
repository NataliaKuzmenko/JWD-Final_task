package by.epamtc.final_task.service.impl;

import by.epamtc.final_task.dao.UserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.impl.UserDaoImpl;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.validation.HashPassword;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final UserServiceImpl instance = new UserServiceImpl();
    private final UserDao userDao = UserDaoImpl.getInstance();
    private static final int PAGE_ITEMS_COUNT = 5;

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

    @Override
    public void updateUser(User user) throws ServiceException {
        try {
            userDao.updateUser(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User updateAvatar(String email, String avatar) throws ServiceException {

        User user = new User();
        if (isLoginExists(email)) {
            user = findUserWithTheAllInfoByLogin(email);
            user.setPhotoPath(avatar);
            try {
                userDao.updateAvatar(user);
                userDao.updateUser(user);
            } catch (DaoException e) {
                throw new ServiceException("Avatar has not been updated", e);
            }
        }
        return user;
    }

    @Override
    public boolean isLoginExists(String enteredLogin) throws ServiceException {
        boolean result;
        try {
            result = userDao.isUserExist(enteredLogin);
            if (!result) {
                throw new ServiceException("User not found. Please contact your system administrator");
            }
        } catch (DaoException e) {
            throw new ServiceException("Select operation failed. Please contact your system administrator", e);
        }
        return result;
    }

    @Override
    public User findUserById(long userId) throws ServiceException {
        try {
            return userDao.findUserById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean addUserOnCourse(long userId, long courseId) throws ServiceException {
        boolean result = false;
        try {
            if (!userDao.isUserOnCourse(userId, courseId)) {
                userDao.addUserOnCourse(userId, courseId);
                result = true;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    /*@Override
    public boolean isUserOnCourse(long userId, long courseId) throws ServiceException {
        boolean result;
        try {
            result = userDao.isUserOnCourse(userId, courseId);
            if (result) {
                throw new ServiceException("User already is on the course");
            }
        } catch (DaoException e) {
            throw new ServiceException("Select operation failed. Please contact your system administrator", e);
        }
        return result;
    }*/

    @Override
    public List<User> findAllUsers(int count) throws ServiceException {
        try {
            int offset = PAGE_ITEMS_COUNT * count;
            List<User> titleList = userDao.findAllUsers(PAGE_ITEMS_COUNT, offset);
            if (titleList.isEmpty()) {
                throw new ServiceException("Users not found.");
            }
            return titleList;
        } catch (DaoException e) {
            throw new ServiceException("Users not found", e);
        }
    }

    @Override
    public int countAllUsers() throws ServiceException {
        try {
            return userDao.countAllCourses();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserRole(User user) throws ServiceException {
        try {
            userDao.updateUserRole(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}



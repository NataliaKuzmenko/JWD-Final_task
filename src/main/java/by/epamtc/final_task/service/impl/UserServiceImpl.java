package by.epamtc.final_task.service.impl;

import by.epamtc.final_task.dao.UserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.impl.UserDaoImpl;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.validation.HashPassword;

import java.util.List;

/**
 * Service that works with user data
 */
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
        boolean result;
        try {
            if (!userDao.isUserExist(enteredLogin)) {
                String hashPassword = HashPassword.hashPassword(enteredPassword);

                result = userDao.create(enteredLogin, hashPassword);
            } else {
                result = false;
            }

        } catch (DaoException e) {
            throw new ServiceException("Creation failed", e);
        }
        return result;
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
            throw new ServiceException("Update user failed", e);
        }
    }

    @Override
    public void updateEmail(User user) throws ServiceException {
        try {
            userDao.updateEmail(user);
        } catch (DaoException e) {
            throw new ServiceException("Update email failed", e);
        }
    }

    @Override
    public void updateNameAndSurname(User user) throws ServiceException {
        try {
            userDao.updateNameAndSurname(user);
        } catch (DaoException e) {
            throw new ServiceException("Update email failed", e);
        }
    }

    @Override
    public void updateAvatar(String email, String avatar) throws ServiceException {

        if (isLoginExists(email)) {
            User user = findUserWithTheAllInfoByLogin(email);
            user.setPhotoPath(avatar);
            try {
                userDao.updateAvatar(user);
            } catch (DaoException e) {
                throw new ServiceException("Avatar has not been updated", e);
            }
        }
    }

    @Override
    public boolean isLoginExists(String enteredLogin) throws ServiceException {
        boolean result;
        try {
            result = userDao.isUserExist(enteredLogin);
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

    @Override
    public List<User> findAllUsers(int count) throws ServiceException {
        try {
            int offset = PAGE_ITEMS_COUNT * count;
            List<User> userList = userDao.findAllUsers(PAGE_ITEMS_COUNT, offset);
            if (userList.isEmpty()) {
                throw new ServiceException("Users not found.");
            }
            return userList;
        } catch (DaoException e) {
            throw new ServiceException("Users not found", e);
        }
    }

    @Override
    public List<User> findAllUsersOnCourse(long courseId) throws ServiceException {
        List<User> userList = null;
        try {
            userList = userDao.findAllUsersOnCourse(courseId);

        } catch (DaoException e) {
            throw new ServiceException("Users not found", e);
        }
        return userList;
    }

    @Override
    public int countAllUsers() throws ServiceException {
        try {
            return userDao.countAllUsers();
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



package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.User;

import java.util.List;

public interface UserDao {

    boolean create(String email, String password) throws DaoException;

    boolean findUserByLoginAndPassword(String login, String password) throws DaoException;

    boolean isUserExist(String email) throws DaoException;

    User findUserWithTheAllInfoByLogin(String email) throws DaoException;

    void updateUser(User user) throws DaoException;

    void updateEmail(User user) throws DaoException;

    void updateNameAndSurname(User user) throws DaoException;

    User findUserById(long userId) throws DaoException;

    void addUserOnCourse(long studentId, long courseId) throws DaoException;

    boolean isUserOnCourse(long userId, long courseId) throws DaoException;

    void updateAvatar(User user) throws DaoException;

    List<User> findAllUsers(int count, int offset) throws DaoException;

    int countAllCourses() throws DaoException;

    void updateUserRole(User user) throws DaoException;

    List<User> findAllUsersOnCourse(long courseId) throws DaoException;
}


package by.epamtc.final_task.service;

import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    boolean create(String enteredLogin, String enteredPassword) throws ServiceException;

    boolean isLoginAndPasswordValid(String enteredLogin, String enteredPassword) throws ServiceException;

    User findUserWithTheAllInfoByLogin(String email) throws ServiceException;

    void updateUser(User user) throws ServiceException;

    void updateEmail(User user) throws ServiceException;

    void updateNameAndSurname(User user) throws ServiceException;

    void updateAvatar(String email, String avatar) throws ServiceException;

    boolean isLoginExists(String enteredLogin) throws ServiceException;

    User findUserById(long userId) throws ServiceException;

    boolean addUserOnCourse(long userId, long courseId) throws ServiceException;

    List<User> findAllUsers(int count) throws ServiceException;

    List<User> findAllUsersOnCourse(long courseId) throws ServiceException;

    int countAllUsers() throws ServiceException;

    void updateUserRole(User user) throws ServiceException;
}

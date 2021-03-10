package by.epamtc.final_task.service;

import by.epamtc.final_task.entity.user.User;
import by.epamtc.final_task.service.exception.ServiceException;

public interface UserService {

    boolean create(String enteredLogin, String enteredPassword) throws ServiceException;

    boolean isLoginAndPasswordValid(String enteredLogin, String enteredPassword) throws ServiceException;

    boolean isLoginExistsForCreationUser(String enteredLogin) throws ServiceException;

    User findUserWithTheAllInfoByLogin(String email) throws ServiceException;

}

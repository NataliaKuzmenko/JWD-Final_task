package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.entity.UserAuthorizationData;

public interface UserDao {
    User authorization(String login, String password) throws DaoException;

    void register(UserAuthorizationData user) throws DaoException;

    boolean create(String email, String password) throws DaoException;

    boolean findUserByLoginAndPassword(String login, String password) throws DaoException;

    boolean isUserExist(String email) throws DaoException;


}


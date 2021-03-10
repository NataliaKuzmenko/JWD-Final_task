package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.pool.exception.PoolException;
import by.epamtc.final_task.entity.user.User;
import by.epamtc.final_task.entity.UserAuthorizationData;

public interface UserDao {

    boolean create(String email, String password) throws DaoException;

    boolean findUserByLoginAndPassword(String login, String password) throws DaoException;

    boolean isUserExist(String email) throws DaoException;

    User findUserWithTheAllInfoByLogin(String email) throws DaoException;


}


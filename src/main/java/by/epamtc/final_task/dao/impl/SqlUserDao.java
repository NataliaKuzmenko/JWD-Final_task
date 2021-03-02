package by.epamtc.final_task.dao.impl;

import by.epamtc.final_task.dao.UserDAO;
import by.epamtc.final_task.dao.exception.DAOException;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.entity.UserAuthorizationData;

public class SqlUserDao implements UserDAO {

    static {
        MYSQLDriverLoader.getInstance();
    }

    @Override
    public User authorization(String login, String password) throws DAOException {

        System.out.println("USER AUTHORIZATION");

        return new User();
    }

    @Override
    public void register(UserAuthorizationData user) throws DAOException {

    }


}

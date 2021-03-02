package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DAOException;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.entity.UserAuthorizationData;
import by.epamtc.final_task.service.exception.ServiceException;

public interface UserDAO {
    User authorization(String login, String password) throws DAOException;

    void register(UserAuthorizationData user) throws DAOException;
}


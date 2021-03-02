package by.epamtc.final_task.service.impl;

import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.entity.UserAuthorizationData;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.UserService;

public class UserServiceImpl implements UserService {


    @Override
    public User authorization(String login, String passport) throws ServiceException {
        return null;
    }

    @Override
    public void register(UserAuthorizationData user) throws ServiceException {

    }
}

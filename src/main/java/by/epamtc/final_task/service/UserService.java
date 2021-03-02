package by.epamtc.final_task.service;

import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.entity.UserAuthorizationData;
import by.epamtc.final_task.service.exception.ServiceException;

public interface UserService {

    User authorization(String login, String passport) throws ServiceException;

    void register(UserAuthorizationData user) throws ServiceException;

}

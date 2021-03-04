package by.epamtc.final_task.service;

import by.epamtc.final_task.service.impl.UserServiceImpl;

public final class ServiceProvider {

    private static final ServiceProvider instance = new ServiceProvider();

    private ServiceProvider() {}

  //  private final UserService userService = new UserServiceImpl();


    public static ServiceProvider getInstance() {
        return instance;
    }

    /*public UserService getUserService() {
        return userService;
    }*/



}

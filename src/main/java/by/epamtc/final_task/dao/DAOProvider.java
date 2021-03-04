package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.impl.UserDaoImpl;

public final class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

   // private final UserDao userdao = new UserDaoImpl();


    private DAOProvider() {}

    public static DAOProvider getInstance() {
        return instance;
    }

    /*public UserDao getUserdao() {
        return userdao;
    }*/


}

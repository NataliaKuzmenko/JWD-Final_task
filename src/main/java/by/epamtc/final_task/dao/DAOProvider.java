package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.impl.SqlUserDao;

public final class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userdao = new SqlUserDao();


    private DAOProvider() {}

    public static DAOProvider getInstance() {
        return instance;
    }

    public UserDAO getUserdao() {
        return userdao;
    }


}

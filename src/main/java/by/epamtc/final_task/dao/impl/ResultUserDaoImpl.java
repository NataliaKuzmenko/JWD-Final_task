package by.epamtc.final_task.dao.impl;

import by.epamtc.final_task.dao.ResultUserDao;

public class ResultUserDaoImpl implements ResultUserDao {
    private static ResultUserDaoImpl instance;
    private ResultUserDaoImpl() {
    }
    public static ResultUserDaoImpl getInstance() {
        if (instance == null) {
            instance = new ResultUserDaoImpl();
        }
        return instance;
    }
}

package by.epamtc.final_task.dao.impl;

import by.epamtc.final_task.dao.ColumnName;
import by.epamtc.final_task.dao.UserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.pool.ConnectionPool;
import by.epamtc.final_task.dao.pool.exception.PoolException;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.entity.UserAuthorizationData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl instance;

    private static final String INSERT_NEW_USER = "INSERT INTO users(email,password) VALUES(?,?)";
    private static final String SQL_SELECT_BY_LOGIN = "SELECT email, password FROM users WHERE email = ?";
    private static final String SQL_SELECT_COUNT_USERS = "SELECT count(*) FROM users WHERE email = ?";

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public User authorization(String login, String password) throws DaoException {

        System.out.println("USER AUTHORIZATION");

        return new User();
    }

    @Override
    public boolean create(String email, String password) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW_USER)) {
            statement.setString(1, email);
            statement.setString(2, password);
            result = statement.executeUpdate() > 0;
        } catch (SQLException | PoolException e) {
            throw new DaoException("Creation failed", e);
        }
        return result;
    }

    @Override
    public boolean findUserByLoginAndPassword(String email, String password) throws DaoException {
        boolean result = false;
        String userEmail = null;
        String userPassword = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_LOGIN)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    userEmail = resultSet.getString(ColumnName.EMAIL);
                    userPassword = resultSet.getString(ColumnName.PASSWORD);
                }
                if (userEmail != null && userPassword != null) {
                    if (userEmail.equals(email) && userPassword.equals(password)) {
                        result = true;
                    }
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("User not found", e);
        }
        return result;
    }

    @Override
    public boolean isUserExist(String email) throws DaoException {
        boolean result = true;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_COUNT_USERS)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int countUsers = resultSet.getInt(1);
                    if (countUsers == 0) {
                        result = false;
                    }
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Select operation failed", e);
        }
        return result;
    }

    @Override
    public void register(UserAuthorizationData user) throws DaoException {

    }

}
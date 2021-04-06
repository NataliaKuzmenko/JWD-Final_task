package by.epamtc.final_task.dao.impl;

import by.epamtc.final_task.dao.ColumnName;
import by.epamtc.final_task.dao.UserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.pool.ConnectionPool;
import by.epamtc.final_task.dao.pool.exception.PoolException;
import by.epamtc.final_task.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl instance;

    private static final String INSERT_NEW_USER = "INSERT INTO users(email,password) VALUES(?,?)";
    private static final String SQL_SELECT_BY_LOGIN = "SELECT email, password FROM users WHERE email = ?";
    private static final String SQL_SELECT_COUNT_USERS = "SELECT count(*) FROM users WHERE email = ?";
    private static final String SQL_SELECT_THE_ALL_INFO_BY_LOGIN = "SELECT * FROM users WHERE email = ?";
    private static final String UPDATE_USER = "UPDATE users SET first_name=?, last_name=?, email=? WHERE user_id=?";
    private static final String UPDATE_EMAIL = "UPDATE users SET email=? WHERE user_id = ?";
    private static final String UPDATE_NAME_AND_SURNAME = "UPDATE users SET first_name=?, last_name=? WHERE user_id=?";
    private static final String GET_USER_BY_ID = "SELECT user_id,email,first_name,last_name,role_id,photo_path FROM users WHERE user_id=?";
    private static final String ADD_STUDENT_APPLY_ON_COURSE = "INSERT INTO lists_students (user_id, course_run_id) VALUES (?, ?)";
    private static final String SQL_SELECT_USER_ON_COURSE = "SELECT count(*) FROM lists_students WHERE course_run_id=? AND user_id=?";
    private static final String SQL_SELET_ALL_USERS = "SELECT * FROM users LIMIT ? OFFSET ?";
    private static final String SQL_SELECT_COUNT_ALL_USERS = "SELECT * FROM users";
    private static final String SQL_UPDATE_AVATAR_USER = "UPDATE users SET photo_path = ? WHERE email = ?";
    private static final String UPDATE_USER_ROLE = "UPDATE users SET role_id = ? WHERE user_id = ?";
    private static final String SQL_SELET_ALL_USERS_ON_COURSE = "SELECT * FROM lists_students INNER JOIN users ON lists_students.user_id=users.user_id WHERE course_run_id=?";

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
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
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_COUNT_USERS);
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
    public User findUserWithTheAllInfoByLogin(String email) throws DaoException {
        User user = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_THE_ALL_INFO_BY_LOGIN)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    user = createUser(resultSet);
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("User not found", e);
        }
        return user;
    }

    @Override
    public void updateUser(User user) throws DaoException {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setLong(4, user.getUserId());

            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while update user", e);
        }
    }

    @Override
    public void updateEmail(User user) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMAIL)) {

            statement.setString(1, user.getEmail());
            statement.setLong(2, user.getUserId());

            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while update user", e);
        }
    }

    @Override
    public void updateNameAndSurname(User user) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_NAME_AND_SURNAME)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setLong(3, user.getUserId());

            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while update user", e);
        }
    }

    @Override
    public User findUserById(long userId) throws DaoException {
        User user = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USER_BY_ID)
        ) {
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = createUser(resultSet);
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while find user by id " + userId, e);
        }

        return user;
    }

    @Override
    public void addUserOnCourse(long studentId, long courseId) throws DaoException {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_STUDENT_APPLY_ON_COURSE)
        ) {
            statement.setLong(1, studentId);
            statement.setLong(2, courseId);

            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while add student's application on course", e);
        }
    }


    @Override
    public boolean isUserOnCourse(long userId, long courseId) throws DaoException {
        boolean result = true;

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_ON_COURSE);
            statement.setLong(1, courseId);
            statement.setLong(2, userId);

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
    public void updateAvatar(User user) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_AVATAR_USER)) {
            statement.setString(1, user.getPhotoPath());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Avatar has not been updated", e);
        }
            }

    @Override
    public List<User> findAllUsers(int count, int offset) throws DaoException {
        List<User> listUser = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELET_ALL_USERS)) {
            statement.setInt(1, count);
            statement.setInt(2, offset);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = createUser(resultSet);
                    listUser.add(user);
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Courses not found", e);
        }
        return listUser;
    }

    @Override
    public int countAllCourses() throws DaoException {
        int count = 0;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_COUNT_ALL_USERS)
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    count++;
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while get courses count", e);
        }
        return count;
    }

    @Override
    public void updateUserRole(User user) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_ROLE)) {

            statement.setString(1, String.valueOf(User.UserRole.LECTURER));
            statement.setLong(2, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while update user", e);
        }
    }

    @Override
    public List<User> findAllUsersOnCourse(long courseId) throws DaoException {
        List<User> listUser = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELET_ALL_USERS_ON_COURSE)) {
            statement.setLong(1, courseId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = createUser(resultSet);
                    listUser.add(user);
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Courses not found", e);
        }
        return listUser;
    }

    private User createUser(ResultSet resultSet) throws SQLException {

        User user = new User();

        user.setUserId(resultSet.getLong(ColumnName.USER_ID));
        user.setFirstName(resultSet.getString(ColumnName.FIRST_NAME));
        user.setLastName(resultSet.getString(ColumnName.LAST_NAME));
        user.setEmail(resultSet.getString(ColumnName.EMAIL));
        user.setRole(resultSet.getString(ColumnName.ROLE));
        user.setPhotoPath(resultSet.getString(ColumnName.PHOTO_PATH));

        return user;
    }
}


package by.epamtc.final_task.dao.impl;

import by.epamtc.final_task.dao.ColumnName;
import by.epamtc.final_task.dao.ResultUserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.pool.ConnectionPool;
import by.epamtc.final_task.dao.pool.exception.PoolException;
import by.epamtc.final_task.entity.ResultUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultUserDaoImpl implements ResultUserDao {
    private static final String SQL_SELECT_RESULT_USER_BY_ID_ON_COURSE = "SELECT * FROM lists_students " +
            "WHERE user_id = ? AND course_run_id=?";
    private static final String UPDATE_STATUS_USER = "UPDATE lists_students SET status_student_id=? " +
            "WHERE user_id=? AND course_run_id=?";
    private static final String ADD_COURSE_RESULT = "UPDATE lists_students SET mark=?,comment=? " +
            "WHERE user_id = ? AND course_run_id = ?";
    private static ResultUserDaoImpl instance;

    private ResultUserDaoImpl() {
    }

    public static ResultUserDaoImpl getInstance() {
        if (instance == null) {
            instance = new ResultUserDaoImpl();
        }
        return instance;
    }

    @Override
    public void addCourseResult(long studentId, long courseId, int mark, String comment) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_COURSE_RESULT)
        ) {
            statement.setInt(1, mark);
            statement.setString(2, comment);
            statement.setLong(3, studentId);
            statement.setLong(4, courseId);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while add course result", e);
        }
    }

    @Override
    public ResultUser findResultUser(long userId, long courseId) throws DaoException {
        ResultUser resultUser = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_RESULT_USER_BY_ID_ON_COURSE)
        ) {
            statement.setLong(1, userId);
            statement.setLong(2, courseId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    resultUser = createResultUser(resultSet);
                }
            }
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while get result user", e);
        }
        return resultUser;
    }

    @Override
    public void updateUserCourseStatus(long userId, long courseId,
                                       ResultUser.UserCourseStatus status) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_USER)
        ) {
            statement.setString(1, String.valueOf(status));
            statement.setLong(2, userId);
            statement.setLong(3, courseId);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            throw new DaoException("Error while get result user", e);
        }
    }

    private ResultUser createResultUser(ResultSet resultSet) throws SQLException {
        ResultUser resultUser = new ResultUser();

        resultUser.setResultId(resultSet.getLong(ColumnName.RESULT_COURSE_ID));
        resultUser.setMark(resultSet.getInt(ColumnName.MARK));
        resultUser.setComment(resultSet.getString(ColumnName.COMMENT));
        resultUser.setStatus(ResultUser.UserCourseStatus.valueOf(resultSet.getString(ColumnName.STATUS_STUDENT)));

        return resultUser;
    }
}




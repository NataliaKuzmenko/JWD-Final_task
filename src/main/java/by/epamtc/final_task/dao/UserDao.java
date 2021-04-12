package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.User;

import java.util.List;

/**
 * The interface User dao.
 */
public interface UserDao {

    /**
     * User creating
     *
     * @param email    the user email
     * @param password the user password
     * @return the boolean
     * @throws DaoException if an dao exception occurred while processing
     */
    boolean create(String email, String password) throws DaoException;

    /**
     * Find user object by login abd password
     *
     * @param login    the user login
     * @param password the user password
     * @return the boolean
     * @throws DaoException if an dao exception occurred while processing
     */
    boolean findUserByLoginAndPassword(String login, String password) throws DaoException;

    /**
     * Checks if the user exists
     *
     * @param email the user email
     * @return the boolean
     * @throws DaoException if an dao exception occurred while processing
     */
    boolean isUserExist(String email) throws DaoException;

    /**
     * Find user object by email
     *
     * @param email the user email
     * @return the User object
     * @throws DaoException if an dao exception occurred while processing
     */
    User findUserWithTheAllInfoByLogin(String email) throws DaoException;

    /**
     * Update user object
     *
     * @param user the user object
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateUser(User user) throws DaoException;

    /**
     * Update email
     *
     * @param user the user object
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateEmail(User user) throws DaoException;

    /**
     * Update user name and surname
     *
     * @param user the user object
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateNameAndSurname(User user) throws DaoException;

    /**
     * Find user by user id
     *
     * @param userId the user id
     * @return the user object
     * @throws DaoException if an dao exception occurred while processing
     */
    User findUserById(long userId) throws DaoException;

    /**
     * Add user on course
     *
     * @param studentId the student id
     * @param courseId  the course id
     * @throws DaoException if an dao exception occurred while processing
     */
    void addUserOnCourse(long studentId, long courseId) throws DaoException;

    /**
     * Checks if the user is on the course
     *
     * @param userId   the user id
     * @param courseId the course id
     * @return the boolean
     * @throws DaoException if an dao exception occurred while processing
     */
    boolean isUserOnCourse(long userId, long courseId) throws DaoException;

    /**
     * Update user avatar
     *
     * @param user the user object
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateAvatar(User user) throws DaoException;

    /**
     * Find all users
     *
     * @param count  limit of courses
     * @param offset offset of courses
     * @return users list
     * @throws DaoException if an dao exception occurred while processing
     */
    List<User> findAllUsers(int count, int offset) throws DaoException;

    /**
     * Update user role
     *
     * @param user the user object
     * @throws DaoException if an dao exception occurred while processing
     */
    void updateUserRole(User user) throws DaoException;

    /**
     * Find all users on course
     *
     * @param courseId the course id
     * @return users list on course
     * @throws DaoException if an dao exception occurred while processing
     */
    List<User> findAllUsersOnCourse(long courseId) throws DaoException;

    /**
     * Count number of all users
     *
     * @return
     * @throws DaoException
     */
    int countAllUsers() throws DaoException;
}


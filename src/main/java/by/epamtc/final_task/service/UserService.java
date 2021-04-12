package by.epamtc.final_task.service;

import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.exception.ServiceException;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * User creating
     *
     * @param enteredLogin    the user email
     * @param enteredPassword the user password
     * @return the boolean
     * @throws ServiceException if an service exception occurred while processing
     */
    boolean create(String enteredLogin, String enteredPassword) throws ServiceException;

    /**
     * Is login and password valid boolean.
     *
     * @param enteredLogin    the entered login
     * @param enteredPassword the entered password
     * @return the boolean
     * @throws ServiceException if an service exception occurred while processing
     */
    boolean isLoginAndPasswordValid(String enteredLogin, String enteredPassword) throws ServiceException;

    /**
     * Find user with the all info by login user.
     *
     * @param email the user email
     * @return the user object
     * @throws ServiceException if an service exception occurred while processing
     */
    User findUserWithTheAllInfoByLogin(String email) throws ServiceException;

    /**
     * Update user
     *
     * @param user the user object
     * @throws ServiceException if an service exception occurred while processing
     */
    void updateUser(User user) throws ServiceException;

    /**
     * Update email
     *
     * @param user the user object
     * @throws ServiceException if an service exception occurred while processing
     */
    void updateEmail(User user) throws ServiceException;

    /**
     * Update user name and surname
     *
     * @param user the user object
     * @throws ServiceException if an service exception occurred while processing
     */
    void updateNameAndSurname(User user) throws ServiceException;

    /**
     * Update user avatar
     *
     * @param email  the user email
     * @param avatar the user avatar
     * @throws ServiceException if an service exception occurred while processing
     */
    void updateAvatar(String email, String avatar) throws ServiceException;

    /**
     * Is login exists boolean.
     *
     * @param enteredLogin the entered login
     * @return the boolean
     * @throws ServiceException if an service exception occurred while processing
     */
    boolean isLoginExists(String enteredLogin) throws ServiceException;

    /**
     * Find user by user id
     *
     * @param userId the user id
     * @return the user object
     * @throws ServiceException if an service exception occurred while processing
     */
    User findUserById(long userId) throws ServiceException;

    /**
     * Add user on course
     *
     * @param userId   the user id
     * @param courseId the course id
     * @return the boolean
     * @throws ServiceException if an service exception occurred while processing
     */
    boolean addUserOnCourse(long userId, long courseId) throws ServiceException;

    /**
     * Find users count
     *
     * @param count limit of users
     * @return the users list
     * @throws ServiceException if an service exception occurred while processing
     */
    List<User> findAllUsers(int count) throws ServiceException;

    /**
     * Find users on the ourse
     *
     * @param courseId the course id
     * @return the users list
     * @throws ServiceException if an service exception occurred while processing
     */
    List<User> findAllUsersOnCourse(long courseId) throws ServiceException;

    /**
     * Count number of all users
     *
     * @return the users count
     * @throws ServiceException if an service exception occurred while processing
     */
    int countAllUsers() throws ServiceException;

    /**
     * Update user role
     *
     * @param user the user object
     * @throws ServiceException if an service exception occurred while processing
     */
    void updateUserRole(User user) throws ServiceException;
}

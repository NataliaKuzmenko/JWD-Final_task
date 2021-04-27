package by.epamtc.final_task.service.impl;


import by.epamtc.final_task.dao.UserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.impl.UserDaoImpl;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.validation.HashPassword;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class UserServiceImplTest {
    private UserDao userDao;
    private UserService userService;

    @BeforeTest
    public void init() {
        userDao = mock(UserDaoImpl.class);
        Whitebox.setInternalState(UserDaoImpl.class, "instance", userDao);
        userService = UserServiceImpl.getInstance();
    }

    @Test
    public void findUserWithTheAllInfoByLoginPositiveTest() throws ServiceException, DaoException {
        User expected = new User(5, "email1@mail.ru", "Семен", "Семенов", User.UserRole.valueOf("STUDENT"), "defaultPhoto.png");
        when(userDao.findUserWithTheAllInfoByLogin("email1@mail.ru")).thenReturn(expected);
        User actual = userService.findUserWithTheAllInfoByLogin("email1@mail.ru");
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findUserWithTheAllInfoByLoginThrowServiceExceptionTest() throws ServiceException, DaoException {
        User expected = new User(5, "email1@mail.ru", "Семен", "Семенов", User.UserRole.valueOf("STUDENT"), "defaultPhoto.png");
        when(userDao.findUserWithTheAllInfoByLogin("email1@mail.ru")).thenReturn(expected);
        User actual = userService.findUserWithTheAllInfoByLogin("email@mail.ru");
        assertNotEquals(actual, expected);
    }

    @Test
    public void isLoginAndPasswordValidPositiveTest() throws ServiceException, DaoException {
        String email = "email1@mail.ru";
        String password = "Qwer11";
        boolean expected = true;
        when(userDao.findUserByLoginAndPassword(email, HashPassword.hash(password))).thenReturn(expected);
        boolean actual = userService.isLoginAndPasswordValid(email, password);
        assertEquals(actual, expected);
    }
    @Test
    public void isLoginAndPasswordValidNegativeTest() throws ServiceException, DaoException {
        String email = "email1@mail.ru";
        String password = "Qwer11";
        boolean expected = true;
        when(userDao.findUserByLoginAndPassword(email, HashPassword.hash(password))).thenReturn(expected);
        boolean actual = userService.isLoginAndPasswordValid("email@mail.ru", password);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findUserByIdPositiveTest() throws ServiceException, DaoException {
        User expected = new User(5, "email3@mail.ru", "Александр", "Александров", User.UserRole.valueOf("STUDENT"), "defaultPhoto.png");
        when(userDao.findUserById(5)).thenReturn(expected);
        User actual = userService.findUserById(5);
        assertEquals(expected, actual);
    }
    @Test
    public void findUserByIdNegativeTest() throws ServiceException, DaoException {
        User expected = new User(5, "email3@mail.ru", "Александр", "Александров", User.UserRole.valueOf("STUDENT"), "defaultPhoto.png");
        when(userDao.findUserById(5)).thenReturn(expected);
        User actual = userService.findUserById(6);
        assertNotEquals(expected, actual);
    }

    @Test
    public void isLoginExistsPositiveTest() throws DaoException, ServiceException {
        boolean expected = false;
        when(userDao.isUserExist("email@mail.ru")).thenReturn(expected);
        boolean actual = userService.isLoginExists("email@mail.ru");
        assertEquals(actual,expected);
    }
    @Test
    public void isLoginExistsNegativeTest() throws DaoException, ServiceException {
        boolean expected = true;
        when(userDao.isUserExist("email1@mail.ru")).thenReturn(expected);
        boolean actual = userService.isLoginExists("email@mail.ru");
        assertNotEquals(actual,expected);
    }
}

package by.epamtc.final_task.dao.impl;

import by.epamtc.final_task.dao.UserDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserDaoTest {
    private final UserDao userDao = UserDaoImpl.getInstance();

    @Test
    public void findUserByLoginAndPasswordPositiveTest() throws DaoException {
        String email = "email1@mail.ru";
        String password = "ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1";
        boolean expected = true;
        boolean actual = userDao.findUserByLoginAndPassword(email, password);
        assertEquals(expected, actual);
    }

    @Test
    public void findUserWithTheAllInfoByLoginNegativeTest() throws DaoException {
        User expected = new User(5, "email1@mail.ru", "Семен", "Семенов", User.UserRole.valueOf("STUDENT"), "defaultPhoto.png");
        User actual = userDao.findUserWithTheAllInfoByLogin("email1@mail.ru");
        assertNotEquals("Data is incorrect", actual, expected);
    }

    @Test
    public void findUserWithTheAllInfoByLoginPositiveTest() throws DaoException {
        User expected = new User(5, "email3@mail.ru", "Александр", "Александров", User.UserRole.valueOf("STUDENT"), "defaultPhoto.png");
        User actual = userDao.findUserWithTheAllInfoByLogin("email3@mail.ru");
        assertEquals("Data is incorrect", actual, expected);
    }

    @Test
    public void isUserExistPositiveTest() throws DaoException {
        boolean expected = true;
        boolean actual = userDao.isUserExist("email5@mail.ru");
        assertEquals(expected, actual);
    }

    @Test
    public void isUserExistNegativeTest() throws DaoException {
        boolean expected = true;
        boolean actual = userDao.isUserExist("email55@mail.ru");
        assertNotEquals(expected, actual);
    }

    @Test
    public void findUserByIdPositiveTest() throws DaoException {
        long userId = 7;
        User expected = new User(7, "email5@mail.ru", "Геннадий", "Геннадьев", User.UserRole.valueOf("STUDENT"), "defaultPhoto.png");
        User actual = userDao.findUserById(userId);
        assertEquals(expected, actual);
    }

    @Test
    public void findUserByIdNegativeTest() throws DaoException {
        long userId = 11;
        User expected = new User(11, "email8@mail.ru", "Геннадий", "Геннадьев", User.UserRole.valueOf("STUDENT"), "defaultPhoto.png");
        User actual = userDao.findUserById(userId);
        assertNotEquals(expected, actual);
    }

    @Test
    public void isUserOnCoursePositiveTest() throws DaoException {
        boolean expected = true;
        boolean actual = userDao.isUserOnCourse(3, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void isUserOnCourseNegativeTest() throws DaoException {
        boolean expected = true;
        boolean actual = userDao.isUserOnCourse(8, 1);
        assertNotEquals(expected, actual);
    }

    @Test
    public void countAllUsersPositiveTest() throws DaoException {
        int expected = 12;
        int actual = userDao.countAllUsers();
        assertEquals(expected, actual);
    }

    @Test
    public void countAllUsersNegativeTest() throws DaoException {
        int expected = 45;
        int actual = userDao.countAllUsers();
        assertNotEquals(expected, actual);
    }

    @Test
    public void findAllUsersOnCourseNegativeTest() throws DaoException {
        List<User> expected = new ArrayList<>();
        expected.add(new User(11, "email8@mail.ru", "Геннадий", "Геннадьев", User.UserRole.valueOf("STUDENT"), "defaultPhoto.png"));
        expected.add(new User(7, "email5@mail.ru", "Геннадий", "Геннадьев", User.UserRole.valueOf("STUDENT"), "defaultPhoto.png"));
        List<User> actual = userDao.findAllUsersOnCourse(3);
        assertNotEquals(expected, actual);
    }
}

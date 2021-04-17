package by.epamtc.final_task.service.validation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserValidatorTest {

    @Test
    public void isRightEmailPositiveTest() {
        String email = "emai@test.ru";
        UserValidator userValidator = UserValidator.getInstance();
        boolean actual = userValidator.isRightEmail(email);
        assertTrue(actual);
    }
    @Test
    public void isRightEmailNegativeTest() {
        String email = "emailtest.ru";
        UserValidator userValidator = UserValidator.getInstance();
        boolean actual = userValidator.isRightEmail(email);
        assertFalse(actual);
    }
    @Test
    public void isRightPasswordPositiveTest(){
        String password = "Qwert11";
        UserValidator userValidator = UserValidator.getInstance();
        boolean actual = userValidator.isRightPassword(password);
        assertTrue(actual);
    }
    @Test
    public void isRightPasswordNegativeTest(){
        String password = "qwert11";
        UserValidator userValidator = UserValidator.getInstance();
        boolean actual = userValidator.isRightPassword(password);
        assertFalse(actual);
    }
    @Test
    public void isRightNamePositiveTest(){
        String name = "Natalia";
        UserValidator userValidator = UserValidator.getInstance();
        boolean actual = userValidator.isRightName(name);
        assertTrue(actual);
    }
    @Test
    public void isRightNameNegativeTest(){
        String name = "753";
        UserValidator userValidator = UserValidator.getInstance();
        boolean actual = userValidator.isRightName(name);
        assertFalse(actual);
    }
    @Test
    public void isRightLastNamePositiveTest(){
        String lastName = "Kuzmenko";
        UserValidator userValidator = UserValidator.getInstance();
        boolean actual = userValidator.isRightLastName(lastName);
        assertTrue(actual);
    }
    @Test
    public void isRightLastNameNegativeTest(){
        String lastName = "753";
        UserValidator userValidator = UserValidator.getInstance();
        boolean actual = userValidator.isRightLastName(lastName);
        assertFalse(actual);
    }

}

package by.epamtc.final_task.service.validation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashPasswordTest {

    @Test
    public void hashPositiveTest() {
        String password = "Qwer11";
        String expected = "414fc215d37c26f2a5996a35664c42ff";
        String actual = HashPassword.hashPassword(password);
        assertEquals(expected, actual);
    }
}

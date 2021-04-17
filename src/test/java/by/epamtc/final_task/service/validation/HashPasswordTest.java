package by.epamtc.final_task.service.validation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashPasswordTest {

    @Test
    public void hashPositiveTest() {
        String password = "Qwer11";
        String expected = "ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1";
        String actual = HashPassword.hash(password);
        assertEquals(expected, actual);
    }
}

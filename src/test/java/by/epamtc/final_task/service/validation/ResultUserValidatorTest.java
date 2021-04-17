package by.epamtc.final_task.service.validation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ResultUserValidatorTest {
    @Test
    public void isRightCommentPositiveTest() {
        String comment = "Внимательный студент";
        ResultUserValidator resultUserValidator = ResultUserValidator.getInstance();
        boolean actual = resultUserValidator.isRightComment(comment);
        assertTrue(actual);
    }

    @Test
    public void isRightCommentNegativeTest() {
        String comment = "Вн";
        ResultUserValidator resultUserValidator = ResultUserValidator.getInstance();
        boolean actual = resultUserValidator.isRightComment(comment);
        assertFalse(actual);
    }

    @Test
    public void isRightMarkPositiveTest() {
        int mark = 9;
        ResultUserValidator resultUserValidator = ResultUserValidator.getInstance();
        boolean actual = resultUserValidator.isRightMark(mark);
        assertTrue(actual);
    }

    @Test
    public void isRightMarkNegativeTest() {
        int mark = -8;
        ResultUserValidator resultUserValidator = ResultUserValidator.getInstance();
        boolean actual = resultUserValidator.isRightMark(mark);
        assertFalse(actual);
    }
}

package by.epamtc.final_task.service.validation;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseValidatorTest {
    @Test
    public void isRightTitlePositiveTest() {
        String title = "Английский язык";
        CourseValidator courseValidator = CourseValidator.getInstance();
        boolean actual = courseValidator.isRightTitle(title);
        assertTrue(actual);
    }

    @Test
    public void isRightTitleNegativeTest() {
        String title = "Ан";
        CourseValidator courseValidator = CourseValidator.getInstance();
        boolean actual = courseValidator.isRightTitle(title);
        assertFalse(actual);
    }

    @Test
    public void isRightDescriptionPositiveTest() {
        String description = "Описание курса";
        CourseValidator courseValidator = CourseValidator.getInstance();
        boolean actual = courseValidator.isRightDescription(description);
        assertTrue(actual);
    }

    @Test
    public void isRightDescriptionNegativeTest() {
        String description = "Jg";
        CourseValidator courseValidator = CourseValidator.getInstance();
        boolean actual = courseValidator.isRightDescription(description);
        assertFalse(actual);
    }

    @Test
    public void isRightStartDatePositiveTest() {
        LocalDate date = LocalDate.parse("2021-09-01");
        CourseValidator courseValidator = CourseValidator.getInstance();
        boolean actual = courseValidator.isRightStartDate(date);
        assertTrue(actual);
    }

    @Test
    public void isRightStartDateNegativeTest() {
        LocalDate date = LocalDate.parse("2020-09-01");
        CourseValidator courseValidator = CourseValidator.getInstance();
        boolean actual = courseValidator.isRightStartDate(date);
        assertFalse(actual);
    }

    @Test
    public void isRightEndDatePositiveTest() {
        LocalDate startDate = LocalDate.parse("2021-09-01");
        LocalDate endDate = LocalDate.parse("2021-10-01");
        CourseValidator courseValidator = CourseValidator.getInstance();
        boolean actual = courseValidator.isRightEndDate(startDate, endDate);
        assertTrue(actual);
    }

    @Test
    public void isRightEndDateNegativeTest() {
        LocalDate startDate = LocalDate.parse("2021-09-01");
        LocalDate endDate = LocalDate.parse("2021-08-01");
        CourseValidator courseValidator = CourseValidator.getInstance();
        boolean actual = courseValidator.isRightEndDate(startDate, endDate);
        assertFalse(actual);
    }

    @Test
    public void isRightFormatPositiveTest() {
        String format = "ONLINE";
        CourseValidator courseValidator = CourseValidator.getInstance();
        boolean actual = courseValidator.isRightFormat(format);
        assertTrue(actual);
    }
}



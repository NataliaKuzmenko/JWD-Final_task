package by.epamtc.final_task.dao.impl;

import by.epamtc.final_task.dao.CourseDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.Course;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertNotEquals;

public class CourseDaoTest {
    private final CourseDao courseDao = CourseDaoImpl.getInstance();

    @Test
    public void findInfoAboutCourseNegativeTest() throws DaoException {
        long courseId = 1;
        Course expected = new Course(1, "title", "description", "materials",
                LocalDate.parse("2021-02-15"), LocalDate.parse("2021-05-06"), 2, Course.StatusCourse.NOT_STARTED, Course.FormatCourse.ONLINE, 10);
        Course actual = courseDao.findInfoAboutCourse(courseId);
        assertNotEquals(expected, actual);
    }
}

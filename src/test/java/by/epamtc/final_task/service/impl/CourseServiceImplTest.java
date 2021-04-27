package by.epamtc.final_task.service.impl;

import by.epamtc.final_task.dao.CourseDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.impl.CourseDaoImpl;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.service.CourseService;
import by.epamtc.final_task.service.exception.ServiceException;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CourseServiceImplTest {
    private CourseDao courseDao;
    private CourseService courseService;

    @BeforeTest
    public void init() {
        courseDao = mock(CourseDaoImpl.class);
        Whitebox.setInternalState(CourseDaoImpl.class, "instance", courseDao);
        courseService = CourseServiceImpl.getInstance();
    }

    @Test
    public void findInfoAboutCoursePositiveTest() throws DaoException, ServiceException {
        Course expected = new Course(1, "Общий курс английского языка", "ОБЩИЙ КУРС АНГЛИЙСКОГО ЯЗЫКА",
                "materials.pdf", LocalDate.parse("2021-09-01"), LocalDate.parse("2022-05-31"), 2,
                Course.StatusCourse.IN_PROGRESS, Course.FormatCourse.OFFLINE, 12);
        when(courseDao.findInfoAboutCourse(1)).thenReturn(expected);
        Course actual = courseService.findInfoAboutCourse(1);
        assertEquals(expected, actual);
    }

    @Test
    public void countAllCoursesPositiveTest() throws DaoException, ServiceException {
        int expected = 6;
        when(courseDao.countAllCourses()).thenReturn(expected);
        int actual = courseService.countAllCourses();
        assertEquals(actual, expected);
    }

    @Test
    public void countCoursesPositiveTest() throws DaoException, ServiceException {
        int expected = 5;
        when(courseDao.countCourses("NOT_STARTED")).thenReturn(expected);
        int actual = courseService.countCourses("NOT_STARTED");
        assertEquals(actual, expected);
    }

    @Test
    public void countCoursesNegativeTest() throws DaoException, ServiceException {
        int expected = 6;
        when(courseDao.countCourses("NOT_STARTED")).thenReturn(expected);
        int actual = courseService.countCourses("FINISHED");
        assertNotEquals(actual, expected);
    }
}

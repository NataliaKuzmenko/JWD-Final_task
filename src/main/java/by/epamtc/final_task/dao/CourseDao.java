package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseDao {

    void create(String title, String description, long lecturerId, LocalDate startDate, LocalDate endDate, String format) throws DaoException;

    List<Course> findCoursesAvailableForRegistration(int count, int offset) throws DaoException;

    List<Course> findAllCourses(int count, int offset) throws DaoException;

    Course findInfoAboutCourse(long courseId) throws DaoException;

    int countCourses(String status) throws DaoException;

    int countAllCourses() throws DaoException;

    List<Course> findCoursesUser(long userId) throws DaoException;

    void updateStatusCourse(long courseId, Course.StatusCourse statusCourse) throws DaoException;

    void updateFormat(long courseId, Course.FormatCourse format) throws DaoException;

    void updateTitle(long courseId, String title) throws DaoException;

    void updateDescription(long courseId, String description) throws DaoException;

    void updateDate(long courseId, LocalDate startDate, LocalDate endDate) throws DaoException;

}

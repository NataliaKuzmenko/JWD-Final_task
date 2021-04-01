package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.entity.User;

import java.util.List;

public interface CourseDao {

    List<Course> findCoursesAvailableForRegistration(int count, int offset) throws DaoException;

    List<Course> findAllCourses(int count, int offset) throws DaoException;

    Course findInfoAboutCourse(long courseId) throws DaoException;

    int countCourses(String status) throws DaoException;

    int countAllCourses() throws DaoException;

    List<Course> findCoursesUser(long userId) throws DaoException;

   // User.UserCourseStatus getStatusUserOnCourse(long userId, long courseId) throws DaoException;
}

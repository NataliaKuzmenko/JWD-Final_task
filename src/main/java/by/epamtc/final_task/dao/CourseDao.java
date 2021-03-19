package by.epamtc.final_task.dao;

import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.service.exception.ServiceException;

import java.util.List;

public interface CourseDao {

    //List<Course> findTitlesOfCourses(int count, int offset) throws DaoException;
    List<Course> findCoursesAvailableForRegistration(int count,int offset) throws DaoException;

    Course findInfoAboutCourse(int courseId) throws DaoException;

    int countCourses(String status) throws DaoException;
}

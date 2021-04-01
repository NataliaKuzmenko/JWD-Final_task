package by.epamtc.final_task.service;

import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.exception.ServiceException;

import java.util.List;

public interface CourseService {

    List<Course> findCoursesAvailableForRegistration(int count) throws ServiceException;

    List<Course> findAllCourses(int count) throws ServiceException;

    Course findInfoAboutCourse(long courseId) throws ServiceException;

    int countCourses(String status) throws ServiceException;

    int countAllCourses() throws ServiceException;

    List<Course> findCoursesUser(long userId) throws ServiceException;

   // User.UserCourseStatus getStatusUserOnCourse(long userId, long courseId) throws ServiceException;

}

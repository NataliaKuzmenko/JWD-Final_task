package by.epamtc.final_task.service;

import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.service.exception.ServiceException;

import java.util.List;

public interface CourseService {

   // List<Course> findTitlesOfCourses(int count) throws ServiceException;

    List<Course> findCoursesAvailableForRegistration(int count) throws ServiceException;

    Course findInfoAboutCourse(int courseId) throws ServiceException;

    int countCourses(String status) throws ServiceException;
}

package by.epamtc.final_task.service;

import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.service.exception.ServiceException;

import java.time.LocalDate;
import java.util.List;

public interface CourseService {
    void create(String title, String description, long lecturerId, LocalDate startDate, LocalDate endDate, String format) throws ServiceException;

    List<Course> findCoursesAvailableForRegistration(int count) throws ServiceException;

    List<Course> findAllCourses(int count) throws ServiceException;

    Course findInfoAboutCourse(long courseId) throws ServiceException;

    int countCourses(String status) throws ServiceException;

    int countAllCourses() throws ServiceException;

    List<Course> findCoursesUser(long userId) throws ServiceException;

    void updateStatusCourse(long courseId, Course.StatusCourse statusCourse) throws ServiceException;

    void updateFormat(long courseId, Course.FormatCourse format) throws ServiceException;

    void updateTitle(long courseId, String title) throws ServiceException;

    void updateDescription(long courseId, String description) throws ServiceException;

    void updateDate(long courseId, LocalDate startDate, LocalDate endDate) throws ServiceException;

    List<Course> findCoursesByLecturerId(Long lecturerId) throws ServiceException;

}

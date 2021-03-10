package by.epamtc.final_task.service;

import by.epamtc.final_task.entity.course.Course;
import by.epamtc.final_task.entity.course.StatusCourse;
import by.epamtc.final_task.service.exception.ServiceException;

public interface CourseService {
    void create(Course course) throws ServiceException;
    void update(Course course) throws ServiceException;
    void updateStatus(int courseId, StatusCourse courseStatus) throws ServiceException;
}

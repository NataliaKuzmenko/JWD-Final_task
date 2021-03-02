package by.epamtc.final_task.service;

import by.epamtc.final_task.service.exception.ServiceException;

public interface ResultUserService {

    void addCourseResult(int studentId, int courseId, int mark, String comment) throws ServiceException;
}

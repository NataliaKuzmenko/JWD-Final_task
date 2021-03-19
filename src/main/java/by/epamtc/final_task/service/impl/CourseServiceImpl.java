package by.epamtc.final_task.service.impl;

import by.epamtc.final_task.dao.CourseDao;
import by.epamtc.final_task.dao.exception.DaoException;
import by.epamtc.final_task.dao.impl.CourseDaoImpl;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.service.CourseService;
import by.epamtc.final_task.service.exception.ServiceException;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private static final int PAGE_ITEMS_COUNT = 5;


    private static final CourseServiceImpl instance = new CourseServiceImpl();
    private CourseDao courseDao = CourseDaoImpl.getInstance();

    private CourseServiceImpl() {
    }

    public static CourseServiceImpl getInstance() {
        return instance;
    }


/*    @Override
    public List<Course> findTitlesOfCourses(int count) throws ServiceException {
        try {
            int offset = PAGE_ITEMS_COUNT * count;
            List<Course> titleList = courseDao.findTitlesOfCourses(PAGE_ITEMS_COUNT, offset);
            if (titleList.isEmpty()) {
                throw new ServiceException("Courses not found.");
            }
            return titleList;
        } catch (DaoException e) {
            throw new ServiceException("Courses not found", e);
        }
    }*/

    @Override
    public List<Course> findCoursesAvailableForRegistration(int count) throws ServiceException {
        try {
            int offset = PAGE_ITEMS_COUNT * count;
            List<Course> titleList = courseDao.findCoursesAvailableForRegistration(PAGE_ITEMS_COUNT, offset);
            if (titleList.isEmpty()) {
                throw new ServiceException("Courses not found.");
            }
            return titleList;
        } catch (DaoException e) {
            throw new ServiceException("Courses not found", e);
        }
    }

    @Override
    public Course findInfoAboutCourse(int courseId) throws ServiceException {

        try {
            Course course = courseDao.findInfoAboutCourse(courseId);
            if (course == null) {
                throw new ServiceException("Course not found.");
            }
            return course;
        } catch (DaoException e) {
            throw new ServiceException("Course not found", e);
        }
    }

    @Override
    public int countCourses(String status) throws ServiceException {
        try {
            return courseDao.countCourses(status);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}

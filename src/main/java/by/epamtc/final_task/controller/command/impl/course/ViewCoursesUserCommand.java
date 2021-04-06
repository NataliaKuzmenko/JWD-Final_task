package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.entity.ResultUser;
import by.epamtc.final_task.service.CourseService;
import by.epamtc.final_task.service.ResultUserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.CourseServiceImpl;
import by.epamtc.final_task.service.impl.ResultUserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCoursesUserCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    private CourseService courseService = CourseServiceImpl.getInstance();
    private ResultUserService resultUserService = ResultUserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page = PageName.USER_COURSES;

        String courseIdStr = request.getParameter(ParameterName.COURSE_ID);
        long userId = (Long) request.getSession().getAttribute(ParameterName.USER_ID);

        try {
            if (courseIdStr != null) {
                long courseId = Long.parseLong(courseIdStr);
                if (resultUserService.updateUserCourseStatus(userId, courseId, ResultUser.UserCourseStatus.DENIED)) {
                    request.setAttribute(ParameterName.COURSE_CANCEL, true);
                } else {
                    request.setAttribute(ParameterName.ERROR_CANCEL_COURSE, true);
                }
            }

            Map<Course, ResultUser> userCourses = new HashMap<>();
            List<Course> courseList = courseService.findCoursesUser(userId);
            for (Course course : courseList
            ) {
                ResultUser resultUser = resultUserService.findResultUser(userId, course.getId());
                userCourses.put(course, resultUser);
            }
            if (userCourses.isEmpty()) {
                request.setAttribute(ParameterName.NOT_REGISTER_ON_COURSE, true);
            } else {
                request.setAttribute(ParameterName.NOT_REGISTER_ON_COURSE, false);
                request.setAttribute(ParameterName.COURSE_LIST, userCourses);
            }

            request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND, "viewcoursesuser");
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Command  ViewCoursesUserCommand invalid", e);
            throw new CommandException("Command  ViewCoursesUserCommand invalid", e);
        }
        return new Router(page);
    }
}

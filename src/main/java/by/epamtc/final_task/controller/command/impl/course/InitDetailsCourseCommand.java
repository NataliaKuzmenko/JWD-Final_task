package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.CourseService;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.CourseServiceImpl;
import by.epamtc.final_task.service.impl.UserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Class implementing action of opening 'Course details' page
 */
public class InitDetailsCourseCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    private final CourseService courseService = CourseServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {

        Course course;
        User user;
        String courseIdStr = request.getParameter(ParameterName.COURSE_ID) == null
                ? (String) request.getSession().getAttribute(ParameterName.COURSE_ID)
                : request.getParameter(ParameterName.COURSE_ID);
        request.getSession().setAttribute(ParameterName.COURSE_ID, courseIdStr);
        String statusCourse = request.getParameter(ParameterName.STATUS_COURSE);
        String register = request.getParameter(ParameterName.REGISTER);
        String format = request.getParameter(ParameterName.FORMAT);

        try {
            long courseId = Long.parseLong(courseIdStr);

            if (statusCourse != null) {
                courseService.updateStatusCourse(courseId, Course.StatusCourse.valueOf(statusCourse));
                request.setAttribute(ParameterName.CHANGE_STATUS_COURSE, true);
            }
            if (format != null) {
                courseService.updateFormat(courseId, Course.FormatCourse.valueOf(format));
                request.setAttribute(ParameterName.CHANGE_FORMAT_COURSE, true);
            }

            if (register != null) {
                Long userIdStr = (Long) request.getSession().getAttribute(ParameterName.USER_ID);
                if (userService.addUserOnCourse(userIdStr, courseId)) {
                    request.setAttribute(ParameterName.REGISTER_COURSE_MESSAGE, true);
                } else {
                    request.setAttribute(ParameterName.REGISTER_COURSE_ERROR, true);
                }
            }

            course = courseService.findInfoAboutCourse(courseId);
            user = userService.findUserById(course.getLecturerId());

            request.setAttribute(ParameterName.COURSE, course);
            request.setAttribute(ParameterName.USER, user);

            request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND, ParameterName.INIT_DETAILS_COURSE_COMMAND);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Course not found", e);
            throw new CommandException("Command  InitDetailsCourseCommand invalid", e);
        }
        return new Router(PageName.DETAILS_COURSE_PAGE);
    }
}



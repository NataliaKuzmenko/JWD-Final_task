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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class InitDetailsCourseCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    private final CourseService courseService = CourseServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page;
        Course course;
        User user;
        String courseIdStr = request.getParameter(ParameterName.COURSE_ID);
        if (courseIdStr == null) {
            courseIdStr = (String) request.getSession().getAttribute(ParameterName.COURSE_ID);
        }
        request.getSession().setAttribute(ParameterName.COURSE_ID, courseIdStr);
        try {
            long courseId = Long.parseLong(courseIdStr);
            course = courseService.findInfoAboutCourse(courseId);
            user = userService.findUserById(course.getLecturerId());
        } catch (ServiceException e) {
            throw new CommandException("Command  InitDetailsCourseCommand invalid", e);
        }
        request.getSession().setAttribute(ParameterName.COURSE, course);
        request.getSession().setAttribute(ParameterName.USER, user);

        request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND,
                ParameterName.INIT_DETAILS_COURSE_COMMAND);

        page = PageName.DETAILS_COURSE_PAGE;
        return new Router(page);
    }
}



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
import java.util.List;

public class CoursesLecturerCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    private final CourseService courseService = CourseServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {

        String email = (String) request.getSession().getAttribute(ParameterName.EMAIL);
        try {
            User user = userService.findUserWithTheAllInfoByLogin(email);
            List<Course> listCourses = courseService.findCoursesByLecturerId(user.getUserId());
            if (listCourses.isEmpty()) {
                request.setAttribute(ParameterName.NOT_COURSES, true);
            } else {
                request.setAttribute(ParameterName.NOT_COURSES, false);
                request.setAttribute(ParameterName.COURSE_LIST, listCourses);
            }
            request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND, ParameterName.COURSES_LECTURER);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Command  coursesLecturer invalid", e);
            throw new CommandException("Command  coursesLecturer invalid", e);
        }
        return new Router(PageName.LECTURER_COURSES_PAGE);
    }
}

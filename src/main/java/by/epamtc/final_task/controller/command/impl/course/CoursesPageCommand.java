package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.service.CourseService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.CourseServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Class implementing action of opening 'Courses list' page
 *
 */
public class CoursesPageCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger();
    private final CourseService courseService = CourseServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String pageForRouter;
        String pageStr = request.getParameter(ParameterName.PAGE);

        try {
            int page = (pageStr == null) ? 0 : Integer.parseInt(pageStr);

            List<Course> listCourse = courseService.findAllCourses(page);
            int coursesCount = courseService.countAllCourses();
            request.setAttribute(ParameterName.COURSE_LIST, listCourse);
            request.getSession().setAttribute(ParameterName.COURSES_COUNT, coursesCount);
            request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND, ParameterName.COURSES_PAGE_COMMAND);
            pageForRouter = PageName.COURSES_PAGE;
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Command  coursesPageCommand invalid", e);
            throw new CommandException("Command  coursesPageCommand invalid", e);
        }
        return new Router(pageForRouter);
    }
}

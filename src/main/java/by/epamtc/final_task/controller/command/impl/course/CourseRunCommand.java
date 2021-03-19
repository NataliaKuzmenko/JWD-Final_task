package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.constant.ParameterName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.entity.Course;
import by.epamtc.final_task.service.CourseService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.CourseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CourseRunCommand implements Command {

    private final CourseService courseService = CourseServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {

        String pageForRouter;
        String pageStr = request.getParameter(ParameterName.PAGE);

        try {
            int page = (pageStr == null) ? 0 : Integer.parseInt(pageStr);
            List<Course> listCourse = courseService.findCoursesAvailableForRegistration(page);
            request.setAttribute(ParameterName.COURSE_LIST, listCourse);
            int coursesCount = courseService.countCourses(String.valueOf(Course.StatusCourse.NOT_STARTED));
            request.getSession().setAttribute(ParameterName.COURSES_COUNT, coursesCount);
            pageForRouter = PageName.COURSES_PAGE;
        } catch (ServiceException e) {
            throw new CommandException("Command  courseRunCommand invalid", e);
        }
        return new Router(pageForRouter);
    }
}

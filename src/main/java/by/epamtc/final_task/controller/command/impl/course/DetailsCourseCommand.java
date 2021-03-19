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

public class DetailsCourseCommand implements Command {

    private final CourseService courseService = CourseServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page;
        Course course;
        String courseIdStr = request.getParameter(ParameterName.COURSE_ID);

        try {
            int courseId = Integer.parseInt(courseIdStr);
            course = courseService.findInfoAboutCourse(courseId);
        } catch (ServiceException e) {
            throw new CommandException("Command  DetailsCourseCommand invalid", e);
        }
        request.setAttribute(ParameterName.COURSE_TITLE, course.getTitle());
        request.setAttribute(ParameterName.DESCRIPTION, course.getDescripton());

        page = PageName.DETAILS_COURSE_PAGE;
        return new Router(page);
    }
}

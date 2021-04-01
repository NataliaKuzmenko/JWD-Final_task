package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;

import javax.servlet.http.HttpServletRequest;

public class UpdateStatusCourseCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page;
       String courseIdStr = request.getParameter(ParameterName.COURSE_ID);
        String statusCourse = request.getParameter(ParameterName.STATUS_COURSE);
       // long courseId = Long.parseLong(courseIdStr);
        System.out.println(courseIdStr);
System.out.println(statusCourse);
        page = PageName.DETAILS_COURSE_PAGE;
        return new Router(page);
    }
}

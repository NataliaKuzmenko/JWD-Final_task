package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CreateCourseCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page;
        Long authorId = request.getParameter(ParameterName.USER_ID) == null
                ? (Long) request.getSession().getAttribute(ParameterName.USER_ID)
                : Long.valueOf(request.getParameter(ParameterName.USER_ID));

        String statusCourse = request.getParameter(ParameterName.STATUS_COURSE);
        String title = request.getParameter(ParameterName.TITLE);
        String description = request.getParameter(ParameterName.DESCRIPTION);
        String limitStudents = request.getParameter(ParameterName.LIMIT_STUDENTS);
        String start = request.getParameter(ParameterName.START);
        String end = request.getParameter(ParameterName.END);
        String format = request.getParameter(ParameterName.FORMAT);

        request.setAttribute(ParameterName.CREATE_MESSAGE, true);
        request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND,"createcourse");

        page = PageName.CREATE_COURSE;
        return new Router(page);
    }
}

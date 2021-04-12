package by.epamtc.final_task.controller.command.impl.page;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The command that helps to go to "Edit course" page
 */
public class ForwardToEditCourseCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page = PageName.EDIT_COURSE;
        String courseIdStr = request.getParameter(ParameterName.COURSE_ID);
        request.getSession().setAttribute(ParameterName.COURSE_ID, courseIdStr);
        String parameter = request.getParameter(ParameterName.PARAMETER);
        request.getSession().setAttribute(ParameterName.PARAMETER, parameter);
        return new Router(page);
    }
}


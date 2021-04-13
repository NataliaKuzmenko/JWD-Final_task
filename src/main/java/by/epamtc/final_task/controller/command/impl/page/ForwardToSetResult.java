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
 * The command that helps to go to "Add result" page
 */
public class ForwardToSetResult implements Command {
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page;
        String studentId = request.getParameter(ParameterName.STUDENT_ID);
        request.getSession().setAttribute(ParameterName.STUDENT_ID, studentId);
        page = PageName.SET_USER_RESULT_PAGE;
        return new Router(page);
    }
}

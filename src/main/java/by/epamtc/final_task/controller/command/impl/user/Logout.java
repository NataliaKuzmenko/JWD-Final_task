package by.epamtc.final_task.controller.command.impl.user;

import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class Logout implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page = PageName.LOGIN_PAGE;
        String currentPage = (String) request.getSession().getAttribute(ParameterName.CURRENT_PAGE);
        String language = (String) request.getSession().getAttribute(ParameterName.LANGUAGE);
        request.getSession().invalidate();
        request.getSession().setAttribute(ParameterName.CURRENT_PAGE, currentPage);
        request.getSession().setAttribute(ParameterName.LANGUAGE, language);
        return new Router(page);
    }
}

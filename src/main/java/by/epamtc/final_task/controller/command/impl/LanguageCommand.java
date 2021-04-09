package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.CommandProvider;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Command for changing the language in the application
 */
public class LanguageCommand implements Command {

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String language = request.getParameter(ParameterName.LANGUAGE);
        HttpSession session = request.getSession();
        session.setAttribute(ParameterName.LANGUAGE, language);

        String action = request.getParameter(ParameterName.LANG_CHANGE_PROCESS_COMMAND) == null
                ? (String) request.getSession().getAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND)
                : request.getParameter(ParameterName.LANG_CHANGE_PROCESS_COMMAND);

        if (ParameterName.EN.equalsIgnoreCase(language)) {
            request.getSession().setAttribute(ParameterName.LANGUAGE, ParameterName.LOCALE_RU);
        } else {
            request.getSession().setAttribute(ParameterName.LANGUAGE, ParameterName.LOCALE_EN);
        }

        String sessionCurrentPage = (String) request.getSession().getAttribute(ParameterName.CURRENT_PAGE);
        String currentPage = sessionCurrentPage == null ? PageName.MAIN_PAGE : sessionCurrentPage;

        if (PageName.INDEX_PAGE.equals(currentPage) && ParameterName.EN.equalsIgnoreCase(language)) {
            currentPage = PageName.MAIN_PAGE;
        }
        Router router = new Router(currentPage);
        if (action != null && !action.isEmpty()) {
            Command current = new EmptyCommand();

            current = CommandProvider.getCommand(current, action);
            router = current.execute(request);
        }
        return router;
    }
}
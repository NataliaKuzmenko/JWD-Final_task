package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.constant.ParameterName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.exception.CommandException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LanguageCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CommandException {

        String language = (String) request.getSession().getAttribute(ParameterName.LANGUAGE);
        if (ParameterName.EN.equalsIgnoreCase(language)) {
            request.getSession().setAttribute(ParameterName.LANGUAGE, ParameterName.LOCALE_RU);
        } else {
            request.getSession().setAttribute(ParameterName.LANGUAGE, ParameterName.LOCALE_EN);
        }
        request.setAttribute(ParameterName.LANGUAGE_CHANGED, true);
        String sessionCurrentPage = (String) request.getSession().getAttribute(ParameterName.CURRENT_PAGE);
        String currentPage = sessionCurrentPage == null ? PageName.MAIN_PAGE : sessionCurrentPage;
        if (PageName.INDEX_PAGE.equals(currentPage) && ParameterName.EN.equalsIgnoreCase(language)) {
            currentPage = PageName.MAIN_PAGE;
        }
        request.getRequestDispatcher(currentPage).forward(request, response);
    }
}


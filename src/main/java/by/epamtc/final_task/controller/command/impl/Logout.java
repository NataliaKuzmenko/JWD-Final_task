package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.constant.ParameterName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout implements Command {
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

    /*@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CommandException {
        request.getSession().invalidate();
        request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
    }*/
}

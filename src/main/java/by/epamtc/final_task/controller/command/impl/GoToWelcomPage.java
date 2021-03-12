package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.exception.CommandException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*public class GoToWelcomPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CommandException {

        HttpSession session = request.getSession();

        if (session == null) {
            request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
        }

        Boolean isAuth = (Boolean) session.getAttribute("auth");

        if (isAuth == null || !isAuth) {
            request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
        }
        request.getRequestDispatcher(PageName.WELCOM_PAGE).forward(request, response);
    }
}*/

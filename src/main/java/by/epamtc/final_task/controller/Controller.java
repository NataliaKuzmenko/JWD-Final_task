package by.epamtc.final_task.controller;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.CommandProvider;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {

    private final CommandProvider provider = new CommandProvider();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        String name;
        Command command;

        name = request.getParameter("command");
        command = provider.takeCommand(name);

        page = command.execute(request);

        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);

            dispatcher.forward(request, response);
        } else {

            page = PageName.INDEX_PAGE;
            request.getSession().setAttribute("nullPage",
                    " Page not found. Business logic error.");
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
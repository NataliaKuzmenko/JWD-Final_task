package by.epamtc.final_task.controller;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.constant.ParameterName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.CommandProvider;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.dao.pool.ConnectionPool;
import by.epamtc.final_task.dao.pool.exception.PoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {
    public static final Logger LOGGER = LogManager.getLogger();
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
        try {
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
        } catch (CommandException e) {
            //logger
            request.setAttribute(ParameterName.ERROR, e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PageName.ERROR_PAGE);
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.getInstance().destroyPool();
        } catch (PoolException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
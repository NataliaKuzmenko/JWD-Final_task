package by.epamtc.final_task.controller;

import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.CommandProvider;
import by.epamtc.final_task.controller.command.Router;
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
import javax.servlet.http.HttpSession;
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

  /*  private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(ParameterName.COMMAND);
        try {

            Command command = provider.takeCommand(commandName);
            Router router = command.execute(request);
            String currentPage = router.getPage();
            if (currentPage == null) {
                router.setPage(PageName.ERROR_PAGE);
                response.sendRedirect(request.getContextPath() + router.getPage());
            }
            if (Router.Type.FORWARD == router.getType()) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(router.getPage());
                dispatcher.forward(request, response);
            } else {
             request.getSession().setAttribute(ParameterName.REDIRECTED_PAGE, router.getPage());
             response.sendRedirect(request.getContextPath() + router.getPage());
            }
            request.getSession().setAttribute(ParameterName.CURRENT_PAGE, currentPage);

        } catch (CommandException e) {
            LOGGER.log(Level.ERROR, e);
            request.setAttribute(ParameterName.ERROR, "Such command is not found");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PageName.ERROR_PAGE);
            dispatcher.forward(request, response);
        }
    }*/
  private void processRequest(HttpServletRequest request
          , HttpServletResponse response) throws ServletException, IOException {
      try {
          String commandName = request.getParameter(ParameterName.COMMAND);
          Command command = provider.takeCommand(commandName);
          Router router = command.execute(request);
          String currentPage = router.getPage();
          if (currentPage == null) {
              router.setPage(PageName.ERROR_PAGE);
              response.sendRedirect(request.getContextPath() + router.getPage());
          }
          if (Router.Type.FORWARD == router.getType()) {
              currentPage = resolveForward(request, router, currentPage);
              RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(router.getPage());
              dispatcher.forward(request, response);
          } else {
              request.getSession().setAttribute(ParameterName.REDIRECTED_PAGE, router.getPage());
              response.sendRedirect(request.getContextPath() + router.getPage());
          }
          request.getSession().setAttribute(ParameterName.CURRENT_PAGE, currentPage);
      } catch (CommandException e) {
          LOGGER.log(Level.ERROR, e);
          request.setAttribute(ParameterName.ERROR, e.getMessage());
          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PageName.ERROR_PAGE);
          dispatcher.forward(request, response);
      }
  }

    private String resolveForward(HttpServletRequest request, Router router, String currentPage) {
        currentPage = resolvePageUpdate(request, router, currentPage);
        if (request.getSession().getAttribute(ParameterName.REDIRECTED_PAGE) != null) {
            router.setPage((String) request.getSession().getAttribute(ParameterName.REDIRECTED_PAGE));
            request.getSession().setAttribute(ParameterName.CURRENT_PAGE_AFTER_REDIRECT, router.getPage());
            request.getSession().removeAttribute(ParameterName.REDIRECTED_PAGE);
        }
        return currentPage;
    }

    private String resolvePageUpdate(HttpServletRequest request, Router router, String routerPage) {
        if (PageName.INDEX_PAGE.equals(routerPage) && request.getSession().getAttribute(ParameterName.REDIRECTED_PAGE) == null) {
            String currentPageAfterRedirect = (String) request.getSession().getAttribute(ParameterName.CURRENT_PAGE_AFTER_REDIRECT);
            if (currentPageAfterRedirect != null) {
                routerPage = currentPageAfterRedirect;

            } else {
                HttpSession session = request.getSession();
                session.removeAttribute(ParameterName.EMAIL);
                session.removeAttribute(ParameterName.ROLE);
            }
            router.setPage(routerPage);
        } else {
            request.getSession().removeAttribute(ParameterName.CURRENT_PAGE_AFTER_REDIRECT);
        }
        return routerPage;
    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.getInstance().destroyPool();
        } catch (PoolException e) {
            LOGGER.log(Level.ERROR, "Error destroy connection pool");
        }
    }
}
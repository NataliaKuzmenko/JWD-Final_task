package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.constant.ParameterName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.UserServiceImpl;
import by.epamtc.final_task.service.validation.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();

    private final UserValidator validationUser = UserValidator.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page;
        String email = request.getParameter(ParameterName.EMAIL);
        String password = request.getParameter(ParameterName.PASSWORD);
        String repeatPassword = request.getParameter(ParameterName.REPEAT_PASSWORD);
        if (!password.equals(repeatPassword)) {
            request.setAttribute(ParameterName.INCORRECT_ERROR_PASSWORDS, "incorrect repeat password");
            //request.setAttribute(RequestAttribute.PASSWORDS_DO_NOT_MATCH, true);
            page = PageName.REGISTRATION_PAGE;
            return new Router(page);
        }
        if (!validationUser.isRightEmail(email) || !validationUser.isRightPassword(password)) {
            request.setAttribute(ParameterName.INCORRECT_ERROR_SYMBOLS, "check email or password");
           // request.setAttribute(RequestAttribute.INCORRECT_ERROR_SYMBOLS, true);
            page = PageName.REGISTRATION_PAGE;
            return new Router(page);
        }
        try {
            Router router;
            if (userService.create(email, password)) {
                router = new Router(PageName.LOGIN_PAGE);
                router.useRedirect();
            } else {
                request.setAttribute(ParameterName.REGISTRATION_ERROR, "user exists or registration error");
               // request.setAttribute(RequestAttribute.REGISTRATION_ERROR, true);
                router = new Router(PageName.REGISTRATION_PAGE);
            }
            return router;
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Registration failed", e);
            throw new CommandException("Registration failed", e);
        }
    }
}


    /*@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CommandException {
        String email = request.getParameter(ParameterName.EMAIL);
        String password = request.getParameter(ParameterName.PASSWORD);
        String repeatPassword = request.getParameter(ParameterName.REPEAT_PASSWORD);

        if (!password.equals(repeatPassword)) {
            request.setAttribute(ParameterName.INCORRECT_ERROR_PASSWORDS, "incorrect repeat password");
            request.getRequestDispatcher(PageName.REGISTRATION_PAGE).forward(request, response);
        }
        if (!validationUser.isRightEmail(email) || !validationUser.isRightPassword(password)) {
            request.setAttribute(ParameterName.INCORRECT_ERROR_SYMBOLS, "check email or password");
            request.getRequestDispatcher(PageName.REGISTRATION_PAGE).forward(request, response);
        }
        try {
            if (userService.create(email, password)) {
                response.sendRedirect("controller?command=gotologinpage&"+ParameterName.REGISTRATION_OK+"="+true);
            } else {
                request.setAttribute(ParameterName.REGISTRATION_ERROR, "user exists or registration error");
                request.getRequestDispatcher(PageName.REGISTRATION_PAGE).forward(request, response);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Registration failed", e);
            throw new CommandException("Registration failed", e);
        }
    }*/


package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.constant.ParameterName;
import by.epamtc.final_task.controller.command.Command;
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
import java.io.IOException;

public class RegistrationCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();

    private final UserValidator validationUser = UserValidator.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException, CommandException {
        String page;
        String email = request.getParameter(ParameterName.EMAIL);
        String password = request.getParameter(ParameterName.PASSWORD);
        String repeatPassword = request.getParameter(ParameterName.REPEAT_PASSWORD);

        if (!password.equals(repeatPassword)) {
            request.setAttribute(ParameterName.INCORRECT_ERROR_PASSWORDS, "incorrect repeat password");
            page = PageName.REGISTRATION_PAGE;
            return page;
        }

        if (!validationUser.isRightEmail(email) || !validationUser.isRightPassword(password)) {
            request.setAttribute(ParameterName.INCORRECT_ERROR_SYMBOLS, "check email or password");
            page = PageName.REGISTRATION_PAGE;
            return page;
        }

        try {
            if (userService.create(email, password)) {
                page = PageName.LOGIN_PAGE;
            } else {
                request.setAttribute(ParameterName.REGISTRATION_ERROR, "user exists or registration error");
                page = PageName.REGISTRATION_PAGE;
            }
            return page;
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Registration failed", e);
            throw new CommandException("Registration failed", e);
        }
    }
}

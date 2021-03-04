package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.constant.ParameterName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.UserServiceImpl;
import by.epamtc.final_task.service.validation.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RegistrationCommand implements Command {

    private final UserValidator validationUser = UserValidator.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException, CommandException {
        String page;
        String email = request.getParameter(ParameterName.EMAIL);
        String password = request.getParameter(ParameterName.PASSWORD);
        String repeatPassword = request.getParameter(ParameterName.REPEAT_PASSWORD);
        if (!password.equals(repeatPassword)) {
            request.setAttribute(ParameterName.INCORRECT_ERROR_PASSWORDS, true);
            page = PageName.REGISTRATION_PAGE;
            return page;
        }
        if (!validationUser.isRightLogin(email) || !validationUser.isRightPassword(password)) {
            request.setAttribute(ParameterName.INCORRECT_ERROR_SYMBOLS, true);
            page = PageName.REGISTRATION_PAGE;
            return page;
        }
        try {

            if (userService.create(email, password)) {
                page = PageName.LOGIN_PAGE;

            } else {
                request.setAttribute(ParameterName.REGISTRATION_ERROR, true);
                page = PageName.REGISTRATION_PAGE;
            }
            return page;
        } catch (ServiceException e) {
            //logger
            throw new CommandException("Registration failed", e);

        }
    }
}

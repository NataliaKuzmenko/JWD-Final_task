package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.constant.ParameterName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.entity.user.User;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.UserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login implements Command {

    public static final Logger LOGGER = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CommandException {
        String email = request.getParameter(ParameterName.EMAIL);
        String password = request.getParameter(ParameterName.PASSWORD);
        try {
            if (userService.isLoginAndPasswordValid(email, password)) {

                User user = userService.findUserWithTheAllInfoByLogin(email);

                // request.getSession().setAttribute(ParameterName.ROLE, user.getRole().name());
                //request.getSession().setAttribute(ParameterName.EMAIL, user.getEmail());
                request.setAttribute(ParameterName.USER_ID, user.getUserId());
                request.setAttribute(ParameterName.EMAIL, user.getEmail());
                request.setAttribute(ParameterName.FIRST_NAME, user.getFirstName());
                request.setAttribute(ParameterName.LAST_NAME, user.getLastName());
                request.setAttribute(ParameterName.PHOTO_PATH, user.getPhotoPath());

                request.getRequestDispatcher(PageName.PROFILE_PAGE).forward(request, response);
            } else {
                request.setAttribute(ParameterName.INCORRECT_LOGIN_AND_PASSWORD, "Incorrect login or password.");
                request.getRequestDispatcher(PageName.LOGIN_PAGE).forward(request, response);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "User is not exist", e);
            throw new CommandException("User is not exist", e);
        }
    }
}



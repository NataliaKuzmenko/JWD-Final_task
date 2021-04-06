package by.epamtc.final_task.controller.command.impl.user;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.UserServiceImpl;
import by.epamtc.final_task.service.validation.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class EditProfileCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();
    private UserValidator validationUser = UserValidator.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page = null;
        long userId = (Long) request.getSession().getAttribute(ParameterName.USER_ID);

        String name = request.getParameter(ParameterName.FIRST_NAME);
        String lastName = request.getParameter(ParameterName.LAST_NAME);
        String email = request.getParameter(ParameterName.EMAIL);

        try {
            if (!email.trim().isEmpty() && !name.trim().isEmpty() && !lastName.trim().isEmpty()) {
                updateNameAndSurnameAndEmail(userId, name, lastName, email, request);
                page = PageName.EDIT_PROFILE_PAGE;
            } else if (name.trim().isEmpty() && lastName.trim().isEmpty()) {
                updateEmail(userId, email, request);
                page = PageName.EDIT_PROFILE_PAGE;
            } else {
                updateNameAndSurname(userId, name, lastName, request);
                page = PageName.EDIT_PROFILE_PAGE;
            }

            request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND, "forwardtoeditprofile");
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "User not found", e);
            throw new CommandException("User not found", e);
        }
        return new Router(page);
    }

    private void updateNameAndSurnameAndEmail(long userId, String name, String lastName, String email, HttpServletRequest request) throws ServiceException {
        if (!userService.isLoginExists(email)) {
            if (validationUser.isRightName(name) && validationUser.isRightLastName(lastName) &&
                    validationUser.isRightEmail(email)) {
                User user = userService.findUserById(userId);
                user.setFirstName(name);
                user.setLastName(lastName);
                user.setEmail(email);
                userService.updateUser(user);
                request.setAttribute(ParameterName.EDIT_PROFILE_RESULT, true);
            } else {
                request.setAttribute(ParameterName.ERROR_DATA, true);
            }
        } else {
            request.setAttribute(ParameterName.USER_IS_EXIST, true);
        }
    }

    private void updateNameAndSurname(long userId, String name, String lastName, HttpServletRequest request) throws ServiceException {
        if (validationUser.isRightName(name) && validationUser.isRightLastName(lastName)) {
            User user = userService.findUserById(userId);
            user.setFirstName(name);
            user.setLastName(lastName);
            userService.updateNameAndSurname(user);
            request.setAttribute(ParameterName.EDIT_PROFILE_RESULT, true);
        } else {
            request.setAttribute(ParameterName.ERROR_DATA, true);
        }
    }

    private void updateEmail(long userId, String email, HttpServletRequest request) throws ServiceException {
        if (!userService.isLoginExists(email)) {
            if (validationUser.isRightEmail(email)) {
                User user = userService.findUserById(userId);
                user.setEmail(email);
                userService.updateEmail(user);
                request.setAttribute(ParameterName.EDIT_PROFILE_RESULT, true);
            } else {
                request.setAttribute(ParameterName.ERROR_DATA, true);
            }
        } else {
            request.setAttribute(ParameterName.USER_IS_EXIST, true);
        }
    }
}


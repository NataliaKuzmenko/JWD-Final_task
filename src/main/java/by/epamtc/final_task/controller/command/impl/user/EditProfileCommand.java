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

/**
 * Class implementing editing of user's profile
 */
public class EditProfileCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger();
    private final UserService userService = UserServiceImpl.getInstance();
    private final UserValidator validationUser = UserValidator.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {

        String emailSession = (String) request.getSession().getAttribute(ParameterName.EMAIL);
        String name = request.getParameter(ParameterName.FIRST_NAME);
        String lastName = request.getParameter(ParameterName.LAST_NAME);
        String email = request.getParameter(ParameterName.EMAIL);

        try {
            User user = userService.findUserWithTheAllInfoByLogin(emailSession);
            if (!email.trim().isEmpty() && !name.trim().isEmpty() && !lastName.trim().isEmpty()) {
                updateNameAndSurnameAndEmail(user.getUserId(), name, lastName, email, request);
            } else if (name.trim().isEmpty() && lastName.trim().isEmpty()) {
                updateEmail(user.getUserId(), email, request);
            } else {
                updateNameAndSurname(user.getUserId(), name, lastName, request);
            }

            request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND,
                    ParameterName.FORWARD_EDIT_PROFILE_COMMAND);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "User not found", e);
            throw new CommandException("User not found", e);
        }
        return new Router(PageName.EDIT_PROFILE_PAGE);
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
                request.getSession().setAttribute(ParameterName.EMAIL, user.getEmail());
                request.setAttribute(ParameterName.EDIT_PROFILE_RESULT, true);
            } else {
                request.setAttribute(ParameterName.ERROR_DATA_PROFILE, true);
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
            request.setAttribute(ParameterName.ERROR_DATA_PROFILE, true);
        }
    }

    private void updateEmail(long userId, String email, HttpServletRequest request) throws ServiceException {
        if (!userService.isLoginExists(email)) {
            if (validationUser.isRightEmail(email)) {
                User user = userService.findUserById(userId);
                user.setEmail(email);
                userService.updateEmail(user);
                request.getSession().setAttribute(ParameterName.EMAIL, user.getEmail());
                request.setAttribute(ParameterName.EDIT_PROFILE_RESULT, true);
            } else {
                request.setAttribute(ParameterName.ERROR_DATA_PROFILE, true);
            }
        } else {
            request.setAttribute(ParameterName.USER_IS_EXIST, true);
        }
    }
}


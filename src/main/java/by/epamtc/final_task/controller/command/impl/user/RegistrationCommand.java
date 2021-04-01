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
            request.setAttribute(ParameterName.INCORRECT_ERROR_PASSWORDS, true);
            page = PageName.REGISTRATION_PAGE;
            return new Router(page);
        }
        if (!validationUser.isRightEmail(email) || !validationUser.isRightPassword(password)) {
            request.setAttribute(ParameterName.INCORRECT_ERROR_SYMBOLS, true);
            page = PageName.REGISTRATION_PAGE;
            return new Router(page);
        }
        try {
            Router router;
            if (userService.create(email, password)) {

                User user = userService.findUserWithTheAllInfoByLogin(email);
                request.getSession().setAttribute(ParameterName.ROLE, user.getRole().name());
                request.getSession().setAttribute(ParameterName.EMAIL, user.getEmail());
                request.getSession().setAttribute(ParameterName.USER_ID,user.getUserId());
                request.setAttribute(ParameterName.FIRST_NAME, user.getFirstName());
                request.setAttribute(ParameterName.LAST_NAME, user.getLastName());
                request.setAttribute(ParameterName.PHOTO_PATH, user.getPhotoPath());

                request.getSession().setAttribute(ParameterName.REGISTRATION_OK, true);
                request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND,"forwardwelcome");
                request.getSession().setAttribute(ParameterName.WELCOME, true);
                router = new Router(PageName.WELCOME_PAGE);
                router.useRedirect();

            } else {
                request.setAttribute(ParameterName.REGISTRATION_ERROR, true);
                router = new Router(PageName.REGISTRATION_PAGE);
            }
            return router;
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Registration failed", e);
            throw new CommandException("Registration failed", e);
        }
    }
}



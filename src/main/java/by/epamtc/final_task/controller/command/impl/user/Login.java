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
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {

    public static final Logger LOGGER = LogManager.getLogger();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page;
        String email = request.getParameter(ParameterName.EMAIL);
        String password = request.getParameter(ParameterName.PASSWORD);
        try {
            if (userService.isLoginAndPasswordValid(email, password)) {

                User user = userService.findUserWithTheAllInfoByLogin(email);

                request.getSession().setAttribute(ParameterName.ROLE, user.getRole().name());
                request.getSession().setAttribute(ParameterName.EMAIL, user.getEmail());
                request.getSession().setAttribute(ParameterName.USER_ID, user.getUserId());

                request.setAttribute(ParameterName.FIRST_NAME, user.getFirstName());
                request.setAttribute(ParameterName.LAST_NAME, user.getLastName());
                request.setAttribute(ParameterName.PHOTO_PATH, user.getPhotoPath());
                request.setAttribute(ParameterName.WELCOME, true);
                page = PageName.WELCOME_PAGE;
                request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND,"forwardwelcome");
            } else {
                request.setAttribute(ParameterName.INCORRECT_LOGIN_AND_PASSWORD, true);
                page = PageName.LOGIN_PAGE;
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "User is not exist", e);
            throw new CommandException("User is not exist", e);
        }
        return new Router(page);
    }
}

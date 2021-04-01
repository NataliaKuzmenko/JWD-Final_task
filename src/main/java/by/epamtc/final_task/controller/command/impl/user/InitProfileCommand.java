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

public class InitProfileCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page = PageName.PROFILE_PAGE;
        try {
            String email = (String) request.getSession().getAttribute(ParameterName.EMAIL);
            String userRole = (String) request.getSession().getAttribute(ParameterName.ROLE);
            if (userRole == null) {
                page = PageName.ERROR_PAGE;
                request.setAttribute(ParameterName.ERROR, ParameterName.ERROR_MESSAGE_404);
                return new Router(page);
            }
            String userEmail = (String) request.getSession().getAttribute(ParameterName.EMAIL);
            User user = userService.findUserWithTheAllInfoByLogin(userEmail);

            request.setAttribute(ParameterName.FIRST_NAME, user.getFirstName());
            request.setAttribute(ParameterName.LAST_NAME, user.getLastName());
            request.setAttribute(ParameterName.EMAIL, user.getEmail());
            request.setAttribute(ParameterName.ROLE, user.getRole());
            request.setAttribute(ParameterName.PHOTO_PATH, user.getPhotoPath());

            request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND,"initprofilecommand");

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "User not found", e);
            throw new CommandException("User not found", e);
        }
        return new Router(page);
    }
}

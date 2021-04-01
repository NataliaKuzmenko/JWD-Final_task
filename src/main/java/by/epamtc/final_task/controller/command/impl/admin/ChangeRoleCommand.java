package by.epamtc.final_task.controller.command.impl.admin;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ChangeRoleCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page;
        String userIdStr = request.getParameter(ParameterName.USER_ID);
        String userRole = request.getParameter(ParameterName.ROLE);
        try {
            if (userRole.equals(String.valueOf(User.UserRole.STUDENT))) {
                long userId = Long.parseLong(userIdStr);
                User user = userService.findUserById(userId);
                userService.updateUserRole(user);

                request.setAttribute(ParameterName.CHANGE_ROLE, true);
                page = PageName.WELCOME_PAGE;
            } else {
                request.setAttribute(ParameterName.CHANGE_ROLE_ERROR, true);
                page = PageName.WELCOME_PAGE;
            }
        } catch (ServiceException e) {
            throw new CommandException("Command  InitTableUsersCommand invalid", e);
        }
        return new Router(page);
    }
}

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
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class InitTableUsersCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {

        String pageForRouter;
        String pageStr = request.getParameter(ParameterName.PAGE);
        String role = (String) request.getSession().getAttribute(ParameterName.ROLE);
        String userIdStr = request.getParameter(ParameterName.USER_ID);
        String userRole = request.getParameter(ParameterName.ROLE);

        try {
            if (userIdStr != null && userRole != null) {
                if (userRole.equals(String.valueOf(User.UserRole.STUDENT))) {
                    Long userId = Long.parseLong(userIdStr);
                    User user = userService.findUserById(userId);
                    userService.updateUserRole(user);
                    request.setAttribute(ParameterName.CHANGE_ROLE, true);
                } else {
                    request.setAttribute(ParameterName.CHANGE_ROLE_ERROR, true);
                }
            }

            int page = (pageStr == null) ? 0 : Integer.parseInt(pageStr);
            if (role.equals(String.valueOf(User.UserRole.ADMIN))) {
                List<User> usersList = userService.findAllUsers(page);
                int usersCount = userService.countAllUsers();

                request.setAttribute(ParameterName.USER_LIST, usersList);
                request.getSession().setAttribute(ParameterName.USERS_COUNT, usersCount);

                request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND, "inittableuserscommand");
                pageForRouter = PageName.USERS;
            } else {
                request.setAttribute(ParameterName.VIEW_USERS_ERROR, true);
                pageForRouter = PageName.ERROR_PAGE;
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Command  InitTableUsersCommand invalid", e);
            throw new CommandException("Command  InitTableUsersCommand invalid", e);
        }
        return new Router(pageForRouter);
    }

}



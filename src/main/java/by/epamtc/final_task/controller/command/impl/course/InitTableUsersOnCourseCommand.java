package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.entity.ResultUser;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.ResultUserService;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.ResultUserServiceImpl;
import by.epamtc.final_task.service.impl.UserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Command to initialize users on course table
 */
public class InitTableUsersOnCourseCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    private final ResultUserService resultUserService = ResultUserServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page;
        String courseIdStr = request.getParameter(ParameterName.COURSE_ID);
        if (courseIdStr == null) {
            courseIdStr = (String) request.getSession().getAttribute(ParameterName.COURSE_ID);
        }
        request.getSession().setAttribute(ParameterName.COURSE_ID, courseIdStr);
        String statusUser = request.getParameter(ParameterName.STATUS_USER);
        String userIdStr = request.getParameter(ParameterName.USER_ID);


        try {
            long courseId = Long.parseLong(courseIdStr);

            if (statusUser != null & userIdStr != null) {
                long userId = Long.parseLong(userIdStr);
                resultUserService.updateUserCourseStatus(userId, courseId, ResultUser.UserCourseStatus.valueOf(statusUser));
            }

            Map<User, ResultUser> result = new HashMap<>();
            List<User> userList = userService.findAllUsersOnCourse(courseId);
            if (userList.isEmpty()) {
                request.setAttribute(ParameterName.ERROR_DATA, true);
            } else {
                for (User user : userList) {
                    ResultUser resultUser = resultUserService.findResultUser(user.getUserId(), courseId);
                    result.put(user, resultUser);
                }
                request.setAttribute(ParameterName.USER_LIST, result);
            }
            page = PageName.USERS_ON_COURSE;
            request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND, ParameterName.INIT_TABLE_USERS_ON_COURSE);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Command  InitTableUsersOnCourseCommand invalid", e);
            throw new CommandException("Command  InitTableUsersOnCourseCommand invalid", e);
        }
        return new Router(page);
    }
}

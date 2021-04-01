package by.epamtc.final_task.controller.command.impl.user;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.UserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RegisterOnCourseCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger();

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {

        Router router;
        Long userId = (Long) request.getSession().getAttribute(ParameterName.USER_ID);
        String courseIdStr = (String)request.getSession().getAttribute(ParameterName.COURSE_ID);

        try {
            long courseId = Long.parseLong(courseIdStr);
            if (userService.addUserOnCourse(userId, courseId)) {
                request.getSession().setAttribute(ParameterName.REGISTER_COURSE_MESSAGE, true);
                router = new Router(PageName.WELCOME_PAGE);
                request.getSession().setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND, "registeroncourse");
                router.useRedirect();
            } else {
                router = new Router(PageName.DETAILS_COURSE_PAGE);
                request.setAttribute(ParameterName.REGISTER_COURSE_ERROR, true);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "RegisterOnCourseCommand", e);
            throw new CommandException("RegisterOnCourseCommand", e);
        }
        return router;
    }
}

package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.entity.ResultUser;
import by.epamtc.final_task.service.ResultUserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.ResultUserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LeaveCourseCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    ResultUserService resultUserService = ResultUserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        String courseIdStr = request.getParameter(ParameterName.COURSE_ID);
        long courseId = Long.parseLong(courseIdStr);
        long userId = (Long) request.getSession().getAttribute(ParameterName.USER_ID);

        try {
            if (resultUserService.updateUserCourseStatus(userId, courseId, ResultUser.UserCourseStatus.DENIED)) {

                router = new Router(PageName.WELCOME_PAGE);
                request.getSession().setAttribute(ParameterName.COURSE_CANCEL, true);
                router.useRedirect();
            } else {
                request.setAttribute(ParameterName.ERROR_CANCEL_COURSE, true);
                router = new Router(PageName.USER_COURSES);
            }
            return router;
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "LeaveCourseCommand failed", e);
            throw new CommandException("Command  LeaveCourseCommand invalid", e);
        }
    }
}


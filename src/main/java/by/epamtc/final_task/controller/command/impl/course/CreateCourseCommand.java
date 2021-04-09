package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.entity.User;
import by.epamtc.final_task.service.CourseService;
import by.epamtc.final_task.service.UserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.CourseServiceImpl;
import by.epamtc.final_task.service.impl.UserServiceImpl;
import by.epamtc.final_task.service.validation.CourseValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

/**
 * Class implementing course creating
 *
 */
public class CreateCourseCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    private final CourseValidator courseValidator = CourseValidator.getInstance();
    private final CourseService courseService = CourseServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;

        String email = (String) request.getSession().getAttribute(ParameterName.EMAIL);
        String title = request.getParameter(ParameterName.TITLE);
        String description = request.getParameter(ParameterName.DESCRIPTION);
        String start = request.getParameter(ParameterName.START);
        String end = request.getParameter(ParameterName.END);
        String format = request.getParameter(ParameterName.FORMAT);
        try {
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);

            if (courseValidator.isRightTitle(title) &&
                    courseValidator.isRightDescription(description) &&
                    courseValidator.isRightStartDate(startDate) &&
                    courseValidator.isRightEndDate(startDate, endDate) &&
                    courseValidator.isRightFormat(format)) {
                User user = userService.findUserWithTheAllInfoByLogin(email);
                courseService.create(title, description, user.getUserId(), startDate, endDate, format);

                router = new Router(PageName.CREATE_COURSE);
                router.setMessage(ParameterName.CREATE_MESSAGE);
                router.useRedirect();
            } else {
                request.setAttribute(ParameterName.ERROR_DATA, true);
                router = new Router(PageName.CREATE_COURSE);
            }
            request.setAttribute(ParameterName.LANG_CHANGE_PROCESS_COMMAND,
                    ParameterName.FORWARD_CREATE_COURSE_COMMAND);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Create course failed", e);
            throw new CommandException("Create course failed", e);
        }
        return router;
    }
}

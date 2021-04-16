package by.epamtc.final_task.controller.command.impl.user;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.service.ResultUserService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.ResultUserServiceImpl;
import by.epamtc.final_task.service.validation.ResultUserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Class implementing add result of course (mark and mark) to student
 */
public class SetCourseResultCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    private final ResultUserValidator resultUserValidator = ResultUserValidator.getInstance();
    private final ResultUserService resultUserService = ResultUserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {

        Router router = new Router(PageName.SET_USER_RESULT_PAGE);
        String courseIdStr = (String) request.getSession().getAttribute(ParameterName.COURSE_ID);
        String markStr = request.getParameter(ParameterName.MARK);
        String comment = request.getParameter(ParameterName.COMMENT);
        String studentIdStr = (String) request.getSession().getAttribute(ParameterName.STUDENT_ID);
        try {
            if (!markStr.trim().isEmpty()) {
                int mark = Integer.parseInt(markStr);
                if (!resultUserValidator.isRightMark(mark) || !resultUserValidator.isRightComment(comment)) {
                    request.setAttribute(ParameterName.INCORRECT_MARK_OR_COMMENT, true);
                    return router;
                }
                long studentId = Long.parseLong(studentIdStr);
                long courseId = Long.parseLong(courseIdStr);
                resultUserService.addCourseResult(studentId, courseId, mark, comment);
                router.setMessage(ParameterName.ADD_RESULT_MESSAGE);
                router.useRedirect();
            } else {
                request.setAttribute(ParameterName.INCORRECT_MARK_OR_COMMENT, true);
            }
            return router;
        } catch (ServiceException | NumberFormatException e) {
            request.setAttribute(ParameterName.INCORRECT_MARK_OR_COMMENT, true);
            LOGGER.log(Level.ERROR, "Set course result failed", e);
            throw new CommandException("Set course result failed", e);
        }
    }
}

package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.constant.ParameterName;
import by.epamtc.final_task.service.CourseService;
import by.epamtc.final_task.service.exception.ServiceException;
import by.epamtc.final_task.service.impl.CourseServiceImpl;
import by.epamtc.final_task.service.validation.CourseValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class EditCourseCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    private final CourseValidator courseValidator = CourseValidator.getInstance();
    private final CourseService courseService = CourseServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;

        String courseIdStr = (String) request.getSession().getAttribute(ParameterName.COURSE_ID);
        String parameter = (String) request.getSession().getAttribute(ParameterName.PARAMETER);
        try {
            long courseId = Long.parseLong(courseIdStr);
            if (parameter.equalsIgnoreCase(ParameterName.TITLE)) {
                router = resolveUpdateTitle(courseId, request);
            } else if (parameter.equalsIgnoreCase(ParameterName.DESCRIPTION)) {
                router = resolveUpdateDescription(courseId, request);
            } else {
                router = resolveUpdateDate(courseId, request);
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Edit course failed", e);
            throw new CommandException("Edit course failed", e);
        }
        return router;
    }

    private Router resolveUpdateTitle(Long courseId, HttpServletRequest request) throws ServiceException {
        String title = request.getParameter(ParameterName.TITLE);
        Router router;
        if (!title.trim().isEmpty()) {
            if (courseValidator.isRightTitle(title)) {
                courseService.updateTitle(courseId, title);
                router = new Router(PageName.EDIT_COURSE);
                router.setMessage(ParameterName.EDIT_COURSE_RESULT);
                router.useRedirect();
            } else {
                request.setAttribute(ParameterName.ERROR, true);
                router = new Router(PageName.EDIT_COURSE);
            }
        } else {
            request.setAttribute(ParameterName.ERROR_DATA, true);
            router = new Router(PageName.EDIT_COURSE);
        }
        return router;
    }

    private Router resolveUpdateDescription(Long courseId, HttpServletRequest request) throws ServiceException {
        String description = request.getParameter(ParameterName.DESCRIPTION);
        Router router;
        if (!description.trim().isEmpty()) {
            if (courseValidator.isRightDescription(description)) {
                courseService.updateDescription(courseId, description);
                router = new Router(PageName.EDIT_COURSE);
                router.setMessage(ParameterName.EDIT_COURSE_RESULT);
                router.useRedirect();
            } else {
                request.setAttribute(ParameterName.ERROR, true);
                router = new Router(PageName.EDIT_COURSE);
            }
        } else {
            request.setAttribute(ParameterName.ERROR_DATA, true);
            router = new Router(PageName.EDIT_COURSE);
        }
        return router;
    }

    private Router resolveUpdateDate(Long courseId, HttpServletRequest request) throws ServiceException {
        String startDateStr = request.getParameter(ParameterName.START);
        String endDateStr = request.getParameter(ParameterName.END);
        Router router;
        if (!startDateStr.trim().isEmpty() && !endDateStr.trim().isEmpty()) {
            LocalDate startDate = LocalDate.parse(startDateStr);
            LocalDate endDate = LocalDate.parse(endDateStr);
            if (courseValidator.isRightStartDate(startDate) &&
                    courseValidator.isRightEndDate(startDate, endDate)) {
                courseService.updateDate(courseId, startDate, endDate);
                router = new Router(PageName.EDIT_COURSE);
                router.setMessage(ParameterName.EDIT_COURSE_RESULT);
                router.useRedirect();
            } else {
                request.setAttribute(ParameterName.ERROR, true);
                router = new Router(PageName.EDIT_COURSE);
            }
        } else {
            request.setAttribute(ParameterName.ERROR_DATA, true);
            router = new Router(PageName.EDIT_COURSE);
        }
        return router;
    }
}

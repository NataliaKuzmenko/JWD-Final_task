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
    CourseValidator courseValidator = CourseValidator.getInstance();
    CourseService courseService = CourseServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page = PageName.EDIT_COURSE;
        ;
        String courseIdStr = (String) request.getSession().getAttribute(ParameterName.COURSE_ID);
        String parameter = (String) request.getSession().getAttribute(ParameterName.PARAMETER);
        try {
            long courseId = Long.parseLong(courseIdStr);

            switch (parameter) {
                case (ParameterName.TITLE):
                    String title = request.getParameter(ParameterName.TITLE);
                    if (!title.trim().isEmpty()) {
                        if (courseValidator.isRightTitle(title)) {
                            courseService.updateTitle(courseId, title);
                            request.setAttribute(ParameterName.EDIT_COURSE_RESULT, true);
                        } else {
                            request.setAttribute(ParameterName.ERROR, true);
                        }
                    } else {
                        request.setAttribute(ParameterName.ERROR_DATA, true);
                    }
                    break;
                case (ParameterName.DESCRIPTION):
                    String description = request.getParameter(ParameterName.DESCRIPTION);
                    //if (!description.trim().isEmpty()) {
                    if (description != null) {
                        if (courseValidator.isRightDescription(description)) {
                            courseService.updateDescription(courseId, description);
                            System.out.println(courseId + " " + description);
                            request.setAttribute(ParameterName.EDIT_COURSE_RESULT, true);
                        } else {
                            request.setAttribute(ParameterName.ERROR, true);
                        }
                    } else {
                        request.setAttribute(ParameterName.ERROR_DATA, true);
                    }
                    break;
                case (ParameterName.START):
                    String startDateStr = request.getParameter(ParameterName.START);
                    String endDateStr = request.getParameter(ParameterName.END);
                    if (!startDateStr.trim().isEmpty() && !endDateStr.trim().isEmpty()) {
                        LocalDate startDate = LocalDate.parse(startDateStr);
                        LocalDate endDate = LocalDate.parse(endDateStr);
                        if (courseValidator.isRightStartDate(startDate) &&
                                courseValidator.isRightEndDate(startDate, endDate)) {
                            courseService.updateDate(courseId, startDate, endDate);
                            System.out.println(courseId + " " + startDate + " " + endDate);
                            request.setAttribute(ParameterName.EDIT_COURSE_RESULT, true);
                        } else {
                            request.setAttribute(ParameterName.ERROR, true);
                        }
                    } else {
                        request.setAttribute(ParameterName.ERROR_DATA, true);
                    }
                    break;
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Edit course failed", e);
            throw new CommandException("Edit course failed", e);
        }
        return new Router(page);
    }
}

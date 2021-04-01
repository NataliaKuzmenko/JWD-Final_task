package by.epamtc.final_task.controller.command.impl.course;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class InitTableUsersOnCourseCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger();
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page;
        page = PageName.USERS_ON_COURSE;
        return new Router(page);
    }
}

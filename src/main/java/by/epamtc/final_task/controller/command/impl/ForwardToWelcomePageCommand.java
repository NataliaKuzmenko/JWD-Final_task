package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.constant.PageName;

import javax.servlet.http.HttpServletRequest;

public class ForwardToWelcomePageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        String page = PageName.WELCOME_PAGE;
        return new Router(page);
    }
}

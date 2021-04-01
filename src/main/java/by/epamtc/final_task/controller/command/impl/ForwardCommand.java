package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;
import by.epamtc.final_task.controller.constant.PageName;

import javax.servlet.http.HttpServletRequest;

public class ForwardCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        String page = request.getParameter(PageName.NEXT_PAGE);
        return new Router(page);
    }
}


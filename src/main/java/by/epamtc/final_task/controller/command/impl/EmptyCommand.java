package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.controller.constant.PageName;
import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.Router;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        String page = PageName.INDEX_PAGE;
        return new Router(page);
    }
}


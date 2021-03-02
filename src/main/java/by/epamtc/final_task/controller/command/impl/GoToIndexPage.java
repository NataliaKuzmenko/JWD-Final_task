package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class GoToIndexPage implements Command {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String page = null;

        page = PageName.INDEX_PAGE;
        return page;
    }
}

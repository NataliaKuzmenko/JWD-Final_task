package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToWelcomPage implements Command {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String page = null;
        if (session == null) {

            page = PageName.INDEX_PAGE;
            return page;
        }
        Boolean isAuth = (Boolean) session.getAttribute("auth");

        if (isAuth == null || !isAuth) {

            page = PageName.INDEX_PAGE;
            return page;
        }
        page = PageName.WELCOM_PAGE;
        return page;
    }

}

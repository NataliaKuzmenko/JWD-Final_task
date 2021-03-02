package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.LoginLogic;
import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        if (LoginLogic.checkLogin(login, pass)) {
            request.setAttribute("user", login);

            page = PageName.WELCOM_PAGE;
        } else {
            request.setAttribute("errorLoginPassMessage",
                    "Incorrect login or password.");
            page = PageName.LOGIN_PAGE;
        }
        return page;
    }
}



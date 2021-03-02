package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.constant.PageName;
import by.epamtc.final_task.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class SaveNewUser implements Command {
    private static String PARAM_NAME_LOGIN = "login";
    private static String PARAM_NAME_PASSWORD = "password";
    private static String PARAM_NAME_EMAIL = "email";
    private static String PARAM_NAME_FIRSTNAME = "firstname";
    private static String PARAM_NAME_LASTNAME = "lastname";
    private static String PARAM_NAME_ROLE = "role";

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String email = request.getParameter(PARAM_NAME_EMAIL);
        String firstName = request.getParameter(PARAM_NAME_FIRSTNAME);
        String lastName = request.getParameter(PARAM_NAME_LASTNAME);
        String role = request.getParameter(PARAM_NAME_ROLE);
        String page;

        if (login.equals("") != true & pass.equals("") != true & email.equals("") != true &
                firstName.equals("") != true & lastName.equals("") != true & role.equals("") != true) {
            System.out.println(login + " " + pass.hashCode() + " " + email + " " + firstName + " " + lastName + " " + role);

            request.setAttribute("messageRegistration", "Registration ok");

            page = PageName.LOGIN_PAGE;
        } else {
            request.setAttribute("nullData",
                    "Enter data");
            page = PageName.REGISTRATION_PAGE;
        }
        return page;
    }
}

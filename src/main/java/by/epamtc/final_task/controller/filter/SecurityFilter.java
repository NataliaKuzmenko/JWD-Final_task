package by.epamtc.final_task.controller.filter;

import by.epamtc.final_task.constant.ErrorCode;
import by.epamtc.final_task.constant.ParameterName;
import by.epamtc.final_task.controller.command.CommandName;
import by.epamtc.final_task.entity.user.User;
import by.epamtc.final_task.entity.user.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "Filter")
public class SecurityFilter implements Filter {
    //loger

    private final Map<CommandName, UserRole[]> authorizationMap = new HashMap<>();


    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String commandName = req.getParameter(ParameterName.COMMAND);
        User user = (User) req.getSession(true).getAttribute(ParameterName.USER);

        CommandName command = parseCommand(commandName);

        if (isCommandNeedAuthorization(command) && !hasUserAllowedRole(command, user)) {
           // logger.warn("Authorization fail: try opening private page by user without needed permission");
            resp.sendError(ErrorCode.PERMISSION_DENIED);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private CommandName parseCommand(String commandName) {
        try {
            return CommandName.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            //logger.warn("No such command in enum CommandName: " + commandName);
            return null;
        }
    }


    private boolean isCommandNeedAuthorization(CommandName command) {
        return command != null && authorizationMap.containsKey(command);
    }

    private boolean hasUserAllowedRole(CommandName command, User user) {
        if (user == null) {
           // logger.warn("Authorization fail: try opening private page not authored user");
            return false;
        }

        boolean hasAllowedRole = false;

        UserRole[] allowedRoles = authorizationMap.get(command);

        for (UserRole allowedRole : allowedRoles) {
            if (allowedRole == user.getRole()) {
                hasAllowedRole = true;
                break;
            }
        }

        return hasAllowedRole;
    }
}


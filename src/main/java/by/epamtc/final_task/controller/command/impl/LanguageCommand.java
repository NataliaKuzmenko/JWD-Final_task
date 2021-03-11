package by.epamtc.final_task.controller.command.impl;

import by.epamtc.final_task.controller.command.Command;
import by.epamtc.final_task.controller.command.exception.CommandException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException, CommandException {
        return null;
    }
}

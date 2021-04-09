package by.epamtc.final_task.controller.command;

import by.epamtc.final_task.controller.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;


public interface Command {

    Router execute(HttpServletRequest request) throws CommandException;
}

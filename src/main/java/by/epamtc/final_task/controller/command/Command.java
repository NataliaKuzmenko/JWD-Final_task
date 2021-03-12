package by.epamtc.final_task.controller.command;

import by.epamtc.final_task.controller.command.exception.CommandException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface Command {

  //  String execute(HttpServletRequest request) throws ServletException, IOException, CommandException;
   // void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CommandException;

    Router execute(HttpServletRequest request) throws CommandException;

}

package by.epamtc.final_task.controller.command;

import by.epamtc.final_task.controller.command.exception.CommandException;
import by.epamtc.final_task.controller.command.impl.EmptyCommand;
import by.epamtc.final_task.controller.command.impl.LanguageCommand;
import by.epamtc.final_task.controller.command.impl.admin.InitTableUsersCommand;
import by.epamtc.final_task.controller.command.impl.course.*;
import by.epamtc.final_task.controller.command.impl.page.ForwardCommand;
import by.epamtc.final_task.controller.command.impl.page.ForwardToEditCourseCommand;
import by.epamtc.final_task.controller.command.impl.page.ForwardToSetResult;
import by.epamtc.final_task.controller.command.impl.user.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that provides access to command objects
 */
public class CommandProvider {
    /**
     * Map that matches the name of a command with an object that implements this command
     */
    private final Map<CommandName, Command> commands = new HashMap<>();

    /**
     * Construct a CommandProvider and put commands
     */
    public CommandProvider() {
        commands.put(CommandName.EMPTY, new EmptyCommand());
        commands.put(CommandName.FORWARD, new ForwardCommand());
        commands.put(CommandName.LOGIN, new Login());
        commands.put(CommandName.REGISTRATION, new RegistrationCommand());
        commands.put(CommandName.LOGOUT, new Logout());
        commands.put(CommandName.LANGUAGE, new LanguageCommand());
        commands.put(CommandName.DETAILSCOURSE, new InitDetailsCourseCommand());
        commands.put(CommandName.COURSERUNCOMMAND, new CourseRunCommand());
        commands.put(CommandName.EDITPROFILECOMMAND, new EditProfileCommand());
        commands.put(CommandName.INITPROFILECOMMAND, new InitProfileCommand());
        //  commands.put(CommandName.FORWARDWELCOME, new ForwardToWelcomePageCommand());
        commands.put(CommandName.CREATECOURSE, new CreateCourseCommand());
        commands.put(CommandName.EDITCOURSE, new EditCourseCommand());
        commands.put(CommandName.VIEWCOURSESUSER, new ViewCoursesUserCommand());
        commands.put(CommandName.INITTABLEUSERSONCOURSE, new InitTableUsersOnCourseCommand());
        commands.put(CommandName.INITTABLEUSERSCOMMAND, new InitTableUsersCommand());
        commands.put(CommandName.COURSESPAGE, new CoursesPageCommand());
        commands.put(CommandName.SETCOURSERESULT, new SetCourseResultCommand());
        commands.put(CommandName.FORWARDTOSETRESULT, new ForwardToSetResult());
        commands.put(CommandName.FORWARDTOEDITCOURSE, new ForwardToEditCourseCommand());
        //commands.put(CommandName.FORWARDTOEDITPROFILE, new ForwardToEditProfileCommand());
        //  commands.put(CommandName.FORWARDTOCREATECOURSE, new ForwardToCreateCourseCommand());
        commands.put(CommandName.COURSESLECTURER, new CoursesLecturerCommand());

    }

    /**
     * Finds and returns a command by name
     *
     * @param command name of command
     * @return object that implements this command
     */
    public Command takeCommand(String command) {
        CommandName commandName;
        commandName = CommandName.valueOf(command.toUpperCase());
        return commands.get(commandName);
    }

    /**
     * Finds and returns a command by name for change language
     *
     * @param current name of command
     * @param action  name of command
     * @return object that implements this command
     */
    public static Command getCommand(Command current, String action)
            throws CommandException {
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandProvider commandProvider = new CommandProvider();
            current = commandProvider.takeCommand(action.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new CommandException("Wrong action", e);
        }
        return current;
    }
}

package by.epamtc.final_task.controller.command;

import by.epamtc.final_task.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;



    public class CommandProvider {
        private Map<CommandName, Command> commands = new HashMap<>();

        public CommandProvider() {
            commands.put(CommandName.LOGIN, new Login());
            commands.put(CommandName.GOTOREGISTRATIONPAGE, new GoToRegistrationPage());
            commands.put(CommandName.REGISTRATION, new RegistrationCommand());
            commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
            commands.put(CommandName.GOTOWELCOMPAGE, new GoToWelcomPage());
            commands.put(CommandName.LOGOUT, new Logout());
            commands.put(CommandName.GOTOLOGINPAGE, new GoToLoginPage());

        }

        public Command takeCommand(String name) {
            CommandName commandName;

            commandName = CommandName.valueOf(name.toUpperCase());

            return commands.get(commandName);
        }

    }

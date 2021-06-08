package ua.goit.controller;

import ua.goit.command.*;
import ua.goit.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainControler {
    View view;
    private List<Command> commands;

    public MainControler(View view) {
        this.view = view;
        this.commands = new ArrayList<>(Arrays.asList(
                new Help(view),
                new CreateUser(),
                new CreateUserWithArray(view),
                new GetUserByUserName(view),
                new UpdateUser(view),
                new DeleteUser(view),
                new LogIn(view),
                new LogOut()
        ));
    }

    public void run() {
        view.write("Welcome to the application");
        doCommand();
    }

    private void doCommand() {
        boolean isNotExit = true;
        while (isNotExit) {
            view.write("Please enter a command or help to retrieve command list");
            String inputCommand = view.read();
            for (Command command : commands) {
                if (command.canProcess(inputCommand)) {
                    command.process();
                    break;
                } else if (inputCommand.equalsIgnoreCase("exit")) {
                    view.write("Good Bye!");
                    isNotExit = false;
                    break;
                }
            }
        }
    }
}

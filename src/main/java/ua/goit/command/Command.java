package ua.goit.command;

import java.io.FileNotFoundException;

public interface Command {
    void process() throws FileNotFoundException;

    String commandName();

    default boolean canProcess(String command) {
        return commandName().equals(command);
    }
}

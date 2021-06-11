package ua.goit.command;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
    void process() throws IOException;

    String commandName();

    default boolean canProcess(String command) {
        return commandName().equals(command);
    }
}

package ua.goit.command;

import ua.goit.view.View;

public class Help implements Command{
    private View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public void process() {
        view.write("help - show a list of commands");
        view.write("user -create - create a user");
    }

    @Override
    public String commandName() {
        return "help";
    }
}

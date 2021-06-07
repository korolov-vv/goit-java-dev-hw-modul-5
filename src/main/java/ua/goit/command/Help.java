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
        view.write("user -create1 - create a user with array");
        view.write("user -get1 - get user by username");
        view.write("user -update - update the user");
        view.write("user -delete - delete the user");
    }

    @Override
    public String commandName() {
        return "help";
    }
}

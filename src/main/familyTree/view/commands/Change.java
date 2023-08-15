package view.commands;

import view.ConsoleUI;

public class Change extends Command{

    public Change(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Изменить запись";
    }
    @Override
    public void execute() {
        consoleUI.change();
    }
}

package view.commands;

import view.ConsoleUI;

public class SaveInFile extends Command{

    public SaveInFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить";
    }

    @Override
    public void execute() {
        consoleUI.save();
    }
}

package view.commands;

import view.ConsoleUI;

public class ReadFile extends Command{
    public ReadFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Открыть файл";
    }

    @Override
    public void execute() {
        consoleUI.read();
    }
}

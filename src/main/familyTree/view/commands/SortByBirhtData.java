package view.commands;

import view.ConsoleUI;

public class SortByBirhtData extends Command{
    public SortByBirhtData(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по дате рождения";
    }

    @Override
    public void execute() {
        consoleUI.sortByBirhtData();
    }
}

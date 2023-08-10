package view.commands;

import view.ConsoleUI;

public class GetHumanInfo extends Command{

    public GetHumanInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список семеного древа";
    }

    @Override
    public void execute() {
        consoleUI.getHumanInfo();
    }
}

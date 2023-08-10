import model.SaveAndRead.SaveAndRead;
import model.familyTree.FamilyTRee;
import model.human.Gender;
import model.human.Human;
import view.ConsoleUI;
import view.View;

import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}

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
    //    На момент написания дз урок2 не смотрел
    public static void main(String[] args) {
//        Human evgeniy = new Human("Евгений", "Чулаков", "Игоревич",
//                LocalDate.of(1995, 11, 05), Gender.Male);
//        Human igor = new Human("Игорь", "Чулаков", "Иванович",
//                LocalDate.of(1971, 12, 27), Gender.Male);
//        Human helga = new Human("Ольга", "Чулакова", "Игоревна",
//                LocalDate.of(2005, 02, 05), Gender.Female);
//        Human vitaliy = new Human("Виталий", "Рула", "Федорович",
//                LocalDate.of(1956, 02, 3), LocalDate.of(2021, 12, 2), Gender.Male);
//        Human natalya = new Human("Наталья", "Чулакова", "Александровна",
//                LocalDate.of(1972, 12, 30), Gender.Female);
//        evgeniy.setFather(igor);
//        natalya.addChild(evgeniy);
//        helga.setFather(igor);
//        igor.setFather(vitaliy);
//        evgeniy.setMather(natalya);
//        FamilyTRee fam = new FamilyTRee();
//        fam.addfam(evgeniy);
//        fam.addfam(evgeniy.getFather());
//        fam.addfam(evgeniy.getMather());
//
//        File file = new File("person.out");
//        SaveAndRead save = new SaveAndRead(file);
//        save.save(fam, String.valueOf(file));
//        FamilyTRee tree = (FamilyTRee) save.read(file.toString());
//        System.out.println(tree);
//        tree.sortByAge();
//        System.out.println(tree);
        View view = new ConsoleUI();
        view.start();
    }
}

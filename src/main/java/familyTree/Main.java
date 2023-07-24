package familyTree;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    На момент написания дз урок2 не смотрел
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Human evgeniy = new Human("Евгений","Чулаков","Игоревич",
                LocalDate.of(1995,11,05),Gender.Male);
        Human igor = new Human("Игорь","Чулаков","Иванович",
                LocalDate.of(1971,12,27),Gender.Male);
        Human helga = new Human("Ольга","Чулакова","Игоревна",
                LocalDate.of(2005,02,05),Gender.Female);
        Human vitaliy = new Human("Виталий","Рула","Федорович",
                LocalDate.of(1956,02,3), LocalDate.of(2021,12,2),Gender.Male);
        Human natalya = new Human("Наталья","Чулакова","Александровна",
                LocalDate.of(1972,12,30),Gender.Female);
        evgeniy.setFather(igor);
        natalya.addChild(evgeniy);
        helga.setFather(igor);
        igor.setFather(vitaliy);
        evgeniy.setMather(natalya);
        FamilyTRee fam = new FamilyTRee();
        List<String> familys = fam.printfam(evgeniy);
        familys.add(String.valueOf(fam.printfam(evgeniy.getFather1())));
//Когда один уровень родителей нет масива в выводе, а когда добавляю родителей у родителей печатается внизу массив
//        for (String family: familys){
//            System.out.println(family);
//        }

        Save save = new Save(familys);
        ReadFamily rd = new ReadFamily();
        List gg = new ArrayList<>();
        rd.ReadFam("ss", gg);
        for (Object person: gg){
            System.out.println(person);
        }



    }
}

package familyTree;

public class Main {
//    На момент написания дз урок2 не смотрел
    public static void main(String[] args) {
        Human human1 = new Human("Евгений","Чулаков","Игоревич",
                1995,11,05,Gender.Male);
        Human human2 = new Human("Игорь","Чулаков","Иванович",
                1971,12,27,Gender.Male);
        Human human3 = new Human("Ольга","Чулакова","Игоревна",
                2005,02,05,Gender.Female);
        human1.setFather(human2);
        human3.setFather(human2);
        System.out.println(human1);
        System.out.println(human1.getFather());
        System.out.println(human2.getChildren());

    }
}

package view;

import model.human.Gender;
import model.human.Human;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }
    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void hello() {
        System.out.println("Доброго времени суток!");
    }

    public void addHuman() {
        System.out.println("Введите имя человека");
        String firstname = scanner.nextLine();
        System.out.println("Введите фамилию человека");
        String lastName = scanner.nextLine();
        System.out.println("Введите отчество");
        String patronymic = scanner.nextLine();
        System.out.println("Введите дату рождения(гггг-мм-дд)");
        String birthdateIn = scanner.nextLine();
        LocalDate birthdate = LocalDate.parse(birthdateIn);
        System.out.println("Введите дату смерти(если она есть)");
        String dathDataIn = scanner.nextLine();
        LocalDate dathData;
        if (!(dathDataIn.equalsIgnoreCase(""))) {
            dathData = LocalDate.parse(dathDataIn);
        }else {
            dathData = null;
        }
        System.out.println("Введите пол(М или Ж)");
        Gender gender = gender(scanner.nextLine());
        presenter.addHuman(firstname,lastName,patronymic,birthdate,dathData,gender);

    }
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void getHumanInfo() {
        presenter.getHumanInfo();
    }
    public void sortByBirhtData(){
        presenter.sortByBirthData();
    }
    public void sortByName(){
        presenter.sortByName();
    }

    public void save(){
        String name = inputFile("Введите имя файла");
        presenter.save(name);
    }
    public void read(){
        String name = inputFile("Введите имя файла");
        presenter.read(name);
    }

    public Gender gender(String data){
        if (data.equalsIgnoreCase("М")){
            return Gender.Male;
        }else {
            return Gender.Female;
        }
    }

    public String inputFile(String mesage){
        System.out.println(mesage);
        String name = scanner.nextLine();
        name += ".out";
        return name;
    }

    public void change(){
        getHumanInfo();
        System.out.println("Введите номер записи");
        String index = scanner.nextLine();
        Human human = presenter.change(index);
        boolean databool = true;
        while (databool){
        System.out.println("что имеено вы хотите изменить или добавить в запись?\n" +
                "1. Поле отца\n" +
                "2. Поле матери\n" +
                "3. Дату смерти\n" +
                "4. выйти из редакотора записи");
        String data = scanner.nextLine();
            switch (data){
                case "1":
                    addHuman();
                    presenter.addFather(human,presenter.change("0"));
                    break;
                case "2":
                    addHuman();
                    presenter.addMather(human,presenter.change("0"));
                    break;
                case  "3":
                    presenter.addDathData(human, LocalDate.parse(scanner.nextLine()));
                    break;
                case  "4":
                    databool = false;
                    break;
                default:
                    System.out.println("Некоректный вод");
            }
        }

    }

    public void exit(boolean bo){
        this.work = bo;
    }
}

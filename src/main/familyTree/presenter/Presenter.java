package presenter;

import model.human.Gender;
import model.service.Service;
import view.View;

import java.io.File;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String firstname, String lastName, String patronymic, LocalDate birthdate, LocalDate dathData, Gender gender) {
        service.addHuman(firstname,lastName,patronymic,birthdate,dathData,gender);

        getHumanInfo();
    }

    public void getHumanInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void sortByBirthData(){
        service.sortByBirthdate();
        view.printAnswer("сортировка прошла успешна");
        getHumanInfo();
    }

    public void sortByName(){
        service.sortByName();
        view.printAnswer("сортировка прошла успешна");
        getHumanInfo();
    }

    public void save(String name) {
        service.save(new File(name));
    }

    public void read(String name) {
        service.read(new File(name));
    }
}

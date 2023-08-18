package presenter;

import model.familyTree.FamilyTRee;
import model.human.Gender;
import model.human.Human;
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
    public Presenter(Service service) {
        this.service = service;
    }

    public void addHuman(String firstname, String lastName, String patronymic, LocalDate birthdate, LocalDate dathData, Gender gender) {
        service.addHuman(firstname,lastName,patronymic,birthdate,dathData,gender);

        view.printAnswer("Запись успешно добавлена");
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
        service.save(name);
    }

    public void read(String name) {
       service.read(name);
    }

    public Human change(String indexStr) {
        Integer index = Integer.parseInt(indexStr);
        return service.change(index);

    }
    public void addFather(Human human, Human father){
        human.setFather(father);
    }
    public void addMather(Human human,Human mather){
        human.setMather(mather);
    }
    public void addDathData(Human human,LocalDate dathdata){
        human.setDathData(dathdata);
    }
}

package model.service;

import model.SaveAndRead.SaveAndRead;
import model.familyTree.FamilyTRee;
import model.human.Gender;
import model.human.Human;

import java.io.File;
import java.time.LocalDate;

public class Service {
    private FamilyTRee<Human> familyTRee;
    private SaveAndRead saveAndRead;
    private File file;

    public Service() {

        familyTRee = new FamilyTRee<>();
        saveAndRead = new SaveAndRead();
    }
    public void addHuman(String firstname, String lastName, String patronymic, LocalDate birthdate, LocalDate dathData,
                         Gender gender, Human father, Human mather){
        Human human = new Human(firstname,lastName, patronymic, birthdate,dathData, gender, father, mather);
        familyTRee.addfam(human);
    }
    public void addHuman(String firstname, String lastName, String patronymic, LocalDate birthdate, LocalDate dathData,
                         Gender gender){
        Human human = new Human(firstname,lastName, patronymic, birthdate,dathData, gender);
        familyTRee.addfam(human);
    }
    public String getHumanInfo() {
        StringBuilder sb = new StringBuilder();
        for (Human human : familyTRee) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        familyTRee.sortByName();
    }

    public void sortByBirthdate(){
        familyTRee.sortByBirthdate();
    }

    public boolean save(File file){
        return saveAndRead.save(familyTRee, String.valueOf(file));
    }
    public boolean read(File file){
        return (boolean) saveAndRead.read(String.valueOf(file));
    }
}

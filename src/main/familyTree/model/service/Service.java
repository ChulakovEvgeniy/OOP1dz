package model.service;

import model.SaveAndRead.SaveAndRead;
import model.SaveAndRead.Writable;
import model.familyTree.FamilyTRee;
import model.human.Gender;
import model.human.Human;

import java.io.File;
import java.time.LocalDate;

public class Service {
    private FamilyTRee<Human> familyTRee;
    private Writable writable;
    private File file;

    public Service() {

        familyTRee = new FamilyTRee<Human>();
        this.writable = new SaveAndRead();
    }
    public Service(FamilyTRee<Human> familyTRee){
        this.familyTRee = familyTRee;
        this.writable = new SaveAndRead();
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
        int i =1;
        for (Human human : familyTRee) {
            sb.append(i++ + ". ");
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

    public boolean save(String file){
        return writable.save(familyTRee, String.valueOf(file));
    }
    public Object read(String file){
        return this.familyTRee = ((FamilyTRee) writable.read(file));
    }

    public Human change(Integer index) {
        return familyTRee.change(index);
    }
}

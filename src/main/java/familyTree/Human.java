package familyTree;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.*;

public class Human {
    private Map name;
    private LocalDate birthdate;
    private Gender gender;

    private Human father;
    private Human mather;

    List<Human> children = new ArrayList<>();

    public Human(String firstname,String lastName,String patronymic, int yearBirth,int monthsBirth, int daysBirth,Gender gender) {
        Map<String,String> human = new HashMap<>();
        human.put("Фамилия",lastName);
        human.put("Имя", firstname);
        human.put("Отчество", patronymic);
        LocalDate date = LocalDate.of(yearBirth, monthsBirth, daysBirth);
        this.name = human;
        this.birthdate = date;
        this.gender = gender;
    }
    public void setFather(Human father){
        father.children.add(this);
        this.father = father;
    }
    public String getFather(){
        return father.toString();
    }
    public void setMather(Human mather){
        mather.children.add(this);
        this.mather = mather;
    }
    public String getMather(){
        return mather.toString();
    }
    public void addChild(Human children) {
        if (!children.father.name.isEmpty() && !children.mather.name.isEmpty()){
            children.setFather(this);
            children.setMather(this);
        }
        this.children.add(children);
    }
    public String getChildren(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human child: children) {
            stringBuilder.append(child);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        LocalDate now = LocalDate.now();
        Period age = Period.ofYears(Period.between(birthdate,now).getYears());
        String age1 = String.valueOf(age);
        age1 = age1.replaceAll("[YP]", "");
        return (String)name.get("Фамилия")+" "+ name.get("Имя")+" " + name.get("Отчество")+" " + age1 + " лет";
    }
}

package familyTree.human;

import familyTree.familyTree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Human implements Serializable, Comparable<Human>, FamilyTreeItem {
    private Map name;
    private LocalDate birthdate;
    private LocalDate dathData;
    private Gender gender;
    private Human father;
    private Human mather;
    private List<Human> children = new ArrayList<>();

    public Human(String firstname, String lastName, String patronymic, LocalDate birthdate, LocalDate dathData, Gender gender, Human father, Human mather) {
        Map<String, String> human = new HashMap<>();
        human.put("Фамилия", lastName);
        human.put("Имя", firstname);
        human.put("Отчество", patronymic);
        this.name = human;
        this.birthdate = birthdate;
        this.gender = gender;
        this.dathData = dathData;
        this.father = father;
        this.mather = mather;
    }

    public Human(String firstname, String lastName, String patronymic, LocalDate birthdate, Gender gender) {
        this(firstname, lastName, patronymic, birthdate, null, gender, null, null);
    }

    public Human(String firstname, String lastName, String patronymic, LocalDate birthdate, LocalDate dathData, Gender gender) {
        this(firstname, lastName, patronymic, birthdate, dathData, gender, null, null);
    }

    public void setFather(Human father) {
        father.children.add(this);
        this.father = father;
    }

    public String getFatherInfo() {
        String info = ", отец: ";
        Human father = getFather();
        if (father != null) {
            info += father.toStringInfo();
        } else {
            info += "неизвестно";
        }
        return info;
    }

    public Human getFather() {
        return father;
    }

    public Human getMather() {
        return mather;
    }

    public void setMather(Human mather) {
        if (this.mather == null || this.mather.children.contains(mather)) {
            mather.children.add(this);
            this.mather = mather;
        }
    }

    public String getMatherInfo() {
        String info = ", мать: ";
        Human mather = getMather();
        if (mather != null) {
            info += mather.toStringInfo();
        } else {
            info += "неизвестно";
        }
        return info;
    }

    public void addChild(Human children) {
        if (!(this.children.contains(children))) {
            if (children.father != null && children.mather != null) {
                children.setFather(this);
                children.setMather(this);
            }
            this.children.add(children);
        }

    }

    public int countChildren() {
        int count = 0;
        for (Human child : children) {
            count++;
        }
        return count;
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human child : children) {
            stringBuilder.append(child);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Human> getChill() {
        List<Human> chill = new ArrayList<>();
        chill.addAll(this.children);
        return chill;
    }

    public String getAge() {
        if (dathData != null) {
            Period age = Period.ofYears(Period.between(birthdate, dathData).getYears());
            String age1 = String.valueOf(age);
            age1 = age1.replaceAll("[YP]", "");
            return age1;
        }
        LocalDate now = LocalDate.now();
        Period age = Period.ofYears(Period.between(birthdate, now).getYears());
        String age1 = String.valueOf(age);
        age1 = age1.replaceAll("[YP]", "");
        return age1;
    }

    @Override
    public String toString() {
        return toString1();
    }

    public String toStringInfo() {
        if (dathData != null) {
            return (String) name.get("Фамилия") + " " + name.get("Имя") + " " + name.get("Отчество") + " умер в " + getAge() + " лет ";
        }
        return (String) name.get("Фамилия") + " " + name.get("Имя") + " " + name.get("Отчество") + " " + getAge() + " лет ";
    }

    public String toString1() {
        StringBuilder sb = new StringBuilder();
        if (dathData != null) {
            sb.append("ФИО: " + name.get("Фамилия") + " " + name.get("Имя") + " " + name.get("Отчество") + ", " +
                    "д/р: " + birthdate + ", д/c: " + dathData + ", пол: " + gender + getFatherInfo() + getMatherInfo());
        } else {
            sb.append("ФИО: " + name.get("Фамилия") + " " + name.get("Имя") + " " + name.get("Отчество") + ", д/р: " +
                    "" + birthdate + ", пол: " + gender + getFatherInfo() + getMatherInfo());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.name.values().equals(name.values()) && human.birthdate.isEqual(birthdate);
    }

    public String getName() {
        return (String) name.get("Имя");
    }

    public int compareTo() {
        return 0;
    }

    @Override
    public int compareTo(Human o) {
        return 0;
    }
}

package model.familyTree;

import java.time.LocalDate;

public interface FamilyTreeItem<E> {
    //    void setFather();
    String getFatherInfo();

    //    void setMather();
    String getMatherInfo();

    //    void addChild();
    int countChildren();

    String getChildren();

    //    List<T> getChill();
    String getAge();

    E getFather();

    E getMather();

    int compareTo();

    String getName();

    LocalDate getBirthdate();
}

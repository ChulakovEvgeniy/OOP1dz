package familyTree.familyTree;

import familyTree.human.Human;

public interface FamilyTreeItem {
//    void setFather();
    String getFatherInfo();
//    <T> getFather();
//    <T> getMather();
//    void setMather();
    String getMatherInfo();
//    void addChild();
    int countChildren();
    String getChildren();
//    List<T> getChill();
    String getAge();

    <E extends FamilyTreeItem> E getFather();

    <E extends FamilyTreeItem> E getMather();
    int compareTo();

    String  getName();
}

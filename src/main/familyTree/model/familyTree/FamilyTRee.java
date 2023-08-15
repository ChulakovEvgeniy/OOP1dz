package model.familyTree;

import model.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTRee<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private List<E> famTree;

    public FamilyTRee() {
        this.famTree = new ArrayList<>();
    }

    public void addfam(E person) {
        if (!famTree.contains(person)) {
            famTree.add(0, person);
        }
        if (!famTree.contains((E) person.getFather())) {
            if (person.getFather() != null) {
                famTree.add(0, (E) person.getFather());
            }
        }
        if (!famTree.contains((E) person.getMather())) {
            if (person.getMather() != null) {
                famTree.add(0, (E) person.getMather());
            }
        }

    }
    public Human change(Integer index){
        if (index == 0){
            return (Human) famTree.get(0);
        }else {
            return (Human) famTree.get(index-1);
        }
    }


    @Override
    public Iterator<E> iterator() {
        return new EntityIterator<>(famTree);
    }

    public void sortByName() {
        famTree.sort((Comparator<? super E>) new ComparatorByName());
    }

    public void sortByBirthdate() {
        famTree.sort((Comparator<? super E>) new ComparatorByBirthdate());
    }
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for (E person : famTree) {
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }
}

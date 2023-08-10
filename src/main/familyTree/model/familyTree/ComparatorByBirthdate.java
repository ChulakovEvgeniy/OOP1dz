package model.familyTree;

import java.util.Comparator;

public class ComparatorByBirthdate<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthdate().compareTo(o2.getBirthdate());
    }
}

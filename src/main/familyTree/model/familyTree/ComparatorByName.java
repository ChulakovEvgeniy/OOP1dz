package model.familyTree;

import java.util.Comparator;

public class ComparatorByName<E extends FamilyTreeItem> implements Comparator<E> {
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

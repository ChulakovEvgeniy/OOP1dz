package model.familyTree;

import java.util.Iterator;
import java.util.List;

public class EntityIterator<E extends FamilyTreeItem> implements Iterator<E> {
    private int index;
    private List<E> entityList;


    public EntityIterator(List<E> entityList) {
        this.entityList = entityList;
    }

    @Override
    public boolean hasNext() {
        return entityList.size() > index;
    }

    public E next() {
        return entityList.get(index++);
    }
}

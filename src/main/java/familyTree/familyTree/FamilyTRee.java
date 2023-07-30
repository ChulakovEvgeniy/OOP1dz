package familyTree.familyTree;

import familyTree.human.Human;
import familyTree.human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTRee implements Serializable, Iterable<Human> {
    private List<Human> famTree;

    public FamilyTRee() {
        this.famTree = new ArrayList<>();
    }

    public void addfam(Human human) {
        if (!famTree.contains(human)) {
            famTree.add(0, human);
        }
        if (!famTree.contains(human.getFather())) {
            if (human.getFather() != null) {
                famTree.add(0, human.getFather());
            }
        }
        if (!famTree.contains(human.getMather())) {
            if (human.getMather() != null) {
                famTree.add(0, human.getMather());
            }
        }

    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for (Human human : famTree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(famTree);
    }

    public void sortByName() {
        famTree.sort((Comparator<? super Human>) new HumanComparatorByName());
    }

    public void sortByAge() {
        famTree.sort((Comparator<? super Human>) new HumanComparatorByAge());
    }
}

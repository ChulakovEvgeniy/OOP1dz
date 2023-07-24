package familyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTRee {
    List<String> famTree = new ArrayList<>();
        public List printfam(Human human){
            famTree.add(0,"");

            famTree.add(0,human.toString1());
            if (human.getFather1() != null){
                famTree.add(0,human.getFather1().toString1());
                }
            if (human.getMather1() != null){
                famTree.add(0,human.getMather1().toString1());
            }
                return famTree;
        }
}

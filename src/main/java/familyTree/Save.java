package familyTree;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Save {
    PrintWriter writer = new PrintWriter("FamilyTree.txt", "UTF-8");

    public Save(List<String> list) throws FileNotFoundException, UnsupportedEncodingException {
        for (String family: list){
            writer.println(family);
        }
        writer.close();
    }
}

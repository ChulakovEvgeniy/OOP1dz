package familyTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFamily {
    List<String> list = new ArrayList<>();
    public void ReadFam(String string, List list) throws FileNotFoundException {
        try {
            File file = new File("G:\\Учеба Женя\\OOP\\lesson1\\dz\\FamilyTree.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
//                System.out.println(line);
                list.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

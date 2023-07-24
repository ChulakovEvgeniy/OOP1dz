package familyTree;

import java.io.*;
import java.util.List;

public class SaveAndRead implements Serializable {
    private File file;

    public SaveAndRead(File file) {
        this.file = file;
    }

    public void save(List<Human> list) throws IOException {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(file));
                objectOutputStream.writeObject(list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void read() throws IOException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(file));
            List<Human> readCase = (List<Human>) objectInputStream.readObject();
            for (int i = 0; i < readCase.size(); i++) {
                System.out.println(readCase.get(i));
            }
            objectInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

//    PrintWriter writer = new PrintWriter("FamilyTree.txt", "UTF-8");
//
//    public Save(List<String> list) throws FileNotFoundException, UnsupportedEncodingException {
//        for (String family: list){
//            writer.println(family);
//        }
//        writer.close();
//    }
}

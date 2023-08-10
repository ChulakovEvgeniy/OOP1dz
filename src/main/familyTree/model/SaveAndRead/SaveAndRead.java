package model.SaveAndRead;

import java.io.*;

public class SaveAndRead implements Writable {
    private File file;

    public SaveAndRead(File file) {
        this.file = file;
    }
    public SaveAndRead(){

    }

//    public void save(List<Human> list) throws IOException {
//        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//                    new FileOutputStream(file));
//                objectOutputStream.writeObject(se);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public void read() throws Exception {
//        try {
//            ObjectInputStream objectInputStream = new ObjectInputStream(
//                    new FileInputStream(file));
//            List<Human> readCase = (List<Human>) objectInputStream.readObject();
//            for (int i = 0; i < readCase.size(); i++) {
//                System.out.println(readCase.get(i));
//            }
//            objectInputStream.close();
//
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    @Override
    public boolean save(Serializable serializable, String filePath) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(filePath));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.writeObject("\n");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filePath) {
        try {
            ObjectInputStream objectOutputStream = new ObjectInputStream(
                    new FileInputStream(filePath));
            return objectOutputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

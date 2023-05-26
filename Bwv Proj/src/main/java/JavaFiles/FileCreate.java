package JavaFiles;

import java.io.File;

public class FileCreate {

    public FileCreate() {

    }

    public void createtheFile(String path) {

        try {
            File file = new File(path);
            if (file.createNewFile()) {
                System.out.println("File wurde erstellt " + file.getName());
            } else {
                System.out.println("File existiert schon ");
            }

        } catch (Exception e) {
           System.out.println("Error ");
           e.printStackTrace();
        }

    }

}

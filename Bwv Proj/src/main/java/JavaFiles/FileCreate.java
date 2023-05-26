package JavaFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

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

    public void writeToFile(String s) {

        try {
            FileWriter writer = new FileWriter(s);
            Scanner scan = new Scanner(System.in);
            writer.write(scan.nextLine());       
            scan.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("fehler ist aufgetretten ");
            e.printStackTrace();
        }

    }

}

package JavaFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Fileread {
    
    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void fileReader(String path){
        setPath(path);
    }

    public ArrayList<String> readFile(){
        String path = getPath();

        ArrayList<String> reader = new ArrayList<>();

            try {
                File file = new File(path);
                Scanner scan = new Scanner(file);
                while(scan.hasNext()){
                    reader.add(scan.nextLine());
                }
                scan.close();


            } catch (Exception e) {
                System.out.println("Error");
                e.printStackTrace();
            }

        return reader;

    }


}

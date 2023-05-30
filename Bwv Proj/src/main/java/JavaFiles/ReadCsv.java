package JavaFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCsv {


    public ArrayList<String> readCSV(String path) throws FileNotFoundException {
        ArrayList<String> csvList = new ArrayList<>();

        try {
            File file = new File(path);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                csvList.add(scan.nextLine());
            }
            scan.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return csvList;
    }




}

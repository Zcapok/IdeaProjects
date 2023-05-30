package JavaFiles;

import java.util.ArrayList;
import java.util.List;

public class FileMain {


    public static void main(String[] args){

        List<String> objList = new ArrayList<>();
            objList.add("Erster String");
            objList.add("Zweiter String");
            objList.add("Dritter String");
            objList.add("Vierter String");

        AllFile myobj = new AllFile("Beispieldatei.csv");
        myobj.myFilereader();
        myobj.myFileCreator("Allfile.txt");
        myobj.setPath("Allfile.txt");
        myobj.myFileWriter(objList);
        myobj.myFilereader();
    }
    
}

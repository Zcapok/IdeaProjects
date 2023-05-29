package JavaFiles;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
       
        ArrayList<String> tmplist= new ArrayList<>();

        FileCreate file = new FileCreate();
        file.createtheFile("Testfile.txt");
        

        Fileread read = new Fileread();
        read.setPath("Testfile.txt");
        tmplist = read.readFile();
        
        System.out.println("Inhalt vor dem Filewriter : ");
        for( String s : tmplist){
            System.out.println(s);
        }


        System.out.println("Inhalt nach dem Filewriter : ");
        file.writeToFile("Testfile.txt");

        tmplist = read.readFile();

        for(String s : tmplist){
            System.out.println(s);
        }

        
    }

}

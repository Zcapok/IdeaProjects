package JavaFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllFile {
    
        private String path;
        private List<String> myList = new ArrayList<>();

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public AllFile(String path){
           setPath(path);
        }

        public void myFilereader(){

            try {
                File myFile = new File(getPath());
                Scanner myScan = new Scanner(myFile);
                while(myScan.hasNextLine()){
                    String data = myScan.nextLine();
                    myList.add(data);
                }
                    myScan.close();
                System.out.println(myList);    
            } catch (Exception e) {
                System.out.println("File not found");
            }

        }


        public void myFileCreator(String Filename){

            File myFile = new File(Filename);
            try {
                if(myFile.createNewFile()){
                    System.out.println("File " + myFile.getName() + " is created");
                }else{
                    System.out.println("File " + myFile.getName() + " already exist");
                }

            } catch (IOException e) {
                System.out.println("File " + myFile.getName() + " is not created");
                e.printStackTrace();
            }


        }



        public void myFileWriter(List<String> stringList){

            try {
                FileWriter myWriter = new FileWriter(getPath());
               for (String string : stringList) {
                    myWriter.write(string);
               }
                    myWriter.close();
            } catch (IOException e) {
                System.out.println("File cant be written!");
                e.printStackTrace();
            }
        }

}

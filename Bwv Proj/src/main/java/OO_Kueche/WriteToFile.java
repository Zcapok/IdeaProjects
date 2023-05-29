package OO_Kueche;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile{

    public void inputWriter(ArrayList<String> list){
        try{
            FileWriter myfile = new FileWriter("Testfile.txt",  true); 
            for(String s : list){
                myfile.write(s);
            }

            myfile.close();
        }catch(IOException e){
            System.out.println("File cant be written");
            e.printStackTrace();
        }
           

    } 

}
package Workers.GUI;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Mitarbeiter.verwaltung.Abteilung;
import MitarbeiterVerwaltung.Verwaltung;
import Workers.mitarbeiter.BueroArbeiter;
import Workers.mitarbeiter.Mitarbeiter;

public class Main {
    
    public static void main(String[] args){
       

        // List<Mitarbeiter> list = new ArrayList<>();
        //     list.add(new BueroArbeiter(1,"Stan",2000));
        //     list.add(new BueroArbeiter(2,"Holger",3000));           

            Model model = new Model();
            model.mitarbeiterReader("mitarbeiter.csv");
            Gui gui = new Gui(model.getMitarbeiterListe());
            
        
        
        
        
    }

}

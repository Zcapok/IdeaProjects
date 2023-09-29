package Workers.GUI;


import java.util.ArrayList;
import java.util.List;

import MitarbeiterVerwaltung.Verwaltung;
import Workers.mitarbeiter.BueroArbeiter;
import Workers.mitarbeiter.Manager;
import Workers.mitarbeiter.Mitarbeiter;

public class Main {
    
    public static void main(String[] args){
        
        List<Mitarbeiter> list = new ArrayList<>();
            list.add(new Manager(20, "Bob", 25000, 5));
            list.add(new BueroArbeiter(1,"Stan",2000));
            list.add(new BueroArbeiter(2,"Holger",3000));          
            
            Gui gui = new Gui(list);
            
        
        
        
        
    }

}

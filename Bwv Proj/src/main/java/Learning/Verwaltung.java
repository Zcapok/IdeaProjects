package Learning;

import java.util.ArrayList;
import java.util.List;

public class Verwaltung {
    
    private List<Mitarbeiter> mitarbeiterListe = new ArrayList<>();

    public List<Mitarbeiter> getMitarbeiterListe() {
        return mitarbeiterListe;
    }

    public void setMitarbeiterListe(List<Mitarbeiter> mitarbeiterListe) {
        this.mitarbeiterListe = mitarbeiterListe;
    }

    public void addMitarbeiter(Mitarbeiter mitarbeiter){
       mitarbeiterListe.add(mitarbeiter);
       setMitarbeiterListe(mitarbeiterListe);

    }
    public void removeMitarbeiter(Mitarbeiter mitarbeiter){
        mitarbeiterListe.remove(mitarbeiter);
        setMitarbeiterListe(mitarbeiterListe);
    }
}
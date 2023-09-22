package MitarbeiterVerwaltung;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Verwaltung implements IF_Mitarbeiter {
    
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

    @Override
    public void Kontonummer(String konto) throws IOException {

        for (Mitarbeiter m: getMitarbeiterListe()){
            String temp = m.toString().concat(konto);
            System.out.println(temp);
        }


    }

    public void addMitarbeiter(Workers.mitarbeiter.Mitarbeiter stan) {
    }
}
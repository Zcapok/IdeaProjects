package MitarbeiterVerwaltung;

public class Schichtarbeiter extends Mitarbeiter {
// Gehalt mit getter und setter
    private double gehalt;
    

    public double getGehalt() {
        return gehalt;
    }


    public void setGehalt(int gehalt) {
        this.gehalt = gehalt;
    }


    public Schichtarbeiter(int id, String name, String vorname, int age, int gehalt ) {
        super(id, name, vorname, age);
        setGehalt(gehalt);
    }


    @Override
    public double einkommensberechnung() {
       return getGehalt();
    }



}

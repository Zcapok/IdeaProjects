package MitarbeiterVerwaltung;

public class Bueroarbeiter extends Mitarbeiter {
    // Gehalt sowie getter und setter
    private int gehalt;

    public int getGehalt() {
        return gehalt;
    }

    public void setGehalt(int gehalt) {
        this.gehalt = gehalt;
    }

    // Konstruktor
    public Bueroarbeiter(int id, String name, String vorname, int age, int gehalt) {
        super(id, name, vorname, age);
        setGehalt(gehalt);
    }

    public String toString() {
        return super.toString() + ", gehalt=" + einkommensberechnung();
    }

    @Override
    public double einkommensberechnung() {
        double einkommen = Math.round(getGehalt() * 1.15);
        return einkommen;
    }


}
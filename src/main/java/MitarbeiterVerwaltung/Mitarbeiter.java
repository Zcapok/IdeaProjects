package MitarbeiterVerwaltung;

public abstract class Mitarbeiter {
    // name und getter und setter
    private String name;

    public Mitarbeiter(int id, String name, String vorname, int age) {
        this.name = name;
        this.vorname = vorname;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // vorname und getter und setter
    private String vorname;

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    // alter und getter und setter
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ID und getter und setter
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String toString() {
        return "Name: " + name + " Vorname: " + vorname + " Age: " + age + " ID: " + id;
    }

    public abstract double einkommensberechnung();


}

package Learning;

public class Main {

    public static void main(String args[]) {

        Verwaltung liste = new Verwaltung();

        Mitarbeiter walter = new Bueroarbeiter(5, "White", "Walter", 37, 2900);
        System.out.println(walter.toString());

        Mitarbeiter john = new Manager(10, "Carpenter", "John", 55, 3500, 1.20);
        System.out.println(john.toString());

        Mitarbeiter kalle = new Schichtarbeiter(22, "Gruber", "Kalle", 45, 3400);

        liste.addMitarbeiter(walter);
        liste.addMitarbeiter(john);
        liste.addMitarbeiter(kalle);
        //liste.removeMitarbeiter(john);
        System.out.println(liste.toString());

        for (Mitarbeiter mitarbeiter : liste.getMitarbeiterListe()) {
            System.out.println(mitarbeiter.toString());
        }

        MitarbeiterCSVWriter csvWriter = new MitarbeiterCSVWriter("mitarbeiter.csv");
        csvWriter.saveMitarbeiterListeToCSV(liste.getMitarbeiterListe());

    }

}
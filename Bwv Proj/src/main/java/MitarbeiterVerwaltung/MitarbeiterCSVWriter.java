package MitarbeiterVerwaltung;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MitarbeiterCSVWriter {

    private String filename;

    public MitarbeiterCSVWriter(String filename) {
        this.filename = filename;
    }

    public void saveMitarbeiterListeToCSV(List<Mitarbeiter> mitarbeiterListe) {
        try (FileWriter writer = new FileWriter(filename)) {
            // Schreiben der Spaltenüberschriften
            writer.write("ID,Name,Vorname,Alter,Gehalt"+"\n");

            // Schreiben der Daten für jeden Mitarbeiter
            for (Mitarbeiter mitarbeiter : mitarbeiterListe) {
                String line = mitarbeiter.getId() + ","
                        + mitarbeiter.getName() + ","
                        + mitarbeiter.getVorname() + ","
                        + mitarbeiter.getAge() + ","
                        + mitarbeiter.einkommensberechnung() + "\n";
                        
                writer.write(line);
            }

            System.out.println("Mitarbeiterliste wurde erfolgreich in die CSV-Datei gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Mitarbeiterliste: " + e.getMessage());
        }
    }
}
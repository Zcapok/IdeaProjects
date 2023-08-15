package MitarbeiterVerwaltung;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;

public class MitarbeiterCSVWriter {

    private String filename;

    public MitarbeiterCSVWriter(String filename) {
        this.filename = filename;
    }

    public void saveMitarbeiterListeToCSV(List<Mitarbeiter> mitarbeiterListe) {
        try (FileWriter writer = new FileWriter(filename)) {
            // Schreiben der Spaltenüberschriften
            writer.write("ID,Name,Vorname,Alter,Gehalt" + "\n");

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

    public void saveMitarbeiterListeToTxt(List<Mitarbeiter> mitarbeiterListe) {

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filepath = selectedFile.getAbsolutePath();

            try {

                FileWriter writer = new FileWriter(filepath);
                writer.write("ID,Name,Vorname,Alter,Gehalt" + "\n");

                for (Mitarbeiter mit : mitarbeiterListe) {
                    String line = mit.getId() + "," + mit.getName() + "," + mit.getVorname() + "," + mit.getAge() + ","
                            + mit.einkommensberechnung() + "\n";
                    writer.write(line);

                }
                writer.close();
                System.out.println("Datei erfolgreich gespeichert");
            }

            catch (IOException e) {
                System.out.println("Fehler beim Speichern der Txtdatei");
            }

        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Speichern abgebrochen");
        }
    }
}
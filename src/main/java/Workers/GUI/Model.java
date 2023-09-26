package Workers.GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Workers.mitarbeiter.BueroArbeiter;
import Workers.mitarbeiter.Mitarbeiter;

public class Model{

    private List<Mitarbeiter> liste = new ArrayList<>();

    public List<Mitarbeiter> getMitarbeiterListe(){
        return this.liste;
    }

    public void mitarbeiterReader(String pfadName){
         String csvFile = pfadName; // Passe den Dateinamen entsprechend an
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Trenne die Zeile anhand des Kommas (CSV-Trennzeichen)
                String[] values = line.split(",");
                Mitarbeiter m = new BueroArbeiter(Integer.parseInt(values[0]), values[1], Double.parseDouble(values[2]));
                liste.add(m);
                // Hier kannst du die Werte verarbeiten, z.B. ausgeben
                // for (String value : values) {
                   
                // }
                System.out.println(); // Neue Zeile nach jeder Zeile in der CSV-Datei
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveWorker(String pfadName,int id, String name,double Gehalt){
        String csvFile = pfadName; // Passe den Dateinamen entsprechend an
        
        // Die neue Zeile, die du hinzufügen möchtest
        String newLine = id + "," + name + "," + Gehalt; // ID, Name, Gehalt
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            
            // Lese die vorhandenen Zeilen und speichere sie in einem StringBuffer
            StringBuilder fileContents = new StringBuilder();
            // String line;
            // while ((line = br.readLine()) != null) {
            //     fileContents.append(line).append("\n");
            // }
            
            // Füge die neue Zeile am Ende hinzu
            fileContents.append(newLine);
            
            // Schreibe die aktualisierten Daten zurück in die CSV-Datei
            bw.write(fileContents.toString());
            
            System.out.println("Zeile erfolgreich hinzugefügt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteWorker(String pfadName,int removeLine){
       String csvFile = pfadName; // Passe den Dateinamen entsprechend an
        int lineToRemove = removeLine; // Hier die Zeilennummer angeben, die gelöscht werden soll (zum Beispiel Zeile 3)

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter("temp.csv"))) {
            
            String line;
            int currentLine = 0;
            
            while ((line = br.readLine()) != null) {
                if (currentLine != lineToRemove) {
                    // Schreibe die Zeile in die temp-Datei, außer wenn es die zu löschende Zeile ist
                    bw.write(line);
                    bw.newLine(); // Füge eine neue Zeile hinzu
                }
                currentLine++;
            }
            
            // Lösche die ursprüngliche Datei
            File originalFile = new File(csvFile);
            if (originalFile.delete()) {
                // Benenne die temp-Datei in den ursprünglichen Dateinamen um
                File newFile = new File(csvFile);
                if (newFile.renameTo(originalFile)) {
                    System.out.println("Zeile erfolgreich gelöscht.");
                } else {
                    System.out.println("Fehler beim Umbenennen der temp-Datei.");
                }
            } else {
                System.out.println("Fehler beim Löschen der ursprünglichen Datei.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
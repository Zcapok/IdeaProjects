package Datenspeicherung;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Verzeichnis erstellen
            /*Path directoryPath = Paths.get("C:", "mydir");
            FilesUtil.createDirectory(directoryPath);
            System.out.println("Verzeichnis erstellt: " + directoryPath);*/

            // Datei erstellen
            //Path filePath = Paths.get("C:", "Users\\soulw\\OneDrive\\Schule\\BwvGit", "mitarbeiter.csv");
            Path filePath = Paths.get("C:", "mydir", "myfile.txt");
            FilesUtil.createFile(filePath);
            System.out.println("Datei erstellt: " + filePath);
            //C:\Users\soulw\OneDrive\Schule\BwvGit\mitarbeiter.csv
            // Zeilen aus Datei lesen
            List<String> lines = FilesUtil.readAllLines(filePath, StandardCharsets.UTF_8);
            System.out.println("Inhalt der Datei:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Ausführen der Dateioperationen: " + e.getMessage());
        }
    }
}

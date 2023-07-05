package de.stan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class WindowsIPConfig {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(WindowsIPConfig::createAndShowGUI);

    }

    private static void createAndShowGUI() {
        try {
            // Setze das Look-and-Feel auf das systemeigene Look-and-Feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Setze den Dark Mode
            UIManager.put("nimbusBase", Color.DARK_GRAY);
            UIManager.put("nimbusBlueGrey", Color.DARK_GRAY);
            UIManager.put("control", Color.DARK_GRAY);

            // Erstelle das Fenster
            JFrame frame = new JFrame("IPConfig All");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLayout(new BorderLayout());
           

            JTextArea outputArea = new JTextArea();
            outputArea.setEditable(false);
            outputArea.setForeground(Color.WHITE);
            outputArea.setBackground(Color.DARK_GRAY);
            JScrollPane scrollPane = new JScrollPane(outputArea);
            frame.add(scrollPane, BorderLayout.CENTER);

            JButton runButton = new JButton("Run IPConfig");
            runButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    runIPConfig(outputArea);
                }
            });
            frame.add(runButton, BorderLayout.SOUTH);

            // Zeige das Fenster an
            SwingUtilities.updateComponentTreeUI(frame);
            frame.setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }

    private static void runIPConfig(JTextArea outputArea) {
        try {
            // Erstelle einen ProcessBuilder mit dem "ipconfig /all"-Kommando
            ProcessBuilder processBuilder = new ProcessBuilder("ipconfig", "/all");
            processBuilder.redirectErrorStream(true);

            // Starte den Prozess
            Process process = processBuilder.start();

            // Lese den Ausgabe-Stream des Prozesses
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                outputArea.append(line + "\n");
            }

            // Warte auf Beendigung des Prozesses
            int exitCode = process.waitFor();
            outputArea.append("\nExit-Code: " + exitCode + "\n");

            // Schließe den BufferedReader
            reader.close();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }


}
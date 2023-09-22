package Workers.GUI;
import Workers.mitarbeiter.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Gui extends JFrame {

    private JFrame frame = new JFrame();
    private List<Mitarbeiter> list = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable table;

    public Gui(List<Mitarbeiter> mitarbeiterListe) {
        this.list = mitarbeiterListe;
        initGui();
    }

    public void initGui() {
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(800, 600);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        // Spalten Füllen mit Überschrift
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Gehalt");

        // Spalten füllen mit Werten
        for (Mitarbeiter m : list) {
            // Erzeugen Sie ein Array von Objekten für jede Zeile
            Object[] row = {m.getID(), m.getName(), m.einkommen()};
            // Fügen Sie die Zeile dem TableModel hinzu
            tableModel.addRow(row);
        }

        JButton addButton = new JButton("Mitarbeiter hinzufügen");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField gehaltField = new JTextField();

        Object[] fields = {
            "ID:", idField,
            "Name:", nameField,
            "Gehalt:", gehaltField
        };

        int result = JOptionPane.showConfirmDialog(
            frame,
            fields,
            "Mitarbeiter hinzufügen",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {
            try {
                // Die eingegebenen Daten aus den Textfeldern abrufen
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                double gehalt = Double.parseDouble(gehaltField.getText());

                // Einen neuen Mitarbeiter erstellen und zur Liste hinzufügen
                Mitarbeiter neuerMitarbeiter = new BueroArbeiter(id, name, gehalt);
                list.add(neuerMitarbeiter);

                // Die neue Zeile zur Tabelle hinzufügen
                Object[] row = {neuerMitarbeiter.getID(), neuerMitarbeiter.getName(), neuerMitarbeiter.einkommen()};
                tableModel.addRow(row);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Ungültige Eingabe. ID und Gehalt müssen Zahlen sein.", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }
    

                
            }
        });

        JButton removeButton = new JButton("Mitarbeiter entfernen");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    // Entfernen des ausgewählten Mitarbeiters 
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Bitte eine Zeile auswählen.", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
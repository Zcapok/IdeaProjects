package Mitarbeiter.gui;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Mitarbeiter.mitarbeiter.MitarbeiterTyp;

public class EmployeePanel extends JPanel {
	
    private static final long serialVersionUID = 1L;
    
	private JTextField nameField;
    private JComboBox<String> jobComboBox;
    private JTextField salaryField;

	private JTextField idField;

	private JTextField bonusField;

	private JTextField licenceField;

	private JTextField hoursField;

    public EmployeePanel() {
        
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	
    	idField = new JTextField();
    	add(new JLabel("ID: "));
    	add(idField);

        // Name-Eingabefeld erstellen
        nameField = new JTextField(20);
        add(new JLabel("Name: "));
        add(nameField);
        
        // Namen aus Enum ziehen
        MitarbeiterTyp[] mETypes = MitarbeiterTyp.values();
        String[] mTypes = new String[mETypes.length];
        for (int i = 0; i < mTypes.length; i++) {
			mTypes[i] = mETypes[i].getDisplayName();
		}

        // Job-Auswahlliste erstellen
        jobComboBox = new JComboBox<>(mTypes);
        add(new JLabel("Job: "));
        add(jobComboBox);

        // Gehalt-Eingabefeld erstellen
        salaryField = new JTextField(10);
        add(new JLabel("Gehalt: "));
        add(salaryField);
        
        // Bonus-Eingabefeld erstellen nur für Manager
        bonusField = new JTextField(10);
        add(new JLabel("Bonus(Manager [1-200%]): "));
        add(bonusField);
        
        // Führerschein-Eingabefeld erstellen nur für Manager
        licenceField = new JTextField(10);
        add(new JLabel("Führerschein(Fahrer): "));
        add(licenceField);
        
        // Anzahl Stunden-Eingabefeld nuf für Schicht und Fahrer
        hoursField = new JTextField(10);
        add(new JLabel("Stunden(Schicht & Fahrer): "));
        add(hoursField);
        
    }

    // Getter-Methoden für die eingegebenen Werte
    public String getName() {
        return nameField.getText();
    }

    public String getJob() {
        return jobComboBox.getSelectedItem().toString();
    }

    public double getSalary() {
        try {
            return Double.parseDouble(salaryField.getText());
        } catch (NumberFormatException e) {
            // Fehlerbehandlung, falls die Eingabe keine gültige Double-Zahl ist
            return 0.0; // Standardwert zurückgeben oder Fehlerbehandlung nach Bedarf anpassen
        }
    }
    
    public int getID() {
    	return Integer.parseInt(idField.getText());
    }
    
    public double getBonus() {
    	if(getJob().equals(MitarbeiterTyp.MANAGER.getDisplayName()))
    		return Double.parseDouble(bonusField.getText());
    	return 0d;
    }
    
    public String getLicence() {
    	if(getJob().equals(MitarbeiterTyp.FAHRER.getDisplayName()))
    		return licenceField.getText();
    	return "";
    }
    
    public int getHours() {
    	if(getJob().equals(MitarbeiterTyp.SCHICHT.getDisplayName()) || getJob().equals(MitarbeiterTyp.FAHRER.getDisplayName()))
    		return Integer.parseInt(hoursField.getText());
    	return 0;
    }

}


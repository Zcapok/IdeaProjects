package Mitarbeiter.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Mitarbeiter.mitarbeiter.*;
import Mitarbeiter.mitarbeiter.vonMir.CSVHandler;
import Mitarbeiter.mitarbeiter.vonMir.MitarbeiterFactory;

/**
 * Create a graphical user interface to control employee.<br>
 * You can import or export them.<br>
 * Or you can add more and change them for export
 * 
 * @author robingorissen
 *
 */
public class GUI extends JFrame {

	// Normally they get it from model but here we do not use the
	// model-view-controller pattern
	private ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<>();

	private static final long serialVersionUID = 1L;

	private JButton btnAdd;
	private JButton btnRem;
	private JButton btnImp;
	private JButton btnExp;
	private DefaultTableModel mTableModel;

	private JTable mTable;

	public GUI() {
		createGUI();
		this.setVisible(true);
	}

	/**
	 * Create all necessary parts of the graphical user interface
	 */
	private void createGUI() {

		// Configuration

		this.setSize(400, 400);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setTitle("Mitarbeiterverwaltung v1.0 by Robin G.");

		// Mitarbeiter Table

		JPanel pnlMitarbeiter = new JPanel(new BorderLayout());

		// Table model for easy changing the table
		mTableModel = new DefaultTableModel();

		mTableModel.addColumn("MitarbeiterID");
		mTableModel.addColumn("MitarbeiterType");
		mTableModel.addColumn("Name");
		mTableModel.addColumn("Gehalt");
		mTableModel.addColumn("Andere");

		// Table
		mTable = new JTable(mTableModel);
		mTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// colors
		TableCellRenderer customRenderer = new CustomTableCellRenderer(); // Row color
		mTable.setDefaultRenderer(Object.class, customRenderer);

		mTable.getTableHeader().setBackground(new Color(30, 129, 176)); // Column color

		// Add the scalable table to the frame
		JScrollPane sp = new JScrollPane(mTable);
		pnlMitarbeiter.add(sp);
		this.add(pnlMitarbeiter);

		// Controls on the right corner

		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new BoxLayout(pnlButtons, BoxLayout.Y_AXIS));
		btnAdd = new JButton("Hinzufügen");
		btnRem = new JButton("Entfernen");
		btnImp = new JButton("Export");
		btnExp = new JButton("Import");

		btnAdd.addActionListener(new ButtonActions());
		btnRem.addActionListener(new ButtonActions());
		btnImp.addActionListener(new ButtonActions());
		btnExp.addActionListener(new ButtonActions());

		// Add all into the frame
		pnlButtons.add(btnAdd);
		pnlButtons.add(btnRem);
		pnlButtons.add(btnImp);
		pnlButtons.add(btnExp);

		this.add(pnlButtons, BorderLayout.EAST);

	}

	/**
	 * Go over each column row to calculate the best spacing and adds 10px more
	 */
	private void updateTableSize() {
		TableColumnModel columnModel = mTable.getColumnModel();
		for (int columnIndex = 0; columnIndex < columnModel.getColumnCount(); columnIndex++) {
			int maxWidth = 0;
			for (int rowIndex = 0; rowIndex < mTable.getRowCount(); rowIndex++) {
				TableCellRenderer cellRenderer = mTable.getCellRenderer(rowIndex, columnIndex);
				Object value = mTable.getValueAt(rowIndex, columnIndex);
				Component cellComponent = cellRenderer.getTableCellRendererComponent(mTable, value, false, false,
						rowIndex, columnIndex);
				maxWidth = Math.max(maxWidth, cellComponent.getPreferredSize().width);
			}
			columnModel.getColumn(columnIndex).setPreferredWidth(maxWidth + 10); // For extra space -> cosmetics
		}

	}

	/**
	 * Adds the Mitarbeiter to the end of the list
	 * 
	 * @param m    Mitarbeiter object
	 * @param type the MitarbeiterTyp display name
	 * @param some addon like manager bonus or driver licence
	 */
	public void appendMiarbetier(Mitarbeiter m, String type, String some) {
		String[] row = new String[5];
		row[0] = m.getID() + ""; // +"" Converts to String
		row[1] = type;
		row[2] = m.getName();
		row[3] = m.einkommen() + "";
		row[4] = some;

		mTableModel.addRow(row);
		mitarbeiter.add(m);

	}

	/**
	 * Class for button actions
	 * 
	 * @author robingorissen
	 *
	 */
	private class ButtonActions implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
//			if (1 == 1) { // Testing. I though maybe its a beauty if i can click it and there only adds an
//							// row but... no thats bec i wrote i though
//				mTableModel.addRow(new Object[0]);
//				return;
//			}

			String action = e.getActionCommand();
			

			doAction(action);

		}

		private void doAction(String action) {
			if (action.equals("Hinzufügen")) {
				try {
					// Show a new "frame" with inputs to create a Mitarbeiter with the factory
					addMitarbeiter(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(GUI.this,
							"Es wurden nicht alle Felder ordnungsgemäß ausgefüllt!\nMitarbeiter nicht hinzugefügt!");
					return;
				}
			} else if (action.equals("Entfernen"))
				removeMitarbeiter();
			else if (action.equals("Export"))
				export();
			else if (action.equals("Import"))
				mimport();
			else
				throw new RuntimeException("Cannot handle " + action);

		}

		/**
		 * imnport a csv or txt file filled with Mitarbeiter csv strings.<br>
		 * And appends them to the table
		 */
		private void mimport() {
			
			// JFileChooser opens a file explorer window.
			
			File f = null;
			FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV und TXT Dateien", "csv", "txt");
			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(filter);
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

			// Open the chooser and get okay or cancel input from the user
			int retVal = fc.showOpenDialog(GUI.this);

			if (retVal == JFileChooser.APPROVE_OPTION) {
				f = fc.getSelectedFile();
			} else {
				JOptionPane.showMessageDialog(GUI.this, "Import abgebrochen");
				return;
			}

			// Import
			
			try {
				ArrayList<Mitarbeiter> imported = CSVHandler.mImport(f, GUI.this);
				for (Mitarbeiter mitarbeiter : imported) {

				}
				JOptionPane.showMessageDialog(GUI.this, "Import abgeschlossen!");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(GUI.this, e.getMessage());
				e.printStackTrace();
			}
			updateTableSize();
		}

		/**
		 * Open the JFilechooser and export the Mitarbeiter from the Table to the csv or txt file
		 */
		private void export() {
			
			// JFileChooser
			
			File f = null;
			FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV und TXT Dateien", "csv", "txt");
			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(filter);
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

			int retVal = fc.showOpenDialog(GUI.this);

			if (retVal == JFileChooser.APPROVE_OPTION) {
				f = fc.getSelectedFile();
			} else {
				JOptionPane.showMessageDialog(GUI.this, "Export abgebrochen");
				return;
			}
			
			// Export

			try {
				CSVHandler.export(mitarbeiter, f);
				JOptionPane.showMessageDialog(GUI.this, "Export abgeschlossen!");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(GUI.this, e.getMessage());
				e.printStackTrace();
			}

		}

		/**
		 * Removes the selected Mitarbeiter
		 */
		private void removeMitarbeiter() {
			int selected = mTable.getSelectedRow();
			try {
				mTableModel.removeRow(selected);
				mitarbeiter.remove(selected);
				JOptionPane.showMessageDialog(GUI.this, "Mitarbeiter entfernt!");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(GUI.this, "Wähle einen Mitarbeiter aus\nMitarbeiter nicht entfernt!");
			}
			updateTableSize();

		}

		private void addMitarbeiter(ArrayList<Object> parameters) {
			if (parameters != null) {
				// TODO: if == null copy following code after if, add magic the parameters from
				// import in the table
			}
			EmployeePanel pnlInputs = new EmployeePanel();
			pnlInputs.setLayout(new BoxLayout(pnlInputs, BoxLayout.Y_AXIS));

			int retVal = JOptionPane.showConfirmDialog(GUI.this, pnlInputs, "Mitarbeiter hinzufügen",
					JOptionPane.OK_CANCEL_OPTION);

			if (retVal == JOptionPane.OK_OPTION) {

				// Get the user inputs
				int id = pnlInputs.getID();
				String name = pnlInputs.getName();
				String job = pnlInputs.getJob();
				double salary = pnlInputs.getSalary();
				double bonus = pnlInputs.getBonus();
				String licence = pnlInputs.getLicence();
				int hours = pnlInputs.getHours();

				String some = ""; // For the last column(Andere)

				// Prepare Factory parameters
				parameters = new ArrayList<>();
				parameters.add(id + "");
				parameters.add(name + "");
				parameters.add(salary + "");

				// Fill some with addition
				if (bonus != 0) {
					parameters.add(bonus + "");
					some = "Bonus: " + bonus;
				}

				if (hours != 0) {
					parameters.add(hours + "");
					some += "Stunden: " + hours + " ";
				}

				if (licence != "") {
					parameters.add(licence + "");
					some += "Führerschein: " + licence + " ";
				}

				MitarbeiterFactory factory = new MitarbeiterFactory();
				Mitarbeiter m = null;
				try {
					m = factory.getMitarbeiter(factory.getTypeByString(job), parameters);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(GUI.this, e1.getMessage() + "\nMitarbeiter nicht hinzugefügt!");
					return;
					// e1.printStackTrace();
				}

				// Append Mitarbeiter creates from the factory to the table
				appendMiarbetier(m, job, some);
				JOptionPane.showMessageDialog(GUI.this, "Mitarbeiter hinzugefügt!");

			} else {
				JOptionPane.showMessageDialog(GUI.this, "Mitarbeiter nicht hinzugefügt!");
			}

			updateTableSize();
		}

	}

	/**
	 * Custom TableCellRenderer class
	 * 
	 * @author robingorissen
	 *
	 */
	static class CustomTableCellRenderer extends DefaultTableCellRenderer {

		private static final long serialVersionUID = 1L;

		private final Color evenColor = new Color(240, 240, 240); // Color for even rows
		private final Color oddColor = new Color(220, 220, 220); // Color for odd rows

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if (row % 2 == 0) {
				renderer.setBackground(evenColor);
			} else {
				renderer.setBackground(oddColor);
			}
			return renderer;
		}
	}

}

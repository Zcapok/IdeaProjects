package Mitarbeiter.mitarbeiter.vonMir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import Mitarbeiter.gui.GUI;
import Mitarbeiter.mitarbeiter.Mitarbeiter;
import Mitarbeiter.mitarbeiter.MitarbeiterTyp;

public class CSVHandler {

	/**
	 * Run the Arraylist and get the csv string. Appends the csv string to the given file
	 * @param m
	 * @param f
	 * @throws IOException
	 */
	public static void export(ArrayList<Mitarbeiter> m, File f) throws IOException {
		FileWriter writer = new FileWriter(f);

		String line = "";
		for (Mitarbeiter mitarbeiter : m) {
			line = mitarbeiter.toCSVString() + "\n";
			writer.append(line);
			writer.flush();
		}

		writer.close();

	}

	/**
	 * Import Mitarbeiter from the given file. They adds automatically to GUI <s>if not null</s>
	 * @param f to import
	 * @param g to append
	 * @return the whole list
	 * @throws IOException
	 */
	public static ArrayList<Mitarbeiter> mImport(File f, GUI g) throws IOException {
		if (f == null)
			return null;
		ArrayList<Mitarbeiter> m = new ArrayList<>();

		try {
			Files.lines(Paths.get(f.getAbsolutePath())).forEach((line) -> {
				System.out.println(line);
				String[] splitted = line.split(";");
				MitarbeiterTyp key = MitarbeiterFactory.getTypeByString(splitted[0]);
				splitted = line.substring(line.indexOf(";")+1).split(";");

				
				MitarbeiterFactory factory = new MitarbeiterFactory();
				Mitarbeiter arbeiter;
				try {
					
					arbeiter = factory.getMitarbeiter(key, Arrays.asList(splitted));
					
					if (arbeiter != null) {
						m.add(arbeiter);
						switch (key) {
						case FAHRER: {
							String licence = splitted[splitted.length-1];
							String hours = splitted[splitted.length-2];
							g.appendMiarbetier(arbeiter, key.getDisplayName(), "Stunden: " + hours + "Fürherschein: " + licence);
							
							break;
						}
						case BUERO:{
							g.appendMiarbetier(arbeiter, key.getDisplayName(), "");
							break;
						}
						case MANAGER: {
							String bonus = splitted[splitted.length-1];
							g.appendMiarbetier(arbeiter, key.getDisplayName(), "Bonus: " + bonus);
							break;
						}
						default:
							String hours = splitted[splitted.length-1];
							g.appendMiarbetier(arbeiter, key.getDisplayName(), "Stunden: " + hours);

						}
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		return m;
	}
}

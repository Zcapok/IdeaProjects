package Mitarbeiter.mitarbeiter.vonMir;

import java.util.Collection;
import java.util.Iterator;

import Mitarbeiter.mitarbeiter.BueroArbeiter;
import Mitarbeiter.mitarbeiter.Fahrer;
import Mitarbeiter.mitarbeiter.Manager;
import Mitarbeiter.mitarbeiter.Mitarbeiter;
import Mitarbeiter.mitarbeiter.MitarbeiterTyp;
import Mitarbeiter.mitarbeiter.SchichtArbeiter;

/**
 * To create a Mitarbeiter from the enum MitarbeiterTyp
 * 
 * @author robingorissen
 *
 */
public class MitarbeiterFactory {

	public static MitarbeiterTyp getTypeByString(String type) {
		// Get the name from the enum
		MitarbeiterTyp[] mETypes = MitarbeiterTyp.values();
		for (int i = 0; i < mETypes.length; i++) {
			if (mETypes[i].getDisplayName().equalsIgnoreCase(type))
				return mETypes[i];
		}
		return null;
	}

	public static MitarbeiterTyp getByObject(Mitarbeiter m) {
		if (m instanceof BueroArbeiter)
			return MitarbeiterTyp.BUERO;
		else if (m instanceof Manager)
			return MitarbeiterTyp.MANAGER;
		else if (m instanceof SchichtArbeiter)
			return MitarbeiterTyp.SCHICHT;
		else if (m instanceof Fahrer)
			return MitarbeiterTyp.BUERO;
		else
			return null;
	}

	/**
	 * Gets the right type but you have to cast it
	 * 
	 * @param typ
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public Mitarbeiter getMitarbeiter(MitarbeiterTyp typ, Collection<Object> parameters) throws Exception {

		Mitarbeiter arbeiter;
		Iterator<Object> it = parameters.iterator();
		switch (typ) {
		case BUERO: {
			arbeiter = new BueroArbeiter(Integer.parseInt(it.next() + ""), it.next() + "",
					Double.parseDouble(it.next() + ""));
			break;
		}
		case MANAGER: {
			Manager marbeiter = new Manager(Integer.parseInt(it.next() + ""), it.next() + "",
					Double.parseDouble(it.next() + ""), Double.parseDouble(it.next() + "")/100);
			arbeiter = marbeiter;
			break;
		}
		case SCHICHT: {
			SchichtArbeiter sarbeiter = new SchichtArbeiter(Integer.parseInt(it.next() + ""), it.next() + "",
					Double.parseDouble(it.next() + ""));
			sarbeiter.setAnzahlStunden(Integer.parseInt( it.next()+""));
			arbeiter = sarbeiter;

			break;
		}
		case FAHRER: {
			int id = Integer.parseInt(it.next()+"");
			String name = it.next() + "";
			double salary = Double.parseDouble(it.next()+"");
			int hours = Integer.parseInt( it.next()+"");
			String licence = it.next() + "";
			Fahrer farbeiter = new Fahrer(id, name, salary, licence);
			farbeiter.setAnzahlStunden(hours);
			arbeiter = farbeiter;

			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typ.getDisplayName());
		}

		return arbeiter;

	}
}

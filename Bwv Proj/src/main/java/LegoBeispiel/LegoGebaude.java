package LegoBeispiel;

import java.util.ArrayList;
import java.util.List;

public class LegoGebaude {
    private List<Legostein> einzelteile;
    private List<FertigBauteil> fertigteile;

    public LegoGebaude() {
        einzelteile = new ArrayList<>();
        fertigteile = new ArrayList<>();
    }

    public void addStein(Legostein teil) {
        einzelteile.add(teil);
    }

    public void addTeil(FertigBauteil teil) {
        fertigteile.add(teil);
    }

    public double calcPreis() {
        double gesamtPreis = 0;
        for (Legostein teil : einzelteile) {
            gesamtPreis += teil.getPreis();
        }
        for (FertigBauteil teil : fertigteile) {
            gesamtPreis += teil.calcPreis();
        }
        return gesamtPreis;
    }

    public Iterable<? extends FertigBauteil> getFertigteile() {
        return fertigteile;
    }
}

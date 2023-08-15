package LegoBeispiel;

import java.util.ArrayList;
import java.util.List;

public class FertigBauteil {
    private List<Legostein> teile;

    public FertigBauteil() {
        teile = new ArrayList<>();
    }

    public void addTeil(Legostein teil) {
        teile.add(teil);
    }

    public double calcPreis() {
        double gesamtPreis = 0;
        for (Legostein teil : teile) {
            gesamtPreis += teil.getPreis();
        }
        return gesamtPreis;
    }

    public Iterable<? extends Legostein> getTeile() {
        return teile;
    }
}

package LegoBeispiel;

import java.util.ArrayList;
import java.util.List;

public class LegoKomposition extends LegoBauteil{

    private List<LegoBauteil> teile = new ArrayList<>();

    @Override
    public double preis() {
        double preis = 0;
        for (LegoBauteil teil : teile) {
            preis += teil.preis();

        }return preis;

    }

    public void addTeil(LegoBauteil teil){
       teile.add(teil);

    

    }
}

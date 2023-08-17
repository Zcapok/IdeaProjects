package LegoBeispiel;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args){

        Legostein steinBlau4 = new Legostein("Blau",4 , 0.30);
        Legostein steinBlau2 = new Legostein("Blau",2 , 0.30);
        Legostein steinRot4 = new Legostein("Rot",4 , 0.30);
        Legostein steinRot2 = new Legostein("Blau",2 , 0.30);
        // Initiialisierung der Objekte Fertigbauteile
        FertigBauteil linkerFluegel = new FertigBauteil();
        linkerFluegel.addTeil(steinRot2);
        linkerFluegel.addTeil(steinBlau4);
        linkerFluegel.addTeil(steinRot4);
        linkerFluegel.addTeil(steinRot4);

        FertigBauteil rechterFluegel = new FertigBauteil();
        rechterFluegel.addTeil(steinRot4);
        rechterFluegel.addTeil(steinRot4);
        rechterFluegel.addTeil(steinRot4);
        rechterFluegel.addTeil(steinRot4);
        rechterFluegel.addTeil(steinRot2);
        rechterFluegel.addTeil(steinRot2);
        rechterFluegel.addTeil(steinRot2);
        rechterFluegel.addTeil(steinBlau2);
        rechterFluegel.addTeil(steinBlau2);
        rechterFluegel.addTeil(steinBlau4);
        rechterFluegel.addTeil(steinBlau4);
        // Initialisierung des Gebauedes
        // Das Gebaeude wird aus den Fertigbauteilen zusammengebaut
        LegoGebaude palast = new LegoGebaude();
        palast.addTeil(linkerFluegel);
        palast.addTeil(rechterFluegel);
        palast.addStein(steinBlau2);
        // Schleife durch alle Fertigbauteile -> Über dieses Fertigbauteil wird wieder ein Schleifendurchlauf gestartet
        // Aus dem einem Fertigbauteil werden die Informationen über Farbe Größe und Preis ausgegeben
        for (FertigBauteil fertigBauteil : palast.getFertigteile()) {
            for (Legostein teil : fertigBauteil.getTeile()) {
                System.out.println("Farbe: " + teil.getFarbe() + ", Größe: " + teil.getGroesse() + ", Preis: " + teil.getPreis());
            }
        }
        double price = palast.calcPreis();
// Preis wird Kaufmännisch aufgerundet
        BigDecimal bd = new BigDecimal(price);
        System.out.println(bd.setScale(2, RoundingMode.HALF_UP));
// Preis berechnung über das Compositum (Struktur)
        LegoKomposition preisListe = new LegoKomposition();

            preisListe.addTeil(steinBlau2);
            preisListe.addTeil(steinRot4);
        System.out.println("Preisliste aus Kompositum = " + preisListe.preis());

        preisListe.addTeil(steinRot2);
        preisListe.addTeil(steinBlau4);
        System.out.println(preisListe.preis());


    }




}

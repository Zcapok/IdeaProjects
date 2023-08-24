package DesignPattern.Observer;

import javax.swing.*;
import java.awt.*;

public class AktuelleBedingungen implements Observer{

    private WetterDaten aktuell;


    public AktuelleBedingungen(WetterDaten wetterDaten) {
        this.aktuell = wetterDaten;
        GuiMain gui = new GuiMain(aktuell.getTemperatur(),aktuell.getFeuchtigkeit(),aktuell.getLuftdruck());

    }


    @Override
    public void update(Object obj) {
      aktuell = (WetterDaten) obj;
            System.out.println("Aktuelle Bedingungen: Temperatur " + aktuell.getTemperatur() + "°C, Feuchtigkeit " + aktuell.getFeuchtigkeit() + "%, Luftdruck " + aktuell.getLuftdruck() + " hPa");

    }

    @Override
    public String toString() {
        return "AktuelleBedingungen{" +
                "aktuell=" + aktuell +
                '}';
    }
}

package DesignPattern.Observer;

import javax.swing.*;
import java.awt.*;

public class AktuelleBedingungen implements Observer{
    private JLabel displayLabel;
    private WetterDaten aktuell;


    public AktuelleBedingungen(WetterDaten wetterDaten) {
        this.aktuell = wetterDaten;
        GuiMain gui = new GuiMain(aktuell.getTemperatur(),aktuell.getFeuchtigkeit(),aktuell.getLuftdruck());

    }


    @Override
    public void update(Object obj) {
      aktuell = (WetterDaten) obj;
            System.out.println("Aktuelle Bedingungen: Temperatur " + aktuell.getTemperatur() + "°C, Feuchtigkeit " + aktuell.getFeuchtigkeit() + "%, Luftdruck " + aktuell.getLuftdruck() + " hPa");
            displayLabel.setText("Aktuelle Bedingungen: " + aktuell.getTemperatur() + "°C, " + aktuell.getFeuchtigkeit() + "% Luftfeuchtigkeit, " + aktuell.getLuftdruck() + " hPa Luftdruck");
    }

    @Override
    public String toString() {
        return "AktuelleBedingungen{" +
                "aktuell=" + aktuell +
                '}';
    }

    public void CurrentConditionsDisplay() {
        JFrame frame = new JFrame("Aktuelle Bedingungen");
        displayLabel = new JLabel("");
        frame.add(displayLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

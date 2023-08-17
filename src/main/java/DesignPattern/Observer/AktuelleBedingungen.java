package DesignPattern.Observer;

public class AktuelleBedingungen implements Observer{

    private WetterDaten aktuell;
    public AktuelleBedingungen(WetterDaten wetterDaten) {
        this.aktuell = wetterDaten;
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

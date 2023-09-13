package Playground;

public class WetterStationAachen implements Observer{

    private WetterDaten wetterDaten;

    public WetterStationAachen(WetterDaten daten){
        this.wetterDaten = daten;
        
    }

    @Override
    public void update() {
        System.out.println("Daten aus Aachen :\n" + "Temperatur = " + wetterDaten.getTemperatur() +"\n" + "Feuchtigkeit = " + wetterDaten.getFeuchtigkeit() + "\n" + "Luftdruck = " + wetterDaten.getLuftdruck() + "\n");
    }





}
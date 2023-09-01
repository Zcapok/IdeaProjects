package Playground;

public class WetterStationAachen implements Observer{

    private WetterDaten wetterDaten;

    public WetterStationAachen(WetterDaten daten){
        this.wetterDaten = daten;
        
    }

    @Override
    public void update() {
        System.out.println("Temperatur = " + wetterDaten.getTemperatur() + "Feuchtigkeit = " + wetterDaten.getFeuchtigkeit() + "Luftdruck = " + wetterDaten.getLuftdruck());
    }





}
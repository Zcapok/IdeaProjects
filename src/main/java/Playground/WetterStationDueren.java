package Playground;

public class WetterStationDueren implements Observer {
    
    private WetterDaten wetterDaten;

    public WetterStationDueren(WetterDaten daten){
        this.wetterDaten = daten;
    }

    @Override
    public void update() {
        System.out.println("Daten aus Düren :\n" + "Temperatur = " + wetterDaten.getTemperatur() +"\n" + "Feuchtigkeit = " + wetterDaten.getFeuchtigkeit() + "\n" + "Luftdruck = " + wetterDaten.getLuftdruck() + "\n");
    }

}

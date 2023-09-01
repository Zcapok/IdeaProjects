package Playground;

import java.util.Random;

public class Main_Wetter {

    public static void main(String[] args) {
        
        Random zM = new Random();

     WetterDaten daten = new WetterDaten(25, 60, 1000);
     WetterStationAachen aachen = new WetterStationAachen(daten);

     
     try {
        for (int i = 0; i < 5; i++) {
            int welcher = zM.nextInt(3);
            float wert = 0f;
            switch (welcher) {
                case 0:
                    daten.setTemperatur(daten.getTemperatur() + (zM.nextInt(8) - 4));
                    break;
                case 1:
                    wert = daten.getFeuchtigkeit() + zM.nextInt(40) - 20;
                    if (wert >= 0)
                        daten.setFeuchtigkeit(wert);
                    break;
                case 2:
                    wert = daten.getLuftdruck() + zM.nextInt(30) - 15;
                    if (wert >= 650)
                        daten.setLuftdruck(wert);
                    break;
            }
            System.out.println(daten + "\n");

            Thread.sleep(1000);
        }
        //wetterDaten.removeObserver(aktuell);
        daten.removeObserver(aachen);
        Thread.sleep(500);
        daten.setMesswerte(28, 16, 78);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    }
    
}

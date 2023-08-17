package DesignPattern.Observer;

public class WetterVorhersage implements Observer {

    private final AktuelleBedingungen aktuell;

    public WetterVorhersage(AktuelleBedingungen aktuell) {
        this.aktuell = aktuell;
    }

    @Override
    public void update(Object obs) {
        System.out.println("Wettervorhersage: ...");

    }

    @Override
    public String toString() {
        return "WetterVorhersage{" +
                "aktuell=" + aktuell +
                '}';
    }
}

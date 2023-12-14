package DesignPattern.StatePattern;

public class TuerAbgeschlossen extends Tuerstatus{

    @Override
    public void oeffnen(Tuer tuer) {
        tuer.setStatus(new TuerAbgeschlossen());
        System.out.println("Abgeschlossen");
    }

    @Override
    public void schliessen(Tuer tuer) {
        tuer.setStatus(new TuerAbgeschlossen()); 
        System.out.println("Abgeschlossen");
    }

    @Override
    public void abschliessen(Tuer tuer) {
        tuer.setStatus(new TuerAbgeschlossen());
        System.out.println("Tür ist schon abgeschlossen");
    }

    @Override
    public void aufschliessen(Tuer tuer) {
        tuer.setStatus(new TuerGeschlossen());
        System.out.println("Tür ist Geschlossen aber aufgeschlossen");
    }

}
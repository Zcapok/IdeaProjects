package DesignPattern.StatePattern;

public class TuerOffenAbgeschlossen extends Tuerstatus{

    @Override
    public void oeffnen(Tuer tuer) {
        tuer.setStatus(new TuerOffenAbgeschlossen());
        System.out.println("Tür ist schon offen Abgeschlossen");
    }

    @Override
    public void schliessen(Tuer tuer) {
        tuer.setStatus(new TuerOffenAbgeschlossen()); 
        System.out.println("Geht nicht !");
    }

    @Override
    public void abschliessen(Tuer tuer) {
        tuer.setStatus(new TuerOffenAbgeschlossen());
        System.out.println("Tür ist schon abgeschlossen");
    }

    @Override
    public void aufschliessen(Tuer tuer) {
        tuer.setStatus(new TuerOffenAufgeschlossen());
        System.out.println("Tür ist Geschlossen aber aufgeschlossen");
    }

    
}

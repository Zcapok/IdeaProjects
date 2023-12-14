package DesignPattern.StatePattern;

public class TuerOffenAufgeschlossen extends Tuerstatus {

    @Override
    public void oeffnen(Tuer tuer) {
        tuer.setStatus(new TuerOffenAufgeschlossen());
        System.out.println("Tür ist schon offen.");
    }

    @Override
    public void schliessen(Tuer tuer) {
        tuer.setStatus(new TuerGeschlossen()); 
        System.out.println("Tür wurde geschlossen.");
    }

    @Override
    public void abschliessen(Tuer tuer) {
        tuer.setStatus(new TuerOffenAbgeschlossen());
        System.out.println("Tür wurde offen abgeschlossen");
    }

    @Override
    public void aufschliessen(Tuer tuer) {
        tuer.setStatus(new TuerOffenAufgeschlossen());
        System.out.println("Tür ist schon offen aufgeschlossen");
    }
    
}

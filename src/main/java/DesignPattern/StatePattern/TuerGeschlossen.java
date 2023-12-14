package DesignPattern.StatePattern;

public class TuerGeschlossen extends Tuerstatus {

    @Override
    public void oeffnen(Tuer tuer) {
        tuer.setStatus(new TuerOffenAufgeschlossen());
        System.out.println("Tür steht offen aufgeschlossen.");
    }

    @Override
    public void schliessen(Tuer tuer) {
        tuer.setStatus(new TuerGeschlossen()); 
        System.out.println("Tür bleibt geschlossen.");
    }

    @Override
    public void abschliessen(Tuer tuer) {
        tuer.setStatus(new TuerAbgeschlossen());
        System.out.println("Tür wurde abgeschlossen.");
    }

    @Override
    public void aufschliessen(Tuer tuer) {
        tuer.setStatus(new TuerGeschlossen());
        System.out.println("Tür ist bereits aufgeschlossen.");
    }
    
}

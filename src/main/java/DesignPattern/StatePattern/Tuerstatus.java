package DesignPattern.StatePattern;
public abstract class Tuerstatus {
    
    public TuerOffenAbgeschlossen offenAbgeschlossen;
    public TuerGeschlossen geschlossen;
    public TuerAbgeschlossen abgeschlossen;
    public TuerOffenAufgeschlossen aufgeschlossen;

    public abstract void oeffnen(Tuer tuer);
    public abstract void schliessen(Tuer tuer);
    public abstract void abschliessen(Tuer tuer);
    public abstract void aufschliessen(Tuer tuer);

}

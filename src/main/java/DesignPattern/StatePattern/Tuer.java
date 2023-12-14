package DesignPattern.StatePattern;

public class Tuer{
    
    private Tuerstatus tuerstatus = new TuerGeschlossen();
    
    public void setStatus(Tuerstatus status){
        this.tuerstatus = status;
    }

    public Tuerstatus getStatus(){
        return this.tuerstatus;
    }

    public void oeffnen(){
        tuerstatus.oeffnen(this);
    }
    public void schliessen(){
        tuerstatus.schliessen(this);
    }
    public void abschliessen(){
        tuerstatus.abschliessen(this);
    }
    public void aufschliessen(){
        tuerstatus.aufschliessen(this);
    }
    

}

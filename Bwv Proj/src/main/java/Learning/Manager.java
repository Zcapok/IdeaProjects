package Learning;

public class Manager extends Bueroarbeiter {

    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(int id, String name, String vorname, int age, int gehalt, double bonus) {
        super(id, name, vorname, age, gehalt);
        setBonus(bonus);
    }
    
    public String toString(){
        return super.toString() + " Bonus: " + einkommensberechnung() * getBonus();
    }

    @Override
    public double einkommensberechnung() {
        return super.einkommensberechnung();
    }

}

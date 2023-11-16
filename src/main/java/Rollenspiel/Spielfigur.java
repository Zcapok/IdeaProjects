package Rollenspiel;

public abstract class Spielfigur {

    private Weaponbehavior currentweapon;

    public Weaponbehavior getCurrentweapon() {
        return currentweapon;
    }

    public void setCurrentweapon(Weaponbehavior currentweapon) {
        this.currentweapon = currentweapon;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    private int hp;

    public abstract void fight();

}

package Rollenspiel;

public abstract class Weaponbehavior {

    public final void useWeapon() {
        prepare();
        aim();
        strike();
    }

    public abstract void draw();

    public abstract void prepare();

    public abstract void aim();

    public abstract void strike();

    public abstract void holster();
}

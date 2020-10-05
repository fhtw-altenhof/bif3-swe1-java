package bif3.swe1.tdd.fighter;

public interface FighterInterface {
    Aim nextAim();

    int getVitality();
    void changeVitality(int change);
    boolean isDead();
}

package bif3.swe1.tdd.combat;

import bif3.swe1.tdd.fighter.Aim;
import bif3.swe1.tdd.fighter.FighterInterface;

import java.util.Optional;

public class BaseCombat implements CombatInterface {
    protected FighterInterface opponentA;
    protected FighterInterface opponentB;

    protected BaseCombat(FighterInterface opponentA, FighterInterface opponentB) {
        this.opponentA = opponentA;
        this.opponentB = opponentB;
    }

    @Override
    public void move(Aim aimA, Aim aimB) {
        if (aimA == Aim.ATTACK) {
            if (aimB == Aim.ATTACK) {
                opponentA.changeVitality(-1);
                opponentB.changeVitality(-1);
            } else if (aimB == Aim.DEFENSE) {
                opponentA.changeVitality(-2);
            } else { // REST
                opponentB.changeVitality(-2);
            }
        } else if (aimA == Aim.DEFENSE) {
            if (aimB == Aim.ATTACK) {
                opponentB.changeVitality(-2);
            } else if (aimB == Aim.DEFENSE) {
                opponentA.changeVitality(-1);
                opponentB.changeVitality(-1);
            } else { // REST
                opponentB.changeVitality(+1);
            }
        } else if (aimA == Aim.REST) {
            if (aimB == Aim.ATTACK) {
                opponentA.changeVitality(-2);
            } else if (aimB == Aim.DEFENSE) {
                opponentA.changeVitality(+1);
            } else { // REST
                opponentA.changeVitality(+1);
                opponentB.changeVitality(+1);
            }
        }
    }

    public boolean isFighting() {
        return !opponentA.isDead() && !opponentB.isDead();
    }

    public Optional<FighterInterface> getWinner() {
        if (opponentA.isDead() && opponentB.isDead())
            return Optional.empty();    // all are dead - no winner

        if (opponentA.isDead())
            return Optional.of(opponentB);
        if (opponentB.isDead())
            return Optional.of(opponentA);

        if (opponentA.getVitality() == opponentB.getVitality())
            return Optional.empty();    // both equal - still no winner
        return Optional.of((opponentA.getVitality() > opponentB.getVitality()) ? opponentA : opponentB);
    }

    public void printWinner() {
        Optional<FighterInterface> optWinner = getWinner();
        if (optWinner.isEmpty())
            System.out.println("There is no winner");
        else
            System.out.printf("The winner is %s \n", optWinner.get().getName());
    }
}

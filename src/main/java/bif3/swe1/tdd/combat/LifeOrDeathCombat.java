package bif3.swe1.tdd.combat;

import bif3.swe1.tdd.fighter.Aim;
import bif3.swe1.tdd.fighter.FighterInterface;

import java.util.Optional;

public class LifeOrDeathCombat extends BaseCombat {

    public LifeOrDeathCombat(FighterInterface opponentA, FighterInterface opponentB) {
        super(opponentA, opponentB);
    }

    public Optional<FighterInterface> fight() {
        System.out.printf("%s fights agains %s\n", opponentA.getName(), opponentB.getName());
        System.out.println("Let the fight begin!");
        int turn = 1;
        while (isFighting()) {
            Aim aimA = opponentA.nextAim();
            Aim aimB = opponentB.nextAim();
            System.out.printf("%d.turn: %s <---> %s  \n", turn++, aimA, aimB);

            move(aimA, aimB);
        }
        printWinner();
        return getWinner();
    }


}

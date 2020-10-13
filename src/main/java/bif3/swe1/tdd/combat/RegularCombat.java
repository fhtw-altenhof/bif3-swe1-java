package bif3.swe1.tdd.combat;

import bif3.swe1.tdd.fighter.Aim;
import bif3.swe1.tdd.fighter.FighterInterface;

import java.util.Optional;

public class RegularCombat extends BaseCombat {
    private int turns;

    public RegularCombat(FighterInterface opponentA, FighterInterface opponentB, int turns) {
        super(opponentA, opponentB);
        this.turns = turns;
    }

    public Optional<FighterInterface> fight() {
        if( turns < 1 )
            throw new IllegalArgumentException("Number of turns must be greater than 0!");

        System.out.printf("%s fights agains %s\n", opponentA.getName(), opponentB.getName());
        System.out.println("Let the fight begin!");
        for (int turn = 1; turn < turns && isFighting(); turn++) {
            Aim aimA = opponentA.nextAim();
            Aim aimB = opponentB.nextAim();
            System.out.printf("%d.turn: %s <---> %s  \n", turn, aimA, aimB);

            move(aimA, aimB);
        }
        printWinner();
        return getWinner();
    }


}

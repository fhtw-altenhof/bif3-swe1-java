package bif3.swe1.tdd;

import bif3.swe1.tdd.combat.BaseCombat;
import bif3.swe1.tdd.combat.LifeOrDeathCombat;
import bif3.swe1.tdd.combat.RegularCombat;
import bif3.swe1.tdd.fighter.*;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Luke luke = new Luke();
        DarthVader darthVader = new DarthVader();

        LifeOrDeathCombat combat1 = new LifeOrDeathCombat(luke, darthVader);
        combat1.fight();

        System.out.println("--------");

        Optional<FighterInterface> winner = combat1.getWinner();
        if (!winner.isEmpty()) {
            Yoda yoda = new Yoda();

            RegularCombat combat2 = new RegularCombat(yoda, winner.get(), 10);
            combat2.fight();
        }
    }
}

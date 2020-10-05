package bif3.swe1.tdd;

import bif3.swe1.tdd.combat.Combat;
import bif3.swe1.tdd.fighter.DarthVader;
import bif3.swe1.tdd.fighter.LightsaberFighter;
import bif3.swe1.tdd.fighter.Luke;
import bif3.swe1.tdd.fighter.Yoda;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Luke luke = new Luke();
        DarthVader darthVader = new DarthVader();

        Combat combat1 = new Combat(luke, darthVader);
        combat1.fightForLifeAndDeath();

        System.out.println("--------");

        Optional<LightsaberFighter> winner = combat1.getWinner();
        if( !winner.isEmpty() ) {
            Yoda yoda = new Yoda();

            Combat combat2 = new Combat(yoda, winner.get());
            combat2.limitedFight(10);
        }
    }
}

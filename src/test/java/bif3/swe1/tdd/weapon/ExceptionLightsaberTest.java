package bif3.swe1.tdd.weapon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionLightsaberTest {

    @Test
    void testSetBelongsTo_NullPointerException() {
        Lightsaber lightsaber = new Lightsaber();
        assertThrows(NullPointerException.class, () -> lightsaber.setBelongTo(null), "Should throw exception");

    }

}
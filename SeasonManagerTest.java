//test/net/sf/freecol/common/model/SeasonManagerTest.java
package net.sf.freecol.common.model;

import static org.junit.Assert.*;
import org.junit.Test;

import net.sf.freecol.util.test.FreeColTestCase;

// Unit tests for SeasonManager.
 
public class SeasonManagerTest extends FreeColTestCase {

    @Test
    public void testSeasonCycle() {
        SeasonManager manager = new SeasonManager(Season.SPRING, 1);

        assertEquals(Season.SPRING, manager.getCurrentSeason());
        manager.advanceTurn();
        assertEquals(Season.SUMMER, manager.getCurrentSeason());
        manager.advanceTurn();
        assertEquals(Season.AUTUMN, manager.getCurrentSeason());
        manager.advanceTurn();
        assertEquals(Season.WINTER, manager.getCurrentSeason());
        manager.advanceTurn();
        assertEquals(Season.SPRING, manager.getCurrentSeason());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTurnsPerSeasonThrows() {
        new SeasonManager(Season.SPRING, 0);
    }

    @Test
    public void testProductionMultiplierIsPositive() {
        SeasonManager manager = new SeasonManager(Season.SPRING, 10);
        double multiplier = manager.getProductionMultiplier();
        assertTrue(multiplier > 0.0);
    }
}

package net.sf.freecol.common.model;

import junit.framework.TestCase;

public class SeasonManagerTest extends TestCase {

    private SeasonManager manager;

    @Override
    protected void setUp() throws Exception {
        manager = new SeasonManager();
    }

    public void testInitialSeasonIsSpring() {
        assertEquals(SeasonManager.Season.SPRING, manager.getCurrentSeason());
    }

    public void testAdvanceSeason() {
        manager.advanceSeason();
        assertEquals(SeasonManager.Season.SUMMER, manager.getCurrentSeason());

        manager.advanceSeason();
        assertEquals(SeasonManager.Season.FALL, manager.getCurrentSeason());

        manager.advanceSeason();
        assertEquals(SeasonManager.Season.WINTER, manager.getCurrentSeason());

        manager.advanceSeason();
        assertEquals(SeasonManager.Season.SPRING, manager.getCurrentSeason());
    }

    public void testSeasonAffectsProduction() {
        int base = 10;

        int spring = manager.applySeasonalModifier(base, SeasonManager.Season.SPRING);
        int summer = manager.applySeasonalModifier(base, SeasonManager.Season.SUMMER);
        int fall   = manager.applySeasonalModifier(base, SeasonManager.Season.FALL);
        int winter = manager.applySeasonalModifier(base, SeasonManager.Season.WINTER);

        assertTrue(spring >= base);
        assertTrue(summer >= spring);
        assertTrue(fall <= base);
        assertTrue(winter < fall);
    }
}

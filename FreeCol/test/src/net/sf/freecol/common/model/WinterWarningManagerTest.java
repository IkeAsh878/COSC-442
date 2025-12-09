package net.sf.freecol.common.model;

import junit.framework.TestCase;

public class WinterWarningManagerTest extends TestCase {

    private WinterWarningManager manager;

    @Override
    protected void setUp() throws Exception {
        manager = new WinterWarningManager();
    }

    public void testWinterWarningTriggers() {
        boolean warn = manager.shouldShowWinterWarning(SeasonManager.Season.WINTER);
        assertTrue("Should warn at first winter", warn);
    }

    public void testWinterWarningOnlyOnce() {
        manager.shouldShowWinterWarning(SeasonManager.Season.WINTER);
        boolean warnAgain = manager.shouldShowWinterWarning(SeasonManager.Season.WINTER);
        assertFalse("Should NOT warn twice in same winter", warnAgain);
    }

    public void testWarningResetsNextSeason() {
        manager.shouldShowWinterWarning(SeasonManager.Season.WINTER);
        manager.resetWarningIfNeeded(SeasonManager.Season.SPRING);
        boolean warn = manager.shouldShowWinterWarning(SeasonManager.Season.WINTER);
        assertTrue("Warning should reset for next winter", warn);
    }
}

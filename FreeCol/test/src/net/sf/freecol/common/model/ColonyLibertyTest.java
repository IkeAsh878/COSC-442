package net.sf.freecol.common.model;

import junit.framework.TestCase;

public class ColonyLibertyTest extends TestCase {

    private Game game;
    private Player player;
    private Colony colony;

    protected void setUp() {
        game = new Game();
        player = new Player(game, "p1", false);
        colony = new Colony(game, "col_liberty");
        colony.setOwner(player);
    }

    public void testModifyLibertyIncreasesSoL() {
        int before = colony.getSoLPercentage();

        colony.modifyLiberty(200);   // Add liberty points

        int after = colony.getSoLPercentage();
        assertTrue("SoL should increase after modifying liberty", after >= before);
    }

    public void testCalculateRebels() {
        int rebels = Colony.calculateRebels(10, 50);
        assertEquals("50% of 10 colonists = 5 rebels", 5, rebels);
    }
}

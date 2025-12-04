package net.sf.freecol.common.model;

import junit.framework.TestCase;
import java.util.Collection;

public class ColonyWarningTest extends TestCase {

    private Game game;
    private Player player;
    private Colony colony;
    private GoodsType foodType;

    protected void setUp() {
        game = new Game();
        player = new Player(game, "p2", false);
        colony = new Colony(game, "col04");
        colony.setOwner(player);
        foodType = game.getSpecification().getPrimaryFoodType();
    }

    public void testFoodWarningWhenLow() {
        colony.addGoods(foodType, 1);
        Collection warnings = colony.getProductionWarnings(foodType);
        assertNotNull("Warnings list should not be null", warnings);
    }
}

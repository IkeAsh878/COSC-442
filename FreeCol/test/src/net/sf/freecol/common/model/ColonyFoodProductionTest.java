package net.sf.freecol.common.model;

import junit.framework.TestCase;

public class ColonyFoodProductionTest extends TestCase {

    private Game game;
    private Player player;
    private Colony colony;
    private GoodsType foodType;

    protected void setUp() throws Exception {
        game = new Game();
        player = new Player(game, "p3", false);
        colony = new Colony(game, "col_food");
        colony.setOwner(player);

        foodType = game.getSpecification().getPrimaryFoodType();
    }

    public void testFoodProductionNonNegative() {
        int prod = colony.getFoodProduction();
        assertTrue("Food production should be >= 0", prod >= 0);
    }

    public void testStarvationTurnsWhenLowFood() {
        colony.addGoods(foodType, 0);
        int turns = colony.getStarvationTurns();

        assertTrue("Starvation turns should be >= 0 or -1", turns >= -1);
    }
}

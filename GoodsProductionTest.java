//test/net/sf/freecol/common/model/GoodsProductionTest.java
package net.sf.freecol.common.model;

import static org.junit.Assert.*;
import org.junit.Test;

import net.sf.freecol.util.test.FreeColTestCase;


public class GoodsProductionTest extends FreeColTestCase {

    @Test
    public void testFoodDoesNotUnexpectedlyDrop() {
        Colony colony = TestHelpers.createTestColony();
        Game game = colony.getGame();

        GoodsType foodType = game.getSpecification()
            .getGoodsType("model.goods.food");

        int before = colony.getGoodsCount(foodType);

        colony.produceGoods();  

        int after = colony.getGoodsCount(foodType);

        assertTrue("Food stock should not unexpectedly drop",
                   after >= before);
    }
}

//test/net/sf/freecol/common/model/ColonyGrowthTest.java
package net.sf.freecol.common.model;

import static org.junit.Assert.*;
import org.junit.Test;

import net.sf.freecol.util.test.FreeColTestCase;

//Additional tests around colony growth behavior.
 
public class ColonyGrowthTest extends FreeColTestCase {

    @Test
    public void testColonyPopulationNeverNegative() {
        Colony colony = TestHelpers.createTestColony();

        colony.setFood(0);
        colony.updateGrowth(); 

        assertTrue("Colony unit count should not be negative",
                   colony.getUnitCount() >= 0);
    }
}

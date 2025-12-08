//test/net/sf/freecol/common/model/TestHelpers.java
package net.sf.freecol.common.model;

import net.sf.freecol.util.test.FreeColTestCase;

//Helper methods for creating basic test game objects.

public final class TestHelpers {

    private TestHelpers() {
        // utility class, do not instantiate
    }

    // Create a standard test game using the existing FreeCol test utilities. return a Game instance configured for tests
    
    public static Game createTestGame() {
        return FreeColTestCase.getStandardGame();
    }

    // Create a standard test colony using the existing FreeCol test utilities return a Colony instance configured for tests
    
    public static Colony createTestColony() {
        Game game = FreeColTestCase.getStandardGame();
        FreeColTestCase.setGame(game);
        FreeColTestCase base = new FreeColTestCase();
        return base.getStandardColony();
    }
}

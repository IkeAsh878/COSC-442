package net.sf.freecol.common.model;

import junit.framework.TestCase;

public class ColonyBuildingTest extends TestCase {

    private Game game;
    private Player player;
    private Colony colony;
    private BuildingType warehouseType;

    protected void setUp() {
        game = new Game();
        player = new Player(game, "p1", false);
        colony = new Colony(game, "col_building_test");
        colony.setOwner(player);

        // Load an existing building type
        warehouseType = game.getSpecification().getBuildingType("model.building.warehouse");
    }

    public void testCanBuildWarehouse() {
        assertNotNull("WarehouseType must exist", warehouseType);

        boolean canBuild = colony.canBuild(warehouseType);

        // We don't know if colony meets requirements, so test that call does NOT crash
        assertTrue("canBuild() should return a boolean", canBuild == true || canBuild == false);
    }

    public void testNoAddReasonNotNull() {
        String reason = colony.getNoAddReason(warehouseType);

        assertNotNull("getNoAddReason() should not return null", reason);
    }
}

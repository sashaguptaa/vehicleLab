package tests;

import vehicle.ChevroletBird;
import bcatest.BCATestScenario;

public class Group3_4BirdTester extends BCATestScenario {
    public int runTest() {
        ChevroletBird c1 = new ChevroletBird();

        // 1
        assertEquals(c1.getMileage(), 0, 0.1, "Mileage should be 0, not: " + c1.getMileage());
        // 2
        c1.drive(10);
        assertFalse(c1.checkWingsExtended(), "checkWingsExtended() should return false before driving");
        assertEquals(c1.getMileage(), 10, .1, "Mileage should be 10 after first drive.");
        // 3
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(251);}, "Driving 251 is beyond its max.");
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(-1);}, "cannot drive negative miles.");
        // 4
        double beforefly = c1.getMileage();
        c1.fly(5.5);
        assertEquals(c1.getMileage(), beforefly, 0.01, "Mileage should not change after fly");
        assertTrue(c1.checkWingsExtended(), "Wings should be extended (true) after fly");
        // 5
        assertThrows(IllegalArgumentException.class, () -> {c1.fly(-1);}, "Cannot fly negative miles");
        // 6
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(1 + c1.getRemainingRange());}, "Should not be able to drive more than it's remaining range");
        // 7 and 9
        c1.recharge();
        assertEquals(c1.getRemainingRange(), 250, 0.1, "recharge() should reset remaining range to 250");
        assertEquals(c1.getMaxRange(), 250, 0.1, "max range should be 250");
        // 8
        // come back to this
        // 10 
        assertFalse(c1.canDrive(251), "Cannot drive over max range, so should return false");
        // 24 and 25
        ChevroletBird c2 = new ChevroletBird();
        assertThrows(IllegalArgumentException.class, () -> {c2.fly(1 + c2.getRemainingRange());}, "Should not be able to fly more than it's remaining range");
        assertThrows(IllegalArgumentException.class, () -> {c2.fly(1 + c2.getMaxRange());}, "Should not be able to fly more than it's Max range");
        // 26 
        c1.fly(30);
        assertEquals(c2.getMileage(), 0, 0.1, "Odometer should not change after fly");
        assertEquals(c2.getRemainingRange(), c2.getMaxRange() - 30, 0.1, "Gas should go down by 30 after fly(30)");

        return getFailedCount();
    }
}

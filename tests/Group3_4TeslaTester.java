package tests;

import vehicle.TeslaModelZ;
import bcatest.BCATestScenario;

public class Group3_4TeslaTester extends BCATestScenario{
     public int runTest() {
         TeslaModelZ c1 = new TeslaModelZ();

         assertThrows(IllegalArgumentException.class, () -> {c1.drive(-1);}, "Driving mileage cannot be negative.");

         assertTrue(c1.canDrive(30), "canDrive should be true");
         c1.drive(30);
         assertEquals(c1.getMileage(), 30, .1, "Mileage should be 30 after first drive.");

         c1.drive(200);
         assertEquals(c1.getMileage(), 230, .1, "Mileage should be 230 after second drive.");

         assertEquals(c1.getRemainingRange(), c1.getFuelCapacity() * c1.getMPG() - 230, .1, "Remaining range of car not correct after driving twice.");

         assertFalse(c1.canDrive(252), "Driving 252 should fail.");
         assertTrue(c1.canDrive(251), "Driving 251 should succeed.");

         c1.drive(251);
         assertEquals(c1.getMileage(), 481, .1, "Mileage should be 481 after third drive.");

         assertThrows(IllegalArgumentException.class, () -> {c1.drive(5);}, "Driving beyond empty should fail.");


         return getFailedCount();

         // does this work
    }
}

public class Group3_4TeslaTester extends BCATestScenario{
    public int runTest() {
        TeslaModelZ c1 = new TeslaModelZ();

        // #13
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(-1);}, "Driving mileage cannot be negative.");
        // #14
        assertTrue(c1.canDrive(1), "canDrive should be true for positive values");
        // #15
        assertFalse(c1.canDrive(341), "Driving mileage should not be greater than 340 miles.")
        // #16
        c1.toString();
        // #17
        assertThrows(IllegalArgumentException.class, () -> {c1.driveAutonomously(-1);}

        assertEquals(c1.getMileage(), 30, .1, "Mileage should be 30 after first drive.");

        c1.drive(200);
        assertEquals(c1.getMileage(), 230, .1, "Mileage should be 230 after second drive.");

        assertEquals(c1.getRemainingRange(), c1.getFuelCapacity() * c1.getMPG() - 230, .1, "Remaining range of car not correct after driving twice.");

        assertFalse(c1.canDrive(252), "Driving 252 should fail.");
        assertTrue(c1.canDrive(251), "Driving 251 should succeed.");

        c1.drive(251);
        assertEquals(c1.getMileage(), 481, .1, "Mileage should be 481 after third drive.");

        assertThrows(IllegalArgumentException.class, () -> {c1.drive(5);}, "Driving beyond empty should fail.");


        return getFailedCount();

        // does this work
   }
}
package tests;

import vehicle.ElectricCar;
import vehicle.ChevroletBird;
import bcatest.BCATestScenario;

public class Group3_4BirdTester extends BCATestScenario {
    public int runTest() {
        ChevroletBird c1 = new ChevroletBird();

        return getFailedCount();
    }
}

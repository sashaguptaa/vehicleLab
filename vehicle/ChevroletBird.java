package vehicle;

public class ChevroletBird extends ElectricCar implements Flying {
    private boolean wingsExtended;

    /**
     * Chevrolet Birds have a 250 mile range on a full charge. They start with their
     * wings retracted.
     */
    public ChevroletBird(double startingMileage) {
        super("Chevrolet", "Bird", startingMileage, 250);
        wingsExtended = false;
    }

    /**
     * Defaults mileage to 0.
     */
    public ChevroletBird() {
        super("Chevrolet", "Bird", 250);
        wingsExtended = false;
    }

    /**
     * Returns whether the wings are currently extended.
     */

    public boolean checkWingsExtended() {
        return wingsExtended;
    }

    //Drives just like all other Electric Cars, except make sure that you retract your wings first

    @Override
    public void drive(double miles) {
        wingsExtended = false;
        super.drive(miles);
    }

    /**
     * returns true if wings are retracted and the car has enough charge to go that
     * amount of miles
     */

    @Override
    public boolean canFly(double miles) {

        if (miles < 0) {
            throw new IllegalArgumentException("Must be positive.");
        }

        if (canDrive(miles)) {
            return true;
        }
        return false; 

    }

    @Override
    public void fly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Must be positive.");
        } 
        
        else if (canDrive(miles) == false) {
            throw new IllegalArgumentException(String.format("You can only go %.2f miles on your current charge", getRemainingRange()));
        }

        decreaseCharge(miles); 
        wingsExtended = true;
       
    }
}

package vehicle;

public abstract class ElectricCar extends Car {
    private final double maxRange;
    private double range;

    //Note: Car begins with a full charge (and thus range). @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.

    private ElectricCar(String make, String model, double startingMileage, double milesOnMaxCharge) {
        
        super(make, model, startingMileage);

        if (milesOnMaxCharge <= 0) {
            throw new IllegalArgumentException("Must be positive.");
        }

        this.maxRange = milesOnMaxCharge;
        this.range = milesOnMaxCharge;
    }

    //Defaults mileage to 0. @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.

    private ElectricCar(String make, String model, double milesOnMaxCharge) {

        super(make, model);

        if (milesOnMaxCharge <= 0) {
            throw new IllegalArgumentException("Must be positive.");
        }

        this.maxRange = milesOnMaxCharge;
        this.range = milesOnMaxCharge;
    }

    // Drives the full given number of miles. @throws IllegalArgumentException if miles is negative. @throws IllegalArgumentException if miles is too high given the current charge.
    public void drive(double miles) {

        if (miles <= 0) {
            throw new IllegalArgumentException("Must be positive.");

        } 
        
        else if (!canDrive(miles)) {
            throw new IllegalArgumentException(String.format("You can only go with current " + "charge is %.2f miles", getRemainingRange()));
        }


        super.addMileage(miles);
        decreaseCharge(miles);
    }

    /**
     * Returns how many more miles the car can currently go without recharging.
     */
    public double getRemainingRange() {
        return range;
    }

    /**
     * Returns how many miles the car could go on a full charge.
     */
    public double getMaxRange() {
        return maxRange;

    }

    /**
     * Recharges the car to max range capability.
     */
    public void recharge() {
        range = maxRange;
    }

    /**
     * Decreases the amount of energy in the battery based by the number of miles
     * passed as an argument.
     *
     * @throws IllegalArgumentException if miles is negative or removing this many
     *                                  miles results in a negative battery capacity
     */
    protected void decreaseCharge(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("miles %.1f must be at least 0.", miles));
        } else if (miles > getRemainingRange()) {
            throw new IllegalArgumentException(String.format("Cannot remove %.1f miles from the charge while the " +
                    "capacity is at %.1f.", miles, getRemainingRange()));
        }
        range -= miles;
    }
}
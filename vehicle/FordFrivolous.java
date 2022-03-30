package vehicle;

public class FordFrivolous extends GasPoweredCar implements Flying{
    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */

    public FordFrivolous(double startingMileage){
        super("Ford", "Frivolous", startingMileage, 23.6, 20);  
    }

    /** Defaults mileage to 0. */
    public FordFrivolous(){
        super("Ford", "Frivolous", 0, 23.6, 20);  
    }

    public void driveAutonomously(double miles){
        if(miles < 0 || miles > getRemainingRange()){
            throw new IllegalArgumentException();
        }

        decreaseFuelLevel(miles * 2);
        super.addMileage(miles); 
    }

    public void fly(double miles){
        if(miles < 0 || miles > getRemainingRange()){
            throw new IllegalArgumentException();
        }
        decreaseFuelLevel(miles * 3);
    }

    public boolean canFly(double miles){
        if (miles < 0){
            throw new IllegalArgumentException(); 
        }
        if (miles <= getFuelLevel())
            return true; 
        
        return false; 
    }
}


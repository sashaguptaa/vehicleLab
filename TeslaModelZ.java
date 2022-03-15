package vehicle;

class TeslaModelZ extends ElectricCar{
    /** modelNum specifies the model number. Tesla cares about that
    stuff. Tesla Model Z’s have a 340 mile range on a full charge.
    For a Tesla, the make is Tesla. The model is Z. The model number is
    an additional value.
    */
    private int modelNum; 
    private double startingMileage; 
    public TeslaModelZ(double startingMileage, int modelNum){
        super("Tesla", "Z" + modelNum, startingMileage); 

        this.modelNum = modelNum; 
        this.startingMileage = startingMileage; 
    }

    /** Defaults mileage to 0. */
    public TeslaModelZ(int modelNum){
        super("Tesla", "Z" + modelNum, 0); 
        
        this.modelNum = modelNum; 
        this.startingMileage = 0; 
    }

    /** Returns the model number.*/
    public int getModelNum(){
        return modelNum; 
    }

    /** Returns the model and model number concatenated together. For
    example, returns "Z70" for modelNum 70. */
    public String getModel(){
        return "Z" + getModelNum(); 
    }

    /** Prints out the make, model, model number, and mileage.
    Ex: "Tesla Z70 (30.0 mi)"
    You may not need to implement this method depending on how you
    implement Car.toString()
    */
    public String toString(){
        return super.toString(); 
    }
}

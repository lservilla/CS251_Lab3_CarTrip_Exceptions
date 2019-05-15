
/**
 * @version date (CS_251_004, 2019-02-10)
 * @author Lasair Servilla
 */

/**
 * • The constructor should take a String for the license plate number
 * and a double for the fuel economy (miles traveled per gallon of fuel)
 * of the car. Cars should initially have zero gallons of fuel in the tank.
 * • Provide a getLicensePlate method to return the String
 * license plate identifier. (It should not be possible for the license plate
 * value to be changed once it has been set.)
 * • Provide a getFuelEconomy method to return the double fuel economy
 * (miles per gallon) value. (It should not be possible for the
 * fuel economy value to be changed once it has been set.)
 * • Provide a getFuelRemaining method to return the current amount
 * of fuel left in the tank. This value should be a double.
 * • Provide a getRange method to return the maximum distance that the car
 * could travel by multiplying the current fuel amount and the fuel economy.
 * • The class should have an addFuel methods that takes a double
 * amount of gallons and adds it to the current amount of fuel in the tank.
 * This method returns nothing.
 * • The class should have a drive method that takes a double amount
 * representing the number of miles to drive,
 * computes the amount of fuel needed to drive that distance and subtracts it
 * from the current amount of fuel in the tank. This method returns nothing.
 * If the distance to drive exceeds the current range of the car (i.e.,
 * if there is not enough fuel) then the amount of fuel should be set to zero
 * and an OutOfFuelException thrown with the shortfall amount of fuel passed
 * into the constructor as outlined above (this should be a positive value).
 */

public class Car {

    /** Name of the car license plate*/
    private final String licensePlate;

    /** Fuel economy for the car*/
    private final double fuelEconomy;

    /** The fuel that is left in the car*/
    private double fuelRemaining = 0 ;

    /**
     * Creating the car with a license plate and fuel economy. Fuel in tank
     * starts as 0.
     * @param licensePlate name of license plate
     * @param fuelEconomy fuel economy of car
     */
    public Car(String licensePlate, double fuelEconomy){
    this.licensePlate = licensePlate;
    this.fuelEconomy = fuelEconomy;
}

    /**
     * Get the license plate
     * @return license plate
     */
    public final String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Get the fuel economy
     * @return fuel economy
     */
    public final double getFuelEconomy() {
        return fuelEconomy;
    }

    /**
     * Adds fuel to the car
     * @param fuelToAdd to add fuel
     */
    public void addFuel(double fuelToAdd){

    fuelRemaining = fuelRemaining + fuelToAdd;
    }

    /**
     * Get remaining fuel
     * @return remaining fuel
     */
    public double getFuelRemaining() {
        return fuelRemaining;
    }

    /**
     * Get range, by multiplying fuel economy by fuel remaining
     * @return range
     */
    public double getRange(){

    double range = fuelRemaining * fuelEconomy;
    return range;
    }

    /**
     * Give the number of miles that you want to drive, you will either be able
     * to drive that far, or an exception will be thrown
     * @param milesToDrive input how far you would like to go, in miles
     * @throws OutOfFuelException if the car runs out of gas
     */
    public void drive(double milesToDrive)throws OutOfFuelException{

    if (milesToDrive <= getRange()){
        double fuelUsed = milesToDrive/fuelEconomy;
        fuelRemaining = fuelRemaining - fuelUsed;
    } else {
        double fuelNeeded = (milesToDrive - getRange()) / fuelEconomy;
        fuelRemaining=0;
        throw new OutOfFuelException(
                "You don't have enough fuel to travel that far.", fuelNeeded);


        }


    }
}


/**
 * This file tests your Car implementation to make sure it
 * throws an exception when it should.
 */
public class CarTest {

    /**
     * Print license plate number and remaing fuel in gallons for a given car.
     * @param c The car of interest.
     */
    private static void printCarInfo(Car c) {
        // Displaying only 2 places after decimal
        System.out.printf("Car %s --- fuel economy = %.2f mpg --- fuel remaining = %.2f gallons%n",
                c.getLicensePlate(), c.getFuelEconomy(), c.getFuelRemaining());
    }

    /**
     * Takes the initial fuel amount from command line and plays with a car.
     */
    public static void main(String[] args) {

        double fuelAmount = 25.00;
        if(args.length > 0) {
            try {
                fuelAmount = Double.parseDouble(args[0]);
            } catch (NumberFormatException ex) {
                // argument wasn't valid number, so stick with original value.
                System.out.println("Ignoring invalid argument: " +  args[0]);
            }
        }

        Car c1 = new Car("LWYRUP", 20.0);

        // Put some fuel in there!
        c1.addFuel(fuelAmount);
        printCarInfo(c1);

        // Make a second car to test for inappropriate sharing
        final double testAmount = 100;
        Car c2 = new Car("BMT 216A", 10.0); // should be able to do 1000 miles
        c2.addFuel(testAmount);

        if(!c1.getLicensePlate().equals("LWYRUP") || !c2.getLicensePlate().equals("BMT 216A")) {
            System.out.println("Something isn't right with the license plates!");
        }

        try {
            double distance = 175;
            for(int i = 1; i<=3; ++i) {
                System.out.printf("Try to drive car %s a distance of %.2f miles%n",
                        c1.getLicensePlate(), distance);
                c1.drive(distance);
                printCarInfo(c1);
            }
            System.out.println("Successfully completed the trip!");
            printCarInfo(c1);
        } catch (OutOfFuelException ex) {
            // get shortfall amount from exception and print message
            System.out.printf("Sorry, but you are short by %.2f gallons%n",
                    ex.getShortfall());

            // Print exception's message and stack trace on standard error.
            ex.printStackTrace();
        } finally {
            System.out.println("Done driving for now");
            printCarInfo(c1);
        }

        // Make sure messing with b1 didn't change b2 balance.
        // This shouldn't happen if you implemented BankAccount properly.
        if(c2.getFuelRemaining() != testAmount) {
            System.out.println("Unexpected change in second car!");
            printCarInfo(c2);
        }
    }
}

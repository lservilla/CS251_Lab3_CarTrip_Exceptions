
/**
 * @version date (CS_251_004, 2019-02-10)
 * @author Lasair Servilla
 */

/**
 * • This class should extend Exception,
 * since it is going to be a checked exception.
 * • The constructor should take the amount of the extra fuel needed
 * (as a double) and store it in a member variable.
 * • We want to see some sort of message like “You need more fuel!”
 * in the stack trace, so call a Exception constructor that takes
 * a message by using the super keyword at the beginning of your class’s
 * constructor and pass it an appropriate message string.
 * • The class should have a getShortfall method to access the amount given
 * in the constructor. This method should return a double.
 */

public class OutOfFuelException extends Exception {

    /** The gas that you're short for miles wanted to drive*/
    private double shortfall;


    /**
     * Creating the exception message and the fuel needed to travel the
     * remaining distance
     * @param message given message when the exception is thrown
     * @param shortfall fuel needed to travel remaining distance
     */
    public OutOfFuelException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;

    }

    /**
     * Get the short fall
     * @return short fall
     */
    public double getShortfall() {
        return shortfall;
    }
}

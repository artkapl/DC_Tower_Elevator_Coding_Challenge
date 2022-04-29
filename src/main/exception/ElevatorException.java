package main.exception;

/**
 * The custom Elevator main.exception which is used by several classes within this project.
 *
 * @author Arthur Kaplan
 */
public class ElevatorException extends Exception {

    /**
     * Instantiates a new Elevator main.exception.
     */
    public ElevatorException() {
    }

    /**
     * Instantiates a new Elevator main.exception.
     *
     * @param message the message
     */
    public ElevatorException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Elevator main.exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ElevatorException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Elevator main.exception.
     *
     * @param cause the cause
     */
    public ElevatorException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Elevator main.exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public ElevatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package elevator;

import exception.ElevatorException;
import request.Request;

/**
 * The interface Elevator.
 *
 * @author Arthur Kaplan
 */
public interface Elevator {

    /**
     * Calculates an artificial "delay time" in milliseconds that an elevator needs to reach its destination.
     *
     * @return the delay in ms
     */
    int calculateDelay();

    /**
     * Gets the elevator number.
     *
     * @return the elevator number (a number between 1 and 7)
     */
    int getElevatorNumber();

    /**
     * Sets the elevator number.
     *
     * @param elevatorNumber the elevator number
     */
    void setElevatorNumber(int elevatorNumber);

    /**
     * Gets the current floor.
     *
     * @return the current floor
     */
    int getCurrentFloor();

    /**
     * Sets the current floor.
     */
    void setCurrentFloor();

    /**
     * Gets the destination floor.
     *
     * @return the destination floor of the current request
     */
    int getDestinationFloor();

    /**
     * Sets the destination floor.
     *
     * An elevator can only travel between the ground floor and its destination without intermediate stops.
     *
     * @throws ElevatorException the elevator exception
     */
    void setDestinationFloor() throws ElevatorException;

    /**
     * Gets the request.
     *
     * @return the request
     */
    Request getRequest();

    /**
     * Sets the request.
     *
     * @param request the request
     */
    void setRequest(Request request);

    /**
     * The isAvailable boolean checks whether an elevator is currently free to use.
     *
     * @return true if an elevator is free to use
     */
    boolean isAvailable();

    /**
     * Sets whether an elevator is available to use.
     *
     * @param isAvailable a boolean that checks whether the elevator is currently in use
     */
    void setAvailable(boolean isAvailable);

}

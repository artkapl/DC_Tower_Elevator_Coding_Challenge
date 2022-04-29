package main.elevator;

import main.exception.ElevatorException;
import main.request.Request;

/**
 * The interface Elevator.
 *
 * @author Arthur Kaplan
 */
public interface Elevator {

    /**
     * Calculates an artificial "delay time" in milliseconds that an main.elevator needs to reach its destination.
     *
     * @return the delay in ms
     */
    int calculateDelay();

    /**
     * Gets the main.elevator number.
     *
     * @return the main.elevator number (a number between 1 and 7)
     */
    int getElevatorNumber();

    /**
     * Sets the main.elevator number.
     *
     * @param elevatorNumber the main.elevator number
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
     * @return the destination floor of the current main.request
     */
    int getDestinationFloor();

    /**
     * Sets the destination floor.
     *
     * An main.elevator can only travel between the ground floor and its destination without intermediate stops.
     *
     * @throws ElevatorException the main.elevator main.exception
     */
    void setDestinationFloor() throws ElevatorException;

    /**
     * Gets the main.request.
     *
     * @return the main.request
     */
    Request getRequest();

    /**
     * Sets the main.request.
     *
     * @param request the main.request
     */
    void setRequest(Request request);

    /**
     * The isAvailable boolean checks whether an main.elevator is currently free to use.
     *
     * @return true if an main.elevator is free to use
     */
    boolean isAvailable();

    /**
     * Sets whether an main.elevator is available to use.
     *
     * @param isAvailable a boolean that checks whether the main.elevator is currently in use
     */
    void setAvailable(boolean isAvailable);

}

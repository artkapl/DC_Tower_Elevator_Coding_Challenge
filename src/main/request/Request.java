package main.request;

import main.elevator.Direction;
import main.exception.ElevatorException;

/**
 * The type Request. A main.request consists of the current floor from which an main.elevator was requested, the intended destination and the direction the main.elevator needs to travel.
 *
 * @author Arthur Kaplan
 */
public class Request {

    private int currentRequestFloor;
    private int destinationRequestFloor;
    private final Direction direction;

    /**
     * Instantiates a new Request.
     *
     * @param currentRequestFloor     the current request floor
     * @param destinationRequestFloor the destination request floor
     * @param direction               the travel direction
     * @throws ElevatorException the elevator exception
     */
    public Request(int currentRequestFloor, int destinationRequestFloor, Direction direction) throws ElevatorException {
        setCurrentRequestFloor(currentRequestFloor);
        setDestinationRequestFloor(destinationRequestFloor);
        this.direction = direction;
    }

    /**
     * Gets the current floor
     * @return the current floor from this request
     */
    public int getCurrentRequestFloor() {
        return currentRequestFloor;
    }

    /**
     * Sets current floor.
     *
     * @param currentRequestFloor the current floor from this request
     * @throws ElevatorException the elevator exception
     */
    public void setCurrentRequestFloor(int currentRequestFloor) throws ElevatorException {
        if (currentRequestFloor < 0 || currentRequestFloor >= 55) {
            throw new ElevatorException("Not a valid floor number");
        } else {
            this.currentRequestFloor = currentRequestFloor;
        }
    }

    /**
     * Gets destination floor.
     *
     * @return the destination floor for this request
     */
    public int getDestinationRequestFloor() {
        return destinationRequestFloor;
    }

    /**
     * Sets destination floor.
     *
     * @param destinationRequestFloor the destination floor for this request
     * @throws ElevatorException the elevator exception
     */
    public void setDestinationRequestFloor(int destinationRequestFloor) throws ElevatorException {
        if (destinationRequestFloor < 0 || destinationRequestFloor >= 55) {
            throw new ElevatorException("Not a valid floor number");
        } else {
            this.destinationRequestFloor = destinationRequestFloor;
        }
    }

    /**
     * Gets the direction in which the elevator currently travels.
     *
     * @return the direction as a String object
     */
    public String getDirection() {
        return direction.toString();
    }

}

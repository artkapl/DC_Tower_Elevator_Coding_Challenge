package main.elevator;

import main.exception.ElevatorException;
import main.request.Request;

/**
 * The DC tower elevator class is an implementation of the Elevator interface.
 *
 * @author Arthur Kaplan
 */
public class DCTowerElevator implements main.elevator.Elevator {

    private int elevatorNumber;
    private int currentFloor;
    private int destinationFloor;
    private boolean isAvailable;
    private Request request;

    /**
     * Instantiates a new DC tower elevator.
     *
     * @param elevatorNumber the elevator number
     */
    public DCTowerElevator(int elevatorNumber) {
        this.elevatorNumber = elevatorNumber;
        this.currentFloor = 0;
        this.isAvailable = true;
    }

    /**
     * Calculates a delay time which an elevator needs to reach its destination.<br>
     * Arbitrarily set to the number of floors from the current floor to the destination multiplied by 0.5 seconds.
     *
     * @return the delay in milliseconds
     */
    @Override
    public int calculateDelay() {
        return Math.abs(request.getCurrentRequestFloor() - request.getDestinationRequestFloor()) * 500;
    }

    @Override
    public int getElevatorNumber() {
        return elevatorNumber;
    }

    @Override
    public void setElevatorNumber(int elevatorNumber) {
        this.elevatorNumber = elevatorNumber;
    }

    @Override
    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public void setCurrentFloor() {
        this.currentFloor = request.getDestinationRequestFloor();
    }

    @Override
    public int getDestinationFloor() {
        return request.getDestinationRequestFloor();
    }

    @Override
    public void setDestinationFloor() throws ElevatorException {
        if (destinationFloor < 0 || destinationFloor >= 55) {
            throw new ElevatorException("Not a valid destination floor");
        } else {
            this.destinationFloor = request.getDestinationRequestFloor();
        }
    }

    @Override
    public boolean isAvailable() {
        return this.isAvailable;
    }

    @Override
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public Request getRequest() {
        return request;
    }

    @Override
    public void setRequest(Request request) {
        this.request = request;
        this.currentFloor = request.getCurrentRequestFloor();
        this.destinationFloor = request.getDestinationRequestFloor();
    }

}

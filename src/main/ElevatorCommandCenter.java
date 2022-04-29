package main;

import main.elevator.Elevator;
import main.elevator.ElevatorList;
import main.exception.ElevatorException;
import main.request.Request;
import main.request.RequestList;

/**
 * The Elevator command center controls the entire main.elevator system in the building. It manages the elevators, the requests and utilizes multithreading.
 *
 * @author Arthur Kaplan
 */
public class ElevatorCommandCenter {

    private final ElevatorList elevatorList = new ElevatorList();
    private final RequestList requestList = new RequestList();

    /**
     * Adds a main.request to the list of Requests.
     *
     * @param request the main.request to be added
     * @throws ElevatorException the main.elevator main.exception which is thrown when the main.request cannot be added.
     */
    public void addRequest(Request request) throws ElevatorException {
        requestList.addRequestToList(request);
    }

    /**
     * This method calls the processRequests() method for as long as there are unfulfilled requests in the main.request list.<br>
     * Processing of requests starts after 1 second to ensure that the while loop is not exited before the main.request list can be filled.
     * It also has an inbuilt delay between each main.request.
     */
    public void start() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (requestList.containsRequest()) {
                processRequests();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    /**
     * Processes requests in a new Thread.
     * Depending on the main.request's starting floor, a different message is displayed on the command line.
     * After a main.request is completed, the main.elevator is no longer in use and can fulfill another main.request.
     */
    public void processRequests() {
        Thread thread = new Thread(() -> {
            if (!elevatorList.checkAvailableElevators().isEmpty() && requestList.containsRequest()) {
                Request request = requestList.getNextRequestAndRemoveFromList();
                Elevator elevator = elevatorList.getAvailableElevator(request);

                if (request.getDestinationRequestFloor() == 0) {
                    printMsgCurrentFloorIsNotZero(elevator);
                } else printMsgCurrentFloorIsZero(elevator);

                try {
                    Thread.sleep(elevator.calculateDelay());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                elevator.setCurrentFloor();
                printMsgRequestIsComplete(elevator);
                elevatorList.setElevatorAsAvailable(elevator);

            }
        });
        thread.start();

    }

    /**
     * This message is printed to the command line if the current floor if anything other than the ground floor.
     * @param elevator required to get the main.elevator's current floor, destination, and direction
     */
    private void printMsgCurrentFloorIsNotZero(Elevator elevator) {
        System.out.println("Aufzug "
                + elevator.getElevatorNumber()
                + ": Rückfahrt vom "
                + elevator.getCurrentFloor()
                + ". Stock ins Erdgeschoss: "
                + "[current floor: " + elevator.getCurrentFloor()
                + ", destination floor: "
                + elevator.getDestinationFloor()
                + ", direction: "
                + elevator.getRequest().getDirection()
                + "]");
    }

    /**
     * This message is printed to the command line if the main.elevator is currently on the ground floor.
     * @param elevator required to get the main.elevator's current floor, destination, and direction
     */
    private void printMsgCurrentFloorIsZero(Elevator elevator) {

        System.out.println("DC Tower Zutritt: Aufzug "
                + elevator.getElevatorNumber()
                + " fährt in den "
                + elevator.getDestinationFloor()
                + ". Stock: "
                + "[current floor: " + elevator.getCurrentFloor()
                + ", destination floor: "
                + elevator.getDestinationFloor()
                + ", direction: "
                + elevator.getRequest().getDirection()
                + "]");
    }

    /**
     * This message is printed when a main.request has been completed, i.e. when the main.elevator reaches its destination.
     * @param elevator required to get the main.elevator's number and current floor
     */
    private void printMsgRequestIsComplete(Elevator elevator) {
        System.out.println("Aufzug "
                + elevator.getElevatorNumber()
                + " ist im "
                + elevator.getCurrentFloor()
                + ". Stock und bereit für die nächste Fahrt.");
    }

}

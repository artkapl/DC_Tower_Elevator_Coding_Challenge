import elevator.Elevator;
import elevator.ElevatorList;
import exception.ElevatorException;
import request.Request;
import request.RequestList;

/**
 * The Elevator command center controls the entire elevator system in the building. It manages the elevators, the requests and utilizes multithreading.
 *
 * @author Arthur Kaplan
 */
public class ElevatorCommandCenter {

    private final ElevatorList elevatorList = new ElevatorList();
    private final RequestList requestList = new RequestList();

    /**
     * Adds a request to the list of Requests.
     *
     * @param request the request to be added
     * @throws ElevatorException the elevator exception which is thrown when the request cannot be added.
     */
    public void addRequest(Request request) throws ElevatorException {
        requestList.addRequestToList(request);
    }

    /**
     * This method calls the processRequests() method for as long as there are unfulfilled requests in the request list.<br>
     * Processing of requests starts after 1 second to ensure that the while loop is not exited before the request list can be filled.
     * It also has an inbuilt delay between each request.
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
     * Depending on the request's starting floor, a different message is displayed on the command line.
     * After a request is completed, the elevator is no longer in use and can fulfill another request.
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
     * @param elevator required to get the elevator's current floor, destination, and direction
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
     * This message is printed to the command line if the elevator is currently on the ground floor.
     * @param elevator required to get the elevator's current floor, destination, and direction
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
     * This message is printed when a request has been completed, i.e. when the elevator reaches its destination.
     * @param elevator required to get the elevator's number and current floor
     */
    private void printMsgRequestIsComplete(Elevator elevator) {
        System.out.println("Aufzug "
                + elevator.getElevatorNumber()
                + " ist im "
                + elevator.getCurrentFloor()
                + ". Stock und bereit für die nächste Fahrt.");
    }

}

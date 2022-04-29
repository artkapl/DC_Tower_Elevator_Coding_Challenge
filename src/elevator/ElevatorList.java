package elevator;

import request.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * This class encapsulates all seven elevators of the DC Tower.
 *
 * @author Arthur Kaplan
 */
public class ElevatorList {

    private final List<Elevator> elevators = new ArrayList<>();

    /**
     * This constructor fills a list of elevators.
     * @see Elevator
     */
    public ElevatorList() {
        Elevator elevator1 = new DCTowerElevator(1);
        Elevator elevator2 = new DCTowerElevator(2);
        Elevator elevator3 = new DCTowerElevator(3);
        Elevator elevator4 = new DCTowerElevator(4);
        Elevator elevator5 = new DCTowerElevator(5);
        Elevator elevator6 = new DCTowerElevator(6);
        Elevator elevator7 = new DCTowerElevator(7);

        elevators.add(elevator1);
        elevators.add(elevator2);
        elevators.add(elevator3);
        elevators.add(elevator4);
        elevators.add(elevator5);
        elevators.add(elevator6);
        elevators.add(elevator7);
    }

    public synchronized Elevator getAvailableElevator(Request request) {
        for (Elevator elevator : elevators) {
            if (elevator.isAvailable()) {
                elevator.setAvailable(false);
                elevator.setRequest(request);
                System.out.println("Aufzug " + elevator.getElevatorNumber() + " wird verwendet.");
                return elevator;
            }
        }
        return null;
    }

    public synchronized List<Elevator> checkAvailableElevators() {
        List<Elevator> availableElevators = new ArrayList<>();

        for (Elevator elevator : elevators) {
            if (elevator.isAvailable()) {
                availableElevators.add(elevator);
            }
        }
        return availableElevators;
    }

    public synchronized void setElevatorAsAvailable(Elevator elevator) {
        elevator.setAvailable(true);
    }

}

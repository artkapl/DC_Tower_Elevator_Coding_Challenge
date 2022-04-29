package test.elevator;

import main.elevator.Direction;
import main.elevator.Elevator;
import main.elevator.ElevatorList;
import main.exception.ElevatorException;
import main.request.Request;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorListTest {

    ElevatorList elevatorList = new ElevatorList();

    @Test
    void getAvailableElevator() throws ElevatorException {
        Request request = new Request(0, 44, Direction.UP);
        Elevator requestedElevator = elevatorList.getAvailableElevator(request);
        assertEquals(1, requestedElevator.getElevatorNumber());
        assertEquals(44, requestedElevator.getRequest().getDestinationRequestFloor());
    }

    @Test
    void checkAvailableElevators() {
        List<Elevator> availableElevators = elevatorList.checkAvailableElevators();
        assertEquals(7, availableElevators.size());
    }

}
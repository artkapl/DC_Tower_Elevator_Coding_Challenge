package test.elevator;

import main.elevator.DCTowerElevator;
import main.elevator.Elevator;
import main.exception.ElevatorException;
import main.request.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DCTowerElevatorTest {

    Elevator elevator = new DCTowerElevator(1);

    @BeforeEach
    void setUp() throws ElevatorException {
        elevator.setRequest(new Request(0, 15, main.elevator.Direction.UP));
    }

    @Test
    void calculateDelay() {
        Assertions.assertEquals(7500, elevator.calculateDelay());
    }

    @Test
    void getElevatorNumber() {
        Assertions.assertEquals(1, elevator.getElevatorNumber());
    }

    @Test
    void setElevatorNumber() {
        elevator.setElevatorNumber(999);
        Assertions.assertEquals(999, elevator.getElevatorNumber());
    }

    @Test
    void getCurrentFloor() {
        Assertions.assertEquals(0, elevator.getCurrentFloor());
    }

    @Test
    void setCurrentFloor() {
        elevator.setCurrentFloor();
        Assertions.assertEquals(15, elevator.getCurrentFloor());
    }

    @Test
    void getDestinationFloor() {
        Assertions.assertEquals(15, elevator.getDestinationFloor());
    }

    @Test
    void setDestinationFloor() throws ElevatorException {
        elevator.setDestinationFloor();
        Assertions.assertEquals(15, elevator.getDestinationFloor());
    }

    @Test
    void setDestinationFloorInvalidInput() throws ElevatorException {
        ElevatorException thrown = assertThrows(ElevatorException.class, () -> elevator.getRequest().setDestinationRequestFloor(99));
        assertEquals("Not a valid floor number", thrown.getMessage());
    }

    @Test
    void isAvailable() {
        Assertions.assertTrue(elevator.isAvailable());
    }

    @Test
    void setAvailable() {
        elevator.setAvailable(false);
        Assertions.assertFalse(elevator.isAvailable());
    }

    @Test
    void getRequest() {
        Assertions.assertEquals(main.elevator.Direction.UP.toString(), elevator.getRequest().getDirection());
    }

    @Test
    void setRequest() throws ElevatorException {
        elevator.setRequest(new Request(20, 0, main.elevator.Direction.DOWN));
        Assertions.assertEquals(20, elevator.getCurrentFloor());
    }
}
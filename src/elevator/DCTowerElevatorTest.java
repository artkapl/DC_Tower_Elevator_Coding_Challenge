package elevator;

import exception.ElevatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import request.Request;

import static org.junit.jupiter.api.Assertions.*;

class DCTowerElevatorTest {

    Elevator elevator = new DCTowerElevator(1);

    @BeforeEach
    void setUp() throws ElevatorException {
        elevator.setRequest(new Request(0, 15, Direction.UP));
    }

    @Test
    void calculateDelay() {
        assertEquals(7500, elevator.calculateDelay());
    }

    @Test
    void getElevatorNumber() {
        assertEquals(1, elevator.getElevatorNumber());
    }

    @Test
    void setElevatorNumber() {
        elevator.setElevatorNumber(999);
        assertEquals(999, elevator.getElevatorNumber());
    }

    @Test
    void getCurrentFloor() {
        assertEquals(0, elevator.getCurrentFloor());
    }

    @Test
    void setCurrentFloor() {
        elevator.setCurrentFloor();
        assertEquals(15, elevator.getCurrentFloor());
    }

    @Test
    void getDestinationFloor() {
        assertEquals(15, elevator.getDestinationFloor());
    }

    @Test
    void setDestinationFloor() throws ElevatorException {
        elevator.setDestinationFloor();
        assertEquals(15, elevator.getDestinationFloor());
    }

    @Test
    void setDestinationFloorInvalidInput() throws ElevatorException {
        ElevatorException thrown = assertThrows(ElevatorException.class, () -> elevator.getRequest().setDestinationRequestFloor(99));
        assertEquals("Not a valid floor number", thrown.getMessage());
    }

    @Test
    void isAvailable() {
        assertTrue(elevator.isAvailable());
    }

    @Test
    void setAvailable() {
        elevator.setAvailable(false);
        assertFalse(elevator.isAvailable());
    }

    @Test
    void getRequest() {
        assertEquals(Direction.UP.toString(), elevator.getRequest().getDirection());
    }

    @Test
    void setRequest() throws ElevatorException {
        elevator.setRequest(new Request(20, 0, Direction.DOWN));
        assertEquals(20, elevator.getCurrentFloor());
    }
}
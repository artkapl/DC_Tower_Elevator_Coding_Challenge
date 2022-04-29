package test.request;

import main.elevator.Direction;
import main.exception.ElevatorException;
import main.request.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {

    Request request = new Request(0, 30, Direction.UP);

    RequestTest() throws ElevatorException {
    }

    @Test
    void getCurrentRequestFloor() {
        assertEquals(0, request.getCurrentRequestFloor());
    }

    @Test
    void setCurrentRequestFloor() throws ElevatorException {
        request.setCurrentRequestFloor(11);
        assertEquals(11, request.getCurrentRequestFloor());
    }

    @Test
    void getDestinationRequestFloor() {
        assertEquals(30, request.getDestinationRequestFloor());
    }

    @Test
    void setDestinationRequestFloor() throws ElevatorException {
        request.setDestinationRequestFloor(44);
        assertEquals(44, request.getDestinationRequestFloor());
    }

    @Test
    void getDirection() {
        assertEquals(Direction.UP.toString(), request.getDirection());
    }
}
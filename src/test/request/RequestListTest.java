package test.request;

import main.request.RequestList;
import main.request.Request;
import main.elevator.Direction;
import main.exception.ElevatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class RequestListTest {

    private final RequestList requests = new RequestList();

    @BeforeEach
    void setUp() throws ElevatorException {
        requests.addRequestToList(new Request(0, 35, Direction.UP));
        requests.addRequestToList(new Request(0, 10, Direction.UP));
        requests.addRequestToList(new Request(7, 0, Direction.DOWN));
        requests.addRequestToList(new Request(20, 0, Direction.DOWN));
        requests.addRequestToList(new Request(0, 10, Direction.UP));
    }

    @Test
    void getNextRequestAndRemoveFromList() {
        assertEquals(5, requests.getRequests().size());
        Request removedRequest = requests.getNextRequestAndRemoveFromList();
        assertEquals(35, removedRequest.getDestinationRequestFloor());
        assertEquals(4, requests.getRequests().size());
    }

    @Test
    void containsRequest() {
        assertTrue(requests.containsRequest());
    }
}
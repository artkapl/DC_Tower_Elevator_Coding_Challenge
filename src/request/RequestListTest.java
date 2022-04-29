package request;

import elevator.Direction;
import exception.ElevatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


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
package request;

import exception.ElevatorException;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type Request list.
 *
 * @author Arthur Kaplan
 */
public class RequestList {

    private final Queue<Request> requests = new LinkedList<>();

    /**
     * Gets a list of requests. {@code Queue} was chosen for its use of "First In First Out", as this is ideal for processing request priority.
     *
     * @return the requests
     */
    public Queue<Request> getRequests() {
        return requests;
    }

    /**
     * Add a request to the list.
     *
     * @param request the request to be added
     * @throws ElevatorException the elevator exception
     */
    public synchronized void addRequestToList(Request request) throws ElevatorException {
        if (requests.contains(request)) {
            throw new ElevatorException("Request is already being processed");
        } else {
            requests.add(request);
        }
    }

    /**
     * Gets the next request and removes it from the list.
     *
     * @return the next request and remove from list
     */
    public synchronized Request getNextRequestAndRemoveFromList() {
        return requests.poll();
    }

    /**
     * Checks whether the request list contains a request
     *
     * @return the boolean
     */
    public synchronized boolean containsRequest() {
        return !requests.isEmpty();
    }

}

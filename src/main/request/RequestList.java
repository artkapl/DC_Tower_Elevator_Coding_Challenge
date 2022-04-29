package main.request;

import main.exception.ElevatorException;

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
     * Gets a list of requests. {@code Queue} was chosen for its use of "First In First Out", as this is ideal for processing main.request priority.
     *
     * @return the requests
     */
    public Queue<Request> getRequests() {
        return requests;
    }

    /**
     * Add a main.request to the list.
     *
     * @param request the main.request to be added
     * @throws ElevatorException the main.elevator main.exception
     */
    public synchronized void addRequestToList(Request request) throws ElevatorException {
        if (requests.contains(request)) {
            throw new ElevatorException("Request is already being processed");
        } else {
            requests.add(request);
        }
    }

    /**
     * Gets the next main.request and removes it from the list.
     *
     * @return the next main.request and remove from list
     */
    public synchronized Request getNextRequestAndRemoveFromList() {
        return requests.poll();
    }

    /**
     * Checks whether the main.request list contains a main.request
     *
     * @return the boolean
     */
    public synchronized boolean containsRequest() {
        return !requests.isEmpty();
    }

}

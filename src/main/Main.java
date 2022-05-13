package main;

import main.elevator.Direction;
import main.exception.ElevatorException;
import main.request.Request;

/**
 * The main.Main class is used to start the application and simulates a number of requests for the elevators in the building to process.
 *
 * Note: Command line print statements are written in German for the purpose of this Coding Challenge.
 *
 * @author Arthur Kaplan
 */
public class Main {

    /**
     * The entry point of application which also functions as the testing area for the elevator management system.
     *
     * @param args the input arguments
     * @throws ElevatorException the elevator exception
     */
    public static void main(String[] args) throws ElevatorException {

        System.out.println("Herzlich willkommen im DC Tower Aufzugkontrollsystem!");
        System.out.println("------------------------");

        ElevatorCommandCenter commandCenter = new ElevatorCommandCenter();
        commandCenter.start();

        commandCenter.addRequest(new Request(0, 35, Direction.UP));
        commandCenter.addRequest(new Request(0, 27, Direction.UP));
        commandCenter.addRequest(new Request(0, 42, Direction.UP));
        commandCenter.addRequest(new Request(0, 2, Direction.UP));
        commandCenter.addRequest(new Request(0, 35, Direction.UP));
        commandCenter.addRequest(new Request(0, 35, Direction.UP));
        commandCenter.addRequest(new Request(0, 50, Direction.UP));
        commandCenter.addRequest(new Request(35, 0, Direction.DOWN));
        commandCenter.addRequest(new Request(4, 0, Direction.DOWN));
        commandCenter.addRequest(new Request(30, 0, Direction.DOWN));
        commandCenter.addRequest(new Request(0, 35, Direction.UP));
        commandCenter.addRequest(new Request(35, 0, Direction.DOWN));
        commandCenter.addRequest(new Request(13, 0, Direction.UP));
        commandCenter.addRequest(new Request(0, 27, Direction.UP));
        commandCenter.addRequest(new Request(0, 35, Direction.UP));
        commandCenter.addRequest(new Request(0, 2, Direction.UP));
        commandCenter.addRequest(new Request(35, 0, Direction.DOWN));
        commandCenter.addRequest(new Request(35, 0, Direction.DOWN));
    }
}

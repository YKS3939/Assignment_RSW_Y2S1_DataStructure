package tarc.assignment.core;

import tarc.assignment.control.*;

import java.util.Scanner;

public class App {
    private final ConsoleInput input;
    private final GuestController guestController;
    private final ReservationController reservationController;
    private final RoomController roomController;
    private final CheckInController checkInController;
    private final TaskController taskController;
    private final CheckOutController checkOutController;
    private final Database database;

    private final Boot boot=new Boot();

    public App(Database database){
        Scanner scanner=new Scanner(System.in);
        input = new ConsoleInput(scanner);
        this.database=database;

        guestController=new GuestController(database);
        reservationController=new ReservationController(database);
        roomController=new RoomController(database);
        checkInController=new CheckInController(database);
        taskController=new TaskController(database);
        checkOutController=new CheckOutController(database);
    }

    public ConsoleInput input(){
        return input;
    }

    //Controller
    public GuestController guestController(){
        return guestController;
    }

    public ReservationController reservationController(){
        return reservationController;
    }

    public RoomController roomController(){return roomController;}

    public CheckInController checkInController(){return checkInController;}

    public TaskController taskController(){return taskController;}

    public CheckOutController checkOutController(){return checkOutController;}

    public Database database(){return database;}


}

package tarc.assignment.core;

import tarc.assignment.control.*;

import java.util.Scanner;

public class App {
    private final ConsoleInput input;
    private final GuestController guestController;
    private final ReservationController reservationController;
    private final RoomController roomController;
    private final CheckInController checkInController;
    private final HousekeepingController housekeepingController;
    private final Database database;

    public App(Database database){
        Scanner scanner=new Scanner(System.in);
        input = new ConsoleInput(scanner);
        this.database=database;

        guestController=new GuestController(database);
        reservationController=new ReservationController(database);
        roomController=new RoomController(database);
        housekeepingController=new HousekeepingController(database,roomController);
        checkInController=new CheckInController(database,roomController);
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

    public HousekeepingController housekeepingController(){return housekeepingController;}

    public Database database(){return database;}


}

package tarc.assignment.core;

import tarc.assignment.control.GuestController;
import tarc.assignment.control.ReservationController;

import java.util.Scanner;

public class App {
    private final ConsoleInput input;
    private final GuestController guestController;
    private final ReservationController reservationController;
    private final Database database;

    public App(Database database){
        Scanner scanner=new Scanner(System.in);
        input = new ConsoleInput(scanner);
        this.database=database;
        guestController=new GuestController(database());
        reservationController=new ReservationController(database());
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

    public Database database(){return database;}


}

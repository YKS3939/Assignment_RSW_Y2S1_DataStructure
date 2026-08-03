package tarc.assignment.core;

import tarc.assignment.control.GuestController;

import java.util.Scanner;

public class App {
    private final ConsoleInput input;
    private final GuestController guestController;
    private final Database database;

    public App(Database database){
        Scanner scanner=new Scanner(System.in);
        input = new ConsoleInput(scanner);
        this.database=database;
        guestController=new GuestController(database());
    }

    public ConsoleInput input(){
        return input;
    }

    public GuestController guestController(){
        return guestController;
    }

    public Database database(){return database;}


}

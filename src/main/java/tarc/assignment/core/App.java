package tarc.assignment.core;

import tarc.assignment.control.GuestController;
import tarc.assignment.util.Environment;

import java.util.Scanner;

public class App {
    private final ConsoleInput input;
    private final GuestController guestController;

    public App(){
        Scanner scanner=new Scanner(System.in);
        input = new ConsoleInput(scanner);
        guestController=new GuestController();
    }

    public ConsoleInput input(){
        return input;
    }

    public GuestController guestController(){
        return guestController;
    }
}

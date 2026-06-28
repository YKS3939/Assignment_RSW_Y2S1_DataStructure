package tarc.assignment.boundary.standardbooking;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class StandardBookingUI implements UI {
    private final App app;

    public StandardBookingUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.clear();
            ConsolePrint.menu("Walk-In Registrations & Standard Booking","1. Register Guest","2. View waiting queue","3. Assign the room to next guest","0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
        }while (choice != 0);
    }
}

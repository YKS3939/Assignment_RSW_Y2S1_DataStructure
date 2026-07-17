package tarc.assignment.boundary.standardbooking;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

//ZHUN ONN
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
            ConsolePrint.menu("Walk-In Registrations & Standard Booking","1. Register Guest","2. Assign Room to Next Guest","3. View Current Waiting List","4. Reports","0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
        }while (choice != 0);
    }
}

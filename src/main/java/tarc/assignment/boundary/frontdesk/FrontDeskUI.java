package tarc.assignment.boundary.frontdesk;

import tarc.assignment.boundary.frontdesk.customer.CustomerUI;
import tarc.assignment.boundary.frontdesk.customer.registerUI;
import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.entity.Reservation;
import tarc.assignment.util.ConsolePrint;

//WEN TING
public class FrontDeskUI implements UI {
    private final App app;
//    private final CheckInUI checkInUI;
    private final ReservationUI reservationUI;

    public FrontDeskUI(App app){
        this.app=app;
        this.reservationUI=new ReservationUI(this.app);
//        this.checkInUI=new CheckInUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.clear();
            ConsolePrint.menu("Front-Desk Management",
                    "1. Reservation",
                    "2. Check-In",
                    "3. Check-out & Billing",
                    "0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1->reservationUI.run();
                case 0->{return;}
                default -> {
                    ConsolePrint.error("Invalid choice! Press [ENTER] key to continue....");
                    app.input().pressAnyKey();
                }
            }
        }while (choice != 0);
    }
}



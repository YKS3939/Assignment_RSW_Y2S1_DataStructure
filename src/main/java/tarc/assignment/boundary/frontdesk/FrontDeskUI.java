package tarc.assignment.boundary.frontdesk;

import tarc.assignment.boundary.room.ViewAllRoomUI;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.util.ConsolePrint;

public class FrontDeskUI implements UI {
    private final App app;
    private final CheckInUI checkInUI;
    private final ReservationUI reservationUI;
    private final ViewAllRoomUI viewAllRoomUI;
    private final CheckOutUI checkOutUI;

    public FrontDeskUI(App app){
        this.app=app;
        this.reservationUI=new ReservationUI(this.app);
        this.checkInUI=new CheckInUI(this.app);
        this.viewAllRoomUI=new ViewAllRoomUI(this.app);
        this.checkOutUI=new CheckOutUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.clear();
            ConsolePrint.menu("Front-Desk Management","1. Reservation","2. Check-In","3. Check-out & Billing","4. View all room","0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1->reservationUI.run();
                case 2->checkInUI.run();
                case 3->checkOutUI.run();
                case 4->viewAllRoomUI.run();
                case 0->{return;}
                default -> {
                    ConsolePrint.error("Invalid choice! Press [ENTER] key to continue....");
                    app.input().pressAnyKey();
                }
            }
        }while (choice != 0);
    }
}



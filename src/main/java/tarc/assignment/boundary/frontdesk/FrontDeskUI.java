package tarc.assignment.boundary.frontdesk;

import tarc.assignment.boundary.frontdesk.customer.CustomerUI;
import tarc.assignment.boundary.frontdesk.customer.registerUI;
import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

//WEN TING
public class FrontDeskUI implements UI {
    private final App app;
//    private final checkinUI checkinUI;
//    private final checkoutUI checkoutUI;
//    private final CustomerUI customerUI;
//    private final viewRoomUI viewRoomUI;

    public FrontDeskUI(App app){
        this.app=app;
//        this.checkinUI=new checkinUI(this.app);
//        this.checkoutUI=new checkoutUI(this.app);
//        this.customerUI=new CustomerUI(this.app);
//        this.viewRoomUI=new viewRoomUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.menu("Front-Desk Management",
                    "1. Reservation",
                    "2. Check-In",
                    "3. Check-out & Billing",
                    "4. ",
                    "0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
            switch (choice){

                case 0->{return;}

                default -> {
                    ConsolePrint.error("Invalid choice! Press [ENTER] key to continue....");
                    app.input().pressAnyKey();
                }
            }
        }while (choice != 0);
    }
}



package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

//WEN TING
public class FrontDeskUI implements UI {
    private final App app;
    private final checkinUI checkinUI;
    private final checkoutUI checkoutUI;
    private final registerUI registerUI;
    private final viewRoomUI viewRoomUI;

    public FrontDeskUI(App app){
        this.app=app;
        this.checkinUI=new checkinUI(this.app);
        this.checkoutUI=new checkoutUI(this.app);
        this.registerUI=new registerUI(this.app);
        this.viewRoomUI=new viewRoomUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.menu("Front-Desk",
         "1. Check In",
                    "2. Register New Customer",
                    "3. CheckOut",
                    "4. Check Room Status",
                    "5. Report",
                    "0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1->this.checkinUI.run();
                case 2->this.registerUI.run();
                case 3->this.checkoutUI.run();
                case 4->this.viewRoomUI.run();
                case 0->{return;}

                default -> {
                    ConsolePrint.error("Invalid choice! Press [ENTER] key to continue....");
                    app.input().pressAnyKey();
                }
            }
        }while (choice != 0);
    }
}



package tarc.assignment.boundary.guest;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class GuestManagementUI implements UI {
    private final App app;
    private final String userID;
    private final GuestProfileUI guestProfileUI;

    public GuestManagementUI(App app, String userID){
        this.app=app;
        this.userID=userID;
        guestProfileUI=new GuestProfileUI(app,userID);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.clear();
            ConsolePrint.menu("Guest Management","1. My profile","2. Edit My profile","0. LogOut");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1->guestProfileUI.run();
                case 0 -> {return;}
                default -> {
                    app.input().pressAnyKey("Invalid choice! Press [ENTER] key to continue....",app.input().ERROR);
                }
            }
        }while (choice != 0);

    }
}

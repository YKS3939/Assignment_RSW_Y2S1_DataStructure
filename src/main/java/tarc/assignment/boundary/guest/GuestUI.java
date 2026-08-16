package tarc.assignment.boundary.guest;

import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.util.ConsolePrint;

public class GuestUI implements UI {
    private final App app;
    private final RegisterGuestUI registerGuestUI;
    private final LoginGuestUI loginGuestUI;

    public GuestUI(App app){
        this.app=app;
        this.registerGuestUI=new RegisterGuestUI(this.app);
        this.loginGuestUI=new LoginGuestUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.clear();
            ConsolePrint.menu("Guest",
                    "1. Login",
                    "2. Register a new account",
                    "0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1->loginGuestUI.run();
                case 2 -> registerGuestUI.run();
                case 0 -> {return;}
                default -> {
                    app.input().pressAnyKey("Invalid choice! Press [ENTER] key to continue....",app.input().ERROR);
                }
            }
        }while (choice != 0);
    }
}

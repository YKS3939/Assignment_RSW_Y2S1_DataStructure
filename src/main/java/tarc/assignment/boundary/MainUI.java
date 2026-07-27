package tarc.assignment.boundary;

import tarc.assignment.boundary.frontdesk.FrontDeskUI;
import tarc.assignment.boundary.guest.GuestUI;
import tarc.assignment.boundary.housekeeping.HousekeepingUI;
import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.Environment;


public class MainUI implements UI {
    private final App app;
    private final HousekeepingUI housekeepingUI;
    private final FrontDeskUI frontDeskUI;
    private final GuestUI guestUI;

    public MainUI(App app){
        this.app=app;
        this.housekeepingUI=new HousekeepingUI(this.app);
        this.frontDeskUI=new FrontDeskUI(this.app);
        this.guestUI=new GuestUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.clear();
            ConsolePrint.menu(Environment.get("app.name"),"1. FrontDesk Staff","2. HouseKeeping Staff","3. Guest","0. Exit Program");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1 -> frontDeskUI.run();
                case 2 -> housekeepingUI.run();
                case 3 -> guestUI.run();
                case 0 -> ConsolePrint.success("BYEBYE");
                default -> {
                    app.input().pressAnyKey("Invalid choice! Press [ENTER] key to continue....",app.input().ERROR);
                }
            }
        }while (choice != 0);

    }
}

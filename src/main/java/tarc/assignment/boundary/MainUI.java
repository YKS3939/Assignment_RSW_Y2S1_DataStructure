package tarc.assignment.boundary;

import tarc.assignment.boundary.frontdesk.FrontDeskUI;
import tarc.assignment.boundary.housekeeping.HousekeepingUI;
import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.Environment;


public class MainUI implements UI {
    private final App app;
    private final HousekeepingUI housekeepingUI;
    private final FrontDeskUI frontDeskUI;

    public MainUI(App app){
        this.app=app;
        this.housekeepingUI=new HousekeepingUI(this.app);
        this.frontDeskUI=new FrontDeskUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.clear();
            ConsolePrint.menu(Environment.get("app.name"),"1. FrontDesk Staff","2. HouseKeeping Staff","0. Exit Program");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1 -> frontDeskUI.run();
                case 2 -> housekeepingUI.run();
                case 0 -> ConsolePrint.success("BYEBYE");
                default -> {
                    ConsolePrint.error("Invalid choice! Press [ENTER] key to continue....");
                    app.input().pressAnyKey();
                }
            }
        }while (choice != 0);

    }
}

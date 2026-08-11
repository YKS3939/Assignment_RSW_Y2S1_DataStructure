package tarc.assignment.boundary.housekeeping;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class HousekeepingUI implements UI {
    private final App app;
    public HousekeepingUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        int choice;
        do {
            ConsolePrint.clear();
            ConsolePrint.menu("HouseKeeping","1. Update room status","2. Revert room ","0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
        }while (choice != 0);
    }
}

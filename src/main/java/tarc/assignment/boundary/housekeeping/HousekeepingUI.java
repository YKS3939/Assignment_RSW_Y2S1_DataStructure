package tarc.assignment.boundary.housekeeping;

import tarc.assignment.boundary.room.ViewAllRoomUI;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.util.ConsolePrint;

public class HousekeepingUI implements UI {
    private final App app;
    private final ViewAllRoomUI viewAllRoomUI;
    private final HousekeepingProcessUI housekeepingProcessUI;
    private final RevertTaskProgressUI revertTaskProgressUI;

    public HousekeepingUI(App app){
        this.app=app;
        this.viewAllRoomUI=new ViewAllRoomUI(this.app);
        this.housekeepingProcessUI=new HousekeepingProcessUI(this.app);
        this.revertTaskProgressUI=new RevertTaskProgressUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do {
            ConsolePrint.clear();
            ConsolePrint.menu("HouseKeeping","1. View all room","2. Update room cleaning status","3. Revert last changes","0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1->viewAllRoomUI.run();
                case 2->housekeepingProcessUI.run();
                case 3->revertTaskProgressUI.run();
//                case 4->viewAllRoomUI.run();
                case 0->{return;}
                default -> {
                    ConsolePrint.error("Invalid choice! Press [ENTER] key to continue....");
                    app.input().pressAnyKey();
                }
            }
        }while (choice != 0);
    }
}

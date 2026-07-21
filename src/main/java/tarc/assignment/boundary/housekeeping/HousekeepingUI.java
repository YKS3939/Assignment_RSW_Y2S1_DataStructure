package tarc.assignment.boundary.housekeeping;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class HousekeepingUI implements UI {
    private final App app;
    private final cleaningLogUI cleaningLogUI;
    private final revertStatusUI revertStatusUI;
    private final roomStatusUI roomStatusUI;
    private final updateStatusUI updateStatusUI;

    public HousekeepingUI(App app){
        this.app=app;
        this.cleaningLogUI=new cleaningLogUI(this.app);
        this.revertStatusUI=new revertStatusUI(this.app);
        this.roomStatusUI=new roomStatusUI(this.app);
        this.updateStatusUI=new updateStatusUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.menu("Housekeeping & Task Log",
                    "1. Update room status",
                    "2. Revert Last Changes",
                    "3. View Housekeeping Log",
                    "4. Check room status",
                    "5. Report",
                    "0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1->this.updateStatusUI.run();
                case 2->this.revertStatusUI.run();
                case 3->this.cleaningLogUI.run();
                case 4->this.roomStatusUI.run();
                case 0->{return;}
                default -> {
                    ConsolePrint.error("Invalid choice! Press [ENTER] key to continue....");
                    app.input().pressAnyKey();
                }
            }
        }while (choice != 0);
    }
}

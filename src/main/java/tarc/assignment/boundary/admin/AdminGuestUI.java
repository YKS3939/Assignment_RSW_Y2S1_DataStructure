package tarc.assignment.boundary.admin;

import tarc.assignment.boundary.guest.RegisterGuestUI;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.util.ConsolePrint;

public class AdminGuestUI implements UI {
    private final App app;
    private final AdminGuestAllUI adminGuestAllUI;
    private final RegisterGuestUI registerGuestUI;
    private final AdminGuestTierUI adminGuestTierUI;
    private final AdminGuestSearchUI adminGuestSearchUI;

    public AdminGuestUI(App app){
        this.app=app;
        this.adminGuestAllUI=new AdminGuestAllUI(this.app);
        this.registerGuestUI=new RegisterGuestUI(this.app);
        this.adminGuestTierUI=new AdminGuestTierUI(this.app);
        this.adminGuestSearchUI=new AdminGuestSearchUI(this.app);
    }

    @Override
    public void run() {
        int choice;
        do {
            ConsolePrint.clear();
            ConsolePrint.menu("Admin Management - Guest", "1. Search Guest", "2. Upgrade guest tier", "3. Add new customer", "4. All Guest", "0. Back to Main Menu");
            choice = app.input().readInt("Option: ");
            switch (choice) {
                case 1-> adminGuestSearchUI.run();
                case 2-> adminGuestTierUI.run();
                case 3-> registerGuestUI.run();
                case 4 -> adminGuestAllUI.run();
                case 0 -> {
                    return;
                }

                default -> {
                    app.input().pressAnyKey("Invalid choice! Press [ENTER] key to continue....", app.input().ERROR);
                }
            }
        }while(choice!= 0);
    }

}

package tarc.assignment.boundary.admin;

import tarc.assignment.boundary.room.ViewAllRoomUI;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.util.ConsolePrint;

public class AdminUI implements UI {
    private final App app;
    private final AdminGuestUI adminGuestUI;
    private final AdminPaymentDetailUI adminPaymentDetailUI;
    private final ViewAllRoomUI viewAllRoomUI;
    private final AdminReservationUI adminReservationUI;
    private final AdminHouseKeepingUI adminHouseKeepingUI;

    public AdminUI(App app) {
        this.app = app;
        this.adminGuestUI = new AdminGuestUI(this.app);
        this.adminPaymentDetailUI = new AdminPaymentDetailUI(this.app);
        this.viewAllRoomUI = new ViewAllRoomUI(this.app);
        this.adminReservationUI = new AdminReservationUI(this.app);
        this.adminHouseKeepingUI = new AdminHouseKeepingUI(this.app);
    }

    @Override
    public void run() {
        int choice;
        do {
            ConsolePrint.clear();
            ConsolePrint.menu("Admin Management", "1. Guest", "2. View all room", "3. Payment Record", "4. Reservation Detail", "5. Housekeeping Log", "0. Back to Main Menu");
            choice = app.input().readInt("Option: ");
            switch (choice) {
                case 1 -> adminGuestUI.run();
                case 2 -> viewAllRoomUI.run();
                case 3 -> adminPaymentDetailUI.run();
                case 4 -> adminReservationUI.run();
                case 5 -> adminHouseKeepingUI.run();
                case 0 -> {
                    return;
                }
                default -> {
                    app.input().pressAnyKey("Invalid choice! Press [ENTER] key to continue....", app.input().ERROR);
                }
            }
        } while (choice != 0);
    }
}

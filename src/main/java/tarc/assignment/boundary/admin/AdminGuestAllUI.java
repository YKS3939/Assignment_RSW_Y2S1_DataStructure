package tarc.assignment.boundary.admin;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.MemberTierEnum;
import tarc.assignment.util.ConsolePrint;

public class AdminGuestAllUI implements UI {
    private final App app;

    public AdminGuestAllUI(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        ArrayList<Guest> list = app.guestController().getAll();
        ConsolePrint.clear();
        ConsolePrint.drawLine();
        ConsolePrint.success("Guest List");
        ConsolePrint.drawLine();
        System.out.printf("%-10s %-20s %-12s %-12s %-15s%n",
                "Guest ID", "Name", "Tier", "Points", "Phone Num");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < list.getSize(); i++) {
            Guest g = list.get(i);
            System.out.printf("%-10s %-20s %-12s %-12d %-15s%n",
                    g.getId(),
                    g.getName(),
                    MemberTierEnum.fromCode(g.getMemberTier()),
                    g.getMemberPoint(),
                    g.getPhoneNum());
        }
        System.out.println("-------------------------------------------------------------------");
        app.input().pressAnyKey("Press [ENTER] key to continue....",app.input().SUCCESS);
    }
}
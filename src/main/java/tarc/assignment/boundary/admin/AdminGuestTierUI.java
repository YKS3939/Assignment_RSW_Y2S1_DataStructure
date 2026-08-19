package tarc.assignment.boundary.admin;

import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.MemberTierEnum;
import tarc.assignment.util.ConsolePrint;

public class AdminGuestTierUI implements UI {
    private final App app;

    public AdminGuestTierUI(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        try {
            String userID = this.app.input().readString("Enter Guest ID:");
            Guest guest = app.guestController().find(userID);
            String memberTier = MemberTierEnum.fromCode(guest.getMemberTier());
            ConsolePrint.menu("User Information", "User Id :" + guest.getId(), "Name :" + guest.getName(), "Phone Number :" + guest.getPhoneNum(), "Member Level :" + memberTier, "MemberPoint :" + guest.getMemberPoint());
            boolean choice = app.input().readYesNo("Continue ?");
            if (choice) {
                ConsolePrint.menu("Choose Tier", "[1] Basic", "[2] Elite", "[3] Diamond", "[4] Platinum");
                int selection = app.input().readInt("Selection :");
                app.guestController().changeTier(guest.getId(), selection);
                app.input().pressAnyKey("Member tier updated successfully", app.input().SUCCESS);
            } else {
                throw new RuntimeException("Process Cancelled");
            }
        } catch (NullPointerException e) {
            app.input().pressAnyKey("User not found", app.input().ERROR);
        } catch (RuntimeException e) {
            app.input().pressAnyKey(e.getMessage(), app.input().ERROR);
        }
    }
}

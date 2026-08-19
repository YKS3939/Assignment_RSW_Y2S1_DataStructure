package tarc.assignment.boundary.admin;

import tarc.assignment.boundary.guest.GuestProfileUI;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.Guest;

public class AdminGuestSearchUI implements UI {
    private final App app;

    public AdminGuestSearchUI(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        try {
            String userID = this.app.input().readString("Enter Guest ID: ");
            Guest guest = app.guestController().find(userID);
            if (guest != null) {
                GuestProfileUI guestProfileUI = new GuestProfileUI(this.app, userID);
                guestProfileUI.run();
            }
        } catch (NullPointerException e) {
            app.input().pressAnyKey("User not found", app.input().ERROR);
        } catch (RuntimeException e) {
            app.input().pressAnyKey(e.getMessage(), app.input().ERROR);
        }

    }
}

package tarc.assignment.boundary.guest;

import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;

public class GuestEditPhoneUI implements UI {
    private final App app;
    private final String userID;

    public GuestEditPhoneUI(App app, String userID) {
        this.app = app;
        this.userID = userID;
    }

    @Override
    public void run() {
        try {
            String phoneNum = app.input().readString("Enter your new phone number (without '-'): ");
            app.guestController().changePhone(userID, phoneNum);
            app.input().pressAnyKey("Change Phone number success", app.input().SUCCESS);
        } catch (RuntimeException e) {
            app.input().pressAnyKey(e.getMessage(), app.input().ERROR);
        }

    }
}

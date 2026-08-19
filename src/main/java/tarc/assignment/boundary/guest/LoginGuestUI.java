package tarc.assignment.boundary.guest;

import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.util.ConsolePrint;

public class LoginGuestUI implements UI {
    private final App app;

    public LoginGuestUI(App app) {
        this.app = app;
    }

    @Override
    public void run() {

        String userID = app.input().readString("Enter your user id:");
        String phoneNum = app.input().readString("Enter your phone number (without '-') :");
        boolean result = app.guestController().login(userID, phoneNum);
        if (result) {
            GuestManagementUI guestManagementUI = new GuestManagementUI(app, userID);
            guestManagementUI.run();
        } else {
            ConsolePrint.drawLine();
            app.input().pressAnyKey("LOGIN FAILED", app.input().ERROR);
        }
    }

}

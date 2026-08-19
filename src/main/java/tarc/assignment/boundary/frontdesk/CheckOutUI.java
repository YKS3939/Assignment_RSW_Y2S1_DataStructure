package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.CheckIn;
import tarc.assignment.entity.Guest;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.RubyTime;

public class CheckOutUI implements UI {
    private final App app;

    public CheckOutUI(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        try {
            String confirmationNum = this.app.input().readString("Enter confirmation code: ");
            CheckIn checkIn = app.database().checkInRepository().findByConfirmNum(confirmationNum);
            Guest guest = app.guestController().find(checkIn.getCustomerId());
            ConsolePrint.drawLine();
            ConsolePrint.print("Room Number: " + checkIn.getRoomNum() + "\nGuest Name: " + guest.getName() + "\nCheck In Date: " + RubyTime.convertFormat(checkIn.getCheckInTime(), "yyyy-MM-dd hh:mm a") + "\nCheck Out Deadline: " + RubyTime.convertFormat(checkIn.getCheckOutTime(), "yyyy-MM-dd hh:mm a") + "\n");
            ConsolePrint.drawLine();
            boolean choice = app.input().readYesNo("Continue to payment process?");
            if (choice) {
                CheckOutProcessUI checkOutProcessUI = new CheckOutProcessUI(app, checkIn);
                checkOutProcessUI.run();
            } else {
                throw new RuntimeException("Process cancelled");
            }
        } catch (NullPointerException e) {
            app.input().pressAnyKey("Confirmation code not found", app.input().ERROR);
        } catch (RuntimeException e) {
            app.input().pressAnyKey(e.getMessage(), app.input().ERROR);
        }

    }
}

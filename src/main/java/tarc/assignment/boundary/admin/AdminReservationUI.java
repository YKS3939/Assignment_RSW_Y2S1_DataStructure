package tarc.assignment.boundary.admin;

import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.MemberTierEnum;
import tarc.assignment.entity.Reservation;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.RubyTime;

public class AdminReservationUI implements UI {
    private final App app;
    public AdminReservationUI(App app){
        this.app=app;
    }
    @Override
    public void run() {
        ConsolePrint.clear();

        Reservation standard = app.database().standardBookingADT().peek();
        Reservation vip = app.database().vipBookingADT().peek();

        if (vip == null && standard == null) {
            ConsolePrint.drawLine();
            ConsolePrint.error("No pending bookings found in queue.");
            ConsolePrint.drawLine();
        } else {
            if (vip != null) {
                Guest vipGuest = app.guestController().find(vip.getCustomerId());
                String vipGuestName = (vipGuest != null) ? vipGuest.getName() : "Unknown";

                ConsolePrint.menu("Next VIP Booking",
                        "Confirmation Number : " + vip.getConfirmationNum(),
                        "Customer ID :" + vip.getCustomerId(),
                        "Customer Name :" + vipGuestName,
                        "Member Tier :" + MemberTierEnum.fromCode(vip.getMemberTier()),
                        "Reservation At :" + RubyTime.convertFormat(vip.getCreateAt(), "yyyy-MM-dd hh:mm a")
                );
            } else {
                ConsolePrint.drawLine();
                ConsolePrint.error( "No VIP booking in queue.");
            }

            if (standard != null) {
                Guest stdGuest = app.guestController().find(standard.getCustomerId());
                String stdGuestName = (stdGuest != null) ? stdGuest.getName() : "Unknown";

                ConsolePrint.menu("Next Standard Booking",
                        "Confirmation Number : " + standard.getConfirmationNum(),
                        "Customer ID :" + standard.getCustomerId(),
                        "Customer Name :" + stdGuestName,
                        "Member Tier :" + MemberTierEnum.fromCode(standard.getMemberTier()),
                        "Reservation At :" + RubyTime.convertFormat(standard.getCreateAt(), "yyyy-MM-dd hh:mm a")
                );
            } else {
                ConsolePrint.error( "No Standard booking in queue.");
                ConsolePrint.drawLine();
            }
        }

        app.input().pressAnyKey("Press [ENTER] key to continue....", app.input().SUCCESS);
    }
}

package tarc.assignment.control;

import tarc.assignment.core.Database;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.Reservation;
import tarc.assignment.util.NumGenerate;

import java.time.Instant;

public class ReservationController {
    private final Database database;
    public ReservationController(Database database){
        this.database=database;
    }

    public void create(GuestController guestController,String userID){
        try{
            String confirmationNum= NumGenerate.generateDigit(8);
            Guest guest=guestController.find(userID);
            Instant timeNow = Instant.now();

            if (guest==null){
                throw new NullPointerException();
            }
            Reservation reservation=new Reservation(confirmationNum,userID,guest.getMemberTier(),timeNow);
            database.reservationDAO().create(reservation);
        }catch (NullPointerException e){
            throw new RuntimeException("UserId not found");
        }

    }
}

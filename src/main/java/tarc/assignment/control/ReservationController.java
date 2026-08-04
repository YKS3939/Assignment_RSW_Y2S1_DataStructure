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

    public String create(GuestController guestController,String userID){
        try{
            String confirmationNum;
            Guest guest=guestController.find(userID);
            Instant timeNow = Instant.now();

            if (guest==null){
                throw new NullPointerException();
            }
            while (true) {
                confirmationNum = NumGenerate.generateDigit(8);
                boolean exist = database.reservationADT().exist(confirmationNum);
                if (!exist) {
                    break;
                }
//                throw new RuntimeException("Catch repeat");
            }
            Reservation reservation=new Reservation(confirmationNum,userID,guest.getMemberTier(),timeNow);
            database.reservationDAO().create(reservation);
            database.reservationADT().add(confirmationNum,reservation);
            return confirmationNum;
        }catch (NullPointerException e){
            throw new RuntimeException("UserId not found");
        }

    }
}

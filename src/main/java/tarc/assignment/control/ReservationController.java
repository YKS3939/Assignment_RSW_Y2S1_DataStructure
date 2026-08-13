package tarc.assignment.control;

import tarc.assignment.core.Database;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.MemberTierEnum;
import tarc.assignment.entity.Reservation;
import tarc.assignment.util.NumGenerate;

import java.time.Instant;

public class ReservationController {
    private final Database database;
    public ReservationController(Database database){
        this.database=database;
    }

    public String addRegistration(GuestController guestController,String userID){
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
            if (reservation.getMemberTier()> MemberTierEnum.BASIC.getCode()){
                database.vipBookingADT().insert(reservation);
            }else{
                database.standardBookingADT().enqueue(reservation);
            }
            return confirmationNum;
        }catch (NullPointerException e){
            throw new RuntimeException("UserId not found");
        }
    }

    public Reservation viewNextGuest(){
        if (!database.vipBookingADT().isEmpty()){
            return database.vipBookingADT().peekMax();
        }else if (!database.standardBookingADT().isEmpty()){
            return database.standardBookingADT().peek();
        }else{
            throw new RuntimeException("Queue List are Empty");
        }
    }

    public void dropReservation(String confirmationNum){
        if (!database.vipBookingADT().isEmpty()){
            database.vipBookingADT().extractMax();
            database.reservationDAO().deleteByConfirmationNum(confirmationNum);
        }else if (!database.standardBookingADT().isEmpty()){
            database.standardBookingADT().dequeue();
            database.reservationDAO().deleteByConfirmationNum(confirmationNum);
        }
        else{
            throw new RuntimeException("Queue List are Empty");
        }
    }
}

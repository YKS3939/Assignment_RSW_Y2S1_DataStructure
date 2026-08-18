package tarc.assignment.control;

import tarc.assignment.core.Database;
import tarc.assignment.entity.CheckIn;
import tarc.assignment.entity.Reservation;
import tarc.assignment.util.RubyTime;
import tarc.assignment.validate.CheckInValidate;

import java.time.Instant;

/**
 * Yap Kim Soon & Ng Zhun Onn
 */
public class CheckInController {
    private final Database database;

    public CheckInController(Database database){
        this.database=database;
    }

    public boolean checkIn(RoomController roomController,String confirmationNum,String roomNum,String customerId,boolean meal,int day){
        try{
            CheckInValidate.validateConfirmationNum(confirmationNum);
            CheckInValidate.validateRoomNum(roomNum);
            CheckInValidate.validateDay(day);

            if (roomController.isExistSet(roomNum,"Ready")){
                Instant checkInTime=RubyTime.timeNow();
                Instant checkOutTime=RubyTime.timeAddDays(day);

                Reservation reservation=database.reservationRepository().findByConfirmNum(confirmationNum);
                database.reservationRepository().remove(reservation);

                CheckIn checkIn=new CheckIn(confirmationNum,roomNum,customerId,meal,checkInTime,checkOutTime);
                database.checkInDAO().create(checkIn);
                database.checkInRepository().add(checkIn);
                roomController.changeRoomOnService(roomNum,false);
                return true;
            }else{
                throw new RuntimeException("The Room Number is not accept");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}

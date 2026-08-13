package tarc.assignment.control;

import tarc.assignment.core.Database;
import tarc.assignment.entity.CheckIn;
import tarc.assignment.util.RubyTime;
import tarc.assignment.validate.CheckInValidate;

import java.time.Instant;

public class CheckInController {
    private final Database database;
    private final RoomController roomController;

    public CheckInController(Database database,RoomController roomController){
        this.database=database;
        this.roomController=roomController;
    }

    public boolean checkIn(String confirmationNum,String roomNum,String customerId,boolean meal,int day){
        try{
            CheckInValidate.validateConfirmationNum(confirmationNum);
            CheckInValidate.validateRoomNum(roomNum);
            CheckInValidate.validateDay(day);

            if (roomController.isExistSet(roomNum,"Ready")){
                Instant checkInTime=RubyTime.timeNow();
                Instant checkOutTime=RubyTime.timeAddDays(day);

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

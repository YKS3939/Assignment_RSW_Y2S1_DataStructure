package tarc.assignment.control;

import tarc.assignment.core.Database;
import tarc.assignment.entity.CheckIn;
import tarc.assignment.entity.CheckOut;
import tarc.assignment.entity.Room;
import tarc.assignment.util.Environment;
import tarc.assignment.util.NumGenerate;
import tarc.assignment.util.RubyTime;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

public class CheckOutController {
    private final Database database;

    public CheckOutController(Database database){
        this.database=database;
    }

    //Here don't touch
    public CheckOut processCheckOut(RoomController roomController, CheckIn checkIn) {
        Instant checkInTime = checkIn.getCheckInTime();
        Instant checkOutTime = checkIn.getCheckOutTime();
        Instant timeNow = RubyTime.timeNow();
        String id= NumGenerate.generadeULID();

        BigDecimal mealFee = BigDecimal.ZERO;
        BigDecimal penalty = BigDecimal.ZERO;

        long totalHours = Duration.between(checkInTime, checkOutTime).toHours();
        int days = (int) ((totalHours + 23) / 24);
        if (days <= 0) days = 1;

        if (timeNow.isAfter(checkOutTime)) {
            long penaltyDays = Duration.between(checkOutTime, timeNow).toDays();
            if (penaltyDays <= 0) penaltyDays = 1;

            BigDecimal dailyPenaltyRate = new BigDecimal("10.00");
            penalty = dailyPenaltyRate.multiply(BigDecimal.valueOf(penaltyDays));
        }

        if (checkIn.isMeal()) {
            BigDecimal mealRatePerDay = new BigDecimal(Environment.get("fee.meal"));
            mealFee = mealRatePerDay.multiply(BigDecimal.valueOf(days));
        }

        double price = roomController.find(checkIn.getRoomNum()).getRoomPrice();
        BigDecimal roomPricePerNight = BigDecimal.valueOf(price);

        BigDecimal totalRoomFee = roomPricePerNight.multiply(BigDecimal.valueOf(days));

        //  Room fee+meal fee+ penalty
        BigDecimal total = totalRoomFee.add(mealFee).add(penalty);

//        System.out.println("Total:"+total);
        CheckOut checkOut = new CheckOut(
                id,
                checkIn.getRoomNum(),
                checkIn.getCustomerId(),
                penalty,
                mealFee,
                totalRoomFee,
                total,
                days,
                timeNow
        );
        roomController.changeRoomOnService(checkIn.getRoomNum(),true);
        roomController.changeRoomStatus(checkIn.getRoomNum(),1);
        database.checkOutDAO().create(checkOut);
        database.checkOutADT().add(checkOut);
        database.checkInDAO().deleteByConfirmationNum(checkIn.getConfirmationNum());
        database.checkInRepository().remove(checkIn);
        return checkOut;
    }
}

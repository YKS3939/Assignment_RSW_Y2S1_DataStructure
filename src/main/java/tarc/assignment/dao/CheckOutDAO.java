package tarc.assignment.dao;

import tarc.assignment.entity.CheckIn;
import tarc.assignment.entity.CheckOut;
import tarc.assignment.util.RubyFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckOutDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "checkout_record.txt");

    public void create(CheckOut checkOut){
        String record = String.join(",",checkOut.getId(),checkOut.getRoomNum(), checkOut.getCustomerId(), String.valueOf(checkOut.getPenalty()), String.valueOf(checkOut.getMealFee()), String.valueOf(checkOut.getRoomFee()), String.valueOf(checkOut.getTotal()), String.valueOf(checkOut.getDays()), String.valueOf(checkOut.getCheckOutTime())
        );
        RubyFile.append(path,record);
    }
}

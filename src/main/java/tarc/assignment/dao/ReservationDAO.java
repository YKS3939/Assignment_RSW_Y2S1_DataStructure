package tarc.assignment.dao;

import tarc.assignment.entity.Reservation;
import tarc.assignment.util.RubyFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ReservationDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "reservation.txt");

    public void create(Reservation reservation){
        String record=String.join(",",reservation.getConfirmationNum(), reservation.getCustomerId(),String.valueOf(reservation.getMemberTier()),String.valueOf(reservation.getCreateAt()));
        RubyFile.append(path,record);
    }
}

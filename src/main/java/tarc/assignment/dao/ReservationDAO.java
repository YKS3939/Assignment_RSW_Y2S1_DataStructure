package tarc.assignment.dao;

import tarc.assignment.entity.Reservation;
import tarc.assignment.util.RubyFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ReservationDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "reservation.txt");
    public void create(Reservation reservation){
        String record=String.join(",",reservation.getId(),reservation.getConfirmationNum(),String.valueOf(reservation.getCheckInTime()),String.valueOf(reservation.getCheckOutTime()));
        RubyFile.append(path,record);
    }
}

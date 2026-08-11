package tarc.assignment.dao;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.Reservation;
import tarc.assignment.util.RubyFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

public class ReservationDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "reservation.txt");

    public void create(Reservation reservation){
        String record=String.join(",",reservation.getConfirmationNum(), reservation.getCustomerId(),String.valueOf(reservation.getMemberTier()),String.valueOf(reservation.getCreateAt()));
        RubyFile.append(path,record);
    }

    public ArrayList<Reservation> readAll() {
        ArrayList<Reservation> list = new ArrayList<>(25);
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length >= 4) {
                    Reservation item = new Reservation(data[0], data[1], Integer.parseInt(data[2].trim()), Instant.parse(data[3].trim()));
                    list.add(item);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute file readAll", e);
        }

        return list;
    }
}

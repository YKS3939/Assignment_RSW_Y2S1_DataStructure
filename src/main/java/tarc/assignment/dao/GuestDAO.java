package tarc.assignment.dao;

import tarc.assignment.entity.Guest;
import tarc.assignment.util.RubyFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import tarc.assignment.adt.ArrayList;

public class GuestDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "guest.txt");

    public void create(Guest guest){
        String record = String.join(",", guest.getId(), guest.getName(), String.valueOf(guest.getMemberTier()),String.valueOf(guest.getMemberPoint()),guest.getPhoneNum());
        RubyFile.append(path,record);
    }

    public ArrayList<Guest> readAll() {
        ArrayList<Guest> list = new ArrayList<>(25);
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length >= 5) {
                    Guest guest = new Guest(data[0], data[1], Integer.parseInt(data[2].trim()),Integer.parseInt(data[3].trim()),data[4]);
                    list.add(guest);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute file readAll", e);
        }

        return list;
    }
}

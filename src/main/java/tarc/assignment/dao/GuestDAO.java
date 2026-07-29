package tarc.assignment.dao;

import tarc.assignment.entity.Guest;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.RubyFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class GuestDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "guest.txt");

    public void create(Guest guest){
        String record = String.join(",", guest.getConfirmationNum(), guest.getName(), String.valueOf(guest.getMemberTier()),guest.getPhoneNum());
        RubyFile.append(path,record);
    }

    @Deprecated
    public Guest[] readGuest() {
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            Guest[] guests = new Guest[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                String[] data = lines.get(i).split(",");
                guests[i] = new Guest(data[0], data[1],Integer.valueOf(data[2]) , data[3]);
            }
            return guests;
        } catch (IOException e) {
            e.printStackTrace();
            return new Guest[0];
        }
    }
}

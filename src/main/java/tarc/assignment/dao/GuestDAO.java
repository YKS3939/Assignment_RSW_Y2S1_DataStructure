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
        String record = String.join(",", guest.getConfirmationNum(), guest.getName(), String.valueOf(guest.getMemberTier()),guest.getPhoneNum()) + System.lineSeparator();
        RubyFile.append(path,record);
    }

    @Deprecated
    public void readGuest() {
        try (var lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.forEach(line -> {
                System.out.println(line);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

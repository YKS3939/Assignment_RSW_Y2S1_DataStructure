package tarc.assignment.dao;

import tarc.assignment.util.ConsolePrint;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GuestDAO {
    private final Path path;
    public GuestDAO(){
        this.path= Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "guest.txt");
    }

    @Deprecated
    public void saveGuest(){

    }

    @Deprecated
    public void readGuest(){
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8); //FIXME: ALERT !!!!!NOT A FINAL
            for (String line : lines) {
                ConsolePrint.warning("Not for final");
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

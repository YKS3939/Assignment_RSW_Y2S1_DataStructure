package tarc.assignment.dao;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RoomDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "room.txt");

    private void changeService(String roomNum,boolean onService){

    }

    public ArrayList<Room> readAll() {
        ArrayList<Room> list = new ArrayList<>(25);
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length >= 5) {
                    Room item = new Room(data[0], data[1], Float.parseFloat(data[2].trim()),Boolean.parseBoolean(data[3].trim()), Integer.parseInt(data[4]));
                    list.add(item);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute file readAll", e);
        }

        return list;
    }
}

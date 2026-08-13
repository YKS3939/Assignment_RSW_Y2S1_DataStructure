package tarc.assignment.dao;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.entity.Room;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RoomDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "room.txt");

    public void changeService(String roomNum, boolean onService) {
        updateRoomData(roomNum, onService, null);
    }

    public void changeStatus(String roomNum, int status) {
        updateRoomData(roomNum, null, status);
    }

    /**
     * This method are use AI code generation
     */
    private void updateRoomData(String roomNum, Boolean newOnService, Integer newStatus) {
        if (roomNum == null || roomNum.trim().isEmpty()) {
            return;
        }

        ArrayList<String> lines = new ArrayList<>(25);
        boolean updated = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.isEmpty()) continue;

                String[] data = trimmedLine.split(",");
                if (data.length >= 5 && data[0].trim().equals(roomNum.trim())) {
                    if (newOnService != null) {
                        data[3] = String.valueOf(newOnService);
                    }
                    if (newStatus != null) {
                        data[4] = String.valueOf(newStatus);
                    }
                    line = String.join(",", data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim());
                    updated = true;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read room file during update", e);
        }

        if (updated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile(), false))) { // false 为覆盖模式
                for (int i = 0; i < lines.getSize(); i++) {
                    bw.write(lines.get(i));
                    bw.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to write room file during update", e);
            }
        }
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

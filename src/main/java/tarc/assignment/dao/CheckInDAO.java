package tarc.assignment.dao;

import tarc.assignment.entity.CheckIn;
import tarc.assignment.util.RubyFile;
import tarc.assignment.adt.ArrayList;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

public class CheckInDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "checkin.txt");
    public void create(CheckIn checkIn){
        String record = String.join(",", checkIn.getConfirmationNum(), checkIn.getRoomNum(), checkIn.getCustomerId(),String.valueOf(checkIn.isMeal()),String.valueOf(checkIn.getCheckInTime()),String.valueOf(checkIn.getCheckOutTime()));
        RubyFile.append(path,record);
    }

    public ArrayList<CheckIn> readAll() {
        ArrayList<CheckIn> list = new ArrayList<>(25);
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length >= 6) {
                    String confirmationNum = data[0].trim();
                    String roomNum = data[1].trim();
                    String customerId = data[2].trim();
                    boolean meal = Boolean.parseBoolean(data[3].trim());
                    Instant checkInTime = Instant.parse(data[4].trim());

                    String checkOutStr = data[5].trim();
                    Instant checkOutTime = "null".equalsIgnoreCase(checkOutStr) || checkOutStr.isEmpty()
                            ? null
                            : Instant.parse(checkOutStr);

                    CheckIn item = new CheckIn(confirmationNum, roomNum, customerId, meal, checkInTime, checkOutTime);
                    list.add(item);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute file readAll", e);
        }

        return list;
    }

    public boolean deleteByConfirmationNum(String confirmationNum) {
        if (confirmationNum == null || confirmationNum.trim().isEmpty()) {
            return false;
        }

        ArrayList<String> remainingLines = new ArrayList<>(25);
        boolean deleted = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.isEmpty()) continue;

                String[] data = trimmedLine.split(",");

                if (!deleted && data.length > 0 && data[0].trim().equals(confirmationNum.trim())) {
                    deleted = true;
                    continue;
                }

                remainingLines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file during delete", e);
        }

        if (deleted) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile(), false))) {
                for (int i = 0; i < remainingLines.getSize(); i++) {
                    bw.write(remainingLines.get(i));
                    bw.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to write file during delete", e);
            }
        }

        return deleted;
    }
}

package tarc.assignment.dao;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.Reservation;
import tarc.assignment.util.RubyFile;

import java.io.*;
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

    /**
     * This method are use AI code generation -Ng Zhun Onn
     */
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
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile(), false))) { // false 表示覆盖模式
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

    public boolean updateMemberTier(String confirmationNum, int newMemberTier) {
        if (confirmationNum == null || confirmationNum.trim().isEmpty()) {
            return false;
        }

        ArrayList<String> lines = new ArrayList<>(25);
        boolean updated = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.isEmpty()) continue;

                String[] data = trimmedLine.split(",");
                if (data.length >= 4 && data[0].trim().equals(confirmationNum.trim())) {
                    data[2] = String.valueOf(newMemberTier);
                    line = String.join(",", data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
                    updated = true;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read reservation file during update", e);
        }

        if (updated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile(), false))) { // false 为覆盖模式
                for (int i = 0; i < lines.getSize(); i++) {
                    bw.write(lines.get(i));
                    bw.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to write reservation file during update", e);
            }
        }

        return updated;
    }
}

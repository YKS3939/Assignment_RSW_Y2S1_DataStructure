package tarc.assignment.dao;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.entity.Guest;
import tarc.assignment.util.RubyFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GuestDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "guest.txt");

    public void create(Guest guest) {
        String record = String.join(",", guest.getId(), guest.getName(), String.valueOf(guest.getMemberTier()), String.valueOf(guest.getMemberPoint()), guest.getPhoneNum());
        RubyFile.append(path, record);
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
                    Guest item = new Guest(data[0].trim(), data[1].trim(), Integer.parseInt(data[2].trim()), Integer.parseInt(data[3].trim()), data[4].trim());
                    list.add(item);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute file readAll", e);
        }

        return list;
    }

    public void updatePhoneNum(String guestId, String newPhoneNum) {
        updateGuestData(guestId, null, null, newPhoneNum);
    }

    public void updateMemberTier(String guestId, int newMemberTier) {
        updateGuestData(guestId, newMemberTier, null, null);
    }

    public void updateMemberPoint(String guestId, int newMemberPoint) {
        updateGuestData(guestId, null, newMemberPoint, null);
    }


    private void updateGuestData(String guestId, Integer newMemberTier, Integer newMemberPoint, String newPhoneNum) {
        if (guestId == null || guestId.trim().isEmpty()) {
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
                if (data.length >= 5 && data[0].trim().equals(guestId.trim())) {
                    if (newMemberTier != null) {
                        data[2] = String.valueOf(newMemberTier);
                    }
                    if (newMemberPoint != null) {
                        data[3] = String.valueOf(newMemberPoint);
                    }
                    if (newPhoneNum != null) {
                        data[4] = newPhoneNum.trim();
                    }
                    line = String.join(",", data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim());
                    updated = true;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read guest file during update", e);
        }

        if (updated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile(), false))) { // false 为覆盖模式
                for (int i = 0; i < lines.getSize(); i++) {
                    bw.write(lines.get(i));
                    bw.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to write guest file during update", e);
            }
        }
    }
}
package tarc.assignment.dao;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.entity.CheckOut;
import tarc.assignment.util.RubyFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

public class CheckOutDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "checkout_record.txt");

    public void create(CheckOut checkOut) {
        String record = String.join(",",
                checkOut.id(),
                checkOut.roomNum(),
                checkOut.customerId(),
                String.valueOf(checkOut.penalty()),
                String.valueOf(checkOut.mealFee()),
                String.valueOf(checkOut.roomFee()),
                String.valueOf(checkOut.total()),
                String.valueOf(checkOut.days()),
                String.valueOf(checkOut.checkOutTime())
        );
        RubyFile.append(path, record);
    }

    public ArrayList<CheckOut> readAll() {
        ArrayList<CheckOut> list = new ArrayList<>(25);
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length >= 9) {
                    CheckOut item = new CheckOut(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            new BigDecimal(data[3].trim()),
                            new BigDecimal(data[4].trim()),
                            new BigDecimal(data[5].trim()),
                            new BigDecimal(data[6].trim()),
                            Integer.parseInt(data[7].trim()),
                            Instant.parse(data[8].trim())
                    );
                    list.add(item);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute file readAll", e);
        }

        return list;
    }
}
package tarc.assignment.dao;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.entity.Task;
import tarc.assignment.util.RubyFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

public class TaskDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "task_log.txt");

    public void create(Task task) {
        String record = String.join(",",task.getId(),task.getRoomNum(),String.valueOf(task.getBeforeStatus()), String.valueOf(task.getAfterStatus()), String.valueOf(task.getCreateAt())
        );
        RubyFile.append(path, record);
    }

    public ArrayList<Task> readAll() {
        ArrayList<Task> list = new ArrayList<>(25);
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length >= 5) {
                    Task item = new Task(data[0], data[1], Integer.parseInt(data[2].trim()), Integer.parseInt(data[3].trim()), Instant.parse(data[4]));
                    list.add(item);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute file readAll", e);
        }
        return list;
    }

    public boolean deleteById(String taskId) {
        if (taskId == null || taskId.trim().isEmpty()) {
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

                if (!deleted && data.length > 0 && data[0].trim().equals(taskId.trim())) {
                    deleted = true;
                    continue;
                }

                remainingLines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file during task delete", e);
        }

        if (deleted) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile(), false))) {
                for (int i = 0; i < remainingLines.getSize(); i++) {
                    bw.write(remainingLines.get(i));
                    bw.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to write file during task delete", e);
            }
        }

        return deleted;
    }
}
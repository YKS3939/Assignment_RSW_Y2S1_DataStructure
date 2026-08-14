package tarc.assignment.dao;

import tarc.assignment.entity.Task;
import tarc.assignment.util.RubyFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskDAO {
    private static final Path path = Paths.get("src", "main", "java", "tarc", "assignment", "core", "data", "task_log.txt");

    public void create(Task task){
        String record = String.join(",",task.getId(),task.getRoomNum(),String.valueOf(task.getBeforeStatus()),String.valueOf(task.getAfterStatus()),String.valueOf(task.getCreateAt()));
        RubyFile.append(path,record);
    }

}

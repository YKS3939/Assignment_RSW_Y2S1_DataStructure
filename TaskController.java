package tarc.assignment.control;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.core.Database;
import tarc.assignment.entity.Task;
import tarc.assignment.util.NumGenerate;
import tarc.assignment.util.RubyTime;

/**
 * Ma Chun Yen
 */
public class TaskController {
    private final Database database;
    public TaskController(Database database){
        this.database=database;
    }

    public void addTask(RoomController roomController,String roomNum,int beforeStatus,int afterStatus){
        String ulid= NumGenerate.generadeULID();
        Task newTask=new Task(ulid,roomNum,beforeStatus,afterStatus, RubyTime.timeNow());
        roomController.changeRoomStatus(roomNum,afterStatus);
        database.taskDAO().create(newTask);
        database.taskADT().add(newTask);
    }

    public ArrayList<Task> getTaskList(){
        return database.taskADT();
    }

    public Task getTask(int index){
        return database.taskADT().get(index);
    }

    public void revertTask(RoomController roomController, int index){
        Task task=database.taskADT().remove(index);
        if (task == null) {
            throw new RuntimeException("Task not found");
        }
        roomController.changeRoomStatus(task.getRoomNum(),task.getBeforeStatus());
        database.taskDAO().deleteById(task.getId());
    }

    public ArrayList<Task> getAll(){
        return database.taskDAO().readAll();
    }
}

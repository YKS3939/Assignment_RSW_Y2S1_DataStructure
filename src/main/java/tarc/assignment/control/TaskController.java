package tarc.assignment.control;

import tarc.assignment.core.Database;
import tarc.assignment.entity.Task;
import tarc.assignment.util.NumGenerate;
import tarc.assignment.util.RubyTime;

public class TaskController {
    private final Database database;
    public TaskController(Database database){
        this.database=database;
    }
//TODO: save into ADT and DAO

    public void pushTask(RoomController roomController,String roomNum,int beforeStatus,int afterStatus){
        String ulid= NumGenerate.generadeULID();
        Task newTask=new Task(ulid,roomNum,beforeStatus,afterStatus, RubyTime.timeNow());
        roomController.changeRoomStatus(roomNum,afterStatus);
        database.taskDAO().create(newTask);
        database.taskADT().push(newTask);
    }

    public Task peekRevert(){
        return database.taskADT().peek();
    }
    public void revertTask(RoomController roomController){
        Task task=database.taskADT().pop();
        roomController.changeRoomStatus(task.getRoomNum(),task.getBeforeStatus());
        database.taskDAO().deleteById(task.getId());
    }


}

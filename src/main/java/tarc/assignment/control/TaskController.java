package tarc.assignment.control;

import tarc.assignment.core.Database;
import tarc.assignment.entity.Task;
import tarc.assignment.util.NumGenerate;
import tarc.assignment.util.RubyTime;

public class TaskController {
    private final Database database;
    private final RoomController roomController;

    public TaskController(Database database,RoomController roomController){
        this.database=database;
        this.roomController=roomController;
    }
//TODO: save into ADT and DAO

    public void pushTask(String roomNum,int beforeStatus,int afterStatus){
        String ulid= NumGenerate.generadeULID();
        Task newTask=new Task(ulid,roomNum,beforeStatus,afterStatus, RubyTime.timeNow());
        roomController.changeRoomStatus(roomNum,afterStatus);
        database.taskDAO().create(newTask);
        database.taskADT().push(newTask);
    }



}

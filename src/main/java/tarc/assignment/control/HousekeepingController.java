package tarc.assignment.control;

import tarc.assignment.core.Database;

public class HousekeepingController {
    private final Database database;
    private final RoomController roomController;

    public HousekeepingController(Database database,RoomController roomController){
        this.database=database;
        this.roomController=roomController;
    }

    public void updateTaskStatus(String roomNum,int status){
        roomController.changeRoomStatus(roomNum,status);
        //Insert data to task
    }
}

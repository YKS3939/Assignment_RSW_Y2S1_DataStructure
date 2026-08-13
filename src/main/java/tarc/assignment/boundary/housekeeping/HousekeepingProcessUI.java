package tarc.assignment.boundary.housekeeping;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.entity.Room;
import tarc.assignment.entity.RoomStatusEnum;
import tarc.assignment.util.ConsolePrint;

public class HousekeepingProcessUI implements UI {
    private final App app;
    public HousekeepingProcessUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        try{
            String roomNum=app.input().readString("Room Number :");
            String roomNowStatus=app.roomController().findSet(new Room(roomNum));
            int roomNextStatus= app.roomController().nextSet(roomNowStatus);
            boolean choice=app.input().readYesNo("The room "+roomNum+" will update ["+roomNowStatus+"] to ["+RoomStatusEnum.fromCode(roomNextStatus)+"], Continue ?");
            if (choice){
                app.housekeepingController().updateTaskStatus(roomNum,roomNextStatus);
            }else {
                throw new RuntimeException("Process Cancelled");
            }
        } catch (RuntimeException e) {
            app.input().pressAnyKey(e.getMessage(),app.input().ERROR);
        }


    }
}

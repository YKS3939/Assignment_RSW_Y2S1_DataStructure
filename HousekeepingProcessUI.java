package tarc.assignment.boundary.housekeeping;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
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
            ArrayList<Room> rooms = app.roomController().viewAllRoom();
            if (rooms.isEmpty()) {
                throw new RuntimeException("No room found");
            }

            ConsolePrint.clear();
            ConsolePrint.drawLine();
            ConsolePrint.success("Select a room to update");
            ConsolePrint.drawLine();
            System.out.printf("%-6s %-10s %-12s %-8s%n", "No.", "Room Num", "On Service", "Status");
            System.out.println("----------------------------------------------");
            for (int i = 0; i < rooms.getSize(); i++) {
                Room r = rooms.get(i);
                System.out.printf("%-6d %-10s %-12b %-8s%n",
                        i + 1,
                        r.getRoomNum(),
                        r.isOnService(),
                        RoomStatusEnum.fromCode(r.getStatus()));
            }
            System.out.println("----------------------------------------------");

            int selection = app.input().readInt("Select room number (0 to cancel): ");
            if (selection == 0) {
                throw new RuntimeException("Process Cancelled");
            }

            Room selected = rooms.get(selection - 1);
            if (selected == null) {
                throw new RuntimeException("Invalid room selection");
            }

            String roomNum = selected.getRoomNum();
            String roomNowStatus=app.roomController().findSet(selected);
            String roomNextStatus= app.roomController().nextName(RoomStatusEnum.fromName(roomNowStatus));
            boolean choice=app.input().readYesNo("The room "+roomNum+" will update ["+roomNowStatus+"] to ["+roomNextStatus+"], Continue ?");
            if (choice){
                app.taskController().addTask(app.roomController(),roomNum,RoomStatusEnum.fromName(roomNowStatus),RoomStatusEnum.fromName(roomNextStatus));
                app.input().pressAnyKey("The room cleaning status has been changed",app.input().SUCCESS);
            }else {
                throw new RuntimeException("Process Cancelled");
            }
        } catch (RuntimeException e) {
            app.input().pressAnyKey(e.getMessage(),app.input().ERROR);
        }


    }
}

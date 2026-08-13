package tarc.assignment.boundary.room;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.entity.Room;
import tarc.assignment.entity.RoomStatusEnum;
import tarc.assignment.util.ConsolePrint;

public class AvailableRoomUI implements UI {
    private final App app;
    public AvailableRoomUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        ArrayList<Room> items = app.roomController().getAvailableRoom();
        ConsolePrint.drawLine();
        ConsolePrint.success("Room Available");
        ConsolePrint.drawLine();
        System.out.printf("%-10s %-15s %-20s%n",
                "Room Num", "Room Type", "Price per day(RM)");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < items.getSize(); i++) {
            Room r = items.get(i);
            System.out.printf("%-10s %-15s %-20.2f%n",
                    r.getRoomNum(),
                    r.getRoomType(),
                    r.getRoomPrice());
        }
        System.out.println("-------------------------------------------------------------------");
    }
}

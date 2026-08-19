package tarc.assignment.boundary.room;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.Room;
import tarc.assignment.entity.RoomStatusEnum;
import tarc.assignment.util.ConsolePrint;

public class ViewAllRoomUI implements UI {
    private final App app;

    public ViewAllRoomUI(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        ConsolePrint.clear();
        ArrayList<Room> items = app.roomController().viewAllRoom();
        ConsolePrint.drawLine();
        ConsolePrint.success("All Rooms");
        ConsolePrint.drawLine();
        System.out.printf("%-10s %-15s %-20s %-12s %-8s%n",
                "Room Num", "Room Type", "Price per day(RM)", "On Service", "Status");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < items.getSize(); i++) {
            Room r = items.get(i);
            System.out.printf("%-10s %-15s %-20.2f %-12b %-8s%n",
                    r.getRoomNum(),
                    r.getRoomType(),
                    r.getRoomPrice(),
                    r.isOnService(),
                    RoomStatusEnum.fromCode(r.getStatus()));

        }
        System.out.println("-------------------------------------------------------------------");
        app.input().pressAnyKey("Press [ENTER] key to continue....", app.input().SUCCESS);
    }
}

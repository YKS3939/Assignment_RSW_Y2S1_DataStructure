package tarc.assignment.boundary.admin;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.RoomStatusEnum;
import tarc.assignment.entity.Task;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.RubyTime;

public class AdminHouseKeepingUI implements UI {
    private final App app;

    public AdminHouseKeepingUI(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        ArrayList<Task> list = app.taskController().getAll();

        ConsolePrint.clear();
        ConsolePrint.drawLine();
        ConsolePrint.success("Housekeeping Task List");
        ConsolePrint.drawLine();

        System.out.printf("%-30s %-10s %-15s %-15s %-20s%n",
                "Task ID", "Room Num", "Before Status", "After Status", "Created At");
        System.out.println("-----------------------------------------------------------------------------------");

        if (list != null) {
            for (int i = 0; i < list.getSize(); i++) {
                Task t = list.get(i);

                String timeStr = (t.getCreateAt() != null)
                        ? RubyTime.convertFormat(t.getCreateAt(), "yyyy-MM-dd hh:mm a")
                        : "N/A";

                System.out.printf("%-30s %-10s %-15s %-15s %-20s%n",
                        t.getId(),
                        t.getRoomNum(),
                        RoomStatusEnum.fromCode(t.getBeforeStatus()),
                        RoomStatusEnum.fromCode(t.getAfterStatus()),
                        timeStr);
            }
        }

        System.out.println("-----------------------------------------------------------------------------------");
        app.input().pressAnyKey("Press [ENTER] key to continue....", app.input().SUCCESS);
    }
}
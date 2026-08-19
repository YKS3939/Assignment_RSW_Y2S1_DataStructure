package tarc.assignment.boundary.housekeeping;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.RoomStatusEnum;
import tarc.assignment.entity.Task;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.RubyTime;

public class RevertTaskProgressUI implements UI {
    private final App app;
    public RevertTaskProgressUI(App app){
        this.app=app;
    }
    @Override
    public void run(){
        try {
            ArrayList<Task> tasks = app.taskController().getTaskList();
            if (tasks == null || tasks.isEmpty()) {
                throw new RuntimeException("No Record");
            }

            ConsolePrint.clear();
            ConsolePrint.drawLine();
            ConsolePrint.success("Select a housekeeping change to revert");
            ConsolePrint.drawLine();
            System.out.printf("%-6s %-10s %-15s %-15s %-20s%n",
                    "No.", "Room Num", "Before Status", "After Status", "Created At");
            System.out.println("------------------------------------------------------------------------");
            for (int i = 0; i < tasks.getSize(); i++) {
                Task t = tasks.get(i);
                String timeStr = (t.getCreateAt() != null)
                        ? RubyTime.convertFormat(t.getCreateAt(), "yyyy-MM-dd hh:mm a")
                        : "N/A";
                System.out.printf("%-6d %-10s %-15s %-15s %-20s%n",
                        i + 1,
                        t.getRoomNum(),
                        RoomStatusEnum.fromCode(t.getBeforeStatus()),
                        RoomStatusEnum.fromCode(t.getAfterStatus()),
                        timeStr);
            }
            System.out.println("------------------------------------------------------------------------");

            int selection = app.input().readInt("Select task number (0 to cancel): ");
            if (selection == 0) {
                throw new RuntimeException("Action cancelled");
            }

            Task task = app.taskController().getTask(selection - 1);
            if (task == null) {
                throw new RuntimeException("Invalid task selection");
            }

            boolean choice=app.input().readYesNo("The room "+task.getRoomNum()+" will revert ["+ RoomStatusEnum.fromCode(task.getAfterStatus())+"] to ["+RoomStatusEnum.fromCode(task.getBeforeStatus())+"] ,Continue?");
            if (choice){
                app.taskController().revertTask(app.roomController(), selection - 1);
                app.input().pressAnyKey("Revert Back Success",app.input().SUCCESS);
            }else{
                throw new RuntimeException("Action cancelled");
            }
        }catch (RuntimeException e){
            app.input().pressAnyKey(e.getMessage(),app.input().ERROR);
        }

    }
}

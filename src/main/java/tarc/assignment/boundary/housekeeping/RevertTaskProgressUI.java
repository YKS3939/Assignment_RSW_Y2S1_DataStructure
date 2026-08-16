package tarc.assignment.boundary.housekeeping;

import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.RoomStatusEnum;
import tarc.assignment.entity.Task;

public class RevertTaskProgressUI implements UI {
    private final App app;
    public RevertTaskProgressUI(App app){
        this.app=app;
    }
    @Override
    public void run(){
        try {
            Task task=app.taskController().peekRevert();
            boolean choice=app.input().readYesNo("The room "+task.getRoomNum()+" will revert ["+ RoomStatusEnum.fromCode(task.getAfterStatus())+"] to ["+RoomStatusEnum.fromCode(task.getBeforeStatus())+"] ,Continue?");
            if (choice){
                //revert
                app.taskController().revertTask(app.roomController());
                app.input().pressAnyKey("Revert Back Success",app.input().SUCCESS);
            }else{
                throw new RuntimeException("Action cancelled");
            }
        }catch (NullPointerException e){
            app.input().pressAnyKey("No Record",app.input().ERROR);
        }catch (RuntimeException e){
            app.input().pressAnyKey(e.getMessage(),app.input().ERROR);
        }

    }
}

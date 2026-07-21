package tarc.assignment.boundary.housekeeping;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class updateStatusUI implements UI{
    private final App app;
    public updateStatusUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        int roomNum=app.input().readInt("Enter the Room Number :");
        ConsolePrint.success("room "+ roomNum+" will be updated");
    }
}

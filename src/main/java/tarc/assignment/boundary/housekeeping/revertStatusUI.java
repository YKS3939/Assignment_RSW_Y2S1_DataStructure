package tarc.assignment.boundary.housekeeping;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class revertStatusUI implements UI {
    private final App app;
    public revertStatusUI(App app){
        this.app=app;
    }
    @Override
    public void run(){
        ConsolePrint.println("The room ? status revert [Cleaning->Dirty]");
    }
}

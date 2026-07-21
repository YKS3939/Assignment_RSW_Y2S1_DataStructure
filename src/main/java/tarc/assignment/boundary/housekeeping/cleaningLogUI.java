package tarc.assignment.boundary.housekeeping;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class cleaningLogUI implements UI {
    private final App app;
    public cleaningLogUI(App app){
        this.app=app;
    }
    @Override
    public void run(){
        ConsolePrint.println("Room Number | Status");
    }
}

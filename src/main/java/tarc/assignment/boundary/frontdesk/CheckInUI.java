package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;

public class CheckInUI implements UI {
    private final App app;
    public CheckInUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        String confirmationNum=this.app.input().readString("Enter the guest confirmation Number :");
    }
}

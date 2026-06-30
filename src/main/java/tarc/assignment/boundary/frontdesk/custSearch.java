package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class custSearch implements UI {
    private final App app;

    public custSearch(App app){
        this.app=app;
    }

    @Override
    public void run(){
        String guestId=app.input().readString("Enter guestId :");

        if(guestId.length()==8){
            ConsolePrint.success("Your id is: "+guestId);
        }else {
            ConsolePrint.error("Must be 8 digit! Press [ENTER] key to continue....");
            app.input().pressAnyKey();
        }


    }
}

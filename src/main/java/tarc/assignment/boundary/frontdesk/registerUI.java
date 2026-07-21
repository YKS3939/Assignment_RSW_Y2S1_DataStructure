package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class registerUI implements UI {
    private final App app;

    public registerUI(App app){
        this.app=app;
    }
    @Override
    public void run(){
        String name;
        String phoneNum;
        String icNum;

        ConsolePrint.clear();
        ConsolePrint.println(ConsolePrint.LINE,"Register UI",ConsolePrint.LINE);
        name=this.app.input().readString("Name: ");
        phoneNum=this.app.input().readString("Phone Number: ");
        icNum=this.app.input().readString("MyKad/Passport Number: ");
        ConsolePrint.drawLine();
        ConsolePrint.success("Success,Your id is 12345678 .This is your check-in code\n"+ConsolePrint.SINGLE_LINE+"\n");
        ConsolePrint.println("Press [ENTER] key to continue....");
        this.app.input().pressAnyKey();
    }
}

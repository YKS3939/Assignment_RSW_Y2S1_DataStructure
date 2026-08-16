package tarc.assignment.boundary.guest;

import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.util.ConsolePrint;

public class RegisterGuestUI implements UI {
    private final App app;
    public RegisterGuestUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        try{
            String name=app.input().readString("Enter your name :");
            String phoneNum=app.input().readString("Enter your phoneNum(without '-') :");
            String confirmationNum=this.app.guestController().addCustomer(name,phoneNum);

            ConsolePrint.success(ConsolePrint.SINGLE_LINE+"\nRegister successfully, your 8-digit confirmation number is "+confirmationNum+".\nPlease keep it Carefully\n"+ConsolePrint.SINGLE_LINE);
            app.input().pressAnyKey("Press [ENTER] key to continue....",app.input().SUCCESS);
        } catch (Exception e) {
            ConsolePrint.error(e.getMessage());
            app.input().pressAnyKey("Press [ENTER] key to continue....",app.input().ERROR);
        }
    }
}

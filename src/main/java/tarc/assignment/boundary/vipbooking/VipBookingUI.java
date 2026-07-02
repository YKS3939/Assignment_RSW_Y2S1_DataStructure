package tarc.assignment.boundary.vipbooking;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

//KIM SOON
public class VipBookingUI implements UI {
    private final App app;

    public VipBookingUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.menu("VIP & Loyalty Tier Allocation","1. Register VIP Guest","2. ");
            choice=app.input().readInt("Option: ");
        }while (choice != 0);
    }
}

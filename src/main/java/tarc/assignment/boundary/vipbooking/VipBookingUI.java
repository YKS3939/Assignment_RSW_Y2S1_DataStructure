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
            ConsolePrint.menu("VIP & Loyalty Tier Allocation","1. Register VIP Guest","2. Allocate Room to Top VIP","3. View VIP Queue","4. Reports","0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
        }while (choice != 0);
    }
}

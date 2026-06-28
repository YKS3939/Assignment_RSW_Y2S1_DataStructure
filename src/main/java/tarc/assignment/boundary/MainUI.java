package tarc.assignment.boundary;

import tarc.assignment.boundary.frontdesk.FrontDeskUI;
import tarc.assignment.boundary.housekeeping.HousekeepingUI;
import tarc.assignment.boundary.reward.RewardUI;
import tarc.assignment.boundary.standardbooking.StandardBookingUI;
import tarc.assignment.boundary.vipbooking.VipBookingUI;
import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.Environment;


public class MainUI implements UI {
    private final App app;
    private final StandardBookingUI standardBookingUI;
    private final VipBookingUI vipBookingUI;
    private final HousekeepingUI housekeepingUI;
    private final FrontDeskUI frontDeskUI;
    private final RewardUI rewardUI;

    public MainUI(App app){
        this.app=app;
        this.standardBookingUI=new StandardBookingUI(this.app);
        this.vipBookingUI =new VipBookingUI(this.app);
        this.housekeepingUI=new HousekeepingUI(this.app);
        this.frontDeskUI=new FrontDeskUI(this.app);
        this.rewardUI=new RewardUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.clear();
            ConsolePrint.menu(Environment.get("app.name"),"1. Walk-In Registrations & Standard Booking","2. VIP & Loyalty Tier Allocation","3. Housekeeping & Task Log","4. Front-Desk Service","5. Loyalty and Rewards service","0. Exit Program");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1 -> standardBookingUI.run();
                case 2 -> vipBookingUI.run();
                case 3 -> housekeepingUI.run();
                case 4 -> frontDeskUI.run();
                case 5 -> rewardUI.run();
                case 0 -> ConsolePrint.success("BYEBYE");
                default -> {
                    ConsolePrint.error("Invalid choice! Press [ENTER] key to continue....");
                    app.input().pressAnyKey();
                }
            }
        }while (choice != 0);

    }
}

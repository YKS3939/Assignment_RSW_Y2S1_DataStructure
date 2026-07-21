package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class checkoutUI implements UI {
    private final App app;

    public checkoutUI(App app){
        this.app=app;
    }
    @Override
    public void run(){
        String custID=app.input().readString("Enter customer 8-digit id :");
        //TODO:find room number and billing detail
        ConsolePrint.menu("Bill Details","Days:2","Room Package:Deluxe","Room Number:101","Total Fee:RM 200.00");
        char confirmation=app.input().readChar("Continue to Process?(y/n)");
        switch (Character.toLowerCase(confirmation)){
                case 'y'->{
                    ConsolePrint.success("Checkout success");
                    app.input().pressAnyKey();
                }
                case 'n'-> {
                    ConsolePrint.println("Payment Cancelled, Press [ENTER] key to continue....");
                    app.input().pressAnyKey();
                }
                default -> {
                    ConsolePrint.error("Invalid choice! Press [ENTER] key to continue....");
                    app.input().pressAnyKey();
                }
        }

    }
}

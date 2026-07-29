package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.NumGenerate;

public class ReservationUI implements UI {
    private final App app;
    public ReservationUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        String confirmationNum =app.input().readString("Enter guest 8-digit confirmation Number :");
        int days=app.input().readInt("Enter days of guest want to check-in:");
        ConsolePrint.menu("Do you want to add diet set ?(Only Breakfast)","1. Yes","2. No");
        //房间，人数，时间，是否提供饮食，

    }
}

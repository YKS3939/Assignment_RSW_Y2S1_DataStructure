package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.entity.Guest;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.NumGenerate;

public class ReservationUI implements UI {
    private final App app;
    public ReservationUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        try{
            String userID=this.app.input().readString("Enter the Guest ID :");
            app.reservationController().create(app.guestController(),userID);


        }catch (RuntimeException e){
            app.input().pressAnyKey(e.getMessage(),app.input().ERROR);
        }
    }
}

package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.Reservation;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.NumGenerate;

public class CheckInUI implements UI {
    private final App app;
    public CheckInUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        try{
            char choice;
            ConsolePrint.clear();
            Reservation reservation=app.reservationController().viewNextGuest();
            ConsolePrint.menu("Check-In","Confirmation Id :"+reservation.getConfirmationNum(),"Guest Id :"+reservation.getCustomerId());
            choice=app.input().readChar("Continue to check in process? (y=continue;n=cancelled;d=drop reservation)\nSelection :");
            switch (Character.toLowerCase(choice)){
                case 'y'->{
                    CheckInProcessUI checkInProcessUI=new CheckInProcessUI(app, reservation.getConfirmationNum(), reservation.getCustomerId());
                    checkInProcessUI.run();
                }
                case 'n'->throw new RuntimeException("Process Cancelled");
                case 'd'-> {
                    app.reservationController().dropReservation(reservation.getConfirmationNum());
                    app.input().pressAnyKey("Drop Reservation "+reservation.getConfirmationNum(),app.input().SUCCESS);
                }
                default -> throw new RuntimeException("Invalid choice! Press [ENTER] key to continue....");
            }
        }catch (RuntimeException e){
            app.input().pressAnyKey(e.getMessage(),app.input().ERROR);
        }
    }
}

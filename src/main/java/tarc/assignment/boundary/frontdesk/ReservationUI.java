package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.MemberTierEnum;
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
            char choice;
//            do{
//
//            }while (Character.toLowerCase(choice)!='';

            String userID=this.app.input().readString("Enter the Guest ID :");
            Guest guest=app.guestController().find(userID);
            String memberTier= MemberTierEnum.fromCode(guest.getMemberTier());
            ConsolePrint.menu("User Information","User Id :"+guest.getId(),"Name :"+guest.getName(),"Phone Number :"+guest.getPhoneNum(),"Member Level :"+memberTier,"MemberPoint :"+guest.getMemberPoint());

            choice=app.input().readChar("Do you want to make continue reservation (y/n)?");
            if (Character.toLowerCase(choice)!='y'){
                throw new RuntimeException("Reservation Cancelled");
            }

            String confirmationNum=app.reservationController().addRegistration(app.guestController(),userID);
            ConsolePrint.success("Reservation Successfully, You are adding into queue");
            app.input().pressAnyKey("Your confirmation number is "+confirmationNum,app.input().SUCCESS);

        }catch (RuntimeException e){
            app.input().pressAnyKey(e.getMessage(),app.input().ERROR);
        }
    }
}

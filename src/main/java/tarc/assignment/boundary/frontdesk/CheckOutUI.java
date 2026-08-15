package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.entity.CheckIn;
import tarc.assignment.entity.Guest;
import tarc.assignment.util.ConsolePrint;
import tarc.assignment.util.RubyTime;

public class CheckOutUI implements UI {
    private final App app;
    public CheckOutUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        try{
            String confirmationNum=this.app.input().readString("Enter the Confirmation Code :");
            CheckIn checkIn=app.database().checkInRepository().findByConfirmNum(confirmationNum);
            Guest guest=app.database().guestADT().search(new Guest(checkIn.getCustomerId()));
            ConsolePrint.drawLine();
            ConsolePrint.print("Room Number :"+checkIn.getRoomNum()+"\nGuest Name :"+guest.getName()+"\nCheck In Date :"+ RubyTime.convertFormat(checkIn.getCheckInTime(),"yyyy-MM-dd HH")+"\nCheck Out Deadline :"+RubyTime.convertFormat(checkIn.getCheckOutTime(),"yyyy-MM-dd HH")+"\n" );
            ConsolePrint.drawLine();
            boolean choice=app.input().readYesNo("Do you want to continue process payment?");
            if (choice){
                CheckOutProcessUI checkOutProcessUI=new CheckOutProcessUI(app,checkIn);
                checkOutProcessUI.run();
            }else{
                throw new RuntimeException("Process cancelled");
            }
        } catch (NullPointerException e) {
            app.input().pressAnyKey("Not Found Confirmation Code",app.input().ERROR);
        } catch (RuntimeException e) {
            app.input().pressAnyKey(e.getMessage(),app.input().ERROR);
        }

    }
}

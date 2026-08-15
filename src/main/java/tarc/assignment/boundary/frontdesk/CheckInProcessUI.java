package tarc.assignment.boundary.frontdesk;

import tarc.assignment.boundary.room.AvailableRoomUI;
import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.Environment;


//Must new for each mock or recreate
public class CheckInProcessUI implements UI {
    private final App app;
    private final String confirmationNum;
    private final String customerId;
    private final AvailableRoomUI availableRoomUI;

    public CheckInProcessUI(App app,String confirmationNum,String customerId){
        this.app=app;
        this.confirmationNum=confirmationNum;
        this.customerId=customerId;
        this.availableRoomUI=new AvailableRoomUI(this.app);
    }

    @Override
    public void run(){
        try {
            int day=app.input().readInt("How much of day you want to stay here :");
            boolean meal=app.input().readYesNo("Add breakfast meal set [RM "+ Environment.get("fee.meal") +"/day] ? ");
            availableRoomUI.run();
            String roomNum=app.input().readString("Your room number selection :");
            boolean result=app.checkInController().checkIn(app.roomController(),confirmationNum,roomNum,customerId,meal,day);
            if (result){
                app.reservationController().dropReservation(confirmationNum);
            }
        } catch (RuntimeException e) {
//            e.printStackTrace();
            app.input().pressAnyKey(e.getMessage(),app.input().ERROR);
        }

    }
}

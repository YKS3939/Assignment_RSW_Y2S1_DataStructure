package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.*;
import tarc.assignment.util.ConsolePrint;

public class CheckOutProcessUI implements UI {
    private final App app;
    private final CheckIn checkIn;
    public CheckOutProcessUI(App app,CheckIn checkIn){
        this.app=app;
        this.checkIn=checkIn;
    }

    @Override
    public void run(){
        ConsolePrint.clear();
        CheckOut checkOut=app.checkOutController().processCheckOut(app.roomController(),checkIn);
        ConsolePrint.menu("Payment Receipt","Payment Id :"+checkOut.getId(),"Customer Id ："+checkOut.getCustomerId(),"Customer Name :"+app.guestController().find(checkOut.getCustomerId()).getName(),"Room Number :"+checkOut.getRoomNum(),"Room Type :"+app.roomController().find(checkOut.getRoomNum()).getRoomType(),"Stay Days :"+checkOut.getDays(),"Total Room Price :RM"+checkOut.getRoomFee(),"Total Meal Set Fee :RM"+checkOut.getMealFee(),"Penalty Charge :RM"+checkOut.getPenalty(),"Total :RM"+checkOut.getTotal());
        app.input().pressAnyKey("Payment Success!! Press [ENTER] key to continue.... ",app.input().SUCCESS);
    }
}

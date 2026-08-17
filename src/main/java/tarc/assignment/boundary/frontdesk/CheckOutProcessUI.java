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
        ConsolePrint.menu("Payment Receipt","Payment Id :"+checkOut.id(),"Customer Id ："+checkOut.customerId(),"Customer Name :"+app.guestController().find(checkOut.customerId()).getName(),"Room Number :"+checkOut.roomNum(),"Room Type :"+app.roomController().find(checkOut.roomNum()).getRoomType(),"Stay Days :"+checkOut.days(),"Total Room Price :RM"+checkOut.roomFee(),"Total Meal Set Fee :RM"+checkOut.mealFee(),"Penalty Charge :RM"+checkOut.penalty(),"Total :RM"+checkOut.total());
        app.input().pressAnyKey("Payment Success!! Press [ENTER] key to continue.... ",app.input().SUCCESS);
    }
}

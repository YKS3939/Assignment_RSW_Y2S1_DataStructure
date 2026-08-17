package tarc.assignment.boundary.admin;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.entity.CheckOut;
import tarc.assignment.entity.Guest;
import tarc.assignment.util.ConsolePrint;

public class AdminPaymentDetailUI implements UI {
    private final App app;
    public AdminPaymentDetailUI(App app){
        this.app=app;
    }

    @Override
    public void run() {
        ArrayList<CheckOut> list = app.checkOutController().getRecord();

        ConsolePrint.clear();
        ConsolePrint.drawLine();
        ConsolePrint.success("Payment Details History");
        ConsolePrint.drawLine();

        System.out.printf("%-30s %-8s %-10s %-20s %-6s %-10s %-10s %-10s %-12s%n",
                "ID", "Room", "Cust ID", "Customer Name", "Days", "Penalty", "Meal Fee", "Room Fee", "Total(RM)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

        if (list != null) {
            for (int i = 0; i < list.getSize(); i++) {
                CheckOut co = list.get(i);

                Guest guest = app.guestController().find(co.customerId());
                String customerName = (guest != null) ? guest.getName() : "Unknown";

                System.out.printf("%-30s %-8s %-10s %-20s %-6d %-10.2f %-10.2f %-10.2f %-12.2f%n",
                        co.id(),
                        co.roomNum(),
                        co.customerId(),
                        customerName,
                        co.days(),
                        co.penalty(),
                        co.mealFee(),
                        co.roomFee(),
                        co.total());
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        app.input().pressAnyKey("Press [ENTER] key to continue....", app.input().SUCCESS);
    }
}

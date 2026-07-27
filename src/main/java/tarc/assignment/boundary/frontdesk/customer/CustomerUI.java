package tarc.assignment.boundary.frontdesk.customer;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class CustomerUI implements UI {
    private final App app;
    private final registerUI registerUI;

    public CustomerUI(App app){
        this.app=app;
        this.registerUI=new registerUI(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
        ConsolePrint.menu("Customer Management","1. Register new Customer","2. Search Customer","3. Update customer Info","4. Delete Customer Record","0. Return");
        choice=app.input().readInt("Option: ");
        switch (choice){
            case 1->this.registerUI.run();
            case 0->{return;}
            default -> {
                ConsolePrint.error("Invalid choice! Press [ENTER] key to continue....");
                app.input().pressAnyKey();
            }
        }
        }while (choice != 0);
    }
}

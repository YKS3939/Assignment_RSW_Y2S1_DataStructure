package tarc.assignment.boundary.frontdesk;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class FrontDeskUI implements UI {
    private final App app;
    private final custSearch custSearch;

    public FrontDeskUI(App app){
        this.app=app;
        this.custSearch=new custSearch(this.app);
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.menu("Front-Desk Service",
         "1. Search Guest",
                    "2. Check room availability",
                    "0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
            switch (choice){
                case 1->this.custSearch.run();
            }
        }while (choice != 0);
    }
}



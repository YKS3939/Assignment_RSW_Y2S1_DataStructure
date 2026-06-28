package tarc.assignment.boundary.reward;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.util.ConsolePrint;

public class RewardUI implements UI {
    private final App app;

    public RewardUI(App app){
        this.app=app;
    }

    @Override
    public void run(){
        int choice;
        do{
            ConsolePrint.menu("Loyalty and Rewards service","0. Back to Main Menu");
            choice=app.input().readInt("Option: ");
        }while (choice != 0);
    }
}

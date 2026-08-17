package tarc.assignment.boundary.unknown;

import tarc.assignment.core.App;
import tarc.assignment.core.api.UI;
import tarc.assignment.util.ConsolePrint;

public class Question1UI implements UI {
    private final App app;
    public Question1UI(App app){
        this.app=app;
    }

    @Override
    public void run() {
        int key = (1024 / 256) + (13 % 11);
        ConsolePrint.clear();
        ConsolePrint.menu("Question - Who is our DSA Tutor ?","[1] TAN LAI KIEN","[2] LAM HENG CHAN","[3] RANJINI A/P SHANMUGAM","[4] HAU JOAN","[5] CHAN CHOON KIT","[6] SUHAILAH BINTI FAUZI","[7] THAMARAI A/P SUBRAMANIAM","[8] Answer not at above");
        int choice=app.input().readInt("Selection :");
        if (choice!=key) throw new RuntimeException("Invalid answer");
    }
}

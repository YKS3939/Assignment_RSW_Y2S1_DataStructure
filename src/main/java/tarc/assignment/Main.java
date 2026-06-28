package tarc.assignment;

import tarc.assignment.boundary.MainUI;
import tarc.assignment.core.App;

public class Main {
    public static void main(String[] args) {
        App app=new App();
        MainUI mainUI=new MainUI(app);

        mainUI.run();
    }
}
package tarc.assignment;

import tarc.assignment.boundary.MainUI;
import tarc.assignment.core.App;
import tarc.assignment.core.Database;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        App app = new App(database);
        MainUI mainUI = new MainUI(app);
        mainUI.run();
    }

}
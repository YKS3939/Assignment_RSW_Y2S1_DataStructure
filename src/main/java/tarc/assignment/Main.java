package tarc.assignment;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.boundary.MainUI;
import tarc.assignment.core.App;
import tarc.assignment.core.Database;
import tarc.assignment.dao.GuestDAO;
import tarc.assignment.entity.Guest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database=new Database();
        App app = new App(database);
        MainUI mainUI = new MainUI(app);
        mainUI.run();
    }

}
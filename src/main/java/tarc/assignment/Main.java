package tarc.assignment;

import tarc.assignment.boundary.MainUI;
import tarc.assignment.core.App;
import tarc.assignment.dao.GuestDAO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        MainUI mainUI = new MainUI(app);

        mainUI.run();
    }
}
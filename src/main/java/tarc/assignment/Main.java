package tarc.assignment;

import tarc.assignment.boundary.MainUI;
import tarc.assignment.core.App;
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
//        GuestDAO guestDAO=new GuestDAO();
//        Guest[] guest=guestDAO.readGuest();
//        System.out.println(java.util.Arrays.toString(guest));


        App app = new App();
        MainUI mainUI = new MainUI(app);

        mainUI.run();
    }

}
package tarc.assignment;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.core.Database;
import tarc.assignment.entity.Room;

public class MockTest {
    public static void main(String[] args) {
        Database database = new Database();

        ArrayList<Room> dirtyRooms = database.roomADT().get("Dirty").all();

        for (int i = 0; i < dirtyRooms.getSize(); i++) {
            System.out.println(dirtyRooms.get(i));
        }
    }
}
package tarc.assignment;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.control.RoomController;
import tarc.assignment.core.App;
import tarc.assignment.core.Database;
import tarc.assignment.entity.CheckIn;
import tarc.assignment.entity.Room;
import tarc.assignment.entity.RoomStatusEnum;
import tarc.assignment.entity.Task;

//Here are Trash Can (No la unit testing)
public class MockTest {
    public static void main(String[] args) {
        Database database = new Database();
        App app = new App(database);
        ArrayList<Room> cleanRoom= database.roomADT().get("Cleaning").all();
        ArrayList<Room> dirtyRooms = database.roomADT().get("Dirty").all();
        ArrayList<Room> inspectRooms = database.roomADT().get("Inspected").all();
        ArrayList<Room> readyRooms = database.roomADT().get("Ready").all();

//        app.taskController().pushTask("101",3,4);
//        database.roomDAO().changeStatus("303",4);
//        database.roomDAO().changeService("303",true);
//        CheckIn data=database.checkInRepository().findByConfirmNum("33208955");
//        System.out.println(data.getRoomNum());
//        Room special=database.roomADT().get("Dirty").get(new Room(String.valueOf(301)));
//        System.out.println("Result "+special);
//        RoomController roomController=new RoomController(database);
//        roomController.changeRoomOnService("101",true);
//        System.out.println(database.roomADT().get(RoomStatusEnum.fromCode(3)).get(new Room("101")));
//        ArrayList<CheckIn> checkInArrayList=database.checkInDAO().readAll();
//        System.out.println(checkInArrayList.getSize());
//        String res=roomController.findSet(new Room("202"));
//        System.out.println(res);
//        ArrayList<Room> list=roomController.getAvailableRoom();
//        for (int i = 0; i < list.getSize(); i++) {
//            System.out.println(list.get(i));
//        }
//        roomController.updateRoomStatus(String.valueOf(301),1);


//
//        for (int i = 0; i < cleanRoom.getSize(); i++) {
//            System.out.println("Cleaning "+cleanRoom.get(i).getRoomNum());
//        }
//        for (int i = 0; i < dirtyRooms.getSize(); i++) {
//            System.out.println("Dirty "+dirtyRooms.get(i).getRoomNum());
//        }
//        for (int i = 0; i < inspectRooms.getSize(); i++) {
//            System.out.println("Inspected "+inspectRooms.get(i).getRoomNum());
//        }
//        for (int i = 0; i < readyRooms.getSize(); i++) {
//            System.out.println("Ready "+readyRooms.get(i).getRoomNum());
//        }
    }
}
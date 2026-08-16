package tarc.assignment.control;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.adt.ArraySet;
import tarc.assignment.core.Database;
import tarc.assignment.entity.Room;
import tarc.assignment.entity.RoomStatusEnum;

import java.util.Objects;

public class RoomController {
    private final Database database;

    public RoomController(Database database){
        this.database=database;
    }

    public void updateRoomStatus(String roomNum,int status){
        System.out.println(database.roomADT().get(RoomStatusEnum.fromCode(status)).get(new Room(roomNum)));
    }

    public String findSet(Room room) {
        if (room == null) return null;

        for (RoomStatusEnum statusEnum : RoomStatusEnum.values()) {
            String enumName = statusEnum.getName();
            ArraySet<Room> list = database.roomADT().get(enumName);
            if (list != null && list.get(room) != null) {
                return enumName;
            }
        }

        throw new RuntimeException("The room not found");
    }

    //don't touch !!!!!!!
    public ArrayList<Room> viewAllRoom(){
            ArrayList<Room> items=new ArrayList<>(25);
            for (RoomStatusEnum statusEnum : RoomStatusEnum.values()) {
                String enumName=statusEnum.getName();
                ArraySet<Room> list=database.roomADT().get(enumName);
                if (list != null) {
                    for (int i = 0; i < list.getSize(); i++) {
                        items.add(list.get(i));
                    }
                }
            }
            return items;
        }

    public ArrayList<Room> getAvailableRoom(){
        ArrayList<Room> items=new ArrayList<>(25);
        for (int i = 0; i < database.roomADT().get("Ready").getSize(); i++) {
            Room item=database.roomADT().get("Ready").get(i);
            if (item.isOnService()){
                items.add(item);
            }
        }
        return items;
    }

    public boolean isExistSet(String roomNum, String setName) {
        ArraySet<Room> roomSet = database.roomADT().get(setName);

        if (roomSet == null) {return false;}

        for (int i = 0; i < roomSet.getSize(); i++) {
            Room item = roomSet.get(i);
            if (item != null && Objects.equals(item.getRoomNum(), roomNum)) {
                return true;
            }
        }

        return false;
    }

    public int nextSet(String status) {
        int now = RoomStatusEnum.fromName(status);
        return (now >= 4) ? 1:now + 1;
    }

    public String nextName(int status) {
        int nextCode = (status >= 4) ? 1 : status + 1;
        return RoomStatusEnum.fromCode(nextCode);
    }

    public void changeRoomStatus(String roomNum, int status) {
        Room tempRoom = new Room(roomNum);
        String setNowName = findSet(tempRoom);

        Room room = database.roomADT().get(setNowName).get(tempRoom);
        boolean result = database.roomADT().get(setNowName).remove(tempRoom);

        if (result) {
            room.setStatus(status);
            database.roomADT().get(RoomStatusEnum.fromCode(status)).add(room);
            database.roomDAO().changeStatus(roomNum, status);
        } else {
            throw new RuntimeException("Memory Garbage Collector Clone Conflict");
        }
    }

    public void changeRoomOnService(String roomNum,boolean onService){
        //TODO:need check
        String roomPlace= findSet(new Room(roomNum));
        database.roomADT().get(roomPlace).get(new Room(roomNum)).setOnService(onService);
        database.roomDAO().changeService(roomNum,onService);
    }

    public Room find(String roomNum){
        if (roomNum.trim().isEmpty()) {
            return null;
        }
        return find(new Room(roomNum));
    }

    public Room find(Room room) {
        if (room == null) return null;

        for (RoomStatusEnum statusEnum : RoomStatusEnum.values()) {
            ArraySet<Room> list = database.roomADT().get(statusEnum.getName());
            if (list != null) {
                Room target = list.get(room);
                if (target != null) {
                    return target;
                }
            }
        }
        return null;
    }

}

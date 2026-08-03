package tarc.assignment.entity;

public class Room {
    private int roomNum;
    private String roomType;
    private float roomPrice;
    private boolean onService;

    public Room(int roomNum, String roomType, float roomPrice, boolean onService) {
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.onService = onService;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    public boolean isOnService() {
        return onService;
    }

    public void setOnService(boolean onService) {
        this.onService = onService;
    }
}

package tarc.assignment.entity;

import java.util.Objects;

public class Room implements Comparable<Room>{
    private String roomNum;
    private String roomType;
    private float roomPrice;
    private boolean onService;
    private int status;

    public Room(String roomNum, String roomType, float roomPrice, boolean onService,int status) {
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.onService = onService;
        this.status=status;
    }

    public Room(String roomNum){
        this.roomNum=roomNum;
    }

    @Override
    public int compareTo(Room other) {
        return this.roomNum.compareTo(other.getRoomNum());
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //this method are use AI
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room other = (Room) obj;
        return Objects.equals(this.roomNum, other.roomNum);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNum='" + roomNum + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomPrice=" + roomPrice +
                ", onService=" + onService +
                ", status=" + status +
                '}';
    }
}

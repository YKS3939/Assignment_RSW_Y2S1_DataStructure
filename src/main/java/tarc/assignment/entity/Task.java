package tarc.assignment.entity;

/**
 * For HouseKeeping task - Ma Chun Yen
 */
public class Task {
    private String id;
    private String roomNum;
    private int beforeStatus;
    private int afterStatus;

    public Task(String id, String roomNum, int beforeStatus, int afterStatus) {
        this.id = id;
        this.roomNum = roomNum;
        this.beforeStatus = beforeStatus;
        this.afterStatus = afterStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public int getBeforeStatus() {
        return beforeStatus;
    }

    public void setBeforeStatus(int beforeStatus) {
        this.beforeStatus = beforeStatus;
    }

    public int getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(int afterStatus) {
        this.afterStatus = afterStatus;
    }

}

package tarc.assignment.entity;

import java.time.Instant;

/**
 * For HouseKeeping task - Ma Chun Yen
 */
public class Task {
    private String id;
    private String roomNum;
    private int beforeStatus;
    private int afterStatus;
    private Instant createAt;

    public Task(String id, String roomNum, int beforeStatus, int afterStatus,Instant createAt) {
        this.id = id;
        this.roomNum = roomNum;
        this.beforeStatus = beforeStatus;
        this.afterStatus = afterStatus;
        this.createAt=createAt;
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

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }
}

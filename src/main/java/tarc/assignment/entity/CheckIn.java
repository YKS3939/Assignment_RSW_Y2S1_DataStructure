package tarc.assignment.entity;

import java.time.Instant;

/**
 * Ng Zhun Onn
 */
public class CheckIn {
    private String confirmationNum;
    private String roomNum;
    private String customerId;
    private boolean meal;
    private Instant checkInTime;
    private Instant checkOutTime;

    public CheckIn(String confirmationNum, String roomNum, String customerId, boolean meal, Instant checkInTime, Instant checkOutTime) {
        this.confirmationNum = confirmationNum;
        this.roomNum = roomNum;
        this.customerId = customerId;
        this.meal = meal;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public String getConfirmationNum() {
        return confirmationNum;
    }

    public void setConfirmationNum(String confirmationNum) {
        this.confirmationNum = confirmationNum;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public boolean isMeal() {
        return meal;
    }

    public void setMeal(boolean meal) {
        this.meal = meal;
    }

    public Instant getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Instant checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Instant getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Instant checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}

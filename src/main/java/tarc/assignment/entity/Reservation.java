package tarc.assignment.entity;

import java.time.Instant;

public class Reservation {
    private String id;
    private String confirmationNum;
    private Instant checkInTime;
    private Instant checkOutTime;

    public Reservation(String id, String confirmationNum, Instant checkInTime, Instant checkOutTime) {
        this.id = id;
        this.confirmationNum = confirmationNum;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfirmationNum() {
        return confirmationNum;
    }

    public void setConfirmationNum(String confirmationNum) {
        this.confirmationNum = confirmationNum;
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

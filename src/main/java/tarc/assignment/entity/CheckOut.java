package tarc.assignment.entity;

import java.math.BigDecimal;
import java.time.Instant;

public class CheckOut {
    private String id;
    private String roomNum;
    private String customerId;
    private BigDecimal penalty;
    private BigDecimal mealFee;
    private BigDecimal roomFee;
    private BigDecimal total;
    private int days;
    private Instant checkOutTime;

    public CheckOut(String id, String roomNum, String customerId, BigDecimal penalty, BigDecimal mealFee, BigDecimal roomFee, BigDecimal total, int days, Instant checkOutTime) {
        this.id = id;
        this.roomNum = roomNum;
        this.customerId = customerId;
        this.penalty = penalty;
        this.mealFee = mealFee;
        this.roomFee = roomFee;
        this.total = total;
        this.days = days;
        this.checkOutTime = checkOutTime;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getPenalty() {
        return penalty;
    }

    public void setPenalty(BigDecimal penalty) {
        this.penalty = penalty;
    }

    public BigDecimal getMealFee() {
        return mealFee;
    }

    public BigDecimal getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(BigDecimal roomFee) {
        this.roomFee = roomFee;
    }

    public void setMealFee(BigDecimal mealFee) {
        this.mealFee = mealFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Instant getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Instant checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}

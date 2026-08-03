package tarc.assignment.entity;

import java.time.Instant;

public class Reservation {
    private String confirmationNum;
    private String customerId;

    public Reservation(String confirmationNum, String customerId) {
        this.confirmationNum = confirmationNum;
        this.customerId = customerId;
    }

    public String getConfirmationNum() {
        return confirmationNum;
    }

    public void setConfirmationNum(String confirmationNum) {
        this.confirmationNum = confirmationNum;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}

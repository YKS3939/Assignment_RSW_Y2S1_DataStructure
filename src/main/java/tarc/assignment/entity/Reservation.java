package tarc.assignment.entity;

import java.time.Instant;

public class Reservation implements Comparable<Reservation>{
    private String confirmationNum;
    private String customerId;
    private int memberTier;
    private Instant createAt;

    public Reservation(String confirmationNum, String customerId, int memberTier, Instant createAt) {
        this.confirmationNum = confirmationNum;
        this.customerId = customerId;
        this.memberTier = memberTier;
        this.createAt = createAt;
    }

    public int getMemberTier() {
        return memberTier;
    }

    public void setMemberTier(int memberTier) {
        this.memberTier = memberTier;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
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

    @Override
    public int compareTo(Reservation other) {
        return this.confirmationNum.compareTo(other.getConfirmationNum());
    }
}

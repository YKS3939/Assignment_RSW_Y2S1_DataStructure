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
        if (other == null) return 1;

        int tierCompare = Integer.compare(this.memberTier, other.getMemberTier());
        if (tierCompare != 0) {
            return tierCompare;
        }

        if (this.createAt != null && other.getCreateAt() != null) {
            int timeCompare = other.getCreateAt().compareTo(this.createAt);
            if (timeCompare != 0) {
                return timeCompare;
            }
        }

        if (this.confirmationNum != null && other.getConfirmationNum() != null) {
            return this.confirmationNum.compareTo(other.getConfirmationNum());
        }

        return 0;
    }
}

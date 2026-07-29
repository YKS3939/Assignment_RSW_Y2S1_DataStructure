package tarc.assignment.entity;

public class Guest implements Comparable<Guest>{
    private String confirmationNum;
    private String name;
    private int memberTier;
    private String phoneNum;

    public Guest(String confirmationNum, String name, int memberTier, String phoneNum) {
        this.confirmationNum = confirmationNum;
        this.name = name;
        this.memberTier = memberTier;
        this.phoneNum = phoneNum;
    }

    @Override
    public int compareTo(Guest other) {
        return this.confirmationNum.compareTo(other.getConfirmationNum());
    }

    public String getConfirmationNum() {
        return confirmationNum;
    }

    public void setConfirmationNum(String confirmationNum) {
        this.confirmationNum = confirmationNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberTier() {
        return memberTier;
    }

    public void setMemberTier(int memberTier) {
        this.memberTier = memberTier;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}

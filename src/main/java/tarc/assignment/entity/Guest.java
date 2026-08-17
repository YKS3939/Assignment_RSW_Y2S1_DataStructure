package tarc.assignment.entity;

public class Guest implements Comparable<Guest>{
    private String id;
    private String name;
    private int memberTier;
    private int memberPoint;
    private String phoneNum;

    public Guest(String id) {
        this.id = id;
    }

    public Guest(String id, String name, int memberTier, int memberPoint, String phoneNum) {
        this.id = id;
        this.name = name;
        this.memberTier = memberTier;
        this.memberPoint= memberPoint;
        this.phoneNum = phoneNum;
    }

    @Override
    public int compareTo(Guest other) {
        return this.id.compareTo(other.getId());
    }
    //TODO:change to member tier
    // no la babi binary tree tk payah member tier

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getMemberPoint() {
        return memberPoint;
    }

    public void setMemberPoint(int memberPoint) {
        this.memberPoint = memberPoint;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}

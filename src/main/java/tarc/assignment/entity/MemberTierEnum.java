package tarc.assignment.entity;

public enum MemberTierEnum {
    BASIC(1,"Basic"),
    ELITE(2,"Elite"),
    DIAMOND(3,"Diamond"),
    PLATINUM(4,"Platinum");

    private final int code;
    private final String name;

    MemberTierEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * This method are use AI code generation - Ma Chun Yen
     */
    public static String fromCode(int code) {
        for (MemberTierEnum tier : MemberTierEnum.values()) {
            if (tier.getCode() == code) {
                return tier.name;
            }
        }
        throw new IllegalArgumentException("Invalid MemberTier code: " + code);
    }
}

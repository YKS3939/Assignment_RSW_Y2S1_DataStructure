package tarc.assignment.entity;

public enum RoomStatusEnum {
    DIRTY(1,"Dirty"),
    CLEANING(2,"Cleaning"),
    INSPECTED(3,"Inspected"),
    READY(4,"Ready"),
    ;

    private final int code;
    private final String name;

    RoomStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }


    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String fromCode(int code) {
        for (RoomStatusEnum tier : RoomStatusEnum.values()) {
            if (tier.getCode() == code) {
                return tier.name;
            }
        }
        throw new IllegalArgumentException("Invalid RoomStatus code: " + code);
    }

    public static int fromName(String enumName) {
        for (RoomStatusEnum status : RoomStatusEnum.values()) {
            if (status.name().equalsIgnoreCase(enumName)) {
                return status.getCode();
            }
        }
        throw new IllegalArgumentException("Invalid RoomStatus enum name: " + enumName);
    }
}

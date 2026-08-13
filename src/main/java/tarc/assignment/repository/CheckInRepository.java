package tarc.assignment.repository;

import tarc.assignment.adt.HashTable;
import tarc.assignment.entity.CheckIn;

public class CheckInRepository {
    private final HashTable<String, CheckIn> confirmHash = new HashTable<>();
    private final HashTable<String, CheckIn> roomNumHash = new HashTable<>();
    private final HashTable<String, CheckIn> custIdHash = new HashTable<>();

    public void add(CheckIn checkIn) {
        confirmHash.add(checkIn.getConfirmationNum(),checkIn);
        roomNumHash.add(checkIn.getRoomNum(),checkIn);
        custIdHash.add(checkIn.getCustomerId(),checkIn);
    }

    public void remove(CheckIn checkIn){
        confirmHash.remove(checkIn.getConfirmationNum());
        roomNumHash.remove(checkIn.getRoomNum());
        custIdHash.remove(checkIn.getCustomerId());
    }

    public CheckIn findByConfirmNum(String confirmationNum) {
        return confirmHash.get(confirmationNum);
    }

    public CheckIn findByRoomNum(String roomNum) {
        return roomNumHash.get(roomNum);
    }

    public CheckIn CustomerId(String customerId) {
        return custIdHash.get(customerId);
    }

}

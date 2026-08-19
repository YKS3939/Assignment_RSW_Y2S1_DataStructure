package tarc.assignment.repository;

import tarc.assignment.adt.HashTable;
import tarc.assignment.entity.Reservation;

public class ReservationRepository {
    private final HashTable<String, Reservation> confirmHash = new HashTable<>();
    private final HashTable<String, Reservation> custIdHash = new HashTable<>();

    public void add(Reservation reservation) {
        confirmHash.add(reservation.getConfirmationNum(),reservation);
        custIdHash.add(reservation.getCustomerId(),reservation);
    }

    public void remove(Reservation reservation){
        if (reservation == null) {
            return;
        }
        if (reservation.getConfirmationNum() != null) {
            confirmHash.remove(reservation.getConfirmationNum());
        }
        if (reservation.getCustomerId() != null) {
            custIdHash.remove(reservation.getCustomerId());
        }
    }

    public Reservation findByConfirmNum(String confirmationNum) {
        return confirmHash.get(confirmationNum);
    }

    public Reservation findByCustomerId(String customerId) {
        return custIdHash.get(customerId);
    }

    public boolean existByConfirmNum(String confirmationNum) {
        if (confirmationNum == null) {
            return false;
        }
        return confirmHash.get(confirmationNum) != null;
    }

    public void clear(){
        confirmHash.clear();
        custIdHash.clear();
    }
}

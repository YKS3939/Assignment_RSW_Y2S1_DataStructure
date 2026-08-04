package tarc.assignment.core;

import tarc.assignment.adt.*;
import tarc.assignment.dao.GuestDAO;
import tarc.assignment.dao.ReservationDAO;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.Reservation;

public class Database {
    private final GuestDAO guestDAO;
    private final ReservationDAO reservationDAO;

    private final BinaryTree<Guest> guestADT=new BinaryTree<>();
    private final Queue<Reservation> standardBookingADT=new Queue<>();
    private final MaxHeap<Reservation> vipBookingADT=new MaxHeap<>();
    private final HashTable<String,Reservation> reservationADT=new HashTable<>();
    //TODO: Remain Stack adt

    public Database(){
        this.guestDAO=new GuestDAO();
        this.reservationDAO=new ReservationDAO();
        loadGuestADT();
        loadReservationADT();
    }

    public GuestDAO guestDAO(){
        return guestDAO;
    }

    public ReservationDAO reservationDAO(){return reservationDAO;}

    public BinaryTree<Guest> guestADT(){
        return guestADT;
    }

    public HashTable<String,Reservation> reservationADT(){return reservationADT;}

    private void loadGuestADT(){
        guestADT.clear();
        ArrayList<Guest> List = guestDAO.readAll();
        for (int i = 0; i < List.getSize(); i++) {
            Guest item = List.get(i);
            if (item != null) {
                guestADT.insert(item);
            }
        }
    }
    private void loadReservationADT(){
        reservationADT.clear();
        ArrayList<Reservation> List = reservationDAO.readAll();
        for (int i = 0; i < List.getSize(); i++) {
            Reservation item = List.get(i);
            if (item != null) {
                reservationADT.add(item.getConfirmationNum(),item);
            }
        }
    }
}

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
        initGuestADT();
    }

    public GuestDAO guestDAO(){
        return guestDAO;
    }

    public ReservationDAO reservationDAO(){return reservationDAO;}

    public BinaryTree<Guest> guestADT(){
        return guestADT;
    }

    private void initGuestADT(){
        ArrayList<Guest> initialList = guestDAO.readGuest();
        for (int i = 0; i < initialList.getSize(); i++) {
            Guest guest = initialList.get(i);
            if (guest != null) {
                guestADT.insert(guest);
            }
        }
    }
}

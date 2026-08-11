package tarc.assignment.core;

import tarc.assignment.adt.*;
import tarc.assignment.dao.GuestDAO;
import tarc.assignment.dao.ReservationDAO;
import tarc.assignment.dao.RoomDAO;
import tarc.assignment.entity.*;

public class Database {
    private final GuestDAO guestDAO;
    private final ReservationDAO reservationDAO;
    private final RoomDAO roomDAO;

    private final BinaryTree<Guest> guestADT=new BinaryTree<>();
    private final Queue<Reservation> standardBookingADT=new Queue<>();
    private final MaxHeap<Reservation> vipBookingADT=new MaxHeap<>();
    private final HashTable<String,Reservation> reservationADT=new HashTable<>();
    private final Stack<Task> taskADT=new Stack<>();
    private final HashTable<String,Set<Room>> roomADT=new HashTable<>();

    //TODO: Remain Stack adt

    public Database(){
        this.guestDAO=new GuestDAO();
        this.reservationDAO=new ReservationDAO();
        this.roomDAO=new RoomDAO();
        loadGuestADT();
        loadReservationADT();
        loadRoomADT();
    }

    public GuestDAO guestDAO(){
        return guestDAO;
    }

    public ReservationDAO reservationDAO(){return reservationDAO;}

    public RoomDAO roomDAO(){return roomDAO;}

    public BinaryTree<Guest> guestADT(){
        return guestADT;
    }

    public HashTable<String,Reservation> reservationADT(){return reservationADT;}

    public Queue<Reservation> standardBookingADT(){
        return standardBookingADT;
    }

    public MaxHeap<Reservation> vipBookingADT(){
        return vipBookingADT;
    }

    public HashTable<String,Set<Room>> roomADT(){return roomADT;}

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
        standardBookingADT.clear();
        vipBookingADT.clear();

        ArrayList<Reservation> List = reservationDAO.readAll();
        for (int i = 0; i < List.getSize(); i++) {
            Reservation item = List.get(i);
            if (item != null) {
                reservationADT.add(item.getConfirmationNum(),item);
                if (item.getMemberTier()> MemberTierEnum.BASIC.getCode()){
                    vipBookingADT.insert(item);
                }else{
                    standardBookingADT.enqueue(item);
                }
            }
        }
    }
    private void loadRoomADT() {
        roomADT.clear();
        for (RoomStatusEnum status : RoomStatusEnum.values()) {
            roomADT.add(status.getName(), new Set<>());
        }

        ArrayList<Room> list = roomDAO.readAll();
        for (int i = 0; i < list.getSize(); i++) {
            Room item = list.get(i);
            if (item != null) {
                String statusName = RoomStatusEnum.fromCode(item.getStatus());
                Set<Room> roomSet = roomADT.get(statusName);
                if (roomSet != null) {
                    roomSet.add(item);
                }
            }
        }
    }
}

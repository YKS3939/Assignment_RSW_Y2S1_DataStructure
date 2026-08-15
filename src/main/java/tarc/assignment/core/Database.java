package tarc.assignment.core;

import tarc.assignment.adt.*;
import tarc.assignment.dao.*;
import tarc.assignment.entity.*;
import tarc.assignment.repository.CheckInRepository;
import tarc.assignment.repository.ReservationRepository;

public class Database {
    private final GuestDAO guestDAO=new GuestDAO();
    private final ReservationDAO reservationDAO=new ReservationDAO();
    private final RoomDAO roomDAO=new RoomDAO();
    private final CheckInDAO checkInDAO=new CheckInDAO();
    private final TaskDAO taskDAO=new TaskDAO();
    private final CheckOutDAO checkOutDAO=new CheckOutDAO();

    private final BinaryTree<Guest> guestADT=new BinaryTree<>();
    private final Queue<Reservation> standardBookingADT=new Queue<>();
    private final MaxHeap<Reservation> vipBookingADT=new MaxHeap<>();
//    private final HashTable<String,Reservation> reservationADT=new HashTable<>();
    private final LinkedStack<Task> taskADT=new LinkedStack<>();
    private final HashTable<String,Set<Room>> roomADT=new HashTable<>();
    private final ArrayList<CheckOut> checkOutADT=new ArrayList<>(25);

    private final CheckInRepository checkInRepository=new CheckInRepository();
    private final ReservationRepository reservationRepository=new ReservationRepository();


    public Database(){
        loadGuestADT();
        loadReservationADT();
        loadRoomADT();
        loadCheckInRepo();
        loadTaskADT();
        //TODO:init checkOut DAO
    }

    public GuestDAO guestDAO(){
        return guestDAO;
    }

    public ReservationDAO reservationDAO(){return reservationDAO;}

    public RoomDAO roomDAO(){return roomDAO;}

    public CheckInDAO checkInDAO(){return checkInDAO;}

    public TaskDAO taskDAO(){return taskDAO;}

    public BinaryTree<Guest> guestADT(){
        return guestADT;
    }

    public CheckOutDAO checkOutDAO(){return  checkOutDAO;}

//    public HashTable<String,Reservation> reservationADT(){return reservationADT;}

    public Queue<Reservation> standardBookingADT(){
        return standardBookingADT;
    }

    public MaxHeap<Reservation> vipBookingADT(){
        return vipBookingADT;
    }

    public HashTable<String,Set<Room>> roomADT(){return roomADT;}

    public LinkedStack<Task> taskADT(){return taskADT;}

    public ArrayList<CheckOut> checkOutADT(){return checkOutADT;}

    public CheckInRepository checkInRepository(){return checkInRepository;}

    public ReservationRepository reservationRepository(){return reservationRepository;}

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
        reservationRepository.clear();
//        reservationADT.clear();
        standardBookingADT.clear();
        vipBookingADT.clear();

        ArrayList<Reservation> List = reservationDAO.readAll();
        for (int i = 0; i < List.getSize(); i++) {
            Reservation item = List.get(i);
            if (item != null) {
                reservationRepository.add(item);
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

    private void loadCheckInRepo(){
        //TODO: add clear
        checkInRepository.clear();
        ArrayList<CheckIn> list = checkInDAO.readAll();
        for (int i = 0; i < list.getSize(); i++) {
            checkInRepository.add(list.get(i));
        }
    }

    private void loadTaskADT(){
        taskADT.clear();
        ArrayList<Task> list = taskDAO.readAll();
        for (int i = 0; i < list.getSize(); i++) {
            taskADT.push(list.get(i));
        }
    }
}

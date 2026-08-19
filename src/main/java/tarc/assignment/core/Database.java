package tarc.assignment.core;

import tarc.assignment.adt.*;
import tarc.assignment.dao.*;
import tarc.assignment.entity.*;
import tarc.assignment.repository.CheckInRepository;
import tarc.assignment.repository.ReservationRepository;

/**
 * Yap Kim Soon, Ma Chun Yen, Goh Wen Ting, Ng Zhun Onn
 */
public class Database {
    private final GuestDAO guestDAO = new GuestDAO();
    private final ReservationDAO reservationDAO = new ReservationDAO();
    private final RoomDAO roomDAO = new RoomDAO();
    private final CheckInDAO checkInDAO = new CheckInDAO();
    private final TaskDAO taskDAO = new TaskDAO();
    private final CheckOutDAO checkOutDAO = new CheckOutDAO();

    private final BinaryTree<Guest> guestADT = new BinaryTree<>();
    private final LinkedQueue<Reservation> standardBookingADT = new LinkedQueue<>();
    private final MaxHeap<Reservation> vipBookingADT = new MaxHeap<>();
    // private final HashTable<String,Reservation> reservationADT=new HashTable<>();
    private final ArrayList<Task> taskADT = new ArrayList<>(25);
    private final HashTable<String, ArraySet<Room>> roomADT = new HashTable<>();
    private final ArrayList<CheckOut> checkOutADT = new ArrayList<>(25);

    private final CheckInRepository checkInRepository = new CheckInRepository();
    private final ReservationRepository reservationRepository = new ReservationRepository();

    public Database() {
        loadGuestADT();
        loadReservationADT();
        loadRoomADT();
        loadCheckInRepo();
        loadTaskADT();
        loadCheckOutADT();
    }

    public GuestDAO guestDAO() {
        return guestDAO;
    }

    public ReservationDAO reservationDAO() {
        return reservationDAO;
    }

    public RoomDAO roomDAO() {
        return roomDAO;
    }

    public CheckInDAO checkInDAO() {
        return checkInDAO;
    }

    public TaskDAO taskDAO() {
        return taskDAO;
    }

    public BinaryTree<Guest> guestADT() {
        return guestADT;
    }

    public CheckOutDAO checkOutDAO() {
        return checkOutDAO;
    }

    // public HashTable<String,Reservation> reservationADT(){return reservationADT;}

    public LinkedQueue<Reservation> standardBookingADT() {
        return standardBookingADT;
    }

    public MaxHeap<Reservation> vipBookingADT() {
        return vipBookingADT;
    }

    public HashTable<String, ArraySet<Room>> roomADT() {
        return roomADT;
    }

    public ArrayList<Task> taskADT() {
        return taskADT;
    }

    public ArrayList<CheckOut> checkOutADT() {
        return checkOutADT;
    }

    public CheckInRepository checkInRepository() {
        return checkInRepository;
    }

    public ReservationRepository reservationRepository() {
        return reservationRepository;
    }

    public void loadGuestADT() {
        guestADT.clear();
        ArrayList<Guest> List = guestDAO.readAll();
        for (int i = 0; i < List.getSize(); i++) {
            Guest item = List.get(i);
            if (item != null) {
                guestADT.insert(item);
            }
        }
    }

    public void loadReservationADT() {
        reservationRepository.clear();
        // reservationADT.clear();
        standardBookingADT.clear();
        vipBookingADT.clear();

        ArrayList<Reservation> List = reservationDAO.readAll();
        for (int i = 0; i < List.getSize(); i++) {
            Reservation item = List.get(i);
            if (item != null) {
                reservationRepository.add(item);
                if (item.getMemberTier() > MemberTierEnum.BASIC.getCode()) {
                    vipBookingADT.insert(item);
                } else {
                    standardBookingADT.enqueue(item);
                }
            }
        }
    }

    private void loadRoomADT() {
        roomADT.clear();
        for (RoomStatusEnum status : RoomStatusEnum.values()) {
            roomADT.add(status.getName(), new ArraySet<>());
        }

        ArrayList<Room> list = roomDAO.readAll();
        for (int i = 0; i < list.getSize(); i++) {
            Room item = list.get(i);
            if (item != null) {
                String statusName = RoomStatusEnum.fromCode(item.getStatus());
                ArraySet<Room> roomSet = roomADT.get(statusName);
                if (roomSet != null) {
                    roomSet.add(item);
                }
            }
        }
    }

    private void loadCheckInRepo() {
        // TODO: add clear
        checkInRepository.clear();
        ArrayList<CheckIn> list = checkInDAO.readAll();
        for (int i = 0; i < list.getSize(); i++) {
            checkInRepository.add(list.get(i));
        }
    }

    private void loadTaskADT() {
        taskADT.clear();
        ArrayList<Task> list = taskDAO.readAll();
        for (int i = 0; i < list.getSize(); i++) {
            taskADT.add(list.get(i));
        }
    }

    private void loadCheckOutADT() {
        checkOutADT.clear();
        ArrayList<CheckOut> list = checkOutDAO.readAll();
        for (int i = 0; i < list.getSize(); i++) {
            checkOutADT.add(list.get(i));
        }
    }
}

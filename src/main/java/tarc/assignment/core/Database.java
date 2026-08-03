package tarc.assignment.core;

import tarc.assignment.adt.ArrayList;
import tarc.assignment.adt.BinaryTree;
import tarc.assignment.dao.GuestDAO;
import tarc.assignment.entity.Guest;

public class Database {
    private final GuestDAO guestDAO;
    private final BinaryTree<Guest> guestADT=new BinaryTree<>();

    public Database(){
        this.guestDAO=new GuestDAO();
        initGuestADT();
    }

    public GuestDAO guestDAO(){
        return guestDAO;
    }

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

package tarc.assignment.control;

import tarc.assignment.adt.BinaryTree;
import tarc.assignment.core.Database;
import tarc.assignment.dao.GuestDAO;
import tarc.assignment.entity.Guest;
import tarc.assignment.util.NumGenerate;
import tarc.assignment.validate.GuestValidate;

import java.util.Objects;

public class GuestController {
    private final Database database;

    public GuestController(Database database){
        this.database=database;
    }

    public String addCustomer(String name,String phoneNum){
        try {
            String custId = NumGenerate.generateDigit(6);

            GuestValidate.validateName(name);
            GuestValidate.validatePhone(phoneNum);

            while (true){
                if (isIdExist(custId)){
                    custId=NumGenerate.generateDigit(6);
                }else{
                    break;
                }
            }

            Guest guest=new Guest(custId,name,1,0,phoneNum);
            this.database.guestDAO().create(guest);
            this.database.guestADT().insert(guest);
            return custId;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean isIdExist(String id) {
        return database.guestADT().search(new Guest(id)) != null;
    }

    public boolean login(String userID,String phoneNum) {
        try {
            Guest guest = database.guestADT().search(new Guest(userID));
            if (Objects.equals(guest.getId(), userID) && Objects.equals(guest.getPhoneNum(), phoneNum)) {
                return true;
            }
            return false;
        }catch (NullPointerException e){
            return false;
        }
    }

    public Guest find(String userID){
        try{
            Guest data=database.guestADT().search(new Guest(userID));
            if (data==null){
                throw new NullPointerException();
            }
            return data;
        }catch (NullPointerException e){
            throw new RuntimeException("Not Found the User");
        }
    }
}

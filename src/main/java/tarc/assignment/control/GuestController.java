package tarc.assignment.control;

import tarc.assignment.dao.GuestDAO;
import tarc.assignment.entity.Guest;
import tarc.assignment.util.NumGenerate;
import tarc.assignment.validate.GuestValidate;

public class GuestController {
    private final GuestDAO guestDAO;

    public GuestController(){
        this.guestDAO=new GuestDAO();
    }

    public String addCustomer(String name,String phoneNum){
        try {
            String randomNum = NumGenerate.generateDigit(8);

            GuestValidate.validateName(name);
            GuestValidate.validatePhone(phoneNum);

            //TODO: use frontdesk module to verify the guest id are exist,if exist, regenerade again

            Guest guest=new Guest(randomNum,name,1,phoneNum);
            this.guestDAO.create(guest);

            //TODO: the data must store into frontdesk binary tree OR hashmap

            return randomNum;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

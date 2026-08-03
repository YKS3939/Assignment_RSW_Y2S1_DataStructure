package tarc.assignment.boundary.guest;

import tarc.assignment.core.App;
import tarc.assignment.core.UI;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.MemberTierEnum;
import tarc.assignment.util.ConsolePrint;

public class GuestProfileUI implements UI {
    private final App app;
    private final String userID;
    public GuestProfileUI(App app, String userID){
        this.app=app;
        this.userID=userID;
    }

    @Override
    public void run(){
        try {
            ConsolePrint.clear();
            Guest guest=app.guestController().find(userID);
            String memberTier= MemberTierEnum.fromCode(guest.getMemberTier());
            //ConsolePrint.println(ConsolePrint.LINE,"User Profile",ConsolePrint.LINE,"Name :"+guest.getName()+"\nPhone Number :"+guest.getPhoneNum()+"\nMember Level :"+memberTier+"MemberPoint: "+guest.getMemberPoint()+"\n"+ConsolePrint.SINGLE_LINE);
            ConsolePrint.menu("User Profile","User Id :"+guest.getId(),"Name :"+guest.getName(),"Phone Number :"+guest.getPhoneNum(),"Member Level :"+memberTier,"MemberPoint :"+guest.getMemberPoint());
            app.input().pressAnyKey( "Press [ENTER] key to continue....",app.input().SUCCESS);
        } catch (RuntimeException e) {
            app.input().pressAnyKey(e.getMessage(),app.input().ERROR);
        }

    }
}

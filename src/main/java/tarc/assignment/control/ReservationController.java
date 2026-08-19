package tarc.assignment.control;

import tarc.assignment.core.Database;
import tarc.assignment.entity.CheckIn;
import tarc.assignment.entity.Guest;
import tarc.assignment.entity.MemberTierEnum;
import tarc.assignment.entity.Reservation;
import tarc.assignment.util.NumGenerate;

import java.time.Instant;

/**
 * Ng Zhun Onn & Yap Kim Soon
 */
public class ReservationController {
    private final Database database;

    public ReservationController(Database database) {
        this.database = database;
    }

    public String addRegistration(GuestController guestController, String userID) {
        try {
            String confirmationNum;
            Guest guest = guestController.find(userID);
            Instant timeNow = Instant.now();

            if (guest == null) {
                throw new NullPointerException();
            }

            Reservation isReserve = database.reservationRepository().findByCustomerId(userID);
            if (isReserve != null) {
                throw new RuntimeException("User already in queue.");
            }

            CheckIn isCheckin = database.checkInRepository().findByCustomerId(userID);
            if (isCheckin != null) {
                throw new RuntimeException("User already checked in.");
            }

            while (true) {
                confirmationNum = NumGenerate.generateDigit(8);

                boolean inReservation = database.reservationRepository().existByConfirmNum(confirmationNum);
                boolean inCheckIn = database.checkInRepository().existByConfirmNum(confirmationNum);

                if (!inReservation && !inCheckIn) {
                    break;
                }
            }
            Reservation reservation = new Reservation(confirmationNum, userID, guest.getMemberTier(), timeNow);
            database.reservationDAO().create(reservation);
            // database.reservationADT().add(confirmationNum,reservation);
            database.reservationRepository().add(reservation);
            if (reservation.getMemberTier() > MemberTierEnum.BASIC.getCode()) {
                database.vipBookingADT().insert(reservation);
            } else {
                database.standardBookingADT().enqueue(reservation);
            }
            return confirmationNum;
        } catch (NullPointerException e) {
            throw new RuntimeException("UserId not found");
        }
    }

    public Reservation viewNextGuest() {
        if (!database.vipBookingADT().isEmpty()) {
            return database.vipBookingADT().peek();
        } else if (!database.standardBookingADT().isEmpty()) {
            return database.standardBookingADT().peek();
        } else {
            throw new RuntimeException("Queue List are Empty");
        }
    }

    /**
     * Yap Kim Soon
     */
    public void dropReservation(String confirmationNum) {
        if (!database.vipBookingADT().isEmpty()) {
            database.vipBookingADT().extract();
            database.reservationDAO().deleteByConfirmationNum(confirmationNum);
            Reservation reservation = database.reservationRepository().findByConfirmNum(confirmationNum);
            database.reservationRepository().remove(reservation);// TODO:find the possible memory deadlock
        } else if (!database.standardBookingADT().isEmpty()) {
            database.standardBookingADT().dequeue();
            database.reservationDAO().deleteByConfirmationNum(confirmationNum);
            Reservation reservation = database.reservationRepository().findByConfirmNum(confirmationNum);
            database.reservationRepository().remove(reservation);
        } else {
            throw new RuntimeException("Queue List are Empty");
        }
    }
}

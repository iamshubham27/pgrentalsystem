package pgrentalsystem;

import java.util.Date;

/**
 * Represents a room booking.
 */
public class Booking {
    private static int bookingCounter = 0; // Change from final
    private final int bookingId;  // Make this final
    private Tenant tenant;
    private Room room;
    private double advancePayment;
    private Date bookingDate;

    public Booking(Tenant tenant, Room room, double advancePayment) {
        this.bookingId = ++bookingCounter;  
        this.tenant = tenant;
        this.room = room;
        this.advancePayment = advancePayment;
        this.bookingDate = new Date();
        room.setOccupied(true);
    }

    public int getBookingId() {
        return bookingId;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double calculateRemainingAmount() {
        return room.getRent() - advancePayment;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", tenant=" + tenant.getName() +
                ", room=" + room.getRoomNumber() +
                ", advancePayment=" + advancePayment +
                ", bookingDate=" + bookingDate +
                '}';
    }
}
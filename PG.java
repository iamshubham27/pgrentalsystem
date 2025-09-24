package pgrentalsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * PG class that manages rooms and tenants.
 */
public class PG {
    private final String name;
    private final String address;
    private final Owner owner;
    private final List<Room> rooms; // Change to final

    public PG(String name, String address, Owner owner) {
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Owner getOwner() {
        return owner;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Adds a room to the PG.
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Returns a list of available (unoccupied) rooms.
     */
    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
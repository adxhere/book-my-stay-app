import java.util.*;

/**
 * Use Case: Room Allocation Processing
 *
 * Demonstrates processing booking requests from a queue
 * and allocating rooms while preventing double booking.
 *
 * @author Jai Aaditya
 * @version 1.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        // Booking request queue
        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Single"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite"));

        // Room inventory
        RoomInventory inventory = new RoomInventory();

        // Process queue
        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.poll();

            String roomId = inventory.allocateRoom(request.roomType);

            if (roomId != null) {

                System.out.println(
                        "Booking confirmed for Guest: "
                                + request.guestName +
                                ", Room ID: " +
                                roomId
                );

            } else {

                System.out.println(
                        "No rooms available for Guest: "
                                + request.guestName
                );
            }
        }
    }
}

/* ---------------- RESERVATION ---------------- */

class Reservation {

    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

/* ---------------- ROOM INVENTORY ---------------- */

class RoomInventory {

    private Map<String, Integer> inventory;
    private Map<String, Integer> roomCounters;

    RoomInventory() {

        inventory = new HashMap<>();
        roomCounters = new HashMap<>();

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        roomCounters.put("Single", 1);
        roomCounters.put("Double", 1);
        roomCounters.put("Suite", 1);
    }

    String allocateRoom(String roomType) {

        int available = inventory.getOrDefault(roomType, 0);

        if (available > 0) {

            int roomNumber = roomCounters.get(roomType);

            String roomId = roomType + "-" + roomNumber;

            roomCounters.put(roomType, roomNumber + 1);
            inventory.put(roomType, available - 1);

            return roomId;
        }

        return null;
    }
}
import java.util.HashMap;

/**
 * Use Case 3: Centralized Room Inventory Management
 *
 * Demonstrates centralized room availability management
 * using a HashMap to avoid scattered availability variables.
 *
 * @author Jai Aaditya
 * @version 1.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display room details with inventory
        displayRoom(single, "Single Room", inventory);
        displayRoom(doubleRoom, "Double Room", inventory);
        displayRoom(suite, "Suite Room", inventory);

    }

    static void displayRoom(Room room, String type, RoomInventory inventory) {

        room.displayRoomDetails(type);
        System.out.println("Available Rooms: " + inventory.getAvailability(type));
        System.out.println();

    }
}

/* ---------------- ROOM INVENTORY ---------------- */

class RoomInventory {

    private HashMap<String, Integer> inventory;

    RoomInventory() {

        inventory = new HashMap<>();

        // initialize availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    int getAvailability(String roomType) {
        return inventory.get(roomType);
    }

    void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }
}

/* ---------------- ABSTRACT ROOM ---------------- */

abstract class Room {

    int beds;
    int size;
    double price;

    Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    void displayRoomDetails(String type) {
        System.out.println(type + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }
}

/* ---------------- SINGLE ROOM ---------------- */

class SingleRoom extends Room {

    SingleRoom() {
        super(1, 250, 1500.0);
    }
}

/* ---------------- DOUBLE ROOM ---------------- */

class DoubleRoom extends Room {

    DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

/* ---------------- SUITE ROOM ---------------- */

class SuiteRoom extends Room {

    SuiteRoom() {
        super(3, 750, 5000.0);
    }
}
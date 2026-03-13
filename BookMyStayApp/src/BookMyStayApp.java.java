import java.util.HashMap;

/**
 * Use Case 4: Room Search & Availability Check
 *
 * Demonstrates read-only room search functionality
 * using centralized inventory without modifying system state.
 *
 * @author Jai Aaditya
 * @version 1.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Search\n");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Search service
        SearchService search = new SearchService(inventory);

        // Perform room search
        search.displayAvailableRoom(single, "Single Room");
        search.displayAvailableRoom(doubleRoom, "Double Room");
        search.displayAvailableRoom(suite, "Suite Room");

    }
}

/* ---------------- SEARCH SERVICE ---------------- */

class SearchService {

    private RoomInventory inventory;

    SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    void displayAvailableRoom(Room room, String type) {

        int available = inventory.getAvailability(type);

        // Defensive check
        if (available > 0) {
            room.displayRoomDetails(type);
            System.out.println("Available: " + available);
            System.out.println();
        }
    }
}

/* ---------------- INVENTORY ---------------- */

class RoomInventory {

    private HashMap<String, Integer> inventory;

    RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    int getAvailability(String roomType) {
        return inventory.get(roomType);
    }
}

/* ---------------- ROOM DOMAIN MODEL ---------------- */

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

/* ---------------- ROOM TYPES ---------------- */

class SingleRoom extends Room {

    SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {

    DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {

    SuiteRoom() {
        super(3, 750, 5000.0);
    }
}
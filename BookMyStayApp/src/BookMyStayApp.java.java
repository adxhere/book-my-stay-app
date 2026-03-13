public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display details
        single.displayRoomDetails("Single Room");
        System.out.println("Available: " + singleAvailable);
        System.out.println();

        doubleRoom.displayRoomDetails("Double Room");
        System.out.println("Available: " + doubleAvailable);
        System.out.println();

        suite.displayRoomDetails("Suite Room");
        System.out.println("Available: " + suiteAvailable);
    }
}

/* ---------------- ABSTRACT CLASS ---------------- */

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
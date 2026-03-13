import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 5: Booking Request Queue (First-Come-First-Served)
 *
 * Demonstrates fair booking request handling using
 * a FIFO queue structure.
 *
 * @author Jai Aaditya
 * @version 1.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking Request Queue");

        // Create booking queue
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Guests submit booking requests
        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Double"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite"));

        // Process queue in FIFO order
        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.poll();

            System.out.println(
                    "Processing booking for Guest: "
                            + request.guestName +
                            ", Room Type: " +
                            request.roomType
            );
        }
    }
}

/* ---------------- RESERVATION CLASS ---------------- */

class Reservation {

    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}
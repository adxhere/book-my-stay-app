/**
 * BookMyStayApp
 *
 * Entry point for the Hotel Booking Management System.
 * Demonstrates how a Java application starts execution
 * and prints a welcome message to the console.
 *
 * @author Jai Aaditya
 * @version 1.0
 */

public class BookMyStayApp {

    /**
     * Main Method
     * JVM starts program execution here
     */
    public static void main(String[] args) {

        displayWelcomeMessage();

    }

    /**
     * UC1: Display welcome message and application details
     */
    public static void displayWelcomeMessage() {

        System.out.println("=======================================");
        System.out.println("        Welcome to BookMyStay");
        System.out.println("   Hotel Booking Management System");
        System.out.println("           Version : 1.0");
        System.out.println("=======================================");

        System.out.println("Application started successfully.");
        System.out.println("Ready to process hotel bookings.");

    }

}
package pgrentalsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * PG Rental System for managing PGs, tenants, and bookings.
 */
public class PGRentSystem {
    private final List<PG> pgList = new ArrayList<>();
    private final List<Tenant> tenantList = new ArrayList<>();
    private final List<Booking> bookingList = new ArrayList<>();

    private final List<Feedback> feedbackList = new ArrayList<>();

    // Vacate a room
    public void vacateRoom(Scanner scanner) {
        if (bookingList.isEmpty()) {
            System.out.println("No active bookings to vacate.");
            return;
        }
    
        System.out.println("Select a booking to vacate:");
        for (int i = 0; i < bookingList.size(); i++) {
            Booking booking = bookingList.get(i);
            System.out.println((i + 1) + ". " + booking.getTenant().getName() + " in Room " + booking.getRoom().getRoomNumber());
        }
    
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        if (choice < 1 || choice > bookingList.size()) {
            System.out.println("Invalid selection.");
            return;
        }
    
        Booking bookingToRemove = bookingList.get(choice - 1);
        Tenant tenant = bookingToRemove.getTenant();
        tenant.clearRoom();
        bookingList.remove(bookingToRemove);
    
        // Ask for rating and feedback
        System.out.print("Please rate your experience (1 to 5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        while (rating < 1 || rating > 5) {
            System.out.print("Invalid rating. Enter a number between 1 and 5: ");
            rating = scanner.nextInt();
            scanner.nextLine();
        }
    
        System.out.print("Any comments or feedback? ");
        String comments = scanner.nextLine();
    
        Feedback feedback = new Feedback(tenant.getName(), rating, comments);
        feedbackList.add(feedback);
    
        System.out.println("Room vacated and feedback recorded. Thank you!");
    }
    

// Make a payment
public void makePayment(Scanner scanner) {
    if (bookingList.isEmpty()) {
        System.out.println("No active bookings to make a payment for.");
        return;
    }

    System.out.println("Select a booking to make payment:");
    for (int i = 0; i < bookingList.size(); i++) {
        Booking booking = bookingList.get(i);
        System.out.println((i + 1) + ". " + booking.getTenant().getName() + " in Room " + booking.getRoom().getRoomNumber());
    }

    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice < 1 || choice > bookingList.size()) {
        System.out.println("Invalid selection.");
        return;
    }

    Booking selectedBooking = bookingList.get(choice - 1);

    System.out.print("Enter payment amount: ");
    double amount = scanner.nextDouble();
    scanner.nextLine();

    Payment payment = new Payment(selectedBooking, amount);
    System.out.println("Payment successful! Receipt:");
    System.out.println(payment);
}
    public static void main(String[] args) {
        PGRentSystem pgRentSystem = new PGRentSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n******* Welcome To APNA PG.COM ********");
            System.out.println("1. Add PG");
            System.out.println("2. Add Tenant");
            System.out.println("3. Book Room");
            System.out.println("4. Make Payment");
            System.out.println("5. Vacate Room");
            System.out.println("6. Display All Bookings");
            System.out.println("7. Search Tenant by Name");
            System.out.println("8. View Feedback");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    pgRentSystem.addPG(scanner);
                    break;
                case 2:
                    pgRentSystem.addTenant(scanner);
                    break;
                case 3:
                    pgRentSystem.bookRoom(scanner);
                    break;
                case 4:
                    pgRentSystem.makePayment(scanner);
                    break;
                case 5:
                    pgRentSystem.vacateRoom(scanner);
                    break;
                case 6:
                    pgRentSystem.displayAllBookings();
                    break;
                case 7:
                    pgRentSystem.searchTenantByName(scanner);
                    break;
                case 8:
                    pgRentSystem.viewFeedback();
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    /**
     * Adds a PG to the system.
    **** */
    public void addPG(Scanner scanner) {
        System.out.print("Enter PG name: ");
        String name = scanner.nextLine();

        System.out.print("Enter PG address: ");
        String address = scanner.nextLine();

        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();

        System.out.print("Enter owner contact number: ");
        String ownerContactNumber = scanner.nextLine();

        Owner owner = new Owner(ownerName, ownerContactNumber);
        PG pg = new PG(name, address, owner);

        System.out.print("Enter the number of rooms in this PG: ");
        int nRoom = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < nRoom; i++) {
            System.out.print("Enter Room No: ");
            int roomNumber = scanner.nextInt();

            System.out.print("Enter Room Rent: ");
            double rent = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Room Type (Sharing/Single): ");
            String sharing = scanner.nextLine();

            Room room = new Room(roomNumber, rent, sharing);
            pg.addRoom(room);
            System.out.println("Room Number " + roomNumber + " added successfully to " + pg.getName() + " PG");
        }
        pgList.add(pg);
        System.out.println("PG added successfully!");
    }

    /**
     * Adds a new tenant to the system.
     */
    public void addTenant(Scanner scanner) {
        System.out.print("Enter tenant name: ");
        String name = scanner.nextLine();

        System.out.print("Enter tenant contact number: ");
        String contactNumber = scanner.nextLine();

        Tenant tenant = new Tenant(name, contactNumber);
        tenantList.add(tenant);
        System.out.println("Tenant added successfully!");
    }

    /**
     * Books a room for a tenant.
     */
    public void bookRoom(Scanner scanner) {
        if (pgList.isEmpty()) {
            System.out.println("No PGs available. Please add a PG first.");
            return;
        }

        System.out.println("Select PG:");
        for (int i = 0; i < pgList.size(); i++) {
            System.out.println((i + 1) + ". " + pgList.get(i).getName());
        }

        int pgChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        PG selectedPG = pgList.get(pgChoice - 1);

        List<Room> availableRooms = selectedPG.getAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms in this PG.");
            return;
        }

        System.out.println("Select Room:");
        for (int i = 0; i < availableRooms.size(); i++) {
            System.out.println((i + 1) + ". Room " + availableRooms.get(i).getRoomNumber());
        }

        int roomChoice = scanner.nextInt();
        scanner.nextLine();
        Room selectedRoom = availableRooms.get(roomChoice - 1);

        if (tenantList.isEmpty()) {
            System.out.println("No tenants available. Please add a tenant first.");
            return;
        }

        System.out.println("Select Tenant:");
        for (int i = 0; i < tenantList.size(); i++) {
            System.out.println((i + 1) + ". " + tenantList.get(i).getName());
        }

        int tenantChoice = scanner.nextInt();
        scanner.nextLine();
        Tenant selectedTenant = tenantList.get(tenantChoice - 1);

        System.out.print("Enter Advance Payment: ");
        double advancePayment = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Booking newBooking = new Booking(selectedTenant, selectedRoom, advancePayment);
        bookingList.add(newBooking);
        
        System.out.println("Booking successful!");
        System.out.println(newBooking);
        
        double remaining = newBooking.calculateRemainingAmount();
        if (remaining > 0) {
            System.out.println("Remaining amount to be paid: ₹" + remaining);
        } else {
            System.out.println("Full payment received. No amount due.");
        }
        
    }

    /**
     * Displays all bookings.
     */
    public void displayAllBookings() {
        if (bookingList.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            for (Booking booking : bookingList) {
                System.out.println(booking);
            }
        }
    }

    /**
     * Searches a tenant by name.
     */
    public void searchTenantByName(Scanner scanner) {
        System.out.print("Enter tenant name: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Tenant tenant : tenantList) {
            if (tenant.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Tenant found: " + tenant);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Tenant not found.");
        }
    }
    public void viewFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback submitted yet.");
        } else {
            for (Feedback feedback : feedbackList) {
                System.out.println(feedback);
            }
        }
    }
}
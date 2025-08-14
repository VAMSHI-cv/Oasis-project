package java_Development_Oasis_tasks;

import java.util.Scanner;

public class OnlineReservationSystem_Task1
{
    static Scanner scanner = new Scanner(System.in);

    // Hardcoded user data (username and password)
    static String[] usernames = {"user1"};
    static String[] passwords = {"pass123"};

    // Arrays to store reservations
    static String[] pnrList = new String[100];
    static String[] ticketList = new String[100];
    static int reservationCount = 0;

    public static void main(String[] args) 
    {
        System.out.println("Welcome to the Online Reservation System!");

        if (login()) 
        {
            while (true) 
            {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Make Reservation");
                System.out.println("2. Cancel Reservation");
                System.out.println("3. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) 
                {
                    case 1:
                        makeReservation();
                        break;
                    case 2:
                        cancelReservation();
                        break;
                    case 3:
                        System.out.println("Thank you for using the Reservation System.");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
        
        else
        {
            System.out.println("Login failed. Exiting...");
        }
    }

    // Method 1: Login
    public static boolean login() 
    {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < usernames.length; i++) 
        {
            if (usernames[i].equals(username) && passwords[i].equals(password))
            {
                System.out.println("Login successful!");
                return true;
            }
        }

        System.out.println("Invalid login credentials.");
        return false;
    }

    // Method 2: Make Reservation
    public static void makeReservation() 
    {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();

        System.out.print("Enter class type (e.g. Sleeper/AC): ");
        String classType = scanner.nextLine();

        System.out.print("Enter journey date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        System.out.print("Enter source station: ");
        String source = scanner.nextLine();

        System.out.print("Enter destination station: ");
        String destination = scanner.nextLine();

        String pnr = "PNR" + (int)(Math.random() * 10000);
        String ticket = "Passenger: " + name + ", Train: " + trainNumber + ", Class: " + classType +
                        ", Date: " + date + ", From: " + source + ", To: " + destination;

        pnrList[reservationCount] = pnr;
        ticketList[reservationCount] = ticket;
        reservationCount++;

        System.out.println("Reservation successful! Your PNR: " + pnr);
    }

    // Method 3: Cancel Reservation
    public static void cancelReservation() 
    {
        System.out.print("Enter PNR number to cancel: ");
        String pnr = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < reservationCount; i++)
        {
            if (pnrList[i].equals(pnr))
            {
                System.out.println("Reservation Details: " + ticketList[i]);
                System.out.print("Do you really want to cancel this reservation? (yes/no): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("yes"))
                {
                    // Shift remaining reservations
                    for (int j = i; j < reservationCount - 1; j++) 
                    {
                        pnrList[j] = pnrList[j + 1];
                        ticketList[j] = ticketList[j + 1];
                    }
                    reservationCount--;
                    System.out.println("Reservation cancelled successfully.");
                } 
                
                else 
                {
                    System.out.println("Cancellation aborted.");
                }

                found = true;
                break;
            }
        }

        if (!found)
        {
            System.out.println("No reservation found with PNR: " + pnr);
        }
    }
}

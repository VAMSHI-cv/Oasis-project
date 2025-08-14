package java_Development_Oasis_tasks;

import java.util.Scanner;

public class DigitalLibraryManagement_Task5
{
    static String[] books = new String[100];
    static int totalBooks = 0;

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\nLogin as:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1)
            {
                adminMenu(scanner);
            }
            
            else if (choice == 2) 
            {
                userMenu(scanner);
            } 
            
            else 
            {
                System.out.println("Exiting system. Goodbye!");
                break;
            }
        }
    }

    // Admin menu
    public static void adminMenu(Scanner scanner) 
    {
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        if (!password.equals("admin123"))
        {
            System.out.println("Invalid password!");
            return;
        }

        while (true) 
        {
            System.out.println("\nAdmin Panel:");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Logout");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option)
            {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    deleteBook(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // User menu
    public static void userMenu(Scanner scanner) 
    {
        while (true) 
        {
            System.out.println("\nUser Panel:");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Logout");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) 
            {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    searchBook(scanner);
                    break;
                case 3:
                    issueBook(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Add a book
    public static void addBook(Scanner scanner)
    {
        System.out.print("Enter book title: ");
        String book = scanner.nextLine();
        books[totalBooks++] = book;
        System.out.println("Book added successfully!");
    }

    // View all books
    public static void displayBooks() 
    {
        if (totalBooks == 0)
        {
            System.out.println("No books available.");
        } 
        
        else
        {
            System.out.println("Books in Library:");
            for (int i = 0; i < totalBooks; i++)
            {
                System.out.println((i + 1) + ". " + books[i]);
            }
        }
    }

    // Delete a book
    public static void deleteBook(Scanner scanner)
    {
        displayBooks();
        if (totalBooks == 0) return;

        System.out.print("Enter book number to delete: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < totalBooks) 
        {
            for (int i = index; i < totalBooks - 1; i++)
            {
                books[i] = books[i + 1];
            }
            totalBooks--;
            System.out.println("Book deleted.");
        }
        
        else 
        {
            System.out.println("Invalid book number.");
        }
    }

    // Search for a book
    public static void searchBook(Scanner scanner) 
    {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < totalBooks; i++)
        {
            if (books[i].equalsIgnoreCase(title)) 
            {
                System.out.println("Book found: " + books[i]);
                found = true;
                break;
            }
        }
        if (!found) 
        {
            System.out.println("Book not found.");
        }
    }

    // Issue a book
    public static void issueBook(Scanner scanner) 
    {
        displayBooks();
        if (totalBooks == 0) return;

        System.out.print("Enter book number to issue: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < totalBooks)
        {
            System.out.println("Book issued: " + books[index]);
        } 
        
        else 
        {
            System.out.println("Invalid book number.");
        }
    }
}

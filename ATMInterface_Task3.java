package java_Development_Oasis_tasks;

import java.util.Scanner;

public class ATMInterface_Task3
{
    static Scanner scanner = new Scanner(System.in);
    static double balance = 1000.00;
    static StringBuilder transactionHistory = new StringBuilder();
    static String userId = "user123";
    static String userPin = "1234";

    public static void main(String[] args) 
    {
        System.out.println("----- Welcome to ATM Machine -----");

        if (login()) 
        {
            int choice;
            
            do 
            {
                showMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) 
                {
                    case 1:
                        showTransactionHistory();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } 
            while (choice != 5);
        } 
        
        else 
        {
            System.out.println("Invalid Login. Exiting...");
        }
    }

    // Method 1: Login
    public static boolean login() 
    {
        System.out.print("Enter User ID: ");
        String enteredId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        return enteredId.equals(userId) && enteredPin.equals(userPin);
    }

    // Method 2: Show Menu
    public static void showMenu()
    {
        System.out.println("\n----- ATM Menu -----");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    // Method 3: Transaction History
    public static void showTransactionHistory() 
    {
        System.out.println("\n--- Transaction History ---");
        if (transactionHistory.length() == 0) 
        {
            System.out.println("No transactions found.");
        }
        
        else 
        {
            System.out.println(transactionHistory.toString());
        }
    }

    // Method 4: Withdraw
    public static void withdraw()
    {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) 
        {
            System.out.println("Invalid amount.");
        } 
        
        else if (amount > balance)
        {
            System.out.println("Insufficient balance.");
        } 
        
        else 
        {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            transactionHistory.append("Withdrawn: ₹").append(amount).append("\n");
        }
    }

    // Method 5: Deposit
    public static void deposit() 
    {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) 
        {
            System.out.println("Invalid amount.");
        } 
        
        else 
        {
            balance += amount;
            System.out.println("Deposit successful.");
            transactionHistory.append("Deposited: ₹").append(amount).append("\n");
        }
    }

    // Method 6: Transfer
    public static void transfer() 
    {
        System.out.print("Enter recipient account number: ");
        String account = scanner.next();

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount <= 0)
        {
            System.out.println("Invalid amount.");
        }
        
        else if (amount > balance)
        {
            System.out.println("Insufficient balance.");
        } 
        
        else
        {
            balance -= amount;
            System.out.println("Transfer to " + account + " successful.");
            transactionHistory.append("Transferred: ₹").append(amount).append(" to A/C ").append(account).append("\n");
        }
    }
}

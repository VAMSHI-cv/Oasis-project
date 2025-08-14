package java_Development_Oasis_tasks;

import java.util.Scanner;

public class OnlineExamination_Task4
{
    static Scanner scanner = new Scanner(System.in);
    static String username = "student1";
    static String password = "pass123";
    static String name = "John Doe";
    static boolean isLoggedIn = false;
    static int score = 0;

    public static void main(String[] args) 
    {
        if (login()) 
        {
            while (true) 
            {
                showMenu();
                int choice = scanner.nextInt();

                switch (choice) 
                {
                    case 1:
                        updateProfile();
                        break;
                    case 2:
                        startExam();
                        break;
                    case 3:
                        logout();
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
        String user = scanner.nextLine();

        System.out.print("Enter password: ");
        String pass = scanner.nextLine();

        if (user.equals(username) && pass.equals(password))
        {
            isLoggedIn = true;
            System.out.println("Login successful. Welcome " + name + "!");
            return true;
        }
        return false;
    }

    // Method 2: Show Menu
    public static void showMenu() 
    {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Update Profile & Password");
        System.out.println("2. Start Exam");
        System.out.println("3. Logout");
        System.out.print("Enter your choice: ");
    }

    // Method 3: Update Profile & Password
    public static void updateProfile() 
    {
        scanner.nextLine(); // consume newline
        System.out.print("Enter new name: ");
        name = scanner.nextLine();

        System.out.print("Enter new password: ");
        password = scanner.nextLine();

        System.out.println("Profile updated successfully!");
    }

    // Method 4: Start Exam (with timer simulation)
    public static void startExam()
    {
        System.out.println("\nExam Started! (You have 60 seconds to finish - simulated)");
        int totalQuestions = 5;
        score = 0;

        String[] questions = 
        	{
            "1. What is the capital of India?\nA. Mumbai\nB. Delhi\nC. Kolkata\nD. Chennai",
            "2. Java is a ___ language?\nA. Scripting\nB. Compiled\nC. Interpreted\nD. Both B and C",
            "3. Who is the founder of Java?\nA. Dennis Ritchie\nB. James Gosling\nC. Bjarne Stroustrup\nD. Guido van Rossum",
            "4. What is the extension of Java bytecode files?\nA. .java\nB. .class\nC. .exe\nD. .js",
            "5. Which keyword is used to inherit a class in Java?\nA. implement\nB. inherits\nC. extends\nD. super"
            };

        char[] answers = {'B', 'D', 'B', 'B', 'C'};

        scanner.nextLine(); // flush input
        for (int i = 0; i < totalQuestions; i++) 
        {
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            char ans = scanner.nextLine().toUpperCase().charAt(0);

            if (ans == answers[i]) 
            {
                score++;
            }
            // Simulate delay per question (can be skipped or made real with Thread.sleep)
        }

        System.out.println("\nTime up! Auto-submitted your answers.");
        System.out.println("Your score: " + score + "/" + totalQuestions);
    }

    // Method 5: Logout
    public static void logout()
    {
        System.out.println("Logging out...");
        isLoggedIn = false;
    }
}

package LibraryManager;

import java.util.Scanner;

public class LibraryView {
    private LibraryController libraryController;
    private Scanner scanner;

    public LibraryView(LibraryController libraryController) {
        this.libraryController = libraryController;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Add a Book");
            System.out.println("4. Display Borrowed Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    libraryController.displayAvailableBooks();
                    break;
                case 2:
                    displayBorrowBookMenu();
                    break;
                case 3:
                    displayAddBookMenu();
                    break;
                case 4:
                    libraryController.displayBorrowedBooks();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void displayBorrowBookMenu() {
        libraryController.displayAvailableBooks();
        System.out.print("Enter the index of the book you want to borrow (or 0 to cancel): ");
        int index = scanner.nextInt();

        if (index != 0) {
            libraryController.borrowBook(index - 1);
        }
    }

    private void displayAddBookMenu() {
        System.out.print("Enter the title of the book to add (or 0 to cancel): ");
        scanner.nextLine(); // Consume the newline character
        String title = scanner.nextLine();

        if (!title.equals("0")) {
            libraryController.addBook(title);
        }
    }
}

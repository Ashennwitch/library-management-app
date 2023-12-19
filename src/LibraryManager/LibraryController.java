package LibraryManager;

import java.util.Date;
import java.util.List;

public class LibraryController {
    private LibraryModel libraryModel;
    private BorrowedBooksModel borrowedBooksModel;

    public LibraryController(LibraryModel libraryModel, BorrowedBooksModel borrowedBooksModel) {
        this.libraryModel = libraryModel;
        this.borrowedBooksModel = borrowedBooksModel;
    }

    public void displayAvailableBooks() {
        List<Book> books = libraryModel.getBooks();
        System.out.println("Available Books:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.isAvailable()) {
                System.out.println((i + 1) + ". " + book.getTitle());
            }
        }
    }

    public void addBook(String title) {
        Book newBook = new Book(title);
        libraryModel.addBook(newBook);
        System.out.println("Book added successfully.");
    }

    public void borrowBook(int index) {
        List<Book> books = libraryModel.getBooks();
        if (index >= 0 && index < books.size()) {
            Book selectedBook = books.get(index);
            if (selectedBook.isAvailable()) {
                selectedBook.setAvailable(false);

                // Calculate return date (7 days from borrow date)
                Date borrowDate = new Date();
                Date returnDate = new Date(borrowDate.getTime() + 7 * 24 * 60 * 60 * 1000);

                BorrowedBook borrowedBook = new BorrowedBook(selectedBook.getTitle(), borrowDate, returnDate);
                borrowedBooksModel.addBorrowedBook(borrowedBook);

                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Sorry, the selected book is not available.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }

    public void displayBorrowedBooks() {
        borrowedBooksModel.loadBorrowedBooksFromFile();
        borrowedBooksModel.displayBorrowedBooks();
    }
}

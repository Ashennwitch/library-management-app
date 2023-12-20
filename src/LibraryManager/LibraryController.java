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

    public void returnBook(String title) {
        // Find the book in the library model and mark it as available
        for (Book book : libraryModel.getBooks()) {
            if (book.getTitle().equals(title)) {
                book.setAvailable(true);
                break;
            }
        }
        // Remove the book from the borrowed books model
        borrowedBooksModel.returnBorrowedBook(title);
    }

    public String getAvailableBooks() {
        List<Book> books = libraryModel.getBooks();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.isAvailable()) {
                sb.append((i + 1) + ". " + book.getTitle() + "\n");
            }
        }
        return sb.toString();
    }

    public String getBorrowedBooks() {
        List<BorrowedBook> borrowedBooks = borrowedBooksModel.getBorrowedBooks();
        StringBuilder sb = new StringBuilder();
        for (BorrowedBook borrowedBook : borrowedBooks) {
            sb.append("Title: " + borrowedBook.getTitle() + "\n");
            sb.append("Borrow Date: " + borrowedBook.getBorrowDate() + "\n");
            sb.append("Return Date: " + borrowedBook.getReturnDate() + "\n");
            sb.append("Fine: Rp" + borrowedBook.calculateFine() + "\n\n");
        }
        return sb.toString();
    }

}

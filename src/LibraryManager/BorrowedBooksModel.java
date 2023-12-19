package LibraryManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BorrowedBooksModel {
    private List<BorrowedBook> borrowedBooks;

    public BorrowedBooksModel() {
        this.borrowedBooks = new ArrayList<>();
    }

    public List<BorrowedBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBooks.add(borrowedBook);
        saveBorrowedBooksToFile();
    }

    public void returnBorrowedBook(String title) {
        BorrowedBook bookToRemove = null;
        for (BorrowedBook borrowedBook : borrowedBooks) {
            if (borrowedBook.getTitle().equals(title)) {
                bookToRemove = borrowedBook;
                break;
            }
        }

        if (bookToRemove != null) {
            borrowedBooks.remove(bookToRemove);
            saveBorrowedBooksToFile();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found in borrowed books list.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books:");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (BorrowedBook borrowedBook : borrowedBooks) {
            System.out.println("Title: " + borrowedBook.getTitle());
            System.out.println("Borrow Date: " + dateFormat.format(borrowedBook.getBorrowDate()));
            System.out.println("Return Date: " + dateFormat.format(borrowedBook.getReturnDate()));
            System.out.println("Fine: Rp" + borrowedBook.getFine());
            System.out.println();
        }
    }

    public void loadBorrowedBooksFromFile() {
        try (Reader reader = new FileReader("src\\LibraryManager\\json\\borrowedBooks.json")) {
            Gson gson = new Gson();
            borrowedBooks = gson.fromJson(reader, new TypeToken<List<BorrowedBook>>() {}.getType());
            if (borrowedBooks == null) {
                borrowedBooks = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveBorrowedBooksToFile() {
        try (Writer writer = new FileWriter("src\\LibraryManager\\json\\borrowedBooks.json")) {
            Gson gson = new Gson();
            gson.toJson(borrowedBooks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

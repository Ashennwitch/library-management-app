package LibraryManager;

import java.util.Date;

public class BorrowedBook {
    private String title;
    private Date borrowDate, returnDate;

    public BorrowedBook(String title, Date borrowDate, Date returnDate) {
        this.title = title;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getTitle() {
        return title;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}

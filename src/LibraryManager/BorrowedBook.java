package LibraryManager;

import java.util.Date;

public class BorrowedBook {
    private String title;
    private Date borrowDate, returnDate;
    private double fine;

    public BorrowedBook(String title, Date borrowDate, Date returnDate) {
        this.title = title;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    private double calculateFine() {
        // A fixed fine rate per day for overdue books
        long overdueDays = Math.max(0, (new Date().getTime() - returnDate.getTime()) / (24 * 60 * 60 * 1000));
        double fineRate = 2000;
        return overdueDays * fineRate;
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

    public double getFine() {
        return fine;
    }
}

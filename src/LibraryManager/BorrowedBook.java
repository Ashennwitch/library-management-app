package LibraryManager;

import java.util.Date;

public class BorrowedBook {
    private String title;
    private Date borrowDate, returnDate;
<<<<<<< HEAD
    private double fine;
=======
>>>>>>> 80809cc41e30ed41491e7328e082c4010d3e86ee

    public BorrowedBook(String title, Date borrowDate, Date returnDate) {
        this.title = title;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

<<<<<<< HEAD
    private double calculateFine() {
        // A fixed fine rate per day for overdue books
        long overdueDays = Math.max(0, (new Date().getTime() - returnDate.getTime()) / (24 * 60 * 60 * 1000));
        double fineRate = 2000;
        return overdueDays * fineRate;
    }

=======
>>>>>>> 80809cc41e30ed41491e7328e082c4010d3e86ee
    public String getTitle() {
        return title;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
<<<<<<< HEAD

    public double getFine() {
        return fine;
    }
=======
>>>>>>> 80809cc41e30ed41491e7328e082c4010d3e86ee
}

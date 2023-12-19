package LibraryManager;

public class LibraryManagementApp {
    public static void main(String[] args) {
        LibraryModel libraryModel = new LibraryModel();
        BorrowedBooksModel borrowedBooksModel = new BorrowedBooksModel();
        LibraryController libraryController = new LibraryController(libraryModel, borrowedBooksModel);
        LibraryView libraryView = new LibraryView(libraryController);
<<<<<<< HEAD
=======

        libraryView.displayMenu();
>>>>>>> 80809cc41e30ed41491e7328e082c4010d3e86ee
    }
}

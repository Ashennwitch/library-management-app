package LibraryManager;

public class LibraryManagementApp {
    public static void main(String[] args) {
        LibraryModel libraryModel = new LibraryModel();
        BorrowedBooksModel borrowedBooksModel = new BorrowedBooksModel();
        LibraryController libraryController = new LibraryController(libraryModel, borrowedBooksModel);
        LibraryView libraryView = new LibraryView(libraryController);
    }
}

package LibraryManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryView {
    private LibraryController libraryController;
    private JFrame frame;
    private JTextArea textArea;

    public LibraryView(LibraryController libraryController) {
        this.libraryController = libraryController;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton displayBooksButton = new JButton("Display Available Books");
        displayBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(libraryController.getAvailableBooks());
            }
        });

        JButton borrowBookButton = new JButton("Borrow a Book");
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBorrowBookMenu();
            }
        });

        JButton addBookButton = new JButton("Add a Book");
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAddBookMenu();
            }
        });

        JButton displayBorrowedBooksButton = new JButton("Display Borrowed Books");
        displayBorrowedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBorrowedBooks();
            }
        });

        JButton returnBookButton = new JButton("Return Borrowed Books");
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayReturnBookMenu();
            }
        });

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 350));

        panel.add(displayBooksButton);
        panel.add(borrowBookButton);
        panel.add(addBookButton);
        panel.add(displayBorrowedBooksButton);
        panel.add(returnBookButton);
        panel.add(scrollPane);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void displayBorrowBookMenu() {
        String availableBooks = libraryController.getAvailableBooks();
        String bookIndexStr = JOptionPane.showInputDialog(frame, "Available Books:\n" + availableBooks + "\nEnter the index of the book you want to borrow (or 0 to cancel):");
        int bookIndex = Integer.parseInt(bookIndexStr);
        if (bookIndex != 0) {
            libraryController.borrowBook(bookIndex - 1);
        }
    }

    private void displayAddBookMenu() {
        String title = JOptionPane.showInputDialog(frame, "Enter the title of the book to add (or 0 to cancel):");
        if (!title.equals("0")) {
            libraryController.addBook(title);
        }
    }

    private void displayBorrowedBooks() {
        String borrowedBooks = libraryController.getBorrowedBooks();
        JTextArea textArea = new JTextArea(borrowedBooks);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(frame, scrollPane, "Borrowed Books", JOptionPane.INFORMATION_MESSAGE);
    }

    private void displayReturnBookMenu() {
        String title = JOptionPane.showInputDialog(frame, "Enter the title of the book you want to return (or 0 to cancel):");
        if (!title.equals("0")) {
            libraryController.returnBook(title);
        }
    }
}

package LibraryManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LibraryModel {
    private List<Book> books;

    public LibraryModel() {
        this.books = new ArrayList<>();
        loadBooksFromFile();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }

    public void loadBooksFromFile() {
        try (Reader reader = new FileReader("src\\LibraryManager\\json\\libraries.json")) {
            Gson gson = new Gson();
            books = gson.fromJson(reader, new TypeToken<List<Book>>() {}.getType());
            if (books == null) {
                books = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveBooksToFile() {
        try (Writer writer = new FileWriter("src\\LibraryManager\\json\\libraries.json")) {
            Gson gson = new Gson();
            gson.toJson(books, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

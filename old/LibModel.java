package FinPro;

import java.util.ArrayList;
import java.util.List;

public class LibModel {
    private List<Buku> daftarBuku = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void tambahBuku(Buku buku) {
        // Implementasi penambahan buku
        // ...
        // Memberitahu observer bahwa model telah berubah
        notifyObservers();
    }

    public void hapusBuku(Buku buku) {
        // Implementasi penghapusan buku
        // ...

        // Memberitahu observer bahwa model telah berubah
        notifyObservers();
    }

    public List<Buku> getCatalog() {
        // Mengembalikan daftar buku
        return daftarBuku;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}


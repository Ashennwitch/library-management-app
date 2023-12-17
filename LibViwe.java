package FinPro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibView extends JFrame implements Observer {
    private LibModel model;

    public LibView(LibModel model) {
        this.model = model;
        model.registerObserver(this);

        // Implementasi antarmuka pengguna menggunakan Swing
        // ...

        // Menambahkan elemen GUI seperti tombol, tabel, dsb.
        // ...

        // Menambahkan ActionListener untuk berinteraksi dengan model
        // ...

        // Inisialisasi dan menampilkan GUI
        initGUI();
        setVisible(true);
    }

    private void initGUI() {
        // Inisialisasi dan penataan elemen GUI
        // ...
    }

    @Override
    public void update() {
        // Memperbarui tampilan setelah model berubah
        // ...
    }
}


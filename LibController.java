package FinPro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibController {
    private LibModel model;
    private LibView view;

    public LibController(LibModel model, LibView view) {
        this.model = model;
        this.view = view;

        // Menambahkan ActionListener ke elemen GUI
        view.getTambahBukuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementasi aksi untuk menambah buku
                // ...
            }
        });

        view.getHapusBukuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementasi aksi untuk menghapus buku
                // ...
            }
        });

        // ... Menambahkan ActionListener lainnya

        // Inisialisasi dan menampilkan antarmuka pengguna
        view.initGUI();
        view.setVisible(true);
    }
}


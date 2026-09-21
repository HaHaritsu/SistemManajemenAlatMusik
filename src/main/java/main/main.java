/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.AlatMusik;
import model.AlatMusikPetik;
import model.AlatMusikTiup;
import model.Stok;
/**
 *
 * @author Harits
 */
public class main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<AlatMusik> daftarAlat = new ArrayList<>();
    static ArrayList<Stok> daftarStok = new ArrayList<>();

    public static void main(String[] args) {

        dataAwal();

        int pilihan;

        do {
            System.out.println("\n==============================");
            System.out.println("  SISTEM MANAJEMEN ALAT MUSIK");
            System.out.println("  By. Harits (2509116058)");
            System.out.println("==============================");
            System.out.println("> Alat Musik <");
            System.out.println("1. Tampilkan Alat Musik");
            System.out.println("2. Tambah Alat Musik");
            System.out.println("3. Update Alat Musik");
            System.out.println("4. Hapus Alat Musik");
            System.out.println("5. Cari Alat Musik");
            System.out.println("------------------------------");
            System.out.println("> Stok <");
            System.out.println("6. Tambah Stok");
            System.out.println("7. Kurangi Stok");
            System.out.println("8. Tampilkan Stok");
            System.out.println("------------------------------");
            System.out.println("> Lainnya <");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanAlat();
                    break;
                case 2:
                    tambahAlat();
                    break;
                case 3:
                    updateAlat();
                    break;
                case 4:
                    hapusAlat();
                    break;
                case 5:
                    cariAlat();
                    break;
                case 6:
                    tambahStok();
                    break;
                case 7:
                    kurangiStok();
                    break;
                case 8:
                    tampilkanStok();
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    static void dataAwal() {
        daftarAlat.add(
            new AlatMusikPetik(
                "A001", "Gitar", "Yamaha", 2500000, 6
            )
        );

        daftarAlat.add(
            new AlatMusikPetik(
                "A002", "Ukulele", "Cort", 850000, 4
            )
        );

        daftarAlat.add(
            new AlatMusikTiup(
                "A003", "Seruling", "Yamaha", 500000, "Kayu"
            )
        );

        daftarAlat.add(
            new AlatMusikTiup(
                "A004", "Saksofon", "Selmer", 7000000, "Logam"
            )
        );

        daftarStok.add(new Stok("A001", 10));
        daftarStok.add(new Stok("A002", 8));
        daftarStok.add(new Stok("A003", 15));
        daftarStok.add(new Stok("A004", 5));
    }

    static void tampilkanAlat() {
        System.out.println("\n===== DAFTAR ALAT MUSIK =====");

        if (daftarAlat.isEmpty()) {
            System.out.println("Belum ada data.");
            return;
        }

        for (AlatMusik alat : daftarAlat) {
            System.out.println("------------------------------");
            alat.tampilkanInfo();
        }
    }

    static void tambahAlat() {
        System.out.println("\n===== TAMBAH ALAT MUSIK =====");

        System.out.print("ID Alat: ");
        String id = input.nextLine();

        if (cariBerdasarkanId(id) != null) {
            System.out.println("ID sudah digunakan.");
            return;
        }

        System.out.print("Nama Alat: ");
        String nama = input.nextLine();

        System.out.print("Merek: ");
        String merek = input.nextLine();

        System.out.print("Harga: ");
        double harga = input.nextDouble();

        System.out.println("1. Alat Musik Petik");
        System.out.println("2. Alat Musik Tiup");
        System.out.print("Pilih jenis: ");
        int jenis = input.nextInt();

        input.nextLine();

        if (jenis == 1) {
            System.out.print("Jumlah senar: ");
            int senar = input.nextInt();
            input.nextLine();

            daftarAlat.add(
                new AlatMusikPetik(id, nama, merek, harga, senar)
            );

        } else if (jenis == 2) {
            System.out.print("Bahan alat: ");
            String bahan = input.nextLine();

            daftarAlat.add(
                new AlatMusikTiup(id, nama, merek, harga, bahan)
            );

        } else {
            System.out.println("Jenis tidak tersedia.");
            return;
        }

        System.out.print("Jumlah stok awal: ");
        int stok = input.nextInt();
        input.nextLine();

        daftarStok.add(new Stok(id, stok));

        System.out.println("Data berhasil ditambahkan.");
    }

    static void updateAlat() {
        System.out.println("\n===== UPDATE ALAT MUSIK =====");

        System.out.print("Masukkan ID alat: ");
        String id = input.nextLine();

        AlatMusik alat = cariBerdasarkanId(id);

        if (alat == null) {
            System.out.println("Data tidak ditemukan.");
            return;
        }

        System.out.print("Nama baru: ");
        alat.setNamaAlat(input.nextLine());

        System.out.print("Merek baru: ");
        alat.setMerek(input.nextLine());

        System.out.print("Harga baru: ");
        alat.setHarga(input.nextDouble());
        input.nextLine();

        System.out.println("Data berhasil diubah.");
    }

    static void hapusAlat() {
        System.out.println("\n===== HAPUS ALAT MUSIK =====");

        System.out.print("Masukkan ID alat: ");
        String id = input.nextLine();

        AlatMusik alat = cariBerdasarkanId(id);

        if (alat == null) {
            System.out.println("Data tidak ditemukan.");
            return;
        }

        daftarAlat.remove(alat);

        Stok stok = cariStok(id);
        if (stok != null) {
            daftarStok.remove(stok);
        }

        System.out.println("Data berhasil dihapus.");
    }

    static void cariAlat() {
        System.out.println("\n===== CARI ALAT MUSIK =====");

        System.out.print("Masukkan nama alat: ");
        String nama = input.nextLine().toLowerCase();

        boolean ditemukan = false;

        for (AlatMusik alat : daftarAlat) {
            if (alat.getNamaAlat().toLowerCase().contains(nama)) {
                System.out.println("------------------------------");
                alat.tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }

    static void tambahStok() {
        System.out.println("\n===== TAMBAH STOK =====");

        System.out.print("ID alat: ");
        String id = input.nextLine();

        Stok stok = cariStok(id);

        if (stok == null) {
            System.out.println("Data stok tidak ditemukan.");
            return;
        }

        System.out.print("Jumlah stok yang ditambahkan: ");
        int jumlah = input.nextInt();
        input.nextLine();

        stok.tambahStok(jumlah);

        System.out.println("Stok berhasil ditambahkan.");
    }

    static void kurangiStok() {
        System.out.println("\n===== KURANGI STOK =====");

        System.out.print("ID alat: ");
        String id = input.nextLine();

        Stok stok = cariStok(id);

        if (stok == null) {
            System.out.println("Data stok tidak ditemukan.");
            return;
        }

        System.out.print("Jumlah stok yang dikurangi: ");
        int jumlah = input.nextInt();
        input.nextLine();

        stok.kurangiStok(jumlah);

        System.out.println("Stok berhasil diproses.");
    }

    static void tampilkanStok() {
        System.out.println("\n===== DAFTAR STOK =====");

        if (daftarStok.isEmpty()) {
            System.out.println("Belum ada data stok.");
            return;
        }

        for (Stok stok : daftarStok) {
            System.out.println("------------------------------");
            stok.tampilkanStok();
        }
    }

    static AlatMusik cariBerdasarkanId(String id) {
        for (AlatMusik alat : daftarAlat) {
            if (alat.getIdAlat().equalsIgnoreCase(id)) {
                return alat;
            }
        }

        return null;
    }

    static Stok cariStok(String id) {
        for (Stok stok : daftarStok) {
            if (stok.getIdAlat().equalsIgnoreCase(id)) {
                return stok;
            }
        }

        return null;
    }
}

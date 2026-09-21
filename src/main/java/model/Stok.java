/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Harits
 */
public class Stok {
    private String idAlat;
    private int jumlah;

    public Stok(String idAlat, int jumlah) {
        this.idAlat = idAlat;
        this.jumlah = jumlah;
    }

    public String getIdAlat() {
        return idAlat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void tambahStok(int jumlah) {
        this.jumlah += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= this.jumlah) {
            this.jumlah -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi.");
        }
    }

    public void tampilkanStok() {
        System.out.println("ID Alat : " + idAlat);
        System.out.println("Stok    : " + jumlah);
    }
}

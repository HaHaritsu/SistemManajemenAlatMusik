/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Harits
 */
public class AlatMusik {
    protected String idAlat;
    protected String namaAlat;
    protected String merek;
    protected double harga;

    public AlatMusik(String idAlat, String namaAlat, String merek, double harga) {
        this.idAlat = idAlat;
        this.namaAlat = namaAlat;
        this.merek = merek;
        this.harga = harga;
    }

    public String getIdAlat() {
        return idAlat;
    }

    public String getNamaAlat() {
        return namaAlat;
    }

    public String getMerek() {
        return merek;
    }

    public double getHarga() {
        return harga;
    }

    public void setNamaAlat(String namaAlat) {
        this.namaAlat = namaAlat;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void tampilkanInfo() {
        System.out.println("ID       : " + idAlat);
        System.out.println("Nama     : " + namaAlat);
        System.out.println("Merek    : " + merek);
        System.out.println("Harga    : Rp" + harga);
    }
}

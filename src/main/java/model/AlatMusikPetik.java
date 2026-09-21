/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Harits
 */
public class AlatMusikPetik extends AlatMusik {
    private int jumlahSenar;

    public AlatMusikPetik(String idAlat, String namaAlat, String merek, double harga, int jumlahSenar) {
        super(idAlat, namaAlat, merek, harga);
        this.jumlahSenar = jumlahSenar;
    }

    public int getJumlahSenar() {
        return jumlahSenar;
    }

    public void setJumlahSenar(int jumlahSenar) {
        this.jumlahSenar = jumlahSenar;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis    : Alat Musik Petik");
        System.out.println("Senar    : " + jumlahSenar);
    }
}

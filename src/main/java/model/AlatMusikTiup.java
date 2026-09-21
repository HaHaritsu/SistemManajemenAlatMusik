/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Harits
 */
public class AlatMusikTiup extends AlatMusik {
    private String bahan;

    public AlatMusikTiup(String idAlat, String namaAlat, String merek, double harga, String bahan) {
        super(idAlat, namaAlat, merek, harga);
        this.bahan = bahan;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis    : Alat Musik Tiup");
        System.out.println("Bahan    : " + bahan);
    }
}

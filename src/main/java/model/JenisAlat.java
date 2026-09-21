/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Harits
 */
public class JenisAlat {
    private String idJenis;
    private String namaJenis;
    private String caraMain;

    public JenisAlat(String idJenis, String namaJenis, String caraMain) {
        this.idJenis = idJenis;
        this.namaJenis = namaJenis;
        this.caraMain = caraMain;
    }

    public String getIdJenis() {
        return idJenis;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public String getCaraMain() {
        return caraMain;
    }

    public void tampilkanInfo() {
        System.out.println("ID Jenis : " + idJenis);
        System.out.println("Jenis    : " + namaJenis);
        System.out.println("Cara Main: " + caraMain);
    }
}

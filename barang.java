/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.entity.npm196;

/**
 *
 * @author Arief
 */
public class barang {

    private String idbarang;
    private String namabarang;
    private String jenisbarang;
    private String harga;
    private String jumlah;
  
    
    public barang(){
        }

    public barang(String idbarang, String namabarang, String jenisbarang, String harga,
         String jumlah) {
        this.idbarang = idbarang;
        this.namabarang = namabarang;
        this.jenisbarang = jenisbarang;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getJenisbarang() {
        return jenisbarang;
    }

    public void setJenisbarang(String jenisbarang) {
        this.jenisbarang = jenisbarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    


    
    public Object getValue(int index){
        switch (index) {
            case 0:
                return idbarang;
            case 1:
                return namabarang;
            case 2:
                return jenisbarang;
            case 3:
                return harga;
            case 4:
                return jumlah;
            
            default:
                return null;

        }
        
    }
            
            
  }






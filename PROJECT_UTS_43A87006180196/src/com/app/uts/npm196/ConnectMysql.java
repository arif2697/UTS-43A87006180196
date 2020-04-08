/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm196;

import com.app.uts.entity.npm196.BarangDataSource;
import com.app.uts.entity.npm196.barang;


/**
 *
 * @author Arief
 */
public class ConnectMysql {
    BarangDataSource datasource = new BarangDataSource();
   
        public static void main(String[] args) {
            //Pemanggilan method insert
            //new ConnectMysql().testInsert();
           
            //Pemanggilan method update
           new ConnectMysql().testDelete();
    }
        
    //pembuatan method insert
    public void testInsert(){
        //pemanggilan kelas mahasiswa
        barang brg = new barang();
        brg.setIdbarang("21345");
        brg.setNamabarang("Pisau");
        brg.setJenisbarang("Perkakas");
        brg.setHarga("42000");
        brg.setJumlah("satu");
        boolean sukses = datasource.insert(brg);
        //berhasil
        if (sukses) {
            System.out.println("Insert Data Berhasil!");
        }else{
            System.out.println("Insert Data Gagal!");
        }
    }
    
    //pembuatan method Update
    public void testUpdate(){
        //pemanggilan kelas getByID
        barang brg = datasource.getByID("21345");
        brg.setNamabarang("sendok");
        boolean sukses = datasource.update(brg);
        //berhasil
        if (sukses) {
            System.out.println("Update Data Berhasil!");
        }else{
            System.out.println("Update Data Gagal!");
        }
    }
    
    public void testDelete(){
        barang brg = datasource.getByID("21345");
        boolean sukses = datasource.delete(brg);
        
        if (sukses) {
            System.out.println("Delete Data Berhasil");
            
            
        }else{
            System.out.println("Delete Data Gagal");
        }
        
    }
}

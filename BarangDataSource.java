/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.entity.npm196;

import com.app.uts.entity.npm196.barang;
import com.app.uts.npm196.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arief
 */
public class BarangDataSource {
    private Connection connection;
    
    
    public BarangDataSource(){
        connection = ConnectionUtil.getConnection();
    }
    
    public List<barang> getALL(){
        List<barang> list = new ArrayList<>();
        String sql = "SELECT * FROM barang";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            barang brg;
            while (rs.next()) {                
                brg = new barang();
                brg.setIdbarang(rs.getString("idbarang"));
                brg.setNamabarang(rs.getString("namabarang"));
                brg.setJenisbarang(rs.getString("jenisbarang"));
                brg.setHarga(rs.getString("harga"));
                brg.setJumlah(rs.getString("email"));
                list.add(brg);
            }
        } catch (Exception e) {
            System.out.println("Error get All"+e.getMessage());
        }
        return list;
    }
    
    
    public barang getByID(String idbarang){
        //? adalah parameter yang di berikan sebagai ganti isi
        String sql = "SELECT * FROM barang WHERE Idbarang = ?";
        barang brg = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pengisian parameter ?
            statement.setString(1, idbarang);
            //ditampung dalam resutset
            ResultSet rs = statement.executeQuery();
            //Pengecekan data rs
            //pakai if karena data tunggal, tidak perlu pakai while
            if (rs.next()) {
                brg = new barang();
                brg.setIdbarang(rs.getString("Idbarang"));
                brg.setNamabarang(rs.getString("Namabarang"));
                brg.setJenisbarang(rs.getString("Jenisbarang"));
                brg.setHarga(rs.getString("Harga"));
                brg.setJumlah(rs.getString("Jumlah"));
            }
        } catch (Exception e) {
        }
        return brg;
    }
    
    //Pembuatan Kelas Manipulasi database Insert
    public boolean insert(barang brg){
        boolean status = false;
        String sql = "INSERT INTO barang VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            statement.setString(1, brg.getIdbarang());
            statement.setString(2, brg.getNamabarang());
            statement.setString(3, brg.getJenisbarang());
            statement.setString(4, brg.getHarga());
            statement.setString(5, brg.getJumlah());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Update
    public boolean update(barang brg){
        boolean status = false;
        String sql = "UPDATE barang SET Namabarang=?, Jenisbarang=?, Harga=?, Jumlah=? " +
                "WHERE Idbarang=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Update, nim jadi dipaling akhir
            statement.setString(1, brg.getNamabarang());
            statement.setString(2, brg.getJenisbarang());
            statement.setString(3, brg.getHarga());
            statement.setString(4, brg.getJumlah());
            statement.setString(5, brg.getIdbarang());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Delete
    public boolean delete(barang brg){
        boolean status = false;
        String sql = "DELETE FROM barang WHERE idbarang=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Delete, hanya 1 parameter saja
            statement.setString(5, brg.getIdbarang());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
}

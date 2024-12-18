/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhapHangDAOimpl implements NhapHangDAO {
    
        @Override
    public List<Product> getList(){
        try{
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM dbo.PRODUCT WHERE PROD_QIS<=10 ";
        List<Product> list =  new ArrayList<>();
        PreparedStatement ps = cons.prepareCall(sql);
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Product sanpham = new Product();
            sanpham.setProduct_code(rs.getString("PRODUCT_CODE"));
            sanpham.setCategory_code(rs.getString("CATEGORY_CODE"));
            sanpham.setSupplier_code(rs.getString("SUPPLIER_CODE"));
            sanpham.setStore_code(rs.getString("STORE_CODE"));
            sanpham.setPro_Description(rs.getString("PROD_DESCRIPTION"));
            sanpham.setPro_Brand(rs.getString("PROD_BRAND"));
            sanpham.setPro_Prize(rs.getFloat("PROD_PRICE"));
            sanpham.setPro_Import_Prize(rs.getFloat("PROD_IMPORT_PRICE"));
            sanpham.setPro_QIS(rs.getInt("PROD_QIS"));
            sanpham.setPro_Dimensions(rs.getString("PROD_DIMENSIONS"));
            sanpham.setPro_MD(rs.getDate("PROD_MD")); 
            sanpham.setPro_EXD(rs.getDate("PROD_EXD"));
            list.add(sanpham);
        }
        ps.close();
        rs.close();
        cons.close();
       
            return list;
    }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

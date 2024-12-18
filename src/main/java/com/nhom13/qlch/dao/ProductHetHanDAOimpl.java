/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.ProductHetHan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ProductHetHanDAOimpl implements ProductHetHanDAO{

    @Override
    public List<ProductHetHan> getList() {
try {
        Connection cons = DBConnect.getConnection();
     String sql = "SELECT * FROM PRODUCTEXPIRED ";
            
        
        List<ProductHetHan> list = new ArrayList<>();
        PreparedStatement ps = cons.prepareCall(sql);
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
       
            while (rs.next()) {
                ProductHetHan product = new ProductHetHan();
                product.setProduct_code(rs.getString("PRODUCT_CODE"));
                product.setSoluong(rs.getInt("QUANLITY"));
                product.setGiaNhap(rs.getFloat("UNITPRICE"));
                product.setNgay_nhap(rs.getDate("PRODUCT_MD"));
                product.setNgay_het_han(rs.getDate("PRODUCT_EXD"));
                list.add(product);
            
           
        }
        
        ps.close();
        rs.close();
        cons.close();

        return list;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }

    @Override
    public int Insert() {
      int result = 0;
try {
    Connection cons = DBConnect.getConnection();
    cons.setAutoCommit(false); // Bắt đầu giao dịch

    String insertSql = "INSERT INTO PRODUCTEXPIRED (PRODUCT_CODE, QUANLITY, UNITPRICE, PRODUCT_MD, PRODUCT_EXD)\n"
            + "SELECT \n"
            + "    p.PRODUCT_CODE, \n"
            + "    p.PROD_QIS, \n"
            + "    p.PROD_IMPORT_PRICE, \n"
            + "    p.PROD_MD, \n"
            + "    p.PROD_EXD\n"
            + "FROM \n"
            + "    PRODUCT AS p\n"
            + "WHERE \n"
            + "    p.PROD_EXD < ? AND\n"
            + "	p.PROD_QIS > 0;";
    PreparedStatement psInsert = cons.prepareStatement(insertSql);

    LocalDate currentDate = LocalDate.now();
    Date sqlDate = Date.valueOf(currentDate); // Chuyển đổi LocalDate thành java.sql.Date
    psInsert.setDate(1, sqlDate);

    int insertedRows = psInsert.executeUpdate();

    // Thực hiện UPDATE
    String updateSql = "UPDATE dbo.PRODUCT SET PROD_QIS=0 WHERE PROD_EXD < ?";
    PreparedStatement psUpdate = cons.prepareStatement(updateSql);
    psUpdate.setDate(1, sqlDate);
    int updatedRows = psUpdate.executeUpdate();

    cons.commit(); // Commit giao dịch

    result = insertedRows + updatedRows;

    psInsert.close();
    psUpdate.close();
    cons.close();
} catch (Exception ex) {
    ex.printStackTrace(); // In ra lỗi
    result = 0; // Gán kết quả bằng 0 nếu có lỗi
}

return result;

    
}
}


package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class InvoiceDAOimpl implements InvoiceDAO {
     @Override
    public List<invoice> getList(){
        try{
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM dbo.INVOICE ";
        List<invoice> list =  new ArrayList<>();
        PreparedStatement ps = cons.prepareCall(sql);
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            invoice hoadon = new invoice();
            hoadon.setMa_hoa_don(rs.getString("INV_CODE"));
            hoadon.setMa_khach_hang(rs.getString("CUS_CODE"));
            hoadon.setMa_nhan_vien(rs.getString("EMP_CODE"));
            hoadon.setInv_Date(rs.getDate("INV_DATE"));
            hoadon.setInv_total(rs.getFloat("INV_TOTAL"));
            hoadon.setphuong_thuc_tt(rs.getString("INV_PAYMENTMETHOD"));
           
            list.add(hoadon);
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

    @Override
    public String Insert( String makhachhang, String phuongthuc, float total_invoice) {
     int result =0;
         try {
            Connection cons = DBConnect.getConnection();

           String sql = "INSERT INTO dbo.INVOICE (INV_CODE, CUS_CODE, INV_DATE, INV_TOTAL, INV_PAYMENTMETHOD) "
           + "VALUES (?, ?, ?, ?, ?)";


            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
 


            LocalDate currentDate = LocalDate.now();
//        System.out.println("Ngày hiện tại: " + currentDate);
        // Chuyển StringBuilder thành String và trả về
           String MaHoaDon=generateInvoice(6);
            ps.setString(1,MaHoaDon);
            ps.setString(2,makhachhang);
            ps.setDate(3, java.sql.Date.valueOf(currentDate));
            ps.setFloat(4,total_invoice);
            ps.setString(5, phuongthuc);
           
          

            result = ps.executeUpdate();
             ps.close();
             cons.close();

            return MaHoaDon;
        } catch (Exception ex) {
            //System.out.println("loi");
            ex.printStackTrace();
        }
        return "0";
    }
        public static String generateInvoice(int length) {
        // Ký tự hoặc số có thể sử dụng trong mã hóa đơn
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // Sử dụng StringBuilder để xây dựng mã hóa đơn
        StringBuilder invoiceBuilder = new StringBuilder();

        // Tạo một đối tượng Random để lấy ký tự/ngẫu nhiên
        Random random = new Random();

        // Tạo mã hóa đơn bằng cách lấy ngẫu nhiên các ký tự từ chuỗi characters
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            invoiceBuilder.append(characters.charAt(index));
        }

        // Chuyển StringBuilder thành String và trả về
        return invoiceBuilder.toString();
    }

    @Override
    public List<invoice> getListToday() {
      try {
    Connection cons = DBConnect.getConnection();
    String sql = "SELECT * FROM dbo.INVOICE WHERE INV_DATE = ?;";
    PreparedStatement ps = cons.prepareStatement(sql);
    LocalDate currentDate = LocalDate.now();
    java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
    ps.setDate(1, sqlDate);

    List<invoice> list =  new ArrayList<>();
    
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        invoice hoadon = new invoice();
        hoadon.setMa_hoa_don(rs.getString("INV_CODE"));
        hoadon.setMa_khach_hang(rs.getString("CUS_CODE"));
        hoadon.setMa_nhan_vien(rs.getString("EMP_CODE"));
        hoadon.setInv_Date(rs.getDate("INV_DATE"));
        hoadon.setInv_total(rs.getFloat("INV_TOTAL"));
        hoadon.setphuong_thuc_tt(rs.getString("INV_PAYMENTMETHOD"));
       
        list.add(hoadon);
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

}

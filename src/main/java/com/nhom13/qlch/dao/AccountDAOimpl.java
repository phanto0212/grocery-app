
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AccountDAOimpl implements AccountDAO{
     @Override
    public Account login(String username, String password) {
       
        try {
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM dbo.ACCOUNT WHERE TEN_DANG_NHAP LIKE ? AND MAT_KHAU LIKE ?;";
        Account account = null;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setTen_dang_nhap(rs.getString("TEN_DANG_NHAP"));
                account.setMat_khau(rs.getString("MAT_KHAU"));
            }
           ps.close();
        rs.close();
        conn.close();
            return account;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int SignUp(String username, String password) {
        int result;
        try {
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO dbo.ACCOUNT(TEN_DANG_NHAP, MAT_KHAU, MA_TAI_KHOAN)"
                + "VALUES(?,?,?);";
        Account account = null;
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
             int MaTaiKhoan =generateRandomNumber(6);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, MaTaiKhoan);
            
            result = ps.executeUpdate();
          
           ps.close();
        
        conn.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Account> getList() {
try {
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM dbo.ACCOUNT ";
        Account account = null;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Account> list =  new ArrayList<>();
            if (rs.next()) {
                account = new Account();
                account.setTen_dang_nhap(rs.getString("TEN_DANG_NHAP"));
                account.setMat_khau(rs.getString("MAT_KHAU"));
                list.add(account);
            }
           ps.close();
        rs.close();
        conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    
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
    public static int generateRandomNumber(int length) {
        // Tạo một đối tượng Random để sinh số ngẫu nhiên
        Random random = new Random();

        // Tính toán giá trị tối đa có thể đạt được với số lượng chữ số được chỉ định
        int maxValue = (int) Math.pow(10, length);

        // Sinh số nguyên ngẫu nhiên trong phạm vi từ 0 đến maxValue - 1
        int randomNumber = random.nextInt(maxValue);

        return randomNumber;
    }

    @Override
    public int setTaiKhoan(String tentaikhoan, String matkhau) {
        int result;
        try {
        Connection conn = DBConnect.getConnection();
         String sql = "UPDATE dbo.TAI_KHOAN_DANG_NHAP\n"
                    + "SET \n"
                    + "    TEN_TAI_KHOAN = ?, \n"
                    + "    MAT_KHAU = ? \n"
                    + "WHERE ID =?;";
                    
        Account account = null;
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
             
            ps.setString(1, tentaikhoan);
            ps.setString(2, matkhau);
            ps.setString(3, "01");
            
            
            result = ps.executeUpdate();
          
           ps.close();
        
        conn.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Account> getTaiKhoan() {
        try {
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM dbo.TAI_KHOAN_DANG_NHAP WHERE ID = '01';";
        Account account = null;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Account> list =  new ArrayList<>();
            if (rs.next()) {
                account = new Account();
                account.setTen_dang_nhap(rs.getString("TEN_TAI_KHOAN"));
                account.setMat_khau(rs.getString("MAT_KHAU"));
                list.add(account);
            }
           ps.close();
        rs.close();
        conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }

    @Override
    public int Update(String tendangnhap, String matkhau) {
        int result;
        try {
        Connection conn = DBConnect.getConnection();
         String sql = "UPDATE dbo.ACCOUNT\n"
                    + "SET \n"
                    + "    MAT_KHAU = ? \n"
                    + "WHERE TEN_DANG_NHAP =?;";
                    
        Account account = null;
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
             
            ps.setString(1, matkhau);
            ps.setString(2, tendangnhap );
            
            
            
            result = ps.executeUpdate();
          
           ps.close();
        
        conn.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int ThemTaiKhoanThongKe(String tendangnhap, int so_luong, float total) {
        int result;
        try {
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO dbo.THONG_KE_TAI_KHOAN(TEN_TAI_KHOAN,NGAY_TAO, QUANLITY, SO_LUONG_HOA_DON, TONG_TIEN)"
                + "VALUES(?, ?, ?, ?, ?);";
        Account account = null;
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
             LocalDate currentDate = LocalDate.now();
            ps.setString(1, tendangnhap);
            ps.setDate(2,java.sql.Date.valueOf(currentDate) );
            ps.setInt(3, so_luong);
            ps.setInt(4, 1);
            ps.setFloat(5, total);
        
            
            result = ps.executeUpdate();
          
           ps.close();
        
        conn.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getSoluongDonHang(String tendangnhap) {
         try{
             int result=0;
        Connection cons = DBConnect.getConnection();
             String sql = "SELECT  \n"
                     + "SUM (dbo.THONG_KE_TAI_KHOAN.QUANLITY) AS SO_LUONG\n"
                     + "FROM \n"
                     + "dbo.THONG_KE_TAI_KHOAN \n"
                     + "WHERE \n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN = ? \n"
                     + "GROUP BY\n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN;";
        PreparedStatement ps = cons.prepareCall(sql);
        ps.setString(1, tendangnhap);
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            result=rs.getInt("SO_LUONG");
            
            
        }
        ps.close();
        rs.close();
        cons.close();
       
            return result;
    }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getSoLuongHoaDon(String tendangnhap) {
try{
             int result=0;
        Connection cons = DBConnect.getConnection();
             String sql = "SELECT  \n"
                     + "COUNT (*) AS SO_LUONG\n"
                     + "FROM \n"
                     + "dbo.THONG_KE_TAI_KHOAN \n"
                     + "WHERE \n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN = ? \n"
                     + "GROUP BY\n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN;";
        PreparedStatement ps = cons.prepareCall(sql);
        ps.setString(1, tendangnhap);
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            result=rs.getInt("SO_LUONG");
            
            
        }
        ps.close();
        rs.close();
        cons.close();
       
            return result;
    }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;    }

    @Override
    public float getTongDoanhThu(String tendangnhap) {
        try{
             float result=0;
        Connection cons = DBConnect.getConnection();
             String sql = "SELECT  \n"
                     + "SUM (dbo.THONG_KE_TAI_KHOAN.TONG_TIEN) AS SO_LUONG\n"
                     + "FROM \n"
                     + "dbo.THONG_KE_TAI_KHOAN \n"
                     + "WHERE \n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN = ? \n"
                     + "GROUP BY\n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN;";
        PreparedStatement ps = cons.prepareCall(sql);
        ps.setString(1, tendangnhap);
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            result=rs.getFloat("SO_LUONG");
            
            
        }
        ps.close();
        rs.close();
        cons.close();
       
            return result;
    }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getDonHangHomNay(String tendangnhap) {
        try{
             int result=0;
        Connection cons = DBConnect.getConnection();
             String sql = "SELECT  \n"
                     + "SUM (dbo.THONG_KE_TAI_KHOAN.QUANLITY) AS SO_LUONG\n"
                     + "FROM \n"
                     + "dbo.THONG_KE_TAI_KHOAN \n"
                     + "WHERE \n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN = ? AND dbo.THONG_KE_TAI_KHOAN.NGAY_TAO = ? \n"
                     + "GROUP BY\n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN;";
        PreparedStatement ps = cons.prepareCall(sql);
         LocalDate currentDate = LocalDate.now();
        ps.setString(1, tendangnhap);
        ps.setDate(2, java.sql.Date.valueOf(currentDate));
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            result=rs.getInt("SO_LUONG");
            
            
        }
        ps.close();
        rs.close();
        cons.close();
       
            return result;
    }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0; 
    }

    @Override
    public int getHoaDonHomNay(String tendangnhap) {
try{
             int result=0;
        Connection cons = DBConnect.getConnection();
             String sql = "SELECT  \n"
                     + "COUNT (*) AS SO_LUONG\n"
                     + "FROM \n"
                     + "dbo.THONG_KE_TAI_KHOAN \n"
                     + "WHERE \n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN = ? AND dbo.THONG_KE_TAI_KHOAN.NGAY_TAO = ? \n"
                     + "GROUP BY\n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN;";
        PreparedStatement ps = cons.prepareCall(sql);
         LocalDate currentDate = LocalDate.now();
        ps.setString(1, tendangnhap);
        ps.setDate(2, java.sql.Date.valueOf(currentDate));
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            result=rs.getInt("SO_LUONG");
            
            
        }
        ps.close();
        rs.close();
        cons.close();
       
            return result;
    }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;     }

    @Override
    public float getDoanhThuHomNay(String tendangnhap) {
try{
             float result=0;
        Connection cons = DBConnect.getConnection();
             String sql = "SELECT  \n"
                     + "SUM (dbo.THONG_KE_TAI_KHOAN.TONG_TIEN) AS SO_LUONG\n"
                     + "FROM \n"
                     + "dbo.THONG_KE_TAI_KHOAN \n"
                     + "WHERE \n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN = ? AND dbo.THONG_KE_TAI_KHOAN.NGAY_TAO = ? \n"
                     + "GROUP BY\n"
                     + "dbo.THONG_KE_TAI_KHOAN.TEN_TAI_KHOAN;";
        PreparedStatement ps = cons.prepareCall(sql);
        LocalDate currentDate = LocalDate.now();
        ps.setString(1, tendangnhap);
        ps.setDate(2, java.sql.Date.valueOf(currentDate));
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            result=rs.getFloat("SO_LUONG");
            
            
        }
        ps.close();
        rs.close();
        cons.close();
       
            return result;
    }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;    }

   

    
}

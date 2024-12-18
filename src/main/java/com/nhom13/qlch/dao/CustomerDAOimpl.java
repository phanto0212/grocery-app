
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAOimpl implements CustomerDAO {
     @Override
    public List<Customer> getList(){
        try{
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM dbo.CUSTOMER ";
        List<Customer> list =  new ArrayList<>();
        PreparedStatement ps = cons.prepareCall(sql);
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Customer customer = new Customer();
            customer.setMa_khach_hang(rs.getString("CUS_CODE"));
            customer.setRank_id(rs.getString("RANK_ID"));
            customer.setTen(rs.getString("CUS_FNAME"));
            customer.setHo_dem(rs.getString("CUS_LNAME"));
            customer.setDob_khach_hang(rs.getDate("CUS_DOB"));
            customer.setEmail(rs.getString("CUS_EMAIL"));
            customer.setSo_dien_thoai(rs.getString("CUS_PHONENUM"));
            customer.setDia_chi(rs.getString("CUS_ADDRESS"));
            customer.setTong_chi_tieu(rs.getFloat("CUS_TOTALPURCHASE"));
            customer.setKhoan_no(rs.getFloat("CONG_NO"));
            
            list.add(customer);
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
    public int setRank() {
        int result = 0;
        try {

            Connection cons = DBConnect.getConnection();

            String sql = "UPDATE dbo.CUSTOMER\n"
            + "SET RANK_ID = CASE "
            + "WHEN CUS_TOTALPURCHASE >= 10000000 THEN ?\n"
            + "WHEN CUS_TOTALPURCHASE >= 4000000 THEN ?\n"
            + "WHEN CUS_TOTALPURCHASE >= 1000000 THEN ?\n"
            + "ELSE ?\n"
            + "END";

            
                  
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, "04");
            ps.setString(2, "03");
            ps.setString(3, "02");
            ps.setString(4, "01");
           

             result = ps.executeUpdate();
             ps.close();
             cons.close();

            
            
            return result;
        } catch (Exception ex) {
           
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int muaHang(float total, String cuscode) {
            int result = 0;
        try {

            Connection cons = DBConnect.getConnection();

            String sql = "UPDATE dbo.CUSTOMER \n"
                    + "SET "
                    + " CUS_TOTALPURCHASE = CUS_TOTALPURCHASE + ? \n"
                    + "WHERE \n"
                    + "CUS_CODE = ?;";
            

            
                  
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setFloat(1, total);
            ps.setString(2, cuscode);
           
           

             result = ps.executeUpdate();
             ps.close();
             cons.close();

            
            
            return result;
        } catch (Exception ex) {
           
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Update(Customer customer) {
        int result = 0;
        try {

            Connection cons = DBConnect.getConnection();

            String sql = "UPDATE dbo.CUSTOMER \n"
                    + "SET \n"
                    + "    RANK_ID = ?, \n"
                    + "    CUS_FNAME = ?, \n"
                    + "    CUS_LNAME = ?, \n"
                    + "    CUS_DOB = ?, \n"
                    + "    CUS_EMAIL = ?, \n"
                    + "    CUS_PHONENUM = ?, \n"
                    + "    CUS_ADDRESS = ?, \n"
                    + "    CUS_TOTALPURCHASE = ? \n"
                    + " WHERE \n"
                    + "    CUS_CODE = ?;";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, customer.getRank_id());
            ps.setString(2, customer.getTen());
            ps.setString(3, customer.getHo_dem());
            ps.setDate(4,new Date (customer.getDob_khach_hang().getTime()));
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getSo_dien_thoai());
            ps.setString(7, customer.getDia_chi());
            ps.setFloat(8, customer.getTong_chi_tieu());
            ps.setString(9,customer.getMa_khach_hang());
           

             result = ps.executeUpdate();
             ps.close();
             cons.close();

            
            
            return result;
        } catch (Exception ex) {
           
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int TongSanPham(Customer customer) {
        
        try{
             int result=0;
        Connection cons = DBConnect.getConnection();
            String sql = "SELECT \n"
                    + "    SUM(dbo.LINE.QUANLITY) AS tong_so_luong_san_pham\n"
                    + "FROM \n"
                    + "    dbo.INVOICE\n"
                    + "JOIN \n"
                    + "    dbo.CUSTOMER ON dbo.INVOICE.CUS_CODE = dbo.CUSTOMER.CUS_CODE\n"
                    + "JOIN \n"
                    + "    dbo.LINE ON dbo.INVOICE.INV_CODE = dbo.LINE.INV_CODE\n"
                    + "WHERE \n"
                    + "	dbo.INVOICE.CUS_CODE = ?\n"
                    + "GROUP BY \n"
                    + "    dbo.INVOICE.CUS_CODE, dbo.CUSTOMER.CUS_FNAME;";
        PreparedStatement ps = cons.prepareCall(sql);
        ps.setString(1, customer.getMa_khach_hang());
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            result=rs.getInt("tong_so_luong_san_pham");
            
            
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
    public int TongHoaDon(Customer customer) {
            try{
             int result=0;
        Connection cons = DBConnect.getConnection();
            String sql = "SELECT \n" +
"	 COUNT(*) AS so_luong_hoa_don\n" +
"	 FROM \n" +
"	 dbo.INVOICE\n" +
"	 WHERE\n" +
"	 dbo.INVOICE.CUS_CODE = ?\n" +
"	 GROUP BY\n" +
"	 dbo.INVOICE.CUS_CODE;";
        PreparedStatement ps = cons.prepareCall(sql);
        ps.setString(1, customer.getMa_khach_hang());
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            result=rs.getInt("so_luong_hoa_don");
            
            
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
    public int CongNo(String makhachhang ,float congno) {
           int result = 0;
    try {
        Connection cons = DBConnect.getConnection();
        String sql = "UPDATE dbo.CUSTOMER "
                + "SET CONG_NO = CONG_NO + ? "
                + "WHERE CUS_CODE = ?";
        PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setFloat(1, congno);
        ps.setString(2, makhachhang);
        result = ps.executeUpdate();
        ps.close();
        cons.close();
        return result;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return 0;
    }

    @Override
    public float TongCongNo() {
    try {
    Connection cons = DBConnect.getConnection();
    String sql = "SELECT "
            + "SUM(dbo.CUSTOMER.CONG_NO) AS TIEN_CONG_NO "
            + "FROM dbo.CUSTOMER "
            + "GROUP BY dbo.CUSTOMER.CONG_NO";
    List<Customer> list = new ArrayList<>();
    PreparedStatement ps = cons.prepareCall(sql);
    ResultSet rs = ps.executeQuery();
    float result = 0;
    while (rs.next()) {
        result += rs.getFloat("TIEN_CONG_NO");
    }
    ps.close();
    rs.close();
    cons.close();
    return result;
} catch (SQLException e) {
    e.printStackTrace();
}
return 0;
}

    @Override
    public int trutien(String makhachhang, float tientra) {
         int result = 0;
    try {
        Connection cons = DBConnect.getConnection();
        String sql = "UPDATE dbo.CUSTOMER "
                + "SET CONG_NO = CONG_NO - ? "
                + "WHERE CUS_CODE = ?";
        PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setFloat(1, tientra);
        ps.setString(2, makhachhang);
        result = ps.executeUpdate();
        ps.close();
        cons.close();
        return result;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return 0;
    }

    @Override
    public int Insert(Customer customer) {
int result = 0;

        try {
            Connection cons = DBConnect.getConnection();

            String sql = "INSERT INTO dbo.CUSTOMER (CUS_CODE, CUS_FNAME, "
                    + "CUS_LNAME, CUS_DOB, CUS_EMAIL,"
                    + " CUS_PHONENUM, CUS_ADDRESS, CUS_TOTALPURCHASE,CONG_NO)\n"
                    + "VALUES (? ,? ,?, ? ,? ,? ,? ,?, ? );";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, customer.getMa_khach_hang());
            ps.setString(2, customer.getTen());
            ps.setString(3, customer.getHo_dem());
            ps.setDate(4, new java.sql.Date(customer.getDob_khach_hang().getTime()));
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getSo_dien_thoai());
            ps.setString(7, customer.getDia_chi());
            ps.setFloat(8, 0);
            ps.setFloat(9, 0);
            

            result = ps.executeUpdate();
             ps.close();
             cons.close();

            return result;
        } catch (Exception ex) {
            //System.out.println("loi");
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Delete(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

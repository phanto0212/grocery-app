
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Line;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.Sold;
import com.nhom13.qlch.model.invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LineDAOimpl implements LineDAO{

    @Override
    public List<Line> getList() {
     try{
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM dbo.LINE ";
        List<Line> list =  new ArrayList<>();
        PreparedStatement ps = cons.prepareCall(sql);
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Line line = new Line();
            line.setLine_num(rs.getInt("LINE_NUM"));
            line.setInvoice_code(rs.getString("INV_CODE"));
            line.setProduct_code(rs.getString("PRODUCT_CODE"));
            line.setSoluong(rs.getInt("QUANLITY"));
            line.setUnit_price(rs.getFloat("UNIT_PRICE"));
            line.setTotal_price(rs.getFloat("LINE_TOTAL"));
           
            list.add(line);
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
    public int Insert(Product product, String Ma_hoa_don,int i) {
        int result =0;
         try {
            Connection cons = DBConnect.getConnection();

           String sql = "INSERT INTO dbo.LINE (LINE_NUM, INV_CODE, PRODUCT_CODE, QUANLITY, UNIT_PRICE, LINE_TOTAL) "
           + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, String.valueOf(i));
            ps.setString(2, Ma_hoa_don);
            ps.setString(3, product.getProduct_code());
            ps.setInt(4, product.getPro_QIS());
            ps.setFloat(5, product.getPro_Prize());
            ps.setFloat(6, product.getPro_Prize()*product.getPro_QIS());
          

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
    public List<Sold> getLit(Date TimeStart, Date TimeEnd) {
        try{
            Connection cons = DBConnect.getConnection();
            String sql = " 	SELECT \n"
                    + "    PRODUCT_CODE,\n"
                    + "    SUM(QUANLITY) AS total_quanlity\n"
                    + "FROM \n"
                    + "    dbo.LINE\n"
                    + "    INNER JOIN dbo.INVOICE ON Line.INV_CODE = dbo.INVOICE.INV_CODE\n"
                    + "WHERE\n"
                    + "    INV_DATE BETWEEN ? AND ? \n"
                    + "GROUP BY \n"
                    + "    PRODUCT_CODE\n"
                    + "ORDER BY \n"
                    + "    PRODUCT_CODE;";
            List<Sold> list1 = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ps.setDate(1, new java.sql.Date(TimeStart.getTime()));
            ps.setDate(2, new java.sql.Date(TimeEnd.getTime()));
//        ps.setString(1, "000001");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sold sold = new Sold();
                sold.setProduct_code(rs.getString("PRODUCT_CODE"));
                sold.setSoluong(rs.getInt("total_quanlity"));
           
           
             list1.add(sold);
        }
        ps.close();
        rs.close();
        cons.close();
       
            return list1;
    }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}

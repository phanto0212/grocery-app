
package com.nhom13.qlch.dao;

import static com.nhom13.qlch.dao.DBConnect.getConnection;
import com.nhom13.qlch.model.Product;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDAOimpl implements ProductDAO {
    @Override
    public List<Product> getList(){
        try{
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM dbo.PRODUCT ";
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
   


    @Override
    public int insert(Product product) {
     int result = 0;
        try {
            Connection cons = DBConnect.getConnection();

            String sql = "INSERT INTO dbo.PRODUCT (PRODUCT_CODE, CATEGORY_CODE, "
                    + "SUPPLIER_CODE, PROD_DESCRIPTION, PROD_BRAND,"
                    + " PROD_PRICE, PROD_IMPORT_PRICE, PROD_QIS, PROD_DIMENSIONS,PROD_MD,PROD_EXD)\n"
                    + "VALUES (? ,? ,?, ? ,? ,? ,? ,?, ?, ?, ? );";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, product.getProduct_code());
            ps.setString(2, product.getCategory_code());
            ps.setString(3, product.getSupplier_code());
            ps.setString(4, product.getPro_Description());
            ps.setString(5, product.getPro_Brand());
            ps.setFloat(6, product.getPro_Prize());
            ps.setFloat(7, product.getPro_Import_Prize());
            ps.setInt(8, product.getPro_QIS());
            ps.setString(9, product.getPro_Dimensions());
            ps.setDate(10,new Date(product.getPro_MD().getTime()));
            ps.setDate(11, new Date(product.getPro_EXD().getTime()));

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
    public int Update(Product product) {
        int result = 0;
        try {

            Connection cons = DBConnect.getConnection();

            String sql = "UPDATE dbo.PRODUCT\n"
                    + "SET \n"
                    + "    CATEGORY_CODE = ?, \n"
                    + "    SUPPLIER_CODE = ?, \n"
                    + "    PROD_DESCRIPTION = ?, \n"
                    + "    PROD_BRAND = ?, \n"
                    + "    PROD_PRICE = ?, \n"
                    + "    PROD_IMPORT_PRICE = ?, \n"
                    + "    PROD_QIS = ?, \n"
                    + "    PROD_DIMENSIONS = ?, \n"
                    + "    PROD_MD = ?,\n"
                    + "    PROD_EXD = ?\n"
                    + "WHERE \n"
                    + "    PRODUCT_CODE = ?;";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, product.getCategory_code());
            ps.setString(2, product.getSupplier_code());
            ps.setString(3, product.getPro_Description());
            ps.setString(4, product.getPro_Brand());
            ps.setFloat(5, product.getPro_Prize());
            ps.setFloat(6, product.getPro_Import_Prize());
            ps.setInt(7, product.getPro_QIS());
            ps.setString(8, product.getPro_Dimensions());
            ps.setDate(9,new Date(product.getPro_MD().getTime()));
            ps.setDate(10, new Date (product.getPro_EXD().getTime()));
            ps.setString(11, product.getProduct_code());

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
    public int Delete(Product product) {
        int result = 0;
        try {
            Connection cons = DBConnect.getConnection();

            String sql = "DELETE FROM dbo.PRODUCT\n"
                    + "WHERE PRODUCT_CODE = ?;";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, "" + product.getProduct_code());

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
public int NhapHang(Product product) {
    int result = 0;
    try {
        Connection cons = DBConnect.getConnection();

        String sql = "UPDATE dbo.PRODUCT\n"
                     + "SET \n"
                     + "    PROD_IMPORT_PRICE = ?, \n"
                     + "    PROD_QIS = PROD_QIS + ?, \n"
                     + "    PROD_MD = ?,\n"
                     + "    PROD_EXD = ?\n"
                     + "WHERE \n"
                     + "    PRODUCT_CODE = ?;";
        PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setFloat(1, product.getPro_Import_Prize());
        ps.setInt(2, product.getPro_QIS());
        ps.setDate(3, new Date(product.getPro_MD().getTime()));
        ps.setDate(4, new Date(product.getPro_EXD().getTime()));
        ps.setString(5, product.getProduct_code());

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
    public int BanHang(Product product) {
       int result = 0;
        try {

            Connection cons = DBConnect.getConnection();

            String sql = "UPDATE dbo.PRODUCT\n"
            + "SET PROD_QIS = PROD_QIS - ?\n" // Chỉnh sửa ở đây, di chuyển WHERE xuống dòng mới
            + "WHERE PRODUCT_CODE = ?;";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            
            ps.setInt(1, product.getPro_QIS());

            ps.setString(2, product.getProduct_code());

            result = ps.executeUpdate();
            ps.close();
            cons.close();

            
            
            return result;
        } catch (Exception ex) {
           
            ex.printStackTrace();
        }
        return 0;
    }

    
    
}


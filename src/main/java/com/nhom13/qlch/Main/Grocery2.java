
package com.nhom13.qlch.Main;

import com.nhom13.qlch.dao.DBConnect;
import static com.nhom13.qlch.dao.DBConnect.getConnection;
import com.nhom13.qlch.model.Customer;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.ProductHetHan;
import com.nhom13.qlch.service.CustomerService;
import com.nhom13.qlch.service.CustomerServiceimpl;
import com.nhom13.qlch.service.ManagerService;
import com.nhom13.qlch.service.ManagerServiceimpl;
import com.nhom13.qlch.service.NhapHangService;
import com.nhom13.qlch.service.NhapHangServiceimpl;
import com.nhom13.qlch.service.ProductHetHanService;
import com.nhom13.qlch.service.ProductHetHanServiceimpl;
import com.nhom13.qlch.service.ProductService;
import com.nhom13.qlch.service.ProductServiceimpl;
import com.nhom13.qlch.view.LoginJFrame;
import com.nhom13.qlch.view.MainJFrame;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.apache.commons.math3.stat.StatUtils.product;


public class Grocery2 {
    public static void main(String[] args) {
//       new MainJFrame().setVisible(true);
//       ManagerService managerService=null;
//       managerService=new ManagerServiceimpl();
//       List<Product> list = managerService.getList();
//        System.out.print(list.size());
       
//          LocalDate currentDate = LocalDate.now();
//        System.out.println("Ngày hiện tại: " + currentDate);
//       NhapHangService nhaphang =null;
//       nhaphang= new NhapHangServiceimpl();
//       List<Product> list=nhaphang.getList();
//       Product pro = list.get(1);
//       String formattedValue = String.format("%.2f", pro.getPro_Prize());
//       System.out.print(formattedValue);

//hethan = new ProductHetHanServiceimpl();
//List<ProductHetHan> list = hethan.getList();
//System.out.print(list.size());
      LoginJFrame loginJDialog = new LoginJFrame();

        loginJDialog.setTitle("Đăng nhập hệ thống");
        loginJDialog.setResizable(false);
        loginJDialog.setLocationRelativeTo(null);
        loginJDialog.setVisible(true);
        Customer customer = new Customer();
//customer.setMa_khach_hang("000002");
//CustomerService hethan = null;
//hethan = new CustomerServiceimpl();
//System.out.print(hethan.TongHoaDon(customer));
//ProductService productService = null ;
//productService = new ProductServiceimpl();
//List<Product> listItem = productService.getList();
//    
//    // In ra kích thước của danh sách sản phẩm
//    System.out.println("Size of product list: " + listItem.size());
//Product product  = new Product();
//product.setProduct_code("000001");
//product.setCategory_code("000002");
//product.setSupplier_code("000001");
//product.setProduct_code("000001");
//product.setPro_Description("banh gao");
//product.setPro_Brand("onion");
//product.setPro_Prize(10000);
//product.setPro_QIS(20);
//product.setPro_Dimensions("12mg");
//product.setPro_MD(new Date(121, 3, 7));
//product.setPro_EXD(new Date(121, 3, 8));
//
//
// try{
//              Connection cons = DBConnect.getConnection();
//
//            String sql = "UPDATE dbo.PRODUCT\n"
//                    + "SET \n"
//                    + "    CATEGORY_CODE = ?, \n"
//                    + "    SUPPLIER_CODE = ?, \n"
//                    + "    PROD_DESCRIPTION = ?, \n"
//                    + "    PROD_BRAND = ?, \n"
//                    + "    PROD_PRICE = ?, \n"
//                    + "    PROD_QIS = ?, \n"
//                    + "    PROD_DIMENSIONS = ?, \n"
//                    + "    PROD_MD = ?,\n"
//                    + "    PROD_EXD = ?\n"
//                    + "WHERE \n"
//                    + "    PRODUCT_CODE = ?;";
//            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//
//            ps.setString(1, product.getCategory_code());
//            ps.setString(2, product.getSupplier_code());
//            ps.setString(3, product.getPro_Description());
//            ps.setString(4, product.getPro_Brand());
//            ps.setFloat(5, product.getPro_Prize());
//            ps.setInt(6, product.getPro_QIS());
//            ps.setString(7, product.getPro_Dimensions());
//            ps.setDate(8,new Date(product.getPro_MD().getTime()));
//            ps.setDate(9, new Date (product.getPro_EXD().getTime()));
//            ps.setString(10, product.getProduct_code());
////        ps.setString(1, "000001");
//         int result =0;
//         result = ps.executeUpdate();
//         System.out.println(result);
//             ps.close();
//             cons.close();
//}
// catch (SQLException e){
//            e.printStackTrace();
//            
//        }
    }
}

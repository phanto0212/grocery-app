
package com.nhom13.qlch.dao;

import com.nhom13.qlch.bean.HoaDonBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ThongKeDAOimpl implements ThongKeDAO{
     @Override
    public List<HoaDonBean> getListbyInvoice(){
        try{
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT INV_DATE , COUNT(*) AS SO_LUONG FROM dbo.INVOICE GROUP BY INV_DATE ";
        List<HoaDonBean> list =  new ArrayList<>();
        PreparedStatement ps = cons.prepareCall(sql);
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            HoaDonBean hoaDonBean = new HoaDonBean();
           java.sql.Date productCodeDate = rs.getDate("INV_DATE");
    
    // Định dạng ngày thành chuỗi
    String productCodeString = null;
    if (productCodeDate != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng mong muốn của bạn
        productCodeString = sdf.format(productCodeDate);
    }
    
    // Set giá trị chuỗi vào đối tượng HoaDonBean
            hoaDonBean.setHoa_don_date(productCodeString);
            hoaDonBean.setSo_luong(rs.getInt("SO_LUONG"));
           
            list.add(hoaDonBean);
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

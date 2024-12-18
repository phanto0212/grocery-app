
package com.nhom13.qlch.unity;

import com.nhom13.qlch.model.Product;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ClassTableModelJpanelView1 {
     public DefaultTableModel setTableProduct2(List<Product> listItem, String[] listColumn) {
    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
 
    dtm.setColumnIdentifiers(listColumn); // Set tên cột
    
    if (listItem != null) { // Kiểm tra null trước khi sử dụng listItem
        for (int i = 0; i < listItem.size(); i++) { // Lặp qua từng hàng trong danh sách
            Product product = listItem.get(i);
            Object[] obj = new Object[2000]; // Tạo một mảng mới cho mỗi hàng
            
            obj[0] = i + 1;
            obj[1] = product.getProduct_code();
            obj[2] = product.getPro_Description();
            obj[3] = product.getPro_Brand();
            obj[4] = product.getPro_Prize();
            obj[5] = product.getPro_QIS();
            obj[6] = product.getPro_Dimensions();
           
            
            dtm.addRow(obj); // Thêm hàng vào bảng
        }
    }
    
    return dtm;
}
}

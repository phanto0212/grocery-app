
package com.nhom13.qlch.unity;

import com.nhom13.qlch.dao.ProductDAO;
import com.nhom13.qlch.model.Product;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ClassTableModelProduct {
   public DefaultTableModel setTableProduct(List<Product> listItem, String[] listColumn) {
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
            Object[] obj = new Object[12]; // Tạo một mảng mới cho mỗi hàng
            
            obj[0] = i + 1;
            obj[1] = product.getProduct_code();
            obj[2] = product.getCategory_code();
            obj[3] = product.getSupplier_code();
//            obj[4] = product.getStore_code();
            obj[4] = product.getPro_Description();
            obj[5] = product.getPro_Brand();
            obj[6] = product.getPro_Prize();
            obj[7] = product.getPro_Import_Prize();
            obj[8] = product.getPro_QIS();
            obj[9] = product.getPro_Dimensions();
            obj[10] = product.getPro_MD();
            obj[11] = product.getPro_EXD();
            
            dtm.addRow(obj); // Thêm hàng vào bảng
        }
    }
    
    return dtm;
}
}

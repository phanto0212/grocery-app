
package com.nhom13.qlch.unity;

import com.nhom13.qlch.model.Customer;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ClassTableModelCustomer {
     public DefaultTableModel setTableProduct(List<Customer> listItem, String[] listColumn) {
    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
 
    dtm.setColumnIdentifiers(listColumn); // Set tên cột
    
    if (listItem != null) { // Kiểm tra null trước khi sử dụng listItem
        for (int i = 0; i < listItem.size(); i++) { // Lặp qua từng hàng trong danh sách
            Customer customer = listItem.get(i);
            Object[] obj = new Object[2000]; // Tạo một mảng mới cho mỗi hàng
            
            obj[0] = i + 1;
            obj[1] = customer.getMa_khach_hang();
            obj[2] = customer.getRank_id();
            obj[3] = customer.getTen();
//            obj[4] = product.getStore_code();
            obj[4] = customer.getHo_dem();
            obj[5] = customer.getDob_khach_hang();
            obj[6] = customer.getEmail();
            obj[7] = customer.getSo_dien_thoai();
            obj[8] = customer.getDia_chi();
            obj[9] = customer.getTong_chi_tieu();
           
            
            dtm.addRow(obj); // Thêm hàng vào bảng
        }
    }
    
    return dtm;
}
}


package com.nhom13.qlch.unity;

import com.nhom13.qlch.model.invoice;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ClassTableModelInvoice {
      public DefaultTableModel setTableProduct(List<invoice> listItem, String[] listColumn) {
    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
 
    dtm.setColumnIdentifiers(listColumn); // Set tên cột
    
    if (listItem != null) { // Kiểm tra null trước khi sử dụng listItem
        for (int i = 0; i < listItem.size(); i++) { // Lặp qua từng hàng trong danh sách
            invoice hoadon = listItem.get(i);
            Object[] obj = new Object[2000]; // Tạo một mảng mới cho mỗi hàng
            
            obj[0] = i + 1;
            obj[1] = hoadon.getMa_hoa_don();
            obj[2] = hoadon.getMa_khach_hang();
            obj[3] = hoadon.getMa_nhan_vien();
//            obj[4] = product.getStore_code();
            obj[4] = hoadon.getInv_Date();
            obj[5] = hoadon.getInv_total();
            obj[6] = hoadon.getphuong_thuc_tt();
           
            dtm.addRow(obj); // Thêm hàng vào bảng
        }
    }
    
    return dtm;
}
}

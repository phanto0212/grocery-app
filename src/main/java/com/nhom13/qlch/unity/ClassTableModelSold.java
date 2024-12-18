
package com.nhom13.qlch.unity;

import com.nhom13.qlch.model.Sold;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModelSold {
    public DefaultTableModel setTableSold(List<Sold> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dtm.setColumnIdentifiers(listColumn); // Set tên cột

        if (listItem != null) { // Kiểm tra null trước khi sử dụng listItem
            for (int i = 0; i < listItem.size(); i++) { // Lặp qua từng hàng trong danh sách
                Sold sold = listItem.get(i);
                Object[] obj = new Object[12]; // Tạo một mảng mới cho mỗi hàng

                obj[0] = i + 1;
                obj[1] = sold.getProduct_code();
                obj[2] = sold.getSoluong();

                dtm.addRow(obj); // Thêm hàng vào bảng
            }
        }
        return dtm;
    }
}


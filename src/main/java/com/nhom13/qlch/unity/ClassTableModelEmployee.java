
package com.nhom13.qlch.unity;

import com.nhom13.qlch.model.Employee;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ClassTableModelEmployee {
     public DefaultTableModel setTableEmployee(List<Employee> listItem, String[] listColumn) {
    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
 
    dtm.setColumnIdentifiers(listColumn); // Set tên cột
    
    if (listItem != null) { // Kiểm tra null trước khi sử dụng listItem
        for (int i = 0; i < listItem.size(); i++) { // Lặp qua từng hàng trong danh sách
            Employee employee = listItem.get(i);
            Object[] obj = new Object[2000]; // Tạo một mảng mới cho mỗi hàng
            
            obj[0] = i + 1;
            obj[1] = employee.getma_nhan_vien();
            obj[2] = employee.getFist_name();
            obj[3] = employee.getLast_name();
            obj[4] = employee.getNgay_sinh();
            obj[5] = employee.getNgay_vo_lam();
            obj[6] = employee.getCong_viec();
            obj[7] = employee.getSalary();
            obj[8] = employee.getemail();
            obj[9] = employee.getphone();
            obj[10] = employee.getadress();
            
            dtm.addRow(obj); // Thêm hàng vào bảng
        }
    }
    
    return dtm;
}
}

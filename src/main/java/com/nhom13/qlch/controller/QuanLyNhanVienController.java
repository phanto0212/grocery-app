
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Employee;
import com.nhom13.qlch.service.EmployeeService;
import com.nhom13.qlch.service.EmployeeServiceimpl;
import com.nhom13.qlch.unity.ClassTableModelEmployee;
import com.nhom13.qlch.view.EmployeeJFrame;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class QuanLyNhanVienController {
     private JTextField jtfsearchstaff;
    private JButton  btnaddStaff;
    private JPanel JPViewStaff;
    private ClassTableModelEmployee classTableModelEmployee = null;

    private  String[] listcolumn  = {"STT", "MÃ NHÂN VIÊN", "TÊN", "HỌ ĐỆM",
        "NGÀY SINH", "NGÀY VÔ LÀM", "CHỨC VỤ","MỨC LƯƠNG", "EMAIL", "SỐ ĐT","ĐỊA CHỈ"};

    private EmployeeService employeeService = null;

    private TableRowSorter<TableModel> rowSorter = null;


    public QuanLyNhanVienController(JTextField jtfsearchstaff, JButton btnaddStaff, JPanel JPViewStaff) {
        this.jtfsearchstaff = jtfsearchstaff;
        this.btnaddStaff = btnaddStaff;
        this.JPViewStaff = JPViewStaff;
        this.classTableModelEmployee = new ClassTableModelEmployee();

        this.employeeService = new EmployeeServiceimpl();
    }
    
    public void setDataToTable() {
        List<Employee> listItem;
         listItem = employeeService.getList();
//        Product sanpham = listItem.get(1 );
//        System.out.println(sanpham.getPro_Brand());
        DefaultTableModel model = new ClassTableModelEmployee().setTableEmployee(listItem, listcolumn );
        JTable table = new JTable(model);

         rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

         jtfsearchstaff.getDocument().addDocumentListener(new DocumentListener() {
             @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfsearchstaff.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

              @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfsearchstaff.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
         table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int selectedRowIndex = table.getSelectedRow();
            
            // Chuyển đổi chỉ số hàng hiển thị thành chỉ số hàng trong mô hình
            selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
            
            Employee employee  = new Employee();
            employee.setma_nhan_vien(model.getValueAt(selectedRowIndex, 1).toString());
            employee.setFist_name(model.getValueAt(selectedRowIndex, 2).toString());
            employee.setLast_name(model.getValueAt(selectedRowIndex, 3).toString());
            employee.setNgay_sinh((Date) model.getValueAt(selectedRowIndex, 4) );
            employee.setNgay_vo_lam((Date) model.getValueAt(selectedRowIndex, 5) );
            employee.setCong_viec(model.getValueAt(selectedRowIndex, 6).toString());
            employee.setSalary((float) model.getValueAt(selectedRowIndex, 7));
            employee.setemail( model.getValueAt(selectedRowIndex, 8).toString());
            employee.setphone( model.getValueAt(selectedRowIndex, 9).toString());
            employee.setadress(model.getValueAt(selectedRowIndex, 10).toString());

            EmployeeJFrame frame = new EmployeeJFrame(employee);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle("Thông tin sản phẩm");
            frame.setVisible(true);
        }
    }
});
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

       

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        JPViewStaff.removeAll();
        JPViewStaff.setLayout(new CardLayout());
        JPViewStaff.add(scroll);
        JPViewStaff.validate();
        JPViewStaff.repaint();

    }
     public void setEvent(){
  
     btnaddStaff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                try {
//                    if (!checkNotNull()) {
//                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
//                    } else {
//                        hocVien.setHo_ten(jtfHoTen.getText().trim());
//                        hocVien.setNgay_sinh(covertDateToDateSql(jdcNgaySinh.getDate()));
//                        hocVien.setSo_dien_thoai(jtfSoDienThoai.getText());
//                        hocVien.setDia_chi(jtaDiaChi.getText());
//                        hocVien.setGioi_tinh(jtfGioiTinhNam.isSelected());
//                        hocVien.setTinh_trang(jcbKichHoat.isSelected());
//                        if (showDialog()) {
//                            int lastId = hocVienService.createOrUpdate(hocVien);
//                            if (lastId != 0) {
//                                hocVien.setMa_hoc_vien(lastId);
//                                jtfMaHocVien.setText("#" + hocVien.getMa_hoc_vien());
//                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
//                            } else {
//                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
//                            }
//                        }
//                    }
//                } catch (Exception ex) {
//                    jlbMsg.setText(ex.toString());
//                }
                 
                    EmployeeJFrame frame = new EmployeeJFrame(new Employee());
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setTitle("Thông tin nhân viên");
                    frame.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
});
     
}}

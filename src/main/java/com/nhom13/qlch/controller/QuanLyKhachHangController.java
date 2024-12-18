
package com.nhom13.qlch.controller;

import com.nhom13.qlch.dao.CustomerDAOimpl;
import com.nhom13.qlch.model.Customer;
import com.nhom13.qlch.service.CustomerService;
import com.nhom13.qlch.service.CustomerServiceimpl;
import com.nhom13.qlch.unity.ClassTableModelCustomer;
import com.nhom13.qlch.view.CustomerJFrame;
import com.nhom13.qlch.view.ThongKeKhachHangJFrame;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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


public class QuanLyKhachHangController {
    private JTextField txtSearchKhachHang;
    private JButton  btnAddCustomer;
    private JPanel jpnViewCustomer;
    private ClassTableModelCustomer classTableModelCustomer = null;

    private  String[] listcolumn  = {"STT", "MÃ KHÁCH HÀNG", "XẾP HẠNG", "TÊN",
        "HỌ ĐỆM", "NGÀY SINH", "EMAIL","SỐ ĐT", "ĐỊA CHỈ", "ĐÃ CHI TIÊU"};

    private CustomerService customerService = null;

    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyKhachHangController(JTextField txtSearchKhachHang, JButton btnAddCustomer, JPanel jpnViewCustomer) {
        this.txtSearchKhachHang = txtSearchKhachHang;
        this.btnAddCustomer = btnAddCustomer;
        this.jpnViewCustomer = jpnViewCustomer;
        this.customerService = new CustomerServiceimpl();
    }
     public void setDataToTable() {
        List<Customer> listItem = customerService.getList();
        customerService.setRank();
//        Product sanpham = listItem.get(1 );
//        System.out.println(sanpham.getPro_Brand());
        DefaultTableModel model = new ClassTableModelCustomer().setTableProduct(listItem, listcolumn );
        JTable table = new JTable(model);

         rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

         txtSearchKhachHang.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtSearchKhachHang.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearchKhachHang.getText();
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
            
            Customer customer = new Customer();
            customer.setMa_khach_hang(model.getValueAt(selectedRowIndex, 1).toString());
            customer.setTen(model.getValueAt(selectedRowIndex, 3).toString());
            customer.setHo_dem(model.getValueAt(selectedRowIndex, 4).toString());
//            customer.setTong_chi_tieu((float) model.getValueAt(selectedRowIndex, 9));
//            customer.setPro_Brand(model.getValueAt(selectedRowIndex, 5).toString());
//            product.setPro_Prize((float) model.getValueAt(selectedRowIndex, 6));
//            product.setPro_QIS((int) model.getValueAt(selectedRowIndex, 7));
//            product.setPro_Dimensions(model.getValueAt(selectedRowIndex, 8).toString());

            ThongKeKhachHangJFrame frame = new ThongKeKhachHangJFrame(customer);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle("Thông tin khách hàng");
            frame.setVisible(true);
        }
    }
});
//         design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

       

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnViewCustomer.removeAll();
        jpnViewCustomer.setLayout(new CardLayout());
        jpnViewCustomer.add(scroll);
        jpnViewCustomer.validate();
        jpnViewCustomer.repaint();

    }
      public void setEvent(){
  
     btnAddCustomer.addMouseListener(new MouseAdapter() {
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
                 
                    CustomerJFrame frame = new CustomerJFrame(new Customer());
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setTitle("Thông tin sản phẩm");
                    frame.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
});
}

}

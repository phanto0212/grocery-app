
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.service.NhapHangService;
import com.nhom13.qlch.service.NhapHangServiceimpl;
import com.nhom13.qlch.service.ProductService;
import com.nhom13.qlch.service.ProductServiceimpl;
import com.nhom13.qlch.unity.ClassTableModelProduct;
import com.nhom13.qlch.view.NhapHangJFrame;
import com.nhom13.qlch.view.ProductJFrame;
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


public class QuanLyNhapHangController {
    private JTextField jTextField1;
    private JButton btnSan_Pham_moi;
    private JButton btnNhap_san_pham;    
    private JPanel jpnView_san_pham_het_hang;     
    private  String[] listcolumns  = {"STT", "MÃ SẢN PHẨM", "MÃ PHÂN LOẠI", "MÃ NHÀ CUNG CẤP",
        "MÔ TẢ", "NHÃN HÀNG", "GIÁ BÁN", "GIÁ NHẬP","SỐ LƯỢNG", "KHỐI LƯỢNG/1", "NGÀY NHẬP HÀNG","NGÀY HẾT HẠN"};
    private NhapHangService nhapHangService = null;
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyNhapHangController(JTextField jTextField1, JButton btnSan_Pham_moi, JButton btnNhap_san_pham, JPanel jpnView_san_pham_het_hang) {
        this.jTextField1 = jTextField1;
        this.btnSan_Pham_moi = btnSan_Pham_moi;
        this.btnNhap_san_pham = btnNhap_san_pham;
        this.jpnView_san_pham_het_hang = jpnView_san_pham_het_hang;
        this.nhapHangService = new NhapHangServiceimpl();
    }
     public void setDataToTable() {
        List<Product> listItem = nhapHangService.getList();
//        Product sanpham = listItem.get(1 );
//        System.out.println(sanpham.getPro_Brand());
        DefaultTableModel model = new ClassTableModelProduct().setTableProduct(listItem, listcolumns );
        JTable table = new JTable(model);

         rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

         jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jTextField1.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jTextField1.getText();
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
            
            Product product = new Product();
            product.setProduct_code(model.getValueAt(selectedRowIndex, 1).toString());
            product.setCategory_code(model.getValueAt(selectedRowIndex, 2).toString());
            product.setSupplier_code(model.getValueAt(selectedRowIndex, 3).toString());
            product.setPro_Description(model.getValueAt(selectedRowIndex, 4).toString());
            product.setPro_Brand(model.getValueAt(selectedRowIndex, 5).toString());
            product.setPro_Prize((float) model.getValueAt(selectedRowIndex, 6));
            product.setPro_Import_Prize((float) model.getValueAt(selectedRowIndex, 7));
            product.setPro_QIS((int) model.getValueAt(selectedRowIndex, 8));
            product.setPro_Dimensions(model.getValueAt(selectedRowIndex, 9).toString());
            ProductJFrame frame = new ProductJFrame(product);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle("Thông tin sản phẩm");
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
        jpnView_san_pham_het_hang.removeAll();
        jpnView_san_pham_het_hang.setLayout(new CardLayout());
        jpnView_san_pham_het_hang.add(scroll);
        jpnView_san_pham_het_hang.validate();
        jpnView_san_pham_het_hang.repaint();

    }
     public void setEvent(){
  
     btnSan_Pham_moi.addMouseListener(new MouseAdapter() {
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
                 
                    ProductJFrame frame = new ProductJFrame(new Product());
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
      btnNhap_san_pham.addMouseListener(new MouseAdapter() {
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
                 
                    NhapHangJFrame frame = new NhapHangJFrame(new Product());
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setTitle("Nhập hàng");
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

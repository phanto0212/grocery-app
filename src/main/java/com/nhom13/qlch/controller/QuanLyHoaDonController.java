
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.invoice;
import com.nhom13.qlch.service.InvoiceService;
import com.nhom13.qlch.service.InvoiceServiceimpl;
import com.nhom13.qlch.unity.ClassTableModelInvoice;
import com.nhom13.qlch.unity.ClassTableModelProduct;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
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


public class QuanLyHoaDonController {
    private JTextField jtfSearchInvoice;
    private JPanel jpnViewInvoice;
    private ClassTableModelInvoice classTableModelInvoice = null;

    private  String[] listcolumn  = {"STT", "MÃ HÓA ĐƠN", "MÃ KHÁCH HÀNG", "MÃ NHÂN VIÊN",
        "NGÀY TẠO", "TỔNG HÓA ĐƠN", "PHƯƠNG THỨC"};

    private InvoiceService invoiceService = null;

    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyHoaDonController(JTextField jtfSearchInvoice, JPanel jpnViewInvoice) {
        this.jtfSearchInvoice = jtfSearchInvoice;
        this.jpnViewInvoice = jpnViewInvoice;
         this.classTableModelInvoice = new ClassTableModelInvoice();

        this.invoiceService = new InvoiceServiceimpl();
    }
    public void setDataToTable() {
        List<invoice> listItem = invoiceService.getList();
//        Product sanpham = listItem.get(1 );
//        System.out.println(sanpham.getPro_Brand());
        DefaultTableModel model = new ClassTableModelInvoice().setTableProduct(listItem, listcolumn );
        JTable table = new JTable(model);

         rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

         jtfSearchInvoice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearchInvoice.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearchInvoice.getText();
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
//         table.addMouseListener(new MouseAdapter() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//        if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
//            DefaultTableModel model = (DefaultTableModel) table.getModel();
//            int selectedRowIndex = table.getSelectedRow();
//            
//            // Chuyển đổi chỉ số hàng hiển thị thành chỉ số hàng trong mô hình
//            selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
//            
//            Product product = new Product();
//            product.setProduct_code(model.getValueAt(selectedRowIndex, 1).toString());
//            product.setCategory_code(model.getValueAt(selectedRowIndex, 2).toString());
//            product.setSupplier_code(model.getValueAt(selectedRowIndex, 3).toString());
//            product.setPro_Description(model.getValueAt(selectedRowIndex, 4).toString());
//            product.setPro_Brand(model.getValueAt(selectedRowIndex, 5).toString());
//            product.setPro_Prize((float) model.getValueAt(selectedRowIndex, 6));
//            product.setPro_QIS((int) model.getValueAt(selectedRowIndex, 7));
//            product.setPro_Dimensions(model.getValueAt(selectedRowIndex, 8).toString());
//
//            ProductJFrame frame = new ProductJFrame(product);
//            frame.setLocationRelativeTo(null);
//            frame.setResizable(false);
//            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            frame.setTitle("Thông tin sản phẩm");
//            frame.setVisible(true);
//        }
//    }
//});
//         design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

       

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnViewInvoice.removeAll();
        jpnViewInvoice.setLayout(new CardLayout());
        jpnViewInvoice.add(scroll);
        jpnViewInvoice.validate();
        jpnViewInvoice.repaint();

    }
    
}


package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Line;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.invoice;
import com.nhom13.qlch.service.CustomerService;
import com.nhom13.qlch.service.CustomerServiceimpl;
import com.nhom13.qlch.service.InvoiceService;
import com.nhom13.qlch.service.InvoiceServiceimpl;
import com.nhom13.qlch.service.LineService;
import com.nhom13.qlch.service.LineServiceimpl;
import com.nhom13.qlch.service.NhapHangService;
import com.nhom13.qlch.service.NhapHangServiceimpl;
import com.nhom13.qlch.unity.ClassTableModelInvoice;
import com.nhom13.qlch.unity.ClassTableModelProduct;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class QuanLyTrangChuController {
 private float total_doanh_thu;
 private int total_don_hang;
 private int total_hoa_don;
 private JPanel JPanelViewHangSapHet;
 private JLabel jtfTong_doanh_thu;
 private JLabel jtfDon_Da_Ban;
 private JLabel jtfSo_Luong_Hoa_Don;
    private ClassTableModelProduct classTableModelProduct = null;
    private ClassTableModelInvoice classTableModelInvoice = null;
    private  String[] listcolumn  = {"STT", "MÃ HÓA ĐƠN", "MÃ KHÁCH HÀNG", "MÃ NHÂN VIÊN",
        "NGÀY TẠO", "TỔNG TIỀN", "PHƯƠNG THỨC"};

    private NhapHangService nhapHangService = null;
    private InvoiceService invoiceService=null;
    private LineService lineService=null;
    private CustomerService customerService= null;
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyTrangChuController(JPanel JPanelViewHangSapHet) {
        this.JPanelViewHangSapHet = JPanelViewHangSapHet;
        this.nhapHangService = new NhapHangServiceimpl();
    }



    public QuanLyTrangChuController(JPanel JPanelViewHangSapHet, JLabel jtfTong_doanh_thu, JLabel jtfDon_Da_Ban, JLabel jtfSo_Luong_Hoa_Don) {
        this.JPanelViewHangSapHet = JPanelViewHangSapHet;
        this.jtfTong_doanh_thu = jtfTong_doanh_thu;
        this.jtfDon_Da_Ban = jtfDon_Da_Ban;
        this.jtfSo_Luong_Hoa_Don = jtfSo_Luong_Hoa_Don;
        this.nhapHangService = new NhapHangServiceimpl();
        this.invoiceService= new InvoiceServiceimpl();
        this.lineService = new LineServiceimpl();
        this.customerService = new CustomerServiceimpl();
    }


    
     public void setDataToTable() {
        List<invoice> listItem = invoiceService.getListToday();
//        Product sanpham = listItem.get(1 );
//        System.out.println(sanpham.getPro_Brand());
        DefaultTableModel model = new ClassTableModelInvoice().setTableProduct(listItem, listcolumn );
        JTable table = new JTable(model);

         rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

//         txtSearchProduct.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                String text = txtSearchProduct.getText();
//                if (text.trim().length() == 0) {
//                    rowSorter.setRowFilter(null);
//                } else {
//                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//                }
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                String text = txtSearchProduct.getText();
//                if (text.trim().length() == 0) {
//                    rowSorter.setRowFilter(null);
//                } else {
//                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//                }
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//            }
//        });
//         table.addMouseListener(new MouseAdapter() {
//    @Override
//    public void mouseClicked(MouseEvent e) {
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
        scroll.setPreferredSize(new Dimension(1350, 650));
        JPanelViewHangSapHet.removeAll();
        JPanelViewHangSapHet.setLayout(new CardLayout());
        JPanelViewHangSapHet.add(scroll);
        JPanelViewHangSapHet.validate();
        JPanelViewHangSapHet.repaint();

    }
     public void setDataToText(){
         List<invoice> listInvoice = invoiceService.getList();
         List<Line> listLine = lineService.getList();
         float tongtienno = customerService.TongCongNo();
         for (invoice hoadon: listInvoice){
             total_doanh_thu+=hoadon.getInv_total();
     
         }
         total_hoa_don=listInvoice.size();
         for (Line duong:listLine){
             total_don_hang+=duong.getSoluong();
         }
         
         String strNumberhoadon = String.valueOf(total_hoa_don);
         String strNumberdonhang = String.valueOf(total_don_hang);
         String strFloatDoanhThu = String.valueOf(total_doanh_thu);
//          String Result = String.format("%.2f", total_doanh_thu);
          DecimalFormat decimalFormat = new DecimalFormat("###,###.000");
          String formated = decimalFormat.format(total_doanh_thu-tongtienno);
         jtfTong_doanh_thu.setText(formated);
         jtfDon_Da_Ban.setText(strNumberdonhang);
         jtfSo_Luong_Hoa_Don.setText(strNumberhoadon);
     }

}

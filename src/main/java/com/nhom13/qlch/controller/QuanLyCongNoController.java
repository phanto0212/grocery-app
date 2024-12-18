/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Customer;
import com.nhom13.qlch.service.CustomerService;
import com.nhom13.qlch.service.CustomerServiceimpl;
import com.nhom13.qlch.unity.ClassTableModelCustomer;
import com.nhom13.qlch.unity.ClassTableModelKhoanNoCus;
import com.nhom13.qlch.view.TraNoJFrame;
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

/**
 *
 * @author Admin
 */
public class QuanLyCongNoController {
    private JTextField jtfSearch;
    private JButton btnSietNo;
    private JPanel jpanelViewCongNo;
   private  String[] listcolumn  = {"STT", "MÃ KHÁCH HÀNG", "XẾP HẠNG", "TÊN",
        "HỌ ĐỆM", "NGÀY SINH", "EMAIL","SỐ ĐT", "ĐỊA CHỈ", "TỔNG NỢ"};

    private CustomerService customerService = null;

    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyCongNoController(JTextField jtfSearch, JButton btnSietNo, JPanel jpanelViewCongNo) {
        this.jtfSearch = jtfSearch;
        this.btnSietNo = btnSietNo;
        this.jpanelViewCongNo = jpanelViewCongNo;
        this.customerService= new CustomerServiceimpl();
        
    }
    public void setDataToTable(){
        List<Customer> listItem = customerService.getList();
        customerService.setRank();
//        Product sanpham = listItem.get(1 );
//        System.out.println(sanpham.getPro_Brand());
        DefaultTableModel model = new ClassTableModelKhoanNoCus().setTableProduct(listItem, listcolumn );
        JTable table = new JTable(model);

         rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

         jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
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
          
         table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

       

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 750));
        jpanelViewCongNo.removeAll();
        jpanelViewCongNo.setLayout(new CardLayout());
        jpanelViewCongNo.add(scroll);
        jpanelViewCongNo.validate();
        jpanelViewCongNo.repaint();
    }
    public void setEvent(){
        btnSietNo.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
   
      TraNoJFrame jframe = new TraNoJFrame();
jframe.setLocationRelativeTo(null); // Đặt vị trí xuất hiện của frame là giữa màn hình
jframe.setResizable(false); // Ngăn chặn khả năng thay đổi kích thước frame
jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng frame khi đóng cửa sổ
jframe.setVisible(true); // Hiển thị frame lên giao diện

      
        
                

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

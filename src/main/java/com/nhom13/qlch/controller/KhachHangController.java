
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Customer;
import com.nhom13.qlch.service.CustomerService;
import com.nhom13.qlch.service.CustomerServiceimpl;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class KhachHangController {
    private final String PHONE_PATTERN = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    private final Pattern pattern_phone = Pattern.compile(PHONE_PATTERN);
    private final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final Pattern pattern_email = Pattern.compile(EMAIL_PATTERN);
     private JButton btnLUUKhach_hang;
    private JTextField jtfMa_khach_hang;
    private JTextField jtfTen_kh;
    private JTextField jtfHo_dem;
    private JTextField jtfEmail;
    private JTextField jtfSo_dt;
    private JTextArea jtaDia_chi;
    private JDateChooser jdKhach_hang;
    private JButton btnUpdate;
    private JButton btnXoa_khach_hang;
    private JLabel jlbReact;
    
    Customer customer = null;
    private CustomerService customerService =null;

    public KhachHangController(JButton btnLUUKhach_hang, JTextField jtfMa_khach_hang, JTextField jtfTen_kh, JTextField jtfHo_dem, JTextField jtfEmail, JTextField jtfSo_dt, JTextArea jtaDia_chi, JDateChooser jdKhach_hang, JButton btnUpdate, JButton btnXoa_khach_hang) {
        this.btnLUUKhach_hang = btnLUUKhach_hang;
        this.jtfMa_khach_hang = jtfMa_khach_hang;
        this.jtfTen_kh = jtfTen_kh;
        this.jtfHo_dem = jtfHo_dem;
        
        this.jtfEmail = jtfEmail;
        this.jtfSo_dt = jtfSo_dt;
        this.jtaDia_chi = jtaDia_chi;
        this.jdKhach_hang = jdKhach_hang;
        this.btnUpdate = btnUpdate;
        this.btnXoa_khach_hang = btnXoa_khach_hang;
         this.customerService = new CustomerServiceimpl();
    }

    public KhachHangController(JButton btnLUUKhach_hang, JTextField jtfMa_khach_hang, JTextField jtfTen_kh, JTextField jtfHo_dem, JTextField jtfEmail, JTextField jtfSo_dt, JTextArea jtaDia_chi, JDateChooser jdKhach_hang, JButton btnUpdate, JButton btnXoa_khach_hang, JLabel jlbReact) {
        this.btnLUUKhach_hang = btnLUUKhach_hang;
        this.jtfMa_khach_hang = jtfMa_khach_hang;
        this.jtfTen_kh = jtfTen_kh;
        this.jtfHo_dem = jtfHo_dem;
        this.jtfEmail = jtfEmail;
        this.jtfSo_dt = jtfSo_dt;
        this.jtaDia_chi = jtaDia_chi;
        this.jdKhach_hang = jdKhach_hang;
        this.btnUpdate = btnUpdate;
        this.btnXoa_khach_hang = btnXoa_khach_hang;
        this.jlbReact = jlbReact;
        this.customerService = new CustomerServiceimpl();
    }
    
    public void setEvent(){
        btnUpdate.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
         if (jtfMa_khach_hang.getText().isEmpty() || jdKhach_hang.getDate() == null  || jtfTen_kh.getText().isEmpty() || jtfHo_dem.getText().isEmpty() ||jtfEmail.getText().isEmpty()  || jtfSo_dt.getText().isEmpty() || jtaDia_chi.getText().isEmpty() ){
             jlbReact.setText("Vui Lòng Nhập Đầy Đủ Thông Tin");
             return;
         }
         Customer customer = new Customer();
         customer.setRank_id("01");
         customer.setMa_khach_hang(jtfMa_khach_hang.getText());
         customer.setTen(jtfTen_kh.getText());
         customer.setHo_dem(jtfHo_dem.getText());
         customer.setDob_khach_hang(jdKhach_hang.getDate());
         customer.setEmail(jtfEmail.getText());
         customer.setSo_dien_thoai(jtfSo_dt.getText());
         customer.setDia_chi(jtaDia_chi.getText());
         int result =0;
         result = customerService.Update(customer);
         if (result > 0 ){
             jlbReact.setText("cap nhat thành cong");
         }
         else{
            jlbReact.setText("sai"); 
         }
         
         
         
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    });
//        btnXoa_khach_hang.addMouseListener(new MouseAdapter() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            if (jtfMa_khach_hang.getText().isEmpty() 
//              ) {
//                jlbReact.setText("NHẬP MÃ ĐỂ XÓA NHÂN VIÊN");
//                return;
//            }
//
//            Customer product = new Customer();
//            product.setMa_khach_hang(jtfMa_khach_hang.getText());
//            
//
//            int result = customerService.Delete(product);
//            if (result > 0 && showDialog("xóa")) {
//                jlbReact.setText("XÓA THÀNH CÔNG!");
//            } else {
//                jlbReact.setText("Có lỗi xảy ra, vui lòng thử lại");
//            }
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//        }
//    });
     btnLUUKhach_hang.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
         if (jtfMa_khach_hang.getText().isEmpty() || jdKhach_hang.getDate() == null  || jtfTen_kh.getText().isEmpty() || jtfHo_dem.getText().isEmpty() ||jtfEmail.getText().isEmpty()  || jtfSo_dt.getText().isEmpty() || jtaDia_chi.getText().isEmpty() ){
             jlbReact.setText("Vui Lòng Nhập Đầy Đủ Thông Tin");
             return;
         }
         Customer customer = new Customer();
         customer.setRank_id("01");
         customer.setMa_khach_hang(jtfMa_khach_hang.getText());
         customer.setTen(jtfTen_kh.getText());
         customer.setHo_dem(jtfHo_dem.getText());
         customer.setDob_khach_hang(jdKhach_hang.getDate());
         customer.setEmail(jtfEmail.getText());
         customer.setSo_dien_thoai(jtfSo_dt.getText());
         customer.setDia_chi(jtaDia_chi.getText());
         int result =0;
         result = customerService.Insert(customer);
         if (result > 0 ){
             jlbReact.setText("LUu thành cong");
         }
         else{
            jlbReact.setText("sai"); 
         }
         
         
         
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    });   
}}

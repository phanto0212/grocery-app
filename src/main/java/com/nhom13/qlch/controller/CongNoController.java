
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Customer;
import com.nhom13.qlch.service.CustomerService;
import com.nhom13.qlch.service.CustomerServiceimpl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class CongNoController {
    private float ConNo,temp;
    private JTextField jtfMaKhachHang;
    private JLabel    jlbTenKhach;
    private JLabel jlbtongNo;
    private JTextField jtfTraTien;
    private JLabel jlbConNo;
    private JButton btnLuu;
    private JButton btnHuy;
    private JButton btnTimkiem;
    private JLabel jlbReact;
    
    private CustomerService customerService = null;


 

    public CongNoController(JTextField jtfMaKhachHang, JLabel jlbTenKhach, JLabel jlbtongNo, JTextField jtfTraTien, JLabel jlbConNo, JButton btnLuu, JButton btnHuy, JButton btnTimkiem, JLabel jlbReact) {
        this.jtfMaKhachHang = jtfMaKhachHang;
        this.jlbTenKhach = jlbTenKhach;
        this.jlbtongNo = jlbtongNo;
        this.jtfTraTien = jtfTraTien;
        this.jlbConNo = jlbConNo;
        this.btnLuu = btnLuu;
        this.btnHuy = btnHuy;
        this.btnTimkiem = btnTimkiem;
        this.jlbReact = jlbReact;
        this.customerService = new CustomerServiceimpl();
    }
    
    public void setEvent(){
        List<Customer> list = customerService.getList();
         btnTimkiem.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        boolean t= true;
   for (Customer khach:list){
       if(khach.getMa_khach_hang().equals(jtfMaKhachHang.getText())){
           t=false;
           DecimalFormat decimalFormat = new DecimalFormat("0.0");
           jlbTenKhach.setText(khach.getHo_dem()+" "+khach.getTen());
          
           jlbtongNo.setText(decimalFormat.format(khach.getKhoan_no()));
           jlbConNo.setText(decimalFormat.format(khach.getKhoan_no()));
       }
       if (t){
           jlbReact.setText("Mã khách hàng không tồn tại!");
           jlbTenKhach.setText("");
           jlbtongNo.setText("");
       }
       else{
          jlbReact.setText(""); 
          
       }
   }
                

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
});
          jtfTraTien.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
         if(!jtfTraTien.getText().isEmpty()){
             DecimalFormat decimalFormat = new DecimalFormat("0.0");
           float TongNo = Float.parseFloat(jlbtongNo.getText());
         ConNo =  TongNo-Float.parseFloat(jtfTraTien.getText());
         jlbConNo.setText(decimalFormat.format(ConNo));
         if (jtfTraTien.getText().length()==1){
             temp = Float.parseFloat(jtfTraTien.getText());
         }
         }
         
              
            
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
       if (!jtfTraTien.getText().isEmpty()){
           float TongNo = Float.parseFloat(jlbtongNo.getText());
           ConNo =TongNo- Float.parseFloat(jtfTraTien.getText());//sai can sua lai
           jlbConNo.setText(String.valueOf(ConNo));
           if (jtfTraTien.getText().length()==1){
             temp = Float.parseFloat(jtfTraTien.getText());
         }
       }
       else{
          jlbConNo.setText(String.valueOf(ConNo+temp)); 
       }
           
//                jlbCongNo.setText(String.valueOf(total));   
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
//        jlbCongNo.setText(String.valueOf(total));  
    }
});
                 btnLuu.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
   if (jtfMaKhachHang.getText().isEmpty() || jlbTenKhach.getText().isEmpty() ){
       JOptionPane.showMessageDialog(null, "Phải nhập đủ thông tin mới trừ nợ được!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
               return;
   }else{
        float tinh = Float.parseFloat(jlbtongNo.getText())-Float.parseFloat(jtfTraTien.getText());
             float trutien = Float.parseFloat(jtfTraTien.getText());
             if (tinh>0){
                 if(customerService.trutien(jtfMaKhachHang.getText(), trutien)>0){
                    jlbReact.setText("thanh toán thành công");
                 }
                 
                 
             }
             else{
                 if(customerService.trutien(jtfMaKhachHang.getText(), Float.parseFloat(jlbtongNo.getText()))>0){
                    jlbReact.setText("thanh toán thành công");
                 }
                
             }
   }
            

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

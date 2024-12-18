/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.controller;

import com.nhom13.qlch.dao.CustomerDAO;
import com.nhom13.qlch.dao.CustomerDAOimpl;
import com.nhom13.qlch.model.Customer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class ThongKeKhachHangController {
    private JLabel jlbTenKhachHang;
    private JLabel jlbMaKhachHang;
    private JLabel jlbDonHangDaMua;
    private JLabel jlbHoaDon;
    private JButton btnClose;
    private CustomerDAO customerDAO = null;

    public ThongKeKhachHangController(JLabel jlbTenKhachHang, JLabel jlbMaKhachHang, JLabel jlbDonHangDaMua, JLabel jlbHoaDon, JButton btnClose) {
        this.jlbTenKhachHang = jlbTenKhachHang;
        this.jlbMaKhachHang = jlbMaKhachHang;
        this.jlbDonHangDaMua = jlbDonHangDaMua;
        this.jlbHoaDon = jlbHoaDon;
        this.btnClose = btnClose;
        this.customerDAO = new CustomerDAOimpl();
    }
    public void setView(Customer customer){
       jlbTenKhachHang.setText(customer.getHo_dem()+" "+customer.getTen());
       jlbMaKhachHang.setText(customer.getMa_khach_hang());
       int soluongsanpham = customerDAO.TongSanPham(customer);
       int soluonghoadon = customerDAO.TongHoaDon(customer);
      jlbDonHangDaMua.setText(String.valueOf(soluongsanpham));
      jlbHoaDon.setText(String.valueOf(soluonghoadon));
       btnClose.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnClose);
            frame.dispose();

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Account;
import com.nhom13.qlch.service.AccountService;
import com.nhom13.qlch.service.AccountServiceimpl;
import com.nhom13.qlch.view.DoiMatKhauJFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SettingTaiKhoanController {
    private JLabel jlbTenTaiKhoan;
    private JLabel jlbHoaDonNumberToday;
    private JLabel jlbProductNumberToday;
    private JLabel jlbDoanhSoToday;
    private JLabel jlbTongDonHang;
    private JLabel jlbTongSoLuongSanPham;
    private JLabel jlbTongDoanhThu;
    private JButton btnDoiMatKhau;
     private AccountService accountService = null;

    public SettingTaiKhoanController(JLabel jlbTenTaiKhoan, JLabel jlbHoaDonNumberToday, JLabel jlbProductNumberToday, JLabel jlbDoanhSoToday, JLabel jlbTongDonHang, JLabel jlbTongSoLuongSanPham, JLabel jlbTongDoanhThu, JButton btnDoiMatKhau) {
        this.jlbTenTaiKhoan = jlbTenTaiKhoan;
        this.jlbHoaDonNumberToday = jlbHoaDonNumberToday;
        this.jlbProductNumberToday = jlbProductNumberToday;
        this.jlbDoanhSoToday = jlbDoanhSoToday;
        this.jlbTongDonHang = jlbTongDonHang;
        this.jlbTongSoLuongSanPham = jlbTongSoLuongSanPham;
        this.jlbTongDoanhThu = jlbTongDoanhThu;
        this.btnDoiMatKhau = btnDoiMatKhau;
        this.accountService = new AccountServiceimpl();
    }

    

    
   public void setEvent(){
       List<Account> account = accountService.getTaiKhoan();
       String tentaikhoan= account.get(0).getTen_dang_nhap();
       int soluonghoadonhomnay = accountService.getHoaDonHomNay(tentaikhoan);
       int soluongdonhanghomnay = accountService.getDonHangHomNay(tentaikhoan);
       float doanhthuhomnay = accountService.getDoanhThuHomNay(tentaikhoan);
       int tongsohoadon = accountService.getSoLuongHoaDon(tentaikhoan);
       int tongsodonhang = accountService.getSoluongDonHang(tentaikhoan);
       float tongdoanhthu = accountService.getTongDoanhThu(tentaikhoan);
       jlbHoaDonNumberToday.setText(String.valueOf(soluonghoadonhomnay));
       jlbProductNumberToday.setText(String.valueOf(soluongdonhanghomnay));
       jlbDoanhSoToday.setText(String.valueOf(doanhthuhomnay));
       jlbTongDonHang.setText(String.valueOf(tongsohoadon));
       jlbTongSoLuongSanPham.setText(String.valueOf(tongsodonhang));
       jlbTongDoanhThu.setText(String.valueOf(tongdoanhthu));
       List<Account> list = accountService.getTaiKhoan();
       Account taikhoan = list.getFirst();
       jlbTenTaiKhoan.setText(taikhoan.getTen_dang_nhap());
            btnDoiMatKhau.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DoiMatKhauJFrame frame = new DoiMatKhauJFrame();
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setTitle("Đổi Mật Khẩu");
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

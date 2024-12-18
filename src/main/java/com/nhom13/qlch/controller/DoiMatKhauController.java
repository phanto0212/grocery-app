/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Account;
import com.nhom13.qlch.service.AccountService;
import com.nhom13.qlch.service.AccountServiceimpl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class DoiMatKhauController {
    private JPasswordField jpfMatKhauHienTai;
    private JPasswordField jpfMatKhauMoi;
    private JPasswordField jpfMatKhauMoiXacNhan;
    private JLabel jlbReact;
    private JButton btnSubmit;
    private AccountService accountService = null;

    public DoiMatKhauController(JPasswordField jpfMatKhauHienTai, JPasswordField jpfMatKhauMoi, JPasswordField jpfMatKhauMoiXacNhan, JLabel jlbReact, JButton btnSubmit) {
        this.jpfMatKhauHienTai = jpfMatKhauHienTai;
        this.jpfMatKhauMoi = jpfMatKhauMoi;
        this.jpfMatKhauMoiXacNhan = jpfMatKhauMoiXacNhan;
        this.jlbReact = jlbReact;
        this.btnSubmit = btnSubmit;
        this.accountService = new AccountServiceimpl();
    }
    public void setEvent(){
        
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<Account> list = accountService.getTaiKhoan();
                Account taikhoan = list.getFirst();
                char[] passwordChar = jpfMatKhauHienTai.getPassword();
                String passwordnow = new String(passwordChar);
                char[] passwordChars = jpfMatKhauMoi.getPassword();
                String passwordnew = new String(passwordChars);
                char[] passwordChars1 = jpfMatKhauMoiXacNhan.getPassword();
                String repasswordnew = new String(passwordChars1);
                if (passwordnow.equals(taikhoan.getMat_khau())) {
                    if (passwordnew.equals(repasswordnew)) {
                        accountService.Update(taikhoan.getTen_dang_nhap(), passwordnew);
                        jlbReact.setText("Đổi mật khẩu thành công");
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnSubmit);
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        jlbReact.setText("Nhập đúng đi mới đổi được");
                    }
                } else {
                    jlbReact.setText("Mật khẩu của bạn không đúng");
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

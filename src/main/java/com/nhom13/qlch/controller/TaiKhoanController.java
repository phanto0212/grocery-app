
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Account;
import com.nhom13.qlch.service.AccountService;
import com.nhom13.qlch.service.AccountServiceimpl;
import com.nhom13.qlch.view.MainJFrame;
import com.nhom13.qlch.view.SignUpJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class TaiKhoanController {
    private JFrame jFrame;
    private JTextField jtfUsername;
    private JPasswordField jPasswordField1;
    private JLabel jlbMsg;
    private JButton btnLogin;
    private JButton btnDK;
    private AccountService accountService = null;

    public TaiKhoanController() {
    }

   
    public TaiKhoanController(JFrame jFrame, JTextField jtfUsername, JPasswordField jPasswordField1, JLabel jlbMsg, JButton btnLogin) {
        this.jFrame = jFrame;
        this.jtfUsername = jtfUsername;
        this.jPasswordField1 = jPasswordField1;
        this.jlbMsg = jlbMsg;
        this.btnLogin = btnLogin;
        this.accountService = new AccountServiceimpl();
    }

    public TaiKhoanController(JFrame jFrame, JTextField jtfUsername, JPasswordField jPasswordField1, JLabel jlbMsg, JButton btnLogin, JButton btnDK) {
        this.jFrame = jFrame;
        this.jtfUsername = jtfUsername;
        this.jPasswordField1 = jPasswordField1;
        this.jlbMsg = jlbMsg;
        this.btnLogin = btnLogin;
        this.btnDK = btnDK;
        this.accountService = new AccountServiceimpl();
    }



    public void setEvent() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = jtfUsername.getText();
                char[] passwordChars = jPasswordField1.getPassword();
                String password = new String(passwordChars);

                if (username.isEmpty() || password.isEmpty()) {
                    jlbMsg.setText("Vui lòng nhập đầy đủ thông tin");
                    return;
                }

                Account account = accountService.login(username, password);
                if (account == null) {
                    jlbMsg.setText("Tên đăng nhập hoặc mật khẩu không chính xác");
                } else {
                    jFrame.dispose();
                    accountService.setTaiKhoan(username, password);
                    MainJFrame mainJFrame = new MainJFrame();
                    mainJFrame.setTitle("Quản lý Cửa hàng");
                    mainJFrame.setLocationRelativeTo(null);
                    mainJFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    mainJFrame.setVisible(true);
                }

                // Xóa mật khẩu từ bộ nhớ sau khi đã sử dụng xong
                java.util.Arrays.fill(passwordChars, ' ');
            }
        });

//        btnLogin.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//               
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                if (jtfUsername.getText().isEmpty() || jPasswordField1.getPassword().length == 0) {
//                    jlbMsg.setText("Vui lòng nhập đầy đủ thông tin");
//                } else {
////                    jllbMsg.setText("");
//                }
//            }
//        });
           btnDK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jFrame.dispose();
               SignUpJFrame frame = new SignUpJFrame();
               frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle("Đăng Ký"
                    );
            frame.setVisible(true);
            }
        });
    }
}

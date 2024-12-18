
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Account;
import com.nhom13.qlch.service.AccountService;
import com.nhom13.qlch.service.AccountServiceimpl;
import com.nhom13.qlch.view.LoginJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SignUpController {
    private JFrame jframe;
    private JTextField jtfUsername;
    private JPasswordField jtfPassword;
    private JPasswordField jtfRe_Password;
    private JButton btnSignUp;
    private JButton btnLogin;
    private JLabel jlbReact;
    private AccountService accountService = null;

    public SignUpController(JFrame jframe, JTextField jtfUsername, JPasswordField jtfPassword, JPasswordField jtfRe_Password, JButton btnSignUp, JButton btnLogin, JLabel jlbReact) {
        this.jframe = jframe;
        this.jtfUsername = jtfUsername;
        this.jtfPassword = jtfPassword;
        this.jtfRe_Password = jtfRe_Password;
        this.btnSignUp = btnSignUp;
        this.btnLogin = btnLogin;
        this.jlbReact = jlbReact;
        this.accountService = new AccountServiceimpl();
    }
    public void setEvent(){
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String username = jtfUsername.getText();
             char[] passwordChars = jtfPassword.getPassword();
             String password = new String(passwordChars);
             char[] passwordChars1 = jtfRe_Password.getPassword();
             String repassword = new String(passwordChars1);
             List <Account> list= accountService.getList();
             if(username.isEmpty()||password.isEmpty()||repassword.isEmpty()){
                 jlbReact.setText("Vui Lòng Nhập Đầy Đủ Thông Tin!!");
             }
             else{
                 boolean t=true;
                 for (Account taikhoan: list){
                     if (username.equals(taikhoan.getTen_dang_nhap())){
                         jlbReact.setText("Tên Đăng Nhập Đã Tồn Tại");
                         t=false;
                     }
                 }
                 if(t){
                     if(password.equals(repassword)){
                        accountService.SignUp(username, password);
                        
                        jlbReact.setText("Đăng Ký Thành Công");
             
            }
                     }
                     else{
                         jlbReact.setText("Mật Khẩu Không Trùng Khớp");
                     }
                 
                 
             }
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                         jframe.dispose();
               LoginJFrame frame = new LoginJFrame();
               frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle("Đăng Ký"
                    );
            frame.setVisible(true);}
        });
    }

   
    
    
    
    
}

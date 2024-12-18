
package com.nhom13.qlch.controller;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.nhom13.qlch.model.Employee;
import com.nhom13.qlch.service.EmployeeService;
import com.nhom13.qlch.service.EmployeeServiceimpl;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class NhanVienController {
      private final String PHONE_PATTERN = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    private final Pattern pattern_phone = Pattern.compile(PHONE_PATTERN);
    private final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final Pattern pattern_email = Pattern.compile(EMAIL_PATTERN);
     private JButton btnLUUEmp;
    private JTextField jtfma_nhan_vien;
    private JTextField jtften_nhan_vien;
    private JTextField jtften_dem;
    private JTextField jtfchuc_vu;
    private JTextField jtfmuc_luong;
    private JTextField jtfdia_chi;
    private JTextField jtfemail;
    private JTextField jtfso_dt;
    private JDateChooser jdngay_sinh;
    private JDateChooser jdngay_lam;
    private JLabel jlbStatus;
    private JButton btnUpdateEmp;
    private JButton btnDeleteEmp;
    Employee employee = null;
    private EmployeeService employeeService =null;

    public NhanVienController(JButton btnLUUEmp, JTextField jtfma_nhan_vien, JTextField jtften_nhan_vien, JTextField jtften_dem, JTextField jtfchuc_vu, JTextField jtfmuc_luong, JTextField jtfdia_chi, JTextField jtfemail, JTextField jtfso_dt, JDateChooser jdngay_sinh, JDateChooser jdngay_lam, JLabel jlbStatus, JButton btnUpdateEmp, JButton btnDeleteEmp) {
        this.btnLUUEmp = btnLUUEmp;
        this.jtfma_nhan_vien = jtfma_nhan_vien;
        this.jtften_nhan_vien = jtften_nhan_vien;
        this.jtften_dem = jtften_dem;
        this.jtfchuc_vu = jtfchuc_vu;
        this.jtfmuc_luong = jtfmuc_luong;
        this.jtfdia_chi = jtfdia_chi;
        this.jtfemail = jtfemail;
        this.jtfso_dt = jtfso_dt;
        this.jdngay_sinh = jdngay_sinh;
        this.jdngay_lam = jdngay_lam;
        this.jlbStatus = jlbStatus;
        this.btnUpdateEmp = btnUpdateEmp;
        this.btnDeleteEmp = btnDeleteEmp;
        this.employeeService = new EmployeeServiceimpl();
    }
     public void setView(Employee employee){
        this.employee = employee;
        jtfma_nhan_vien.setText(employee.getma_nhan_vien());
        jtften_nhan_vien.setText(employee.getFist_name());
        jtften_dem.setText(employee.getLast_name());
        jtfchuc_vu.setText(employee.getCong_viec());
        String salaryText = String.valueOf(employee.getSalary());
        jtfmuc_luong.setText(salaryText);
        jtfdia_chi.setText(employee.getadress());
        jtfemail.setText(employee.getemail());
        jtfso_dt.setText(employee.getphone());
        Date ngaySinh = employee.getNgay_sinh(); // Giả sử ngày sinh đã được lưu dưới dạng Date
        jdngay_sinh.setDate(ngaySinh); // Thiết lập ngày sinh cho JDateChooser
        Date ngayVolam = employee.getNgay_vo_lam(); 
        jdngay_lam.setDate(ngayVolam);
}
        public void setEvent() {
    btnLUUEmp.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
           if (jtfma_nhan_vien.getText().isEmpty() || jtften_nhan_vien.getText().isEmpty() || jtften_dem.getText().isEmpty() || jtfmuc_luong.getText().equals("0.0") || jtfchuc_vu.getText().isEmpty() || jtfdia_chi.getText().isEmpty() || jtfemail.getText().isEmpty() || jtfso_dt.getText().isEmpty() || jdngay_sinh.getDate() == null || jdngay_lam.getDate() == null) {
    jlbStatus.setText("VUI LÒNG NHẬP DỮ LIỆU BẮT BUỘC ");
    return; // Kết thúc phương thức nếu dữ liệu không hợp lệ
}

            

            Employee  employee = new Employee();
            employee.setma_nhan_vien(jtfma_nhan_vien.getText());
            employee.setFist_name(jtften_nhan_vien.getText());
            employee.setLast_name(jtften_dem.getText());
            employee.setCong_viec(jtfchuc_vu.getText());
            employee.setadress(jtfdia_chi.getText());

            if (StringUtils.isNumeric(jtfmuc_luong.getText()) || StringUtils.isNumeric(jtfmuc_luong.getText().replace(".", ""))) {
                float floatValue = Float.parseFloat(jtfmuc_luong.getText());
                employee.setSalary(floatValue);
            } else {
                jlbStatus.setText("MỨC LƯƠNG KHÔNG HỢP LÊ!");
                return; // Ngăn chặn việc tiếp tục thực hiện thêm sản phẩm nếu dữ liệu không hợp lệ
            }
            employee.setNgay_sinh(jdngay_sinh.getDate());
            employee.setNgay_vo_lam(jdngay_lam.getDate());
            if (validate_phone(jtfso_dt.getText()) && validate_email(jtfemail.getText())) {
                        employee.setphone(jtfso_dt.getText());
                        employee.setemail(jtfemail.getText());
                         if (showDialog("thêm")) {
                        int lastid = employeeService.insert(employee);
                        if (lastid > 0) {
                            jlbStatus.setText("Thêm dữ liệu thành công!");
                        } else {
                            jlbStatus.setText("Có lỗi xảy ra, vui lòng thử lại!");
                        }
                    }
            }
                       
            else {
                if (!validate_phone(jtfso_dt.getText())) {
                            jlbStatus.setText("Số điện thoại không hợp lệ VD: +8412345678.");
                        } else if (!validate_email(jtfemail.getText())) {
                            jlbStatus.setText("Email không hợp lệ VD: user123@example.com.");
                        } else {
                            jlbStatus.setText("Số điện thoại và email không hợp lệ.");
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

    btnUpdateEmp.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
             if (jtfma_nhan_vien.getText().isEmpty() || jtften_nhan_vien.getText().isEmpty() || jtften_dem.getText().isEmpty() || jtfmuc_luong.getText().equals("0.0") || jtfchuc_vu.getText().isEmpty() || jtfdia_chi.getText().isEmpty() || jtfemail.getText().isEmpty() || jtfso_dt.getText().isEmpty() || jdngay_sinh.getDate() == null || jdngay_lam.getDate() == null)  {
                jlbStatus.setText("VUI LÒNG NHẬP ĐẦY ĐỦ THÔNG TIN");
                return;
            }

            Employee  employee = new Employee();
            employee.setma_nhan_vien(jtfma_nhan_vien.getText());
            employee.setFist_name(jtften_nhan_vien.getText());
            employee.setLast_name(jtften_dem.getText());
            employee.setCong_viec(jtfchuc_vu.getText());
            employee.setadress(jtfdia_chi.getText());

            if (StringUtils.isNumeric(jtfmuc_luong.getText()) || StringUtils.isNumeric(jtfmuc_luong.getText().replace(".", ""))) {
                float floatValue = Float.parseFloat(jtfmuc_luong.getText());
                employee.setSalary(floatValue);
            } else {
                jlbStatus.setText("MỨC LƯƠNG KHÔNG HỢP LÊ!");
                return; // Ngăn chặn việc tiếp tục thực hiện thêm sản phẩm nếu dữ liệu không hợp lệ
            }
            employee.setNgay_sinh(jdngay_sinh.getDate());
            employee.setNgay_vo_lam(jdngay_lam.getDate());
            if (validate_phone(jtfso_dt.getText()) && validate_email(jtfemail.getText())) {
                        employee.setphone(jtfso_dt.getText());
                        employee.setemail(jtfemail.getText());
                         if (showDialog("cập nhật")) {
                        int lastid = employeeService.Update(employee);
                        if (lastid > 0) {
                            jlbStatus.setText("Cập nhập thành công!");
                        } else {
                            jlbStatus.setText("Có lỗi xảy ra, vui lòng thử lại!");
                        }
                    }
            }
                       
            else {
                if (!validate_phone(jtfso_dt.getText())) {
                            jlbStatus.setText("Số điện thoại không hợp lệ VD: +8412345678.");
                        } else if (!validate_email(jtfemail.getText())) {
                            jlbStatus.setText("Email không hợp lệ VD: user123@example.com.");
                        } else {
                            jlbStatus.setText("Số điện thoại và email không hợp lệ.");
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
    btnDeleteEmp.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (jtfma_nhan_vien.getText().isEmpty() 
              ) {
                jlbStatus.setText("NHẬP MÃ ĐỂ XÓA NHÂN VIÊN");
                return;
            }

            Employee product = new Employee();
            product.setma_nhan_vien(jtfma_nhan_vien.getText());
            

            int result = employeeService.Delete(product);
            if (result > 0 && showDialog("xóa")) {
                jlbStatus.setText("XÓA THÀNH CÔNG!");
            } else {
                jlbStatus.setText("Có lỗi xảy ra, vui lòng thử lại");
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
        public boolean showDialog(String msg) {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn " + msg + " dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    public boolean validate_phone(String phoneNumber) {
        Matcher matcher = pattern_phone.matcher(phoneNumber);
        return matcher.matches();
    }

    public boolean validate_email(String email) {
        Matcher matcher = pattern_email.matcher(email);
        return matcher.matches();
    }
}

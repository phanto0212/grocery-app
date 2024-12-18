/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nhom13.qlch.view;

import com.nhom13.qlch.bean.DanhMucBean;
import com.nhom13.qlch.controller.ChuyenManHinhController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;



public class MainJFrame extends javax.swing.JFrame {
    public MainJFrame() {
        initComponents();
        setTitle("quan ly cua hang");
        List<DanhMucBean> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMucBean("TrangChu", jpnTrangChu, jlbTrangChu));
        listDanhMuc.add(new DanhMucBean("BanHang", jpnSell, jlbSell));
        listDanhMuc.add(new DanhMucBean("SanPham", jpnProduct, jlbProduct));
        listDanhMuc.add(new DanhMucBean("NhanVien", jpnEmployee, jlbEmployee));
        listDanhMuc.add(new DanhMucBean("HoaDon", jpnInvoice, jlbInvoice));
        listDanhMuc.add(new DanhMucBean("khachHang",jPnCustomer,jlbCustomer));
        listDanhMuc.add(new DanhMucBean("ThongKe", jpnTk, jlbTk));
        listDanhMuc.add(new DanhMucBean("NhapHang", jpnNhap_hang, jlbNhap_hang));
        listDanhMuc.add(new DanhMucBean("Sold", jpnSold, jlbSold));
        listDanhMuc.add(new DanhMucBean("LaiLo", jpnLai_Lo, jlbLai_Lo));
        listDanhMuc.add(new DanhMucBean("setting", jpnTaiKhoanSetting, jlbTaiKhoanSetting));
        listDanhMuc.add(new DanhMucBean("CongNo", jpnCongNo, jlbCongNo));
        ChuyenManHinhController controller = new ChuyenManHinhController( jpnView );
        controller.setView(jpnTrangChu, jlbTrangChu);
        controller.setEvent(listDanhMuc);
//        controller.setEvent1();
    }

          
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jpnTrangChu = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jpnSell = new javax.swing.JPanel();
        jlbSell = new javax.swing.JLabel();
        jpnProduct = new javax.swing.JPanel();
        jlbProduct = new javax.swing.JLabel();
        jpnTk = new javax.swing.JPanel();
        jlbTk = new javax.swing.JLabel();
        jpnEmployee = new javax.swing.JPanel();
        jlbEmployee = new javax.swing.JLabel();
        jpnInvoice = new javax.swing.JPanel();
        jlbInvoice = new javax.swing.JLabel();
        jPnCustomer = new javax.swing.JPanel();
        jlbCustomer = new javax.swing.JLabel();
        jpnNhap_hang = new javax.swing.JPanel();
        jlbNhap_hang = new javax.swing.JLabel();
        jpnSold = new javax.swing.JPanel();
        jlbSold = new javax.swing.JLabel();
        jpnLai_Lo = new javax.swing.JPanel();
        jlbLai_Lo = new javax.swing.JLabel();
        jpnTaiKhoanSetting = new javax.swing.JPanel();
        jlbTaiKhoanSetting = new javax.swing.JLabel();
        jpnCongNo = new javax.swing.JPanel();
        jlbCongNo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnMenu.setBackground(new java.awt.Color(25, 118, 211));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("QUẢN LÝ CỬA HÀNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpnTrangChu.setBackground(new java.awt.Color(25, 118, 211));
        jpnTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jlbTrangChu.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jlbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTrangChu.setText("TRANG CHỦ");

        javax.swing.GroupLayout jpnTrangChuLayout = new javax.swing.GroupLayout(jpnTrangChu);
        jpnTrangChu.setLayout(jpnTrangChuLayout);
        jpnTrangChuLayout.setHorizontalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnTrangChuLayout.setVerticalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTrangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jpnSell.setBackground(new java.awt.Color(25, 118, 211));
        jpnSell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnSell.setPreferredSize(new java.awt.Dimension(230, 45));

        jlbSell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbSell.setForeground(new java.awt.Color(255, 255, 255));
        jlbSell.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbSell.setText("QUẢN LÝ BÁN HÀNG");

        javax.swing.GroupLayout jpnSellLayout = new javax.swing.GroupLayout(jpnSell);
        jpnSell.setLayout(jpnSellLayout);
        jpnSellLayout.setHorizontalGroup(
            jpnSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSellLayout.createSequentialGroup()
                .addComponent(jlbSell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnSellLayout.setVerticalGroup(
            jpnSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbSell, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jpnProduct.setBackground(new java.awt.Color(25, 118, 211));
        jpnProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnProduct.setPreferredSize(new java.awt.Dimension(230, 45));

        jlbProduct.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbProduct.setForeground(new java.awt.Color(255, 255, 255));
        jlbProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbProduct.setText("QUẢN LÝ SẢN PHẨM");

        javax.swing.GroupLayout jpnProductLayout = new javax.swing.GroupLayout(jpnProduct);
        jpnProduct.setLayout(jpnProductLayout);
        jpnProductLayout.setHorizontalGroup(
            jpnProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnProductLayout.createSequentialGroup()
                .addComponent(jlbProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnProductLayout.setVerticalGroup(
            jpnProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jpnTk.setBackground(new java.awt.Color(25, 118, 211));
        jpnTk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnTk.setPreferredSize(new java.awt.Dimension(230, 45));

        jlbTk.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbTk.setForeground(new java.awt.Color(255, 255, 255));
        jlbTk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTk.setText("THỐNG KÊ");

        javax.swing.GroupLayout jpnTkLayout = new javax.swing.GroupLayout(jpnTk);
        jpnTk.setLayout(jpnTkLayout);
        jpnTkLayout.setHorizontalGroup(
            jpnTkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTkLayout.createSequentialGroup()
                .addComponent(jlbTk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnTkLayout.setVerticalGroup(
            jpnTkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTk, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jpnEmployee.setBackground(new java.awt.Color(25, 118, 211));
        jpnEmployee.setPreferredSize(new java.awt.Dimension(230, 45));

        jlbEmployee.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbEmployee.setForeground(new java.awt.Color(255, 255, 255));
        jlbEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbEmployee.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jpnEmployeeLayout = new javax.swing.GroupLayout(jpnEmployee);
        jpnEmployee.setLayout(jpnEmployeeLayout);
        jpnEmployeeLayout.setHorizontalGroup(
            jpnEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnEmployeeLayout.createSequentialGroup()
                .addComponent(jlbEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnEmployeeLayout.setVerticalGroup(
            jpnEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jpnInvoice.setBackground(new java.awt.Color(25, 118, 211));
        jpnInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnInvoice.setPreferredSize(new java.awt.Dimension(230, 45));

        jlbInvoice.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbInvoice.setForeground(new java.awt.Color(255, 255, 255));
        jlbInvoice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbInvoice.setText("HÓA ĐƠN");

        javax.swing.GroupLayout jpnInvoiceLayout = new javax.swing.GroupLayout(jpnInvoice);
        jpnInvoice.setLayout(jpnInvoiceLayout);
        jpnInvoiceLayout.setHorizontalGroup(
            jpnInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInvoiceLayout.createSequentialGroup()
                .addComponent(jlbInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnInvoiceLayout.setVerticalGroup(
            jpnInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPnCustomer.setBackground(new java.awt.Color(25, 118, 211));

        jlbCustomer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jlbCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbCustomer.setText("QUẢN LÝ KHÁCH HÀNG");

        javax.swing.GroupLayout jPnCustomerLayout = new javax.swing.GroupLayout(jPnCustomer);
        jPnCustomer.setLayout(jPnCustomerLayout);
        jPnCustomerLayout.setHorizontalGroup(
            jPnCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnCustomerLayout.createSequentialGroup()
                .addComponent(jlbCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPnCustomerLayout.setVerticalGroup(
            jPnCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jpnNhap_hang.setBackground(new java.awt.Color(25, 118, 211));

        jlbNhap_hang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbNhap_hang.setForeground(new java.awt.Color(255, 255, 255));
        jlbNhap_hang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNhap_hang.setText("NHẬP HÀNG HÓA");

        javax.swing.GroupLayout jpnNhap_hangLayout = new javax.swing.GroupLayout(jpnNhap_hang);
        jpnNhap_hang.setLayout(jpnNhap_hangLayout);
        jpnNhap_hangLayout.setHorizontalGroup(
            jpnNhap_hangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhap_hangLayout.createSequentialGroup()
                .addComponent(jlbNhap_hang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnNhap_hangLayout.setVerticalGroup(
            jpnNhap_hangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbNhap_hang, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jpnSold.setBackground(new java.awt.Color(25, 118, 211));

        jlbSold.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbSold.setForeground(new java.awt.Color(255, 255, 255));
        jlbSold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbSold.setText("THỐNG KÊ ĐƠN HÀNG");

        javax.swing.GroupLayout jpnSoldLayout = new javax.swing.GroupLayout(jpnSold);
        jpnSold.setLayout(jpnSoldLayout);
        jpnSoldLayout.setHorizontalGroup(
            jpnSoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSoldLayout.createSequentialGroup()
                .addComponent(jlbSold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnSoldLayout.setVerticalGroup(
            jpnSoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbSold, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jpnLai_Lo.setBackground(new java.awt.Color(25, 118, 211));

        jlbLai_Lo.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jlbLai_Lo.setForeground(new java.awt.Color(255, 255, 255));
        jlbLai_Lo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLai_Lo.setText("Lãi/Lỗ");

        javax.swing.GroupLayout jpnLai_LoLayout = new javax.swing.GroupLayout(jpnLai_Lo);
        jpnLai_Lo.setLayout(jpnLai_LoLayout);
        jpnLai_LoLayout.setHorizontalGroup(
            jpnLai_LoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLai_LoLayout.createSequentialGroup()
                .addComponent(jlbLai_Lo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnLai_LoLayout.setVerticalGroup(
            jpnLai_LoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbLai_Lo, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jpnTaiKhoanSetting.setBackground(new java.awt.Color(25, 118, 211));

        jlbTaiKhoanSetting.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jlbTaiKhoanSetting.setForeground(new java.awt.Color(255, 255, 255));
        jlbTaiKhoanSetting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTaiKhoanSetting.setText("Tài Khoản");

        javax.swing.GroupLayout jpnTaiKhoanSettingLayout = new javax.swing.GroupLayout(jpnTaiKhoanSetting);
        jpnTaiKhoanSetting.setLayout(jpnTaiKhoanSettingLayout);
        jpnTaiKhoanSettingLayout.setHorizontalGroup(
            jpnTaiKhoanSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTaiKhoanSettingLayout.createSequentialGroup()
                .addComponent(jlbTaiKhoanSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnTaiKhoanSettingLayout.setVerticalGroup(
            jpnTaiKhoanSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTaiKhoanSetting, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jpnCongNo.setBackground(new java.awt.Color(25, 118, 211));

        jlbCongNo.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jlbCongNo.setForeground(new java.awt.Color(255, 255, 255));
        jlbCongNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbCongNo.setText("Công Nợ");

        javax.swing.GroupLayout jpnCongNoLayout = new javax.swing.GroupLayout(jpnCongNo);
        jpnCongNo.setLayout(jpnCongNoLayout);
        jpnCongNoLayout.setHorizontalGroup(
            jpnCongNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCongNoLayout.createSequentialGroup()
                .addComponent(jlbCongNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnCongNoLayout.setVerticalGroup(
            jpnCongNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbCongNo, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng Xuất");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnTk, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jpnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnSell, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jpnProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jpnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jpnInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jPnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnNhap_hang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnSold, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnLai_Lo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnTaiKhoanSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnCongNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnNhap_hang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnSold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnLai_Lo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTaiKhoanSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnCongNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       this.dispose();
      LoginJFrame frame = new LoginJFrame();
               frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle("Đăng Ký"
                    );
            frame.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPnCustomer;
    private javax.swing.JLabel jlbCongNo;
    private javax.swing.JLabel jlbCustomer;
    private javax.swing.JLabel jlbEmployee;
    private javax.swing.JLabel jlbInvoice;
    private javax.swing.JLabel jlbLai_Lo;
    private javax.swing.JLabel jlbNhap_hang;
    private javax.swing.JLabel jlbProduct;
    private javax.swing.JLabel jlbSell;
    private javax.swing.JLabel jlbSold;
    private javax.swing.JLabel jlbTaiKhoanSetting;
    private javax.swing.JLabel jlbTk;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JPanel jpnCongNo;
    private javax.swing.JPanel jpnEmployee;
    private javax.swing.JPanel jpnInvoice;
    private javax.swing.JPanel jpnLai_Lo;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNhap_hang;
    private javax.swing.JPanel jpnProduct;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnSell;
    private javax.swing.JPanel jpnSold;
    private javax.swing.JPanel jpnTaiKhoanSetting;
    private javax.swing.JPanel jpnTk;
    private javax.swing.JPanel jpnTrangChu;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}

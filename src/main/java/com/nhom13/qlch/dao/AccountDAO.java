/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Account;
import java.util.List;

public interface AccountDAO {
        public Account login(String username, String password);
        public int SignUp(String username, String password);
        public List<Account> getList();
        public int setTaiKhoan(String tentaikhoan, String matkhau);
        public List<Account> getTaiKhoan();
        public int Update(String tendangnhap, String matkhau);
        public int ThemTaiKhoanThongKe(String tendangnhap, int so_luong, float total);
        public int getSoluongDonHang(String tendangnhap);
        public int getSoLuongHoaDon(String tendangnhap);
        public float getTongDoanhThu(String tendangnhap);
        public int getDonHangHomNay(String tendangnhap);
        public int getHoaDonHomNay(String tendangnhap);
        public float getDoanhThuHomNay(String tendangnhap);
}

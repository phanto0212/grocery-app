/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.service;

import com.nhom13.qlch.dao.AccountDAO;
import com.nhom13.qlch.dao.AccountDAOimpl;
import com.nhom13.qlch.model.Account;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AccountServiceimpl implements AccountService{
       private AccountDAO accountDAO;

    public AccountServiceimpl() {
        accountDAO = new AccountDAOimpl();
    }

    public AccountServiceimpl(AccountDAO accountDao) {
        this.accountDAO = accountDao;
    }
 
    @Override
    public Account login(String username, String password) {
        return accountDAO.login(username, password);
    }

    @Override
    public int SignUp(String username, String password) {
return accountDAO.SignUp(username, password);    }

    @Override
    public List<Account> getList() {
return accountDAO.getList();    }

    @Override
    public int setTaiKhoan(String tentaikhoan, String matkhau) {
return accountDAO.setTaiKhoan(tentaikhoan, matkhau);    }

    @Override
    public List<Account> getTaiKhoan() {
        return accountDAO.getTaiKhoan();
    }

    @Override
    public int Update(String tendangnhap, String matkhau) {
return accountDAO.Update(tendangnhap, matkhau);    }

    @Override
    public int ThemTaiKhoanThongKe(String tendangnhap, int so_luong, float total) {
        return accountDAO.ThemTaiKhoanThongKe(tendangnhap, so_luong, total);
    }

    @Override
    public int getSoluongDonHang(String tendangnhap) {
        return accountDAO.getSoluongDonHang(tendangnhap);
    }

    @Override
    public int getSoLuongHoaDon(String tendangnhap) {
return accountDAO.getSoLuongHoaDon(tendangnhap) ;   }

    @Override
    public float getTongDoanhThu(String tendangnhap) {
return accountDAO.getTongDoanhThu(tendangnhap);    }

    @Override
    public int getDonHangHomNay(String tendangnhap) {
        return accountDAO.getDonHangHomNay(tendangnhap);
    }

    @Override
    public int getHoaDonHomNay(String tendangnhap) {
return accountDAO.getHoaDonHomNay(tendangnhap);    }

    @Override
    public float getDoanhThuHomNay(String tendangnhap) {
return accountDAO.getDoanhThuHomNay(tendangnhap) ;   }

   

    

  
}


package com.nhom13.qlch.service;

import com.nhom13.qlch.dao.CustomerDAO;
import com.nhom13.qlch.dao.CustomerDAOimpl;
import com.nhom13.qlch.model.Customer;
import java.util.List;

public class CustomerServiceimpl implements CustomerService{
         private CustomerDAO customerDAO = null;

    public CustomerServiceimpl() {
        this.customerDAO = new CustomerDAOimpl();
    }

    @Override
    public List<Customer> getList() {
        return customerDAO.getList();
    }

    @Override
    public int setRank() {
        return customerDAO.setRank();
    }

    @Override
    public int muaHang(float total, String cuscode) {
        return customerDAO.muaHang(total, cuscode);
    }

    @Override
    public int Update(Customer customer) {
        return customerDAO.Update(customer);
    }

    @Override
    public int TongSanPham(Customer customer) {
        return customerDAO.TongSanPham(customer);
    }

    @Override
    public int TongHoaDon(Customer customer) {
return customerDAO.TongHoaDon(customer);    }

  

    @Override
    public float TongCongNo() {
return customerDAO.TongCongNo();    }

    @Override
    public int CongNo(String makhachhang, float congno) {
        return customerDAO.CongNo(makhachhang, congno);
    }

    @Override
    public int trutien(String makhachhang, float tientra) {
return customerDAO.trutien(makhachhang, tientra);    }

    @Override
    public int Insert(Customer customer) {
return customerDAO.Insert(customer);    }
}

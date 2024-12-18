
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Customer;
import java.util.List;


public interface CustomerDAO {
      public List<Customer> getList();
      public int Update(Customer customer);
      public int Insert(Customer customer);
      public int Delete(Customer customer);
      public int setRank();
      public int muaHang(float total, String cuscode);
      public int TongSanPham(Customer customer);
      public int TongHoaDon(Customer customer);
      public int CongNo(String makhachhang ,float congno);
      public float TongCongNo();
      public int trutien(String makhachhang, float tientra);
}

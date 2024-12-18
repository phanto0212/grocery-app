/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.invoice;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InvoiceDAO {
    public List<invoice> getList();
    public String Insert(String makhachhang,String phuongthuc,float total_invoice);
    public List<invoice> getListToday();
    
}

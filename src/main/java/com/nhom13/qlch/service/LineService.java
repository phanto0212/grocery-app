/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom13.qlch.service;

import com.nhom13.qlch.model.Line;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.Sold;
import com.nhom13.qlch.model.invoice;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface LineService {
       public List<Line> getList();
       public int Insert(Product product, String Ma_hoa_don, int i);
       public List<Sold> getLit(Date TimeStart, Date TimeEnd);
}

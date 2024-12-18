/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.ProductHetHan;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductHetHanDAO {
    public List<ProductHetHan> getList();
    public int  Insert();
    
}

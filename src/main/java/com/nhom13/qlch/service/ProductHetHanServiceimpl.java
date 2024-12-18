/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.service;

import com.nhom13.qlch.dao.ProductHetHanDAO;
import com.nhom13.qlch.dao.ProductHetHanDAOimpl;
import com.nhom13.qlch.model.ProductHetHan;
import java.util.List;


public class ProductHetHanServiceimpl implements ProductHetHanService{

   
     private ProductHetHanDAO productHetHanDAO = null;

    public ProductHetHanServiceimpl() {
        this.productHetHanDAO = new ProductHetHanDAOimpl();
    }

    @Override
    public List<ProductHetHan> getList() {
        return productHetHanDAO.getList();
    }

    @Override
    public int Insert( ) {
         return productHetHanDAO.Insert();
    }
    
    
}

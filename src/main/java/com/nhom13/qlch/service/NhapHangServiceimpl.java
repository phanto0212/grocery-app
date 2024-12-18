/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.service;

import com.nhom13.qlch.dao.NhapHangDAO;
import com.nhom13.qlch.dao.NhapHangDAOimpl;
import com.nhom13.qlch.model.Product;
import java.util.List;


public class NhapHangServiceimpl implements NhapHangService {
        private NhapHangDAO nhapHangDAO = null;

    public NhapHangServiceimpl() {
        this.nhapHangDAO = new NhapHangDAOimpl();
    }

    @Override
    public List<Product> getList() {
        return nhapHangDAO.getList();
    }
}

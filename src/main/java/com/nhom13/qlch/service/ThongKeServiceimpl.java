/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.service;

import com.nhom13.qlch.bean.HoaDonBean;
import com.nhom13.qlch.dao.ThongKeDAO;
import com.nhom13.qlch.dao.ThongKeDAOimpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeServiceimpl implements ThongKeService {

   
     ThongKeDAO thongKeDAO =null;
      public ThongKeServiceimpl() {
          this.thongKeDAO = new ThongKeDAOimpl();
    }
    @Override
    public List<HoaDonBean> getListbyInvoice() {
       return thongKeDAO.getListbyInvoice();
    }
    
}

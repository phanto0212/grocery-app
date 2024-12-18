/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.ProductHetHan;
import com.nhom13.qlch.model.invoice;
import com.nhom13.qlch.service.InvoiceService;
import com.nhom13.qlch.service.InvoiceServiceimpl;
import com.nhom13.qlch.service.ProductHetHanService;
import com.nhom13.qlch.service.ProductHetHanServiceimpl;
import com.nhom13.qlch.service.ProductService;
import com.nhom13.qlch.service.ProductServiceimpl;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class LaiLoController {
    private float totalTienNhap,totalTienBan,totalTienHetHan,ResultLaiLo;
    private JLabel jlbTien_Ban_Hang;
    private JLabel jlbTienNhapHang;
    private JLabel jlbTien_San_Pham_Het_Han;
    private JLabel jlbLaiOrLo;
    private JLabel jlbResult;
    private JLabel jlbVND;
    private ProductHetHanService productHetHanService = null;
    private ProductService productService = null;
    private InvoiceService invoiceService = null;

    public LaiLoController(JLabel jlbTien_Ban_Hang, JLabel jlbTienNhapHang, JLabel jlbTien_San_Pham_Het_Han) {
        this.jlbTien_Ban_Hang = jlbTien_Ban_Hang;
        this.jlbTienNhapHang = jlbTienNhapHang;
        this.jlbTien_San_Pham_Het_Han = jlbTien_San_Pham_Het_Han;
        this.productHetHanService = new ProductHetHanServiceimpl();
        this.productService = new ProductServiceimpl();
        this.invoiceService = new InvoiceServiceimpl();
    }

    public LaiLoController(JLabel jlbTien_Ban_Hang, JLabel jlbTienNhapHang, JLabel jlbTien_San_Pham_Het_Han, JLabel jlbLaiOrLo, JLabel jlbResult, JLabel jlbVND) {
        this.jlbTien_Ban_Hang = jlbTien_Ban_Hang;
        this.jlbTienNhapHang = jlbTienNhapHang;
        this.jlbTien_San_Pham_Het_Han = jlbTien_San_Pham_Het_Han;
        this.jlbLaiOrLo = jlbLaiOrLo;
        this.jlbResult = jlbResult;
        this.jlbVND = jlbVND;
        this.productHetHanService = new ProductHetHanServiceimpl();
        this.productService = new ProductServiceimpl();
        this.invoiceService = new InvoiceServiceimpl();
    }
    
    public void setEvent (){
        List<Product> list = productService.getList();
        List<ProductHetHan> listHetHan = productHetHanService.getList();
        List<invoice> invoices = invoiceService.getList();
        int temp = productHetHanService.Insert();
        totalTienNhap=0;totalTienBan=0;totalTienHetHan=0;
        for(Product sanpham:list)
        {
            totalTienNhap+=sanpham.getPro_Import_Prize()*sanpham.getPro_QIS();
            
        }
        for (ProductHetHan hangHetHan : listHetHan){
            totalTienHetHan+=hangHetHan.getGiaNhap()*hangHetHan.getSoluong();
           
        }
        for (invoice hoadon:invoices){
            totalTienBan+=hoadon.getInv_total();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###.000");
          String formated = decimalFormat.format(totalTienNhap);
          String formated1 = decimalFormat.format(totalTienHetHan);
          String formated2 = decimalFormat.format(totalTienBan);
      jlbTienNhapHang.setText(formated);
      jlbTien_Ban_Hang.setText(formated2);
      jlbTien_San_Pham_Het_Han.setText(formated1);
        ResultLaiLo = -totalTienNhap+totalTienBan-totalTienHetHan;
         String formated3 = decimalFormat.format(ResultLaiLo);
         if(ResultLaiLo<0){
             Color red = new Color(222, 40, 52);
             jlbLaiOrLo.setText("Làm ăn thất bát! Lỗ:");
             jlbLaiOrLo.setForeground(red);
             jlbResult.setText(formated3);
             jlbResult.setForeground(red);
             jlbVND.setForeground(red);
             
         }
         else {
             Color green = new Color(40,222,46);
             jlbLaiOrLo.setText("Làm ăn được phết! Lãi:");
             jlbLaiOrLo.setForeground(green);
             jlbResult.setText(formated3);
             jlbResult.setForeground(green);
             jlbVND.setForeground(green);
         }
    }
}

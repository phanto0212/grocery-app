
package com.nhom13.qlch.model;

import java.util.Date;


public class ProductHetHan {
    private String Product_code;
    private int Soluong;
    private float GiaNhap;
    private Date Ngay_nhap;
    private Date Ngay_het_han;

    public ProductHetHan() {
    }

    public ProductHetHan(String Product_code, int Soluong, float GiaNhap, Date Ngay_nhap, Date Ngay_het_han) {
        this.Product_code = Product_code;
        this.Soluong = Soluong;
        this.GiaNhap = GiaNhap;
        this.Ngay_nhap = Ngay_nhap;
        this.Ngay_het_han = Ngay_het_han;
    }

    public String getProduct_code() {
        return Product_code;
    }

    public void setProduct_code(String Product_code) {
        this.Product_code = Product_code;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public Date getNgay_nhap() {
        return Ngay_nhap;
    }

    public void setNgay_nhap(Date Ngay_nhap) {
        this.Ngay_nhap = Ngay_nhap;
    }

    public Date getNgay_het_han() {
        return Ngay_het_han;
    }

    public void setNgay_het_han(Date Ngay_het_han) {
        this.Ngay_het_han = Ngay_het_han;
    }
    
}

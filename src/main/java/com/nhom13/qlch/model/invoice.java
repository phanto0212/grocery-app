
package com.nhom13.qlch.model;

import java.util.Date;

public class invoice {
    private String Ma_hoa_don;
    private String Ma_khach_hang;
    private String Ma_nhan_vien;
    private Date Inv_Date;
    private float Inv_total;
    private String phuong_thuc_tt;

    public invoice() {
    }

    public invoice(String Ma_hoa_don, String Ma_khach_hang, String Ma_nhan_vien, Date Inv_Date, float Inv_total, String phuong_thuc_tt) {
        this.Ma_hoa_don = Ma_hoa_don;
        this.Ma_khach_hang = Ma_khach_hang;
        this.Ma_nhan_vien = Ma_nhan_vien;
        this.Inv_Date = Inv_Date;
        this.Inv_total = Inv_total;
        this.phuong_thuc_tt = phuong_thuc_tt;
    }

    public String getMa_hoa_don() {
        return Ma_hoa_don;
    }

    public void setMa_hoa_don(String Ma_hoa_don) {
        this.Ma_hoa_don = Ma_hoa_don;
    }

    public String getMa_khach_hang() {
        return Ma_khach_hang;
    }

    public void setMa_khach_hang(String Ma_khach_hang) {
        this.Ma_khach_hang = Ma_khach_hang;
    }

    public String getMa_nhan_vien() {
        return Ma_nhan_vien;
    }

    public void setMa_nhan_vien(String Ma_nhan_vien) {
        this.Ma_nhan_vien = Ma_nhan_vien;
    }

    public Date getInv_Date() {
        return Inv_Date;
    }

    public void setInv_Date(Date Inv_Date) {
        this.Inv_Date = Inv_Date;
    }

    public float getInv_total() {
        return Inv_total;
    }

    public void setInv_total(float Inv_total) {
        this.Inv_total = Inv_total;
    }

    public String getphuong_thuc_tt() {
        return phuong_thuc_tt;
    }

    public void setphuong_thuc_tt(String phuong_thuc_tt) {
        this.phuong_thuc_tt = phuong_thuc_tt;
    }
    
    
}


package com.nhom13.qlch.model;


public class Account {
    private int Ma_tai_khoan;
    private String Ten_dang_nhap;
    private String Mat_khau;
    private boolean Tinh_trang;

    public int getMa_tai_khoan() {
        return Ma_tai_khoan;
    }

    public void setMa_tai_khoan(int Ma_tai_khoan) {
        this.Ma_tai_khoan = Ma_tai_khoan;
    }

    public String getTen_dang_nhap() {
        return Ten_dang_nhap;
    }

    public void setTen_dang_nhap(String Ten_dang_nhap) {
        this.Ten_dang_nhap = Ten_dang_nhap;
    }

    public String getMat_khau() {
        return Mat_khau;
    }

    public void setMat_khau(String Mat_khau) {
        this.Mat_khau = Mat_khau;
    }

    public boolean isTinh_trang() {
        return Tinh_trang;
    }

    public void setTinh_trang(boolean Tinh_trang) {
        this.Tinh_trang = Tinh_trang;
    }
    
}

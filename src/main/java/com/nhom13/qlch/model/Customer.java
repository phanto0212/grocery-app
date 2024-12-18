
package com.nhom13.qlch.model;

import java.util.Date;


public class Customer {
    private String Ma_khach_hang;
    private String Rank_id;
    private String Ten;
    private String Ho_dem;
    private Date Dob_khach_hang;
    private String Email;
    private String So_dien_thoai;
    private String Dia_chi;
    private float Tong_chi_tieu;
    private float Khoan_no;

    public Customer() {
    }

    public Customer(String Ma_khach_hang, String Rank_id, String Ten, String Ho_dem, Date Dob_khach_hang, String Email, String So_dien_thoai, String Dia_chi, float Tong_chi_tieu) {
        this.Ma_khach_hang = Ma_khach_hang;
        this.Rank_id = Rank_id;
        this.Ten = Ten;
        this.Ho_dem = Ho_dem;
        this.Dob_khach_hang = Dob_khach_hang;
        this.Email = Email;
        this.So_dien_thoai = So_dien_thoai;
        this.Dia_chi = Dia_chi;
        this.Tong_chi_tieu = Tong_chi_tieu;
    }

    public Customer(String Ma_khach_hang, String Rank_id, String Ten, String Ho_dem, Date Dob_khach_hang, String Email, String So_dien_thoai, String Dia_chi, float Tong_chi_tieu, float Khoan_no) {
        this.Ma_khach_hang = Ma_khach_hang;
        this.Rank_id = Rank_id;
        this.Ten = Ten;
        this.Ho_dem = Ho_dem;
        this.Dob_khach_hang = Dob_khach_hang;
        this.Email = Email;
        this.So_dien_thoai = So_dien_thoai;
        this.Dia_chi = Dia_chi;
        this.Tong_chi_tieu = Tong_chi_tieu;
        this.Khoan_no = Khoan_no;
    }

    public float getKhoan_no() {
        return Khoan_no;
    }

    public void setKhoan_no(float Khoan_no) {
        this.Khoan_no = Khoan_no;
    }

    public String getMa_khach_hang() {
        return Ma_khach_hang;
    }

    public void setMa_khach_hang(String Ma_khach_hang) {
        this.Ma_khach_hang = Ma_khach_hang;
    }

    public String getRank_id() {
        return Rank_id;
    }

    public void setRank_id(String Rank_id) {
        this.Rank_id = Rank_id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getHo_dem() {
        return Ho_dem;
    }

    public void setHo_dem(String Ho_dem) {
        this.Ho_dem = Ho_dem;
    }

    public Date getDob_khach_hang() {
        return Dob_khach_hang;
    }

    public void setDob_khach_hang(Date Dob_khach_hang) {
        this.Dob_khach_hang = Dob_khach_hang;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSo_dien_thoai() {
        return So_dien_thoai;
    }

    public void setSo_dien_thoai(String So_dien_thoai) {
        this.So_dien_thoai = So_dien_thoai;
    }

    public String getDia_chi() {
        return Dia_chi;
    }

    public void setDia_chi(String Dia_chi) {
        this.Dia_chi = Dia_chi;
    }

    public float getTong_chi_tieu() {
        return Tong_chi_tieu;
    }

    public void setTong_chi_tieu(float Tong_chi_tieu) {
        this.Tong_chi_tieu = Tong_chi_tieu;
    }
    

   

 
    
    
}

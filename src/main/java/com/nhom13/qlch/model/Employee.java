
package com.nhom13.qlch.model;

import java.util.Date;

public class Employee {
    private String ma_nhan_vien;
    private String Fist_name;
    private String Last_name;
    private Date Ngay_sinh;
    private Date Ngay_vo_lam;
    private String Cong_viec;
    private float Salary;
    private String email;
    private String phone;
    private String adress;

    public Employee() {
    }

    public Employee(String ma_nhan_vien, String Fist_name, String Last_name, Date Ngay_sinh, Date Ngay_vo_lam, String Cong_viec, float Salary, String email, String phone, String adress) {
        this.ma_nhan_vien = ma_nhan_vien;
        this.Fist_name = Fist_name;
        this.Last_name = Last_name;
        this.Ngay_sinh = Ngay_sinh;
        this.Ngay_vo_lam = Ngay_vo_lam;
        this.Cong_viec = Cong_viec;
        this.Salary = Salary;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
    }

    public String getma_nhan_vien() {
        return ma_nhan_vien;
    }

    public void setma_nhan_vien(String ma_nhan_vien) {
        this.ma_nhan_vien = ma_nhan_vien;
    }

    public String getFist_name() {
        return Fist_name;
    }

    public void setFist_name(String Fist_name) {
        this.Fist_name = Fist_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    public Date getNgay_sinh() {
        return Ngay_sinh;
    }

    public void setNgay_sinh(Date Ngay_sinh) {
        this.Ngay_sinh = Ngay_sinh;
    }

    public Date getNgay_vo_lam() {
        return Ngay_vo_lam;
    }

    public void setNgay_vo_lam(Date Ngay_vo_lam) {
        this.Ngay_vo_lam = Ngay_vo_lam;
    }

    public String getCong_viec() {
        return Cong_viec;
    }

    public void setCong_viec(String Cong_viec) {
        this.Cong_viec = Cong_viec;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getadress() {
        return adress;
    }

    public void setadress(String adress) {
        this.adress = adress;
    }

   
    
}

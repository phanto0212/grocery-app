package com.nhom13.qlch.model;

import java.util.Date;

public class Product {
 private String Product_code ;
 private String Category_code;
 private String Supplier_code;
 private String Store_code;
 private String Pro_Description;
 private String Pro_Brand;
 private float Pro_Prize;
 private float Pro_Import_Prize;
 private int Pro_QIS;
 private String Pro_Dimensions;
 private Date Pro_MD;
 private Date Pro_EXD;

    public Product() {
    }



    public Product(String Product_code, String Category_code, String Supplier_code, String Store_code, String Pro_Description, String Pro_Brand, float Pro_Prize, float Pro_Import_Prize, int Pro_QIS, String Pro_Dimensions, Date Pro_MD, Date Pro_EXD) {
        this.Product_code = Product_code;
        this.Category_code = Category_code;
        this.Supplier_code = Supplier_code;
        this.Store_code = Store_code;
        this.Pro_Description = Pro_Description;
        this.Pro_Brand = Pro_Brand;
        this.Pro_Prize = Pro_Prize;
        this.Pro_Import_Prize = Pro_Import_Prize;
        this.Pro_QIS = Pro_QIS;
        this.Pro_Dimensions = Pro_Dimensions;
        this.Pro_MD = Pro_MD;
        this.Pro_EXD = Pro_EXD;
    }

    public float getPro_Import_Prize() {
        return Pro_Import_Prize;
    }

    public void setPro_Import_Prize(float Pro_Import_Prize) {
        this.Pro_Import_Prize = Pro_Import_Prize;
    }

    public String getProduct_code() {
        return Product_code;
    }

    public void setProduct_code(String Product_code) {
        this.Product_code = Product_code;
    }

    public String getCategory_code() {
        return Category_code;
    }

    public void setCategory_code(String Category_code) {
        this.Category_code = Category_code;
    }

    public String getSupplier_code() {
        return Supplier_code;
    }

    public void setSupplier_code(String Supplier_code) {
        this.Supplier_code = Supplier_code;
    }

    public String getStore_code() {
        return Store_code;
    }

    public void setStore_code(String Store_code) {
        this.Store_code = Store_code;
    }

    public String getPro_Description() {
        return Pro_Description;
    }

    public void setPro_Description(String Pro_Description) {
        this.Pro_Description = Pro_Description;
    }

    public String getPro_Brand() {
        return Pro_Brand;
    }

    public void setPro_Brand(String Pro_Brand) {
        this.Pro_Brand = Pro_Brand;
    }

    public float getPro_Prize() {
        return Pro_Prize;
    }

    public void setPro_Prize(float Pro_Prize) {
        this.Pro_Prize = Pro_Prize;
    }

    public int getPro_QIS() {
        return Pro_QIS;
    }

    public void setPro_QIS(int Pro_QIS) {
        this.Pro_QIS = Pro_QIS;
    }

    public String getPro_Dimensions() {
        return Pro_Dimensions;
    }

    public void setPro_Dimensions(String Pro_Dimensions) {
        this.Pro_Dimensions = Pro_Dimensions;
    }

    public Date getPro_MD() {
        return Pro_MD;
    }

    public void setPro_MD(Date Pro_MD) {
        this.Pro_MD = Pro_MD;
    }

    public Date getPro_EXD() {
        return Pro_EXD;
    }

    public void setPro_EXD(Date Pro_EXD) {
        this.Pro_EXD = Pro_EXD;
    }

    public void setPro_ED(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
 


    
}

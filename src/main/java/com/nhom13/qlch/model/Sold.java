/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.qlch.model;


public class Sold {
   private String Product_code;
   private int soluong;

    public Sold(String product_code, int soluong) {
        this.Product_code = product_code;
        this.soluong = soluong;
    }

    public Sold() {
    }

    public String getProduct_code() {
        return Product_code;
    }

    public void setProduct_code(String product_code) {
        this.Product_code = product_code;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
   
}

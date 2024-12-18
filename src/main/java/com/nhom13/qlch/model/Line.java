
package com.nhom13.qlch.model;


public class Line {
    private int Line_num;
    private String Invoice_code;
    private String Product_code;
    private int Soluong;
    private float Unit_price;
    private float Total_price;

    public Line() {
    }

    public Line(int Line_num, String Invoice_code, String Product_code, int Soluong, float Unit_price, float Total_price) {
        this.Line_num = Line_num;
        this.Invoice_code = Invoice_code;
        this.Product_code = Product_code;
        this.Soluong = Soluong;
        this.Unit_price = Unit_price;
        this.Total_price = Total_price;
    }

    public int getLine_num() {
        return Line_num;
    }

    public void setLine_num(int Line_num) {
        this.Line_num = Line_num;
    }

    public String getInvoice_code() {
        return Invoice_code;
    }

    public void setInvoice_code(String Invoice_code) {
        this.Invoice_code = Invoice_code;
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

    public float getUnit_price() {
        return Unit_price;
    }

    public void setUnit_price(float Unit_price) {
        this.Unit_price = Unit_price;
    }

    public float getTotal_price() {
        return Total_price;
    }

    public void setTotal_price(float Total_price) {
        this.Total_price = Total_price;
    }
    
}

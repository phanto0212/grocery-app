
package com.nhom13.qlch.model;


public class TotalCongNo {
     private float total;
    private float congno;

    public TotalCongNo(float total, float congno) {
        this.total = total;
        this.congno = congno;
    }

    public TotalCongNo() {
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getCongno() {
        return congno;
    }

    public void setCongno(float congno) {
        this.congno = congno;
    }
    
}

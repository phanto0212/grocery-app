
package com.nhom13.qlch.bean;


public class HoaDonBean {
    private String  Hoa_don_date;
    private int So_luong;

    public HoaDonBean() {
    }

    public HoaDonBean(String Hoa_don_date, int So_luong) {
        this.Hoa_don_date = Hoa_don_date;
        this.So_luong = So_luong;
    }

    public String getHoa_don_date() {
        return Hoa_don_date;
    }

    public void setHoa_don_date(String Hoa_don_date) {
        this.Hoa_don_date = Hoa_don_date;
    }

    public int getSo_luong() {
        return So_luong;
    }

    public void setSo_luong(int So_luong) {
        this.So_luong = So_luong;
    }
    
    
}

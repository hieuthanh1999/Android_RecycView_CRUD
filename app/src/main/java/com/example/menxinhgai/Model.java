package com.example.menxinhgai;

public class Model {
    private String ma;
    private  String ten;
    private String loai;
    private String day;
    private String khuyenmai;

    public Model(String ma, String ten, String loai, String day, String khuyenmai) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
        this.day = day;
        this.khuyenmai = khuyenmai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(String khuyenmai) {
        this.khuyenmai = khuyenmai;
    }
}

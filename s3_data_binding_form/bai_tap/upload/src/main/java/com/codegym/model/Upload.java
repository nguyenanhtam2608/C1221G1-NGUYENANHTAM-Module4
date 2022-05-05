package com.codegym.model;

public class Upload {
    String nameBaiHat;
    String nameNgheSi;
    String theLoai;
    String duongDan;

    public Upload() {
    }

    public Upload(String nameBaiHat, String nameNgheSi, String theLoai, String duongDan) {
        this.nameBaiHat = nameBaiHat;
        this.nameNgheSi = nameNgheSi;
        this.theLoai = theLoai;
        this.duongDan = duongDan;
    }

    public String getNameBaiHat() {
        return nameBaiHat;
    }

    public void setNameBaiHat(String nameBaiHat) {
        this.nameBaiHat = nameBaiHat;
    }

    public String getNameNgheSi() {
        return nameNgheSi;
    }

    public void setNameNgheSi(String nameNgheSi) {
        this.nameNgheSi = nameNgheSi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }
}

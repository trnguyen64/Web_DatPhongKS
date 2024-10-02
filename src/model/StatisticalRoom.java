package model;

import java.util.Date;

public class StatisticalRoom {
    private String ID,Ten_R,Loai_R;
    private int SoGiuong_R;
    private Date DateFrom, DateTo;
    private float Gia_R,SoDem,Thanhtien;

    public Date getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(Date DateFrom) {
        this.DateFrom = DateFrom;
    }

    public Date getDateTo() {
        return DateTo;
    }

    public void setDateTo(Date DateTo) {
        this.DateTo = DateTo;
    }

    
    
    public float getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien(float Thanhtien) {
        this.Thanhtien = Thanhtien;
    }
    private String NgayNhan,NgayTra;

    public float getSoDem() {
        return SoDem;
    }

    public void setSoDem(float SoDem) {
        this.SoDem = SoDem;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen_R() {
        return Ten_R;
    }

    public void setTen_R(String Ten_R) {
        this.Ten_R = Ten_R;
    }

    public String getLoai_R() {
        return Loai_R;
    }

    public void setLoai_R(String Loai_R) {
        this.Loai_R = Loai_R;
    }

    public int getSoGiuong_R() {
        return SoGiuong_R;
    }

    public void setSoGiuong_R(int SoGiuong_R) {
        this.SoGiuong_R = SoGiuong_R;
    }

    public float getGia_R() {
        return Gia_R;
    }

    public void setGia_R(float Gia_R) {
        this.Gia_R = Gia_R;
    }

    public String getNgayNhan() {
        return NgayNhan;
    }

    public void setNgayNhan(String NgayNhan) {
        this.NgayNhan = NgayNhan;
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(String NgayTra) {
        this.NgayTra = NgayTra;
    }
}

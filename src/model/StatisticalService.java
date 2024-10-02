package model;

import java.util.Date;

public class StatisticalService {
    private String ID_HD,Ten_DV,ID_DV,NgayDung,GhiChu;
    private float Gia_DV,DenBu,Thanhtien;
    private int SoLuong;
    private Date dateFrom, dateTo;

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public float getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien(float Thanhtien) {
        this.Thanhtien = Thanhtien;
    }
 

    public String getTen_DV() {
        return Ten_DV;
    }

    public void setTen_DV(String Ten_DV) {
        this.Ten_DV = Ten_DV;
    }

    public String getID_HD() {
        return ID_HD;
    }

    public void setID_HD(String ID_HD) {
        this.ID_HD = ID_HD;
    }

    public String getID_DV() {
        return ID_DV;
    }

    public void setID_DV(String ID_DV) {
        this.ID_DV = ID_DV;
    }

    public String getNgayDung(){
        return NgayDung;
    }

    public void setNgayDung(String NgayDung) {
        this.NgayDung = NgayDung;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public float getGia_DV() {
        return Gia_DV;
    }

    public void setGia_DV(float Gia_DV) {
        this.Gia_DV = Gia_DV;
    }

    public float getDenBu() {
        return DenBu;
    }

    public void setDenBu(float DenBu) {
        this.DenBu = DenBu;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}

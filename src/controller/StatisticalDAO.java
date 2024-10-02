/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.StatisticalService;
import model.StatisticalRoom;
import java.sql.Date;

/**
 *
 * @author HP
 */
public class StatisticalDAO {
    DAO DAO = new DAO();
    public Connection conn = DAO.DAO_DB();

    public ArrayList<StatisticalRoom> getListDT(){
        ArrayList<StatisticalRoom> list = new ArrayList<>();
        String select = """
                        select a.ID_R,a.Ten_R,a.Loai_R,a.SoGiuong_R,a.Gia_R,e.CheckinDate,
                        e.CheckoutDate,e.SoDem,a.Gia_R* e.SoDem as Thanhtien 
                        from tbl_HotelRoom a,tbl_BookedRoom b , tbl_HD e
                        where b.ID_BK = e.ID_BK and a.ID_R = b.ID_R 
                        """;
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                StatisticalRoom r = new StatisticalRoom();
            //doc du lieu tu sql ra java
                r.setID(rs.getString("ID_R"));
                r.setTen_R(rs.getString("Ten_R"));
                r.setLoai_R(rs.getString("Loai_R"));
                r.setSoGiuong_R(rs.getInt("SoGiuong_R"));
                r.setGia_R(rs.getFloat("Gia_R"));               
                r.setNgayNhan(rs.getString("CheckinDate"));
                r.setNgayTra(rs.getString("CheckoutDate"));
                r.setSoDem(rs.getInt("SoDem"));
                r.setThanhtien(rs.getFloat("Thanhtien"));  
            //thêm vào trong danh sách
                list.add(r);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return list;       
    }
    
    public ArrayList<StatisticalRoom> getListDT(StatisticalRoom sr){
        ArrayList<StatisticalRoom> list = new ArrayList<>();
        String select = """
                        select a.ID_R,a.Ten_R,a.Loai_R,a.SoGiuong_R,a.Gia_R,e.CheckinDate,
                        e.CheckoutDate,e.SoDem,a.Gia_R* e.SoDem as Thanhtien 
                        from tbl_HotelRoom a,tbl_BookedRoom b , tbl_HD e
                        where b.ID_BK = e.ID_BK and a.ID_R = b.ID_R and CheckoutDate between ? and ?
                        """;
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setDate(1, new Date(sr.getDateFrom().getTime()));
            ps.setDate(2, new Date(sr.getDateTo().getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                StatisticalRoom r = new StatisticalRoom();
            //doc du lieu tu sql ra java
                r.setID(rs.getString("ID_R"));
                r.setTen_R(rs.getString("Ten_R"));
                r.setLoai_R(rs.getString("Loai_R"));
                r.setSoGiuong_R(rs.getInt("SoGiuong_R"));
                r.setGia_R(rs.getFloat("Gia_R"));               
                r.setNgayNhan(rs.getString("CheckinDate"));
                r.setNgayTra(rs.getString("CheckoutDate"));
                r.setSoDem(rs.getInt("SoDem"));
                r.setThanhtien(rs.getFloat("Thanhtien"));  
            //thêm vào trong danh sách
                list.add(r);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return list;       
    }
    
    public ArrayList<StatisticalService> getListDTDV(){
        ArrayList<StatisticalService> listDV = new ArrayList<>();
        String select = """
                        select a.ID_DV,b.Ten_DV,a.NgayDung,b.Gia_DV ,a.SoLuong as SoLuong,b.GhiChu_DV,Sum(SoLuong*Gia_DV+a.DenBu) as Thanhtien
                        from tbl_ChiTietHD_DV a,tbl_DV b where b.ID_DV = a.ID_DV  
                        group by a.ID_DV ,b.Ten_DV ,a.SoLuong ,b.GhiChu_DV,b.Gia_DV,a.NgayDung  
                        """;
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                StatisticalService r = new StatisticalService();
            //doc du lieu tu sql ra java               
                r.setID_DV(rs.getString("ID_DV"));
                r.setTen_DV(rs.getString("Ten_DV"));
                r.setNgayDung(rs.getString("NgayDung"));
                r.setGia_DV(rs.getFloat("Gia_DV")); 
                r.setSoLuong(rs.getInt("SoLuong")); 
                r.setGhiChu(rs.getString("GhiChu_DV"));                 
                r.setThanhtien(rs.getFloat("Thanhtien"));               
            //thêm vào trong danh sách
                listDV.add(r);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return listDV;       
    }
    
    public ArrayList<StatisticalService> getListDTDV(StatisticalService ss){
        ArrayList<StatisticalService> listDV = new ArrayList<>();
        String select = """
                        select a.ID_DV,b.Ten_DV,a.NgayDung,b.GhiChu_DV,b.Gia_DV,a.SoLuong as SoLuong,Sum(SoLuong*Gia_DV+a.DenBu) as Thanhtien
                        from tbl_ChiTietHD_DV a,tbl_DV b where b.ID_DV = a.ID_DV and NgayDung between ? and ? 
                        group by a.ID_DV ,b.Ten_DV ,a.SoLuong ,b.GhiChu_DV,b.Gia_DV, a.NgayDung 
                        """;
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setDate(1, new Date(ss.getDateFrom().getTime()));
            ps.setDate(2, new Date(ss.getDateTo().getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                StatisticalService r = new StatisticalService();
            //doc du lieu tu sql ra java               
                r.setID_DV(rs.getString("ID_DV"));
                r.setTen_DV(rs.getString("Ten_DV"));
                r.setNgayDung(rs.getString("NgayDung"));
                r.setGia_DV(rs.getFloat("Gia_DV")); 
                r.setSoLuong(rs.getInt("SoLuong")); 
                r.setGhiChu(rs.getString("GhiChu_DV"));                 
                r.setThanhtien(rs.getFloat("Thanhtien")); 
            //thêm vào trong danh sách
                listDV.add(r);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return listDV;       
    }
}





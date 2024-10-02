/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Service;
import model.ServiceBill;

/**
 *
 * @author Minh Duc
 */
public class ServiceDAO {

    DAO DAO = new DAO();
    public Connection conn = DAO.DAO_DB();

    public int getServiceId() {
        int id = 0;
        String getMaxId = "select max(ID_DV) as MAX_ID from tbl_DV";
        try {
            PreparedStatement ps = conn.prepareStatement(getMaxId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("MAX_ID");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id + 1;
    }

    public ArrayList<Service> getListService() {
        ArrayList<Service> list = new ArrayList<>();
        String select = "Select * from tbl_DV";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service r = new Service();
                r.setID(rs.getString("ID_DV"));
                r.setName(rs.getString("Ten_DV"));
                r.setPrice(rs.getString("Gia_DV"));
                r.setNote(rs.getString("GhiChu_DV"));

                //thêm vào trong danh sách
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Service getSerivce(String id) {
        Service s = new Service();
        String get = "select * from tbl_DV where ID_DV = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(get);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            s.setID(rs.getString("ID_DV"));
            s.setName(rs.getString("Ten_DV"));
            s.setPrice(rs.getString("Gia_DV"));
            s.setNote(rs.getString("GhiChu_DV"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public boolean addService(Service r) {
        String insert = "INSERT INTO tbl_DV(ID_DV, Ten_DV, Gia_DV, GhiChu_DV)"
                + " VALUES(?,?,?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, r.getID());
            ps.setString(2, r.getName());
            ps.setString(3, r.getPrice());
            ps.setString(4, r.getNote());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addServiceBill(ServiceBill sb) {
        String insert = "Insert into tbl_ChiTietHD_DV(ID_HD,ID_DV,NgayDung,SoLuong,GhiChu,DenBu) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, sb.getBillID());
            ps.setString(2, sb.getServiceID());
            ps.setDate(3, new Date(sb.getServiceDay().getTime()));
            ps.setInt(4, sb.getServiceAmount());
            ps.setString(5, sb.getServiceNote());
            ps.setFloat(6, sb.getCompensation());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteService(String id) {
        try {
            String delete = "delete tbl_DV where ID_DV =?";
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean editService(Service r, String id) {
        try {
            String editR = "Update tbl_DV set Ten_DV=?, Gia_DV=?, GhiChu_DV=? where ID_DV=?";
            PreparedStatement ps = conn.prepareStatement(editR);
            ps.setString(1, r.getName());
            ps.setString(2, r.getPrice());
            ps.setString(3, r.getNote());
            ps.setString(4, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Service> getListServicetk(String tk) {
        ArrayList<Service> list_TK = new ArrayList<>();
        try {
            String TK = "select * from tbl_DV where ID_DV like ? or Ten_DV like ?";
            PreparedStatement ps = conn.prepareStatement(TK);
            ps.setString(1, "%" + tk + "%");
            ps.setString(2, "%" + tk + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service DV = new Service();
                //doc du lieu tu sql ra java
                DV.setID(rs.getString("ID_DV"));
                DV.setName(rs.getString("Ten_DV"));
                DV.setPrice(rs.getString("Gia_DV"));
                DV.setNote(rs.getString("GhiChu_DV"));
             
                //thêm vào trong danh sách
                list_TK.add(DV);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list_TK;
    }
}

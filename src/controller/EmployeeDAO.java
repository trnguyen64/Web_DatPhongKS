/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Employee;

public class EmployeeDAO {

    DAO DAO = new DAO();
    public Connection conn = DAO.DAO_DB();

    public ArrayList<Employee> getListNV() {
        ArrayList<Employee> list = new ArrayList<>();
        String select = "Select * from tbl_NV";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee nv = new Employee();
                //doc du lieu tu sql ra java
                nv.setID(rs.getString("ID_NV"));
                nv.setHo(rs.getString("Ho_NV"));
                nv.setTen(rs.getString("Ten_NV"));
                nv.setCCCD(rs.getString("CCCD_NV"));
                nv.setCV(rs.getString("ChucVu"));
                nv.setLuong(rs.getFloat("Luong"));
                nv.setGT(rs.getString("GT"));
                nv.setDC(rs.getString("DC_NV"));
                nv.setSDT(rs.getString("SDT_NV"));
                //thêm vào trong danh sách
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Employee getEmpoyee(String id) {
        Employee nv = new Employee();
        String select = "select * from tbl_NV where ID_NV = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            nv.setID(rs.getString("ID_NV"));
            nv.setHo(rs.getString("Ho_NV"));
            nv.setTen(rs.getString("Ten_NV"));
            nv.setCCCD(rs.getString("CCCD_NV"));
            nv.setCV(rs.getString("ChucVu"));
            nv.setLuong(rs.getFloat("Luong"));
            nv.setGT(rs.getString("GT"));
            nv.setDC(rs.getString("DC_NV"));
            nv.setSDT(rs.getString("SDT_NV"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nv;
    }

    public ArrayList<Employee> getListNVLT() {
        ArrayList<Employee> lt = new ArrayList();
        String get = "select * from tbl_NV where ChucVu like N'Lễ tân'";
        try {
            PreparedStatement ps = conn.prepareStatement(get);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee nv = new Employee();
                nv.setID(rs.getString("ID_NV"));
                nv.setHo(rs.getString("Ho_NV"));
                nv.setTen(rs.getString("Ten_NV"));
                nv.setCCCD(rs.getString("CCCD_NV"));
                nv.setCV(rs.getString("ChucVu"));
                nv.setLuong(rs.getFloat("Luong"));
                nv.setGT(rs.getString("GT"));
                nv.setDC(rs.getString("DC_NV"));
                nv.setSDT(rs.getString("SDT_NV"));

                lt.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lt;
    }

    public ArrayList<Employee> getListCBBSX1() {
        ArrayList<Employee> list1 = new ArrayList<>();
        String select = "Select * from tbl_NV order by ID_NV DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee nv = new Employee();
                //doc du lieu tu sql ra java
                nv.setID(rs.getString("ID_NV"));
                nv.setHo(rs.getString("Ho_NV"));
                nv.setTen(rs.getString("Ten_NV"));
                nv.setCCCD(rs.getString("CCCD_NV"));
                nv.setCV(rs.getString("ChucVu"));
                nv.setLuong(rs.getFloat("Luong"));
                nv.setGT(rs.getString("GT"));
                nv.setDC(rs.getString("DC_NV"));
                nv.setSDT(rs.getString("SDT_NV"));
                //thêm vào trong danh sách
                list1.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list1;
    }

    public ArrayList<Employee> getListCBBSX2() {
        ArrayList<Employee> list2 = new ArrayList<>();
        String select = "Select * from tbl_NV order by ChucVu ASC";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee nv = new Employee();
                //doc du lieu tu sql ra java
                nv.setID(rs.getString("ID_NV"));
                nv.setHo(rs.getString("Ho_NV"));
                nv.setTen(rs.getString("Ten_NV"));
                nv.setCCCD(rs.getString("CCCD_NV"));
                nv.setCV(rs.getString("ChucVu"));
                nv.setLuong(rs.getFloat("Luong"));
                nv.setGT(rs.getString("GT"));
                nv.setDC(rs.getString("DC_NV"));
                nv.setSDT(rs.getString("SDT_NV"));
                //thêm vào trong danh sách
                list2.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list2;
    }

    public ArrayList<Employee> getListCBBSX3() {
        ArrayList<Employee> list3 = new ArrayList<>();
        String select = "Select * from tbl_NV order by Luong ASC";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee nv = new Employee();
                //doc du lieu tu sql ra java
                nv.setID(rs.getString("ID_NV"));
                nv.setHo(rs.getString("Ho_NV"));
                nv.setTen(rs.getString("Ten_NV"));
                nv.setCCCD(rs.getString("CCCD_NV"));
                nv.setCV(rs.getString("ChucVu"));
                nv.setLuong(rs.getFloat("Luong"));
                nv.setGT(rs.getString("GT"));
                nv.setDC(rs.getString("DC_NV"));
                nv.setSDT(rs.getString("SDT_NV"));
                //thêm vào trong danh sách
                list3.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list3;
    }

    public ArrayList<Employee> getListCBBSX4() {
        ArrayList<Employee> list4 = new ArrayList<>();
        String select = "Select * from tbl_NV order by DC_NV ASC";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee nv = new Employee();
                //doc du lieu tu sql ra java
                nv.setID(rs.getString("ID_NV"));
                nv.setHo(rs.getString("Ho_NV"));
                nv.setTen(rs.getString("Ten_NV"));
                nv.setCCCD(rs.getString("CCCD_NV"));
                nv.setCV(rs.getString("ChucVu"));
                nv.setLuong(rs.getFloat("Luong"));
                nv.setGT(rs.getString("GT"));
                nv.setDC(rs.getString("DC_NV"));
                nv.setSDT(rs.getString("SDT_NV"));
                //thêm vào trong danh sách
                list4.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list4;
    }

    //public ArrayList<NV> getListTKNV(String id, String Ten, String CV )
    public ArrayList<Employee> getListTKNV(String string) {
        //public ArrayList<HotelRoom> getListTKRoom(String id ){
        ArrayList<Employee> list_TK = new ArrayList<>();
        //String TK = "select * from tbl_HotelRoom where ID_R like "+id+" and Loai_R like '%"+TypeR+"% and SoGiuong_R like '%"+SG+"%'";
        try {
            String TK = "select * from tbl_NV where ID_NV like ? or Ten_NV like ? or ChucVu like ? or Ho_NV like ?";
            PreparedStatement ps = conn.prepareStatement(TK);
            ps.setString(1, "%" + string + "%");
            ps.setString(2, "%" + string + "%");
            ps.setString(3, "%" + string + "%");
            ps.setString(4, "%" + string + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee nv = new Employee();
                //doc du lieu tu sql ra java
                nv.setID(rs.getString("ID_NV"));
                nv.setHo(rs.getString("Ho_NV"));
                nv.setTen(rs.getString("Ten_NV"));
                nv.setCCCD(rs.getString("CCCD_NV"));
                nv.setCV(rs.getString("ChucVu"));
                nv.setLuong(rs.getFloat("Luong"));
                nv.setGT(rs.getString("GT"));
                nv.setDC(rs.getString("DC_NV"));
                nv.setSDT(rs.getString("SDT_NV"));
                //thêm vào trong danh sách
                list_TK.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list_TK;
    }

    public boolean addNV(Employee r) {
        String insert = "INSERT INTO tbl_NV(ID_NV, Ho_NV, Ten_NV, CCCD_NV, ChucVu,Luong,GT,DC_NV,SDT_NV)"
                + " VALUES(?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, r.getID());
            ps.setString(2, r.getHo());
            ps.setString(3, r.getTen());
            ps.setString(4, r.getCCCD());
            ps.setString(5, r.getCV());
            ps.setBigDecimal(6, new BigDecimal(r.getLuong()));
            ps.setString(7, r.getGT());
            ps.setString(8, r.getDC());
            ps.setString(9, r.getSDT());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNV(String id) {
        try {
            String delete = "delete tbl_NV where ID_NV=?";
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean editNV(Employee r, String id) {
        System.out.println(id);
        try {
            String editR = "update tbl_NV set Ho_NV=?,Ten_NV=?,CCCD_NV=?,ChucVu=?,Luong=?,GT=?,DC_NV=?,SDT_NV=? where ID_NV=?";
            PreparedStatement ps = conn.prepareStatement(editR);
            ps.setString(1, r.getHo());
            ps.setString(2, r.getTen());
            ps.setString(3, r.getCCCD());
            ps.setString(4, r.getCV());
            ps.setBigDecimal(5, new BigDecimal(r.getLuong()));
            ps.setString(6, r.getGT());
            ps.setString(7, r.getDC());
            ps.setString(8, r.getSDT());
            ps.setString(9, id); // id can sua = id sua  
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}

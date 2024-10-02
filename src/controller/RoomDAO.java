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
import model.Room;
import model.RoomStatus;

public class RoomDAO {

    DAO DAO = new DAO();
    public Connection conn = DAO.DAO_DB();

    public ArrayList<Room> getListRoom() {
        ArrayList<Room> list = new ArrayList<>();
        String select = "Select * from tbl_HotelRoom";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                //doc du lieu tu sql ra java
                r.setID(rs.getString("ID_R"));
                r.setName(rs.getString("Ten_R"));
                r.setType(rs.getString("Loai_R"));
                r.setNumberBed(rs.getInt("SoGiuong_R"));
                r.setPrice(rs.getFloat("Gia_R"));
                //thêm vào trong danh sách
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Room getRoom(String id) {
        Room r = new Room();
        String select = "Select * from tbl_HotelRoom where ID_R = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            r.setID(rs.getString("ID_R"));
            r.setName(rs.getString("Ten_R"));
            r.setType(rs.getString("Loai_R"));
            r.setNumberBed(rs.getInt("SoGiuong_R"));
            r.setPrice(rs.getFloat("Gia_R"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return r;
    }

    //Sap xep theo gia giam
    public ArrayList<Room> getListCBBSX1() {
        ArrayList<Room> list1 = new ArrayList<>();
        String select = "Select * from tbl_HotelRoom order by ID_R DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                //doc du lieu tu sql ra java
                r.setID(rs.getString("ID_R"));
                r.setName(rs.getString("Ten_R"));
                r.setType(rs.getString("Loai_R"));
                r.setNumberBed(rs.getInt("SoGiuong_R"));
                r.setPrice(rs.getFloat("Gia_R"));
                //thêm vào trong danh sách
                list1.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list1;
    }

    //Sap xep theo so giuong
    public ArrayList<Room> getListCBBSX2() {
        ArrayList<Room> list2 = new ArrayList<>();
        String select = "Select * from tbl_HotelRoom order by SoGiuong_R ASC";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                //doc du lieu tu sql ra java
                r.setID(rs.getString("ID_R"));
                r.setName(rs.getString("Ten_R"));
                r.setType(rs.getString("Loai_R"));
                r.setNumberBed(rs.getInt("SoGiuong_R"));
                r.setPrice(rs.getFloat("Gia_R"));
                //thêm vào trong danh sách
                list2.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list2;
    }

    //Sap xep thep gia tang
    public ArrayList<Room> getListCBBSX3() {
        ArrayList<Room> list3 = new ArrayList<>();
        String select = "Select * from tbl_HotelRoom order by Gia_R ASC";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                //doc du lieu tu sql ra java
                r.setID(rs.getString("ID_R"));
                r.setName(rs.getString("Ten_R"));
                r.setType(rs.getString("Loai_R"));
                r.setNumberBed(rs.getInt("SoGiuong_R"));
                r.setPrice(rs.getFloat("Gia_R"));
                //thêm vào trong danh sách
                list3.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list3;
    }

    public ArrayList<Room> getListCBBSX4() {
        ArrayList<Room> list4 = new ArrayList<>();
        String select = "Select * from tbl_HotelRoom order by Loai_R ASC";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                //doc du lieu tu sql ra java
                r.setID(rs.getString("ID_R"));
                r.setName(rs.getString("Ten_R"));
                r.setType(rs.getString("Loai_R"));
                r.setNumberBed(rs.getInt("SoGiuong_R"));
                r.setPrice(rs.getFloat("Gia_R"));
                //thêm vào trong danh sách
                list4.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list4;
    }

    public ArrayList<Room> getListTKRoom(String id, String TypeR, String SG) {
        ArrayList<Room> list_TK = new ArrayList<>();
        try {
            String TK = "select * from tbl_HotelRoom where ID_R like ? and Loai_R like ? and SoGiuong_R like ?";
            PreparedStatement ps = conn.prepareStatement(TK);
            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + TypeR + "%");
            ps.setString(3, "%" + SG + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                //doc du lieu tu sql ra java
                r.setID(rs.getString("ID_R"));
                r.setName(rs.getString("Ten_R"));
                r.setType(rs.getString("Loai_R"));
                r.setNumberBed(rs.getInt("SoGiuong_R"));
                r.setPrice(rs.getFloat("Gia_R"));
                //thêm vào trong danh sách
                list_TK.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list_TK;
    }

    public boolean addRoom(Room r) {
        String insert = "INSERT INTO tbl_HotelRoom(ID_R, Ten_R, Loai_R, SoGiuong_R, Gia_R)"
                + " VALUES(?,?,?,?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, r.getID());
            ps.setString(2, r.getName());
            ps.setString(3, r.getType());
            ps.setInt(4, r.getNumberBed());
            //ps.setFloat(5, r.getPrice());
            ps.setBigDecimal(5, new BigDecimal(r.getPrice()));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addRoomStatus(RoomStatus rs) {
        String insertt = "INSERT INTO tbl_RoomStatus(ID_R, statusRoom)"
                + " VALUES(?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(insertt);
            ps.setString(1, rs.getID_R());
            ps.setString(2,"Sẵn sàng");
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteRoom(String id) {
        try {
            String delete = "delete tbl_HotelRoom where ID_R =?";
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteRoomStatus(String id1) {
        try {
            String deletee = "delete tbl_RoomStatus where ID_R =?";
            PreparedStatement ps = conn.prepareStatement(deletee);
            ps.setString(1, id1);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean editRoom(Room r, String id) {
        try {
            String editR = "update tbl_HotelRoom set Ten_R=?, Loai_R=?, SoGiuong_R=?, Gia_R=? where ID_R=?";
            PreparedStatement ps = conn.prepareStatement(editR);
            ps.setString(1, r.getName());
            ps.setString(2, r.getType());
            ps.setInt(3, r.getNumberBed());
            ps.setBigDecimal(4, new BigDecimal(r.getPrice()));
            ps.setString(5, id); // id can sua = id sua  
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public ArrayList<RoomStatus> getRoomStatus (){
        ArrayList<RoomStatus> rstatus = new ArrayList<RoomStatus>();
        String find = """
                 select tbl_RoomStatus.ID_R, Ten_R, Loai_R, SoGiuong_R, Gia_R, statusRoom 
                 from tbl_RoomStatus, tbl_HotelRoom
                 where tbl_RoomStatus.ID_R = tbl_HotelRoom.ID_R
                 """;
        try {
            PreparedStatement ps = conn.prepareStatement(find);      
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RoomStatus r = new RoomStatus();
                r.setID(rs.getString("ID_R"));
                r.setName(rs.getString("Ten_R"));
                r.setType(rs.getString("Loai_R"));
                r.setNumberBed(rs.getInt("SoGiuong_R"));
                r.setPrice(rs.getFloat("Gia_R"));          
                r.setStatus(rs.getString("statusRoom"));
                rstatus.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rstatus;
    }
    
     public boolean updateStatusRoom(String status, String id){
        try {
            String update = "update tbl_RoomStatus set statusRoom = ? where  ID_R = ?";
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setString(1, status);
            ps.setString(2, id);
            return ps.executeUpdate() > 0;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
}

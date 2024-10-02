/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Date;
import model.Bill;
import model.CustomerStay;
import java.sql.ResultSet;

/**
 *
 * @author HNT
 */
public class CheckInDAO {

    DAO DAO = new DAO();
    public Connection conn = DAO.DAO_DB();

    public int getBillId() {
        int id = 0;
        String getMaxId = "select max(ID_HD) as MAX_ID from tbl_HD";
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

    public boolean addBill(Bill b) {
        String insert = "  INSERT INTO tbl_HD(ID_HD,ID_BK, CheckinDate, CheckinTime) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, b.getBillID());
            ps.setString(2, b.getBookingID());
            ps.setDate(3, new Date(b.getDateFrom().getTime()));
            ps.setString(4, b.getTimeFrom());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean addCustomerStay(CustomerStay cs) {
        String insert = "INSERT INTO tbl_KH_stay(ID_HD,Ten_KH_stay, CCCD_KH_stay, NgaySinh, QuocTich)"
                + " VALUES(?,?,?,?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, cs.getId());
            ps.setString(2, cs.getName());
            ps.setString(3, cs.getCCCD());
            ps.setDate(4, new Date(cs.getDateOfBirth().getTime()));
            ps.setString(5, cs.getQuocTich());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<CustomerStay> getCustStay(String id) {
        ArrayList<CustomerStay> clist = new ArrayList();
        String get = "select * from tbl_KH_stay where ID_HD = ?";
        System.out.println(id);
        try {
            PreparedStatement ps = conn.prepareStatement(get);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerStay c = new CustomerStay();
                c.setId(rs.getString("ID_HD"));
                c.setName(rs.getString("Ten_KH_stay"));
                c.setCCCD(rs.getString("CCCD_KH_stay"));
                c.setDateOfBirth(rs.getDate("NgaySinh"));
                c.setQuocTich(rs.getString("QuocTich"));
                clist.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clist;
    }

    public ArrayList<Bill> getListBill() {
        ArrayList<Bill> list = new ArrayList();
        String select = "Select * from tbl_HD, tbl_BookedRoom where tbl_HD.ID_BK = tbl_BookedRoom.ID_BK order by ID_HD desc ";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                //doc du lieu tu sql ra java
                b.setBillID(rs.getString("ID_HD"));
                b.setRoomID(rs.getString("ID_R"));
                b.setBookingID(rs.getString("ID_BK"));
                b.setDateFrom(rs.getDate("CheckinDate"));
                b.setTimeFrom(rs.getString("CheckinTime"));
                b.setEmployeeID(rs.getString("ID_NV"));
                b.setSoDem(rs.getInt("SoDem"));
                b.setStatus(rs.getBoolean("hdstatus"));
                b.setDateTo(rs.getDate("CheckoutDate"));
                b.setTimeTo(rs.getString("CheckoutTime"));
                //thêm vào trong danh sách
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Bill> getBillFound(String search, Bill bill, String status) {
        ArrayList<Bill> blist = new ArrayList();
        String fstatus = "and hdstatus = " + status;
        String date = "(CheckinDate like ? and CheckoutDate like ?)";
        if (status == "") 
            fstatus = "";
                  
        if(status == "0")
            date = "(CheckinDate like ?)";
        try {
            String TK = """
                        Select * from tbl_HD inner join tbl_BookedRoom 
                        on tbl_HD.ID_BK = tbl_BookedRoom.ID_BK where
                        ( ID_R like ? or ID_HD like ? ) and 
                        """ + date + fstatus;
            PreparedStatement ps = conn.prepareStatement(TK);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            if (bill.getDateFrom() != null) {
                ps.setDate(3, new Date(bill.getDateFrom().getTime()));
            } else {
                ps.setString(3, "%");
            }
            if (status != "0") {
                if (bill.getDateTo() != null) {
                    ps.setDate(4, new Date(bill.getDateTo().getTime()));
                } else {
                    ps.setString(4, "%");
                }
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setBillID(rs.getString("ID_HD"));
                b.setRoomID(rs.getString("ID_R"));
                b.setBookingID(rs.getString("ID_BK"));
                b.setDateFrom(rs.getDate("CheckinDate"));
                b.setTimeFrom(rs.getString("CheckinTime"));
                b.setEmployeeID(rs.getString("ID_NV"));
                b.setSoDem(rs.getInt("SoDem"));
                b.setStatus(rs.getBoolean("hdstatus"));
                b.setDateTo(rs.getDate("CheckoutDate"));
                b.setTimeTo(rs.getString("CheckoutTime"));
                //thêm vào trong danh sách
                blist.add(b);
            }
        System.out.println(TK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return blist;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Room;
import java.sql.Date;
import java.sql.ResultSet;
import model.BookingRoom;
import model.FindRoom;

public class BookingRoomDAO {

    public Connection conn = new DAO().DAO_DB();

    public int getBookingId() {
        int id = 0;
        String getMaxId = "select max(ID_BK) as MAX_ID from tbl_BookedRoom";
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

    public ArrayList<Room> getRoomFound(FindRoom f) {
        ArrayList<Room> roomFound = new ArrayList();

        String find = """
                      select * from tbl_HotelRoom where ID_R not in 
                      (select tbl_BookedRoom.ID_R from tbl_BookedRoom, tbl_HotelRoom 
                      where tbl_BookedRoom.ID_R = tbl_HotelRoom.ID_R 
                      and ? between NgayNhan and NgayTra 
                      or ? between NgayNhan and NgayTra ) 
                      and tbl_HotelRoom.Loai_R like ?
                      and tbl_HotelRoom.SoGiuong_R like ?
                      """;

        try {
            PreparedStatement ps = conn.prepareStatement(find);
            ps.setDate(1, new Date(f.getDateFrom().getTime()));
            ps.setDate(2, new Date(f.getDateTo().getTime()));
            ps.setString(3, "%" + String.valueOf(f.getType()) + "%");
            ps.setString(4, "%" + String.valueOf(f.getBed()) + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Room r = new Room();

                r.setID(rs.getString("ID_R"));
                r.setName(rs.getString("Ten_R"));
                r.setType(rs.getString("Loai_R"));
                r.setNumberBed(rs.getInt("SoGiuong_R"));
                r.setPrice(rs.getFloat("Gia_R"));
                roomFound.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return roomFound;
    }

    public ArrayList<BookingRoom> getBookingList() {
        ArrayList<BookingRoom> bookingList = new ArrayList();
        String get = "select * from tbl_BookedRoom order by ID_BK desc";
        try {
            PreparedStatement ps = conn.prepareStatement(get);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookingRoom b = new BookingRoom();
                b.setBookingID(rs.getString("ID_BK"));
                b.setRoomID(rs.getString("ID_R"));
                b.setCustID(rs.getString("ID_KH"));
                b.setDateFrom(rs.getDate("NgayNhan"));
                b.setDateTo(rs.getDate("NgayTra"));
                b.setStatus(rs.getBoolean("bkstatus"));
                bookingList.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingList;
    }

    public ArrayList<BookingRoom> getBookingListFound(String search, String status) {
        ArrayList<BookingRoom> bookingList = new ArrayList();
        String fstatus = "and bkstatus = " + status;
        if (status == "") {
            fstatus = "";
        }
        String get = """
                    select ID_BK, ID_R, tbl_KH.ID_KH, NgayNhan, NgayTra, bkstatus 
                    from tbl_BookedRoom inner join tbl_KH on tbl_BookedRoom.ID_KH = tbl_KH.ID_KH 
                    where (ID_BK like ? or ID_R like ? 
                    or tbl_BookedRoom.ID_KH like ?
                    or Ten_KH like ? or SDT_KH like ? 
                    or NgayNhan like ? or NgayTra like ?)
                     """ + fstatus + "order by ID_BK desc";
        try {
            PreparedStatement ps = conn.prepareStatement(get);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setString(3, "%" + search + "%");
            ps.setString(4, "%" + search + "%");
            ps.setString(5, "%" + search + "%");
            ps.setString(6, "%" + search + "%");
            ps.setString(7, "%" + search + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookingRoom b = new BookingRoom();
                b.setBookingID(rs.getString("ID_BK"));
                b.setRoomID(rs.getString("ID_R"));
                b.setCustID(rs.getString("ID_KH"));
                b.setDateFrom(rs.getDate("NgayNhan"));
                b.setDateTo(rs.getDate("NgayTra"));
                b.setStatus(rs.getBoolean("bkstatus"));

                bookingList.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingList;
    }

    public boolean addBooking(BookingRoom booking) {
        String insert = """
                        insert into tbl_BookedRoom(ID_BK,ID_R,ID_KH,NgayNhan,NgayTra,bkstatus) 
                        values(?,?,?,?,?,?)
                        """;
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, booking.getBookingID());
            ps.setString(2, booking.getRoomID());
            ps.setString(3, booking.getCustID());
            ps.setDate(4, new Date(booking.getDateFrom().getTime()));
            ps.setDate(5, new Date(booking.getDateTo().getTime()));
            int status = booking.isStatus() ? 1 : 0;
            ps.setString(6, String.valueOf(status));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBooking(String id) {
        String insert = "delete tbl_BookedRoom where ID_BK = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean editBooking(BookingRoom b) {
        try {
            String edit = "update tbl_BookedRoom set ID_R = ?, ID_KH = ?, NgayNhan = ?, NgayTra = ? where ID_BK = ?";
            PreparedStatement ps = conn.prepareStatement(edit);
            ps.setString(1, b.getRoomID());
            ps.setString(2, b.getCustID());
            ps.setDate(3, new Date(b.getDateFrom().getTime()));
            ps.setDate(4, new Date(b.getDateTo().getTime()));
            ps.setString(5, b.getBookingID());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateStatusBooking(String id) {
        try {
            String update = "update tbl_BookedRoom set bkstatus = 1 where ID_BK = ?";
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setString(1, id);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

   

}

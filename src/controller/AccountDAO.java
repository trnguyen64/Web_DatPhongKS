/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author khacc
 */
public class AccountDAO {
    DAO DAO = new DAO();
    public Connection conn = DAO.DAO_DB();
    
    public ArrayList<Account> getAllAccount(){
        ArrayList<Account> list = new ArrayList<>();
        String select = "Select * from tbl_Account";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                //doc du lieu tu sql ra java
                a.setUsername(rs.getString("username"));
                a.setName(rs.getString("ten"));
                a.setPassword(rs.getString("pass"));
                a.setPosition(rs.getString("chucvu"));
                a.setPhone(rs.getString("sdt"));
                //thêm vào trong danh sách
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Account login(Account acc){
        ArrayList<Account> alist = this.getAllAccount();  
        for (Account a : alist) {            
            if(acc.getUsername().equals(a.getUsername())){
                if(acc.getPassword().equals(a.getPassword())){
                    return a;
                }
            }         
        }              
        return null;
    }
    
    public Account register(Account acc){
        Account a = new Account();
        String insert = "Insert into tbl_Account(username, pass, ten, chucvu, sdt) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getName());
            ps.setString(4, acc.getPosition());
            ps.setString(5, acc.getPhone());
            ps.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return acc;
    }
    
    public String statusRoomInfo(String idr){
        String info = "";
        String get = """
                    select Ten_KH, CheckinDate, NgayTra  
                    from tbl_HD, tbl_BookedRoom, tbl_KH 
                    where tbl_HD.ID_BK = tbl_BookedRoom.ID_BK 
                    and tbl_BookedRoom.ID_KH = tbl_KH.ID_KH
                    and hdstatus = 0 and ID_R = ?
                    """;
        try {
            PreparedStatement ps = conn.prepareStatement(get);
            ps.setString(1, idr);
            ResultSet rs = ps.executeQuery();
            rs.next();
            info = rs.getString("Ten_KH") + "\n Check In: " + rs.getString("CheckinDate") 
                    + "\n Check Out(dự kiến): " +rs.getString("NgayTra");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }
    
    
}

package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Customer;

public class CustomerDAO {

    DAO DAO = new DAO();
    public Connection conn = DAO.DAO_DB();

    public int getClientId() {
        int id = 0;
        String getMaxId = "select max(ID_KH) as MAX_ID from tbl_KH";
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

    public ArrayList<Customer> getListClient() {
        ArrayList<Customer> list = new ArrayList<>();
        String select = "Select * from tbl_KH";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer r = new Customer();
                r.setID(rs.getString("ID_KH"));
                r.setName(rs.getString("Ten_KH"));
                r.setAddress(rs.getString("DC_KH"));
                r.setPhone(rs.getString("SDT_KH"));

                //thêm vào trong danh sách
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Customer getClient(String id) {
        Customer client = new Customer();
        String select = "Select * from tbl_KH where ID_KH = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            client.setID(rs.getString("ID_KH"));
            client.setName(rs.getString("Ten_KH"));
            client.setAddress(rs.getString("DC_KH"));
            client.setPhone(rs.getString("SDT_KH"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return client;
    }

    public boolean addClient(Customer r) {
        String insert = "INSERT INTO tbl_KH(ID_KH, Ten_KH, DC_KH, SDT_KH)"
                + " VALUES(?,?,?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, r.getID());
            ps.setString(2, r.getName());
            ps.setString(3, r.getAddress());
            ps.setString(4, r.getPhone());
            //ps.setFloat(5, r.getPrice());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteClient(String id) {
        try {
            String delete = "delete tbl_KH where ID_KH =?";
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean editClient(Customer r, String id) {
        try {
            String editR = "Update tbl_KH set Ten_KH=?, DC_KH=?, SDT_KH=? where ID_KH=?";
            PreparedStatement ps = conn.prepareStatement(editR);
            ps.setString(1, r.getName());
            ps.setString(2, r.getAddress());
            ps.setString(3, r.getPhone());
            ps.setString(4, id); // id can sua = id sua  
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Customer> getListClienttk(String tk) {
        ArrayList<Customer> list_TK = new ArrayList<>();
        try {
            String TK = "select * from tbl_KH where ID_KH like ? or Ten_KH like ? or DC_KH like ? or SDT_KH like ?";
            PreparedStatement ps = conn.prepareStatement(TK);
            ps.setString(1, "%" + tk + "%");
            ps.setString(2, "%" + tk + "%");
            ps.setString(3, "%" + tk + "%");
            ps.setString(4, "%" + tk + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer KH = new Customer();
                //doc du lieu tu sql ra java
                KH.setID(rs.getString("ID_KH"));
                KH.setName(rs.getString("Ten_KH"));
                KH.setAddress(rs.getString("DC_KH"));
                KH.setPhone(rs.getString("SDT_KH"));
                //thêm vào trong danh sách
                list_TK.add(KH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list_TK;
    }

    public boolean checkTrungSDT(String SDT) throws SQLException{
        String sql = "SELECT SDT_KH from tbl_KH where SDT_KH = '"+ SDT +"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            return true;
        }
        return false;
    }
}

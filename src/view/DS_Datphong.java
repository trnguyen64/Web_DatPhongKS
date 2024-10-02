package view;

import controller.BookingRoomDAO;
import controller.CustomerDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BookingRoom;
import model.Customer;

public class DS_Datphong extends javax.swing.JFrame {

    private ArrayList<BookingRoom> bookingList;
    private BookingRoomDAO bookingRoomDAO = new BookingRoomDAO();
    private int selectedIndex;
    DefaultTableModel model;
    
    public DS_Datphong() {
        initComponents();
        this.setLocationRelativeTo(null);
        bookingList = new BookingRoomDAO().getBookingList();
        model = (DefaultTableModel) tblBookingList.getModel();
        btnCheckin.setVisible(false);
        showResult();
    }

     public void showResult() {
        model.setRowCount(0);
        int i = 1;
        for (BookingRoom b : bookingList) {
            Customer c = new CustomerDAO().getClient(b.getCustID());
            model.addRow(new Object[]{
                i++, b.getBookingID(), b.getRoomID(), b.getCustID(), c.getName(),
                c.getPhone(), b.getDateFrom(), b.getDateTo(), showStatus(b.isStatus())});
        }
    }
    
    public String showStatus(boolean status){
        if(status){
            return "Đã Check In";
        }else{
            return "Chưa Check In";
        }
    }
    
    public void setCheckin(){
        title.setText("DANH SÁCH ĐẶT PHÒNG CHECK IN");
        cbFilter.setSelectedIndex(2);
        btnCheckin.setVisible(true);
        bookingList = bookingRoomDAO.getBookingListFound(txtSearch.getText(), "0");
        showResult();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        begin = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookingList = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnCheckin = new javax.swing.JButton();
        cbFilter = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRefesh = new javax.swing.JLabel();
        navHome = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách sạn");

        begin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBookingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Đặt Phòng", "Mã Phòng", "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Ngày Nhận Phòng", "Ngày Trả Phòng", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(tblBookingList);

        begin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 130, 980, 520));

        btnSearch.setBackground(new java.awt.Color(112, 26, 98));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(112, 26, 98));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TK.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        begin.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 60, 50));

        txtSearch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });
        begin.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 380, 50));

        btnDelete.setBackground(new java.awt.Color(112, 26, 98));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        begin.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 60, 50));

        btnEdit.setBackground(new java.awt.Color(112, 26, 98));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sua.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        begin.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 60, 50));

        btnCheckin.setBackground(new java.awt.Color(112, 26, 98));
        btnCheckin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheckin.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckin.setText("CHECK IN");
        btnCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckinActionPerformed(evt);
            }
        });
        begin.add(btnCheckin, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 660, 140, 50));

        cbFilter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Ðã Check In", "Chưa Check In" }));
        cbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilterActionPerformed(evt);
            }
        });
        begin.add(cbFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 160, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 440, 10));

        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setText("DANH SÁCH ĐẶT PHÒNG");
        begin.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 60));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-reset-32.png"))); // NOI18N
        btnRefesh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefeshMouseClicked(evt);
            }
        });
        jPanel3.add(btnRefesh, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        navHome.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        navHome.setForeground(new java.awt.Color(255, 255, 255));
        navHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-home-32-view.png"))); // NOI18N
        navHome.setText("|");
        navHome.setToolTipText("");
        navHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navHomeMouseClicked(evt);
            }
        });
        jPanel3.add(navHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen2.jpg"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        begin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen.jpg"))); // NOI18N
        begin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(begin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(begin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String status = "";
        int index = cbFilter.getSelectedIndex();
        if(index == 1){
            status = "1";
        }else if(index == 2){
            status = "0";
        }
        bookingList = bookingRoomDAO.getBookingListFound(txtSearch.getText(), status);
        showResult();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        selectedIndex = tblBookingList.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                "Chưa chọn thông tin đặt phòng cần xóa!");
        } else {
            String id = tblBookingList.getValueAt(selectedIndex, 1).toString();
            bookingRoomDAO.deleteBooking(id);
            bookingList.remove(selectedIndex);
            JOptionPane.showMessageDialog(rootPane,
                "Xóa thông tin đặt phòng thành công!");
            showResult();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        selectedIndex = tblBookingList.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                "Chưa chọn thông tin đặt phòng cần sửa!");
        } else {
            BookingRoom booking = bookingList.get(selectedIndex);
            Datphong dp = new Datphong();
            dp.setVisible(true);
            dp.setEditBooking(booking);
            this.dispose();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckinActionPerformed
        selectedIndex = tblBookingList.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Chưa chọn thông tin đặt phòng cần sửa!");
        } else {
            BookingRoom booking = bookingList.get(selectedIndex);
            Checkin View = new Checkin();
            View.TakeBooking(booking);
            View.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnCheckinActionPerformed

    private void cbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilterActionPerformed
        String status = "";
        int index = cbFilter.getSelectedIndex();
        if(index == 1){
            status = "1";
        }else if(index == 2){
            status = "0";
        }
        bookingList = bookingRoomDAO.getBookingListFound(txtSearch.getText(), status);
        showResult();
    }//GEN-LAST:event_cbFilterActionPerformed

    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        txtSearch.setText("");
        bookingList = new BookingRoomDAO().getBookingList();
        showResult();
    }//GEN-LAST:event_btnRefeshMouseClicked

    private void navHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navHomeMouseClicked
        int conf = JOptionPane.showConfirmDialog(null,
                "Bạn có chắc chắn muốn về trang chủ?",
                "Trang Chủ",
                JOptionPane.YES_OPTION);
        if (conf == 0) {
            new TrangChu().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_navHomeMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DS_Datphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DS_Datphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DS_Datphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DS_Datphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DS_Datphong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnCheckin;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblBookingList;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

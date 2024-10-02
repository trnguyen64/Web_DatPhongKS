package view;

import controller.CheckOutDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import model.BookingRoom;


public class LK_Hoadon extends javax.swing.JFrame {

    private ArrayList<Bill> colist;
    private CheckOutDAO checkoutDAO = new CheckOutDAO();
    DefaultTableModel model;
    private int selectedIndex;
    
    public LK_Hoadon() {
         initComponents();
        this.setLocationRelativeTo(null);
        colist = checkoutDAO.getCheckOutList();
        model = (DefaultTableModel) tblBill.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "Mã Hóa Đơn", "Mã Phòng", "Ngày Check In", "Giờ Check In", "Ngày Trả(dự kiến)"});
        showTable();
    }

    public void showTable() {
         int i = 1;
        //model.setRowCount(0);
        for (Bill bill : colist) {
            BookingRoom bookingRoom = new BookingRoom();
            bookingRoom = checkoutDAO.getBooking(bill.getBookingID());
            model.addRow(new Object[]{
                i++, bill.getBillID(), bookingRoom.getRoomID(), bill.getDateFrom(), bill.getTimeFrom(), bookingRoom.getDateTo()});
        }
    }
    
    public void setCheckOut(){
        title.setText("CHỌN HÓA ĐƠN THUÊ PHÒNG CHECK OUT");
        btnBookService.setVisible(false);
        btnCheckOut.setVisible(true);
    }    
    
    public void setBookService(){
        title.setText("CHỌN HÓA ĐƠN THUÊ PHÒNG ĐẶT DỊCH VỤ");
        btnCheckOut.setVisible(false);
        btnBookService.setVisible(true);
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        begin = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnRefesh = new javax.swing.JLabel();
        navHome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        btnCheckOut = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        btnBookService = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtTK = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách sạn");

        begin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navHomeMouseEntered(evt);
            }
        });
        jPanel3.add(navHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen2.jpg"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        begin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 740, 10));

        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setText("CHỌN HÓA ĐƠN THUÊ PHÒNG CHECK OUT");
        begin.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, 50));

        btnCheckOut.setBackground(new java.awt.Color(112, 26, 98));
        btnCheckOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheckOut.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckOut.setText("Check Out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });
        begin.add(btnCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, 120, 50));

        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblBill);

        begin.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1020, 560));

        btnBookService.setBackground(new java.awt.Color(112, 26, 98));
        btnBookService.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBookService.setForeground(new java.awt.Color(255, 255, 255));
        btnBookService.setText("Ðặt Dịch Vụ");
        btnBookService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookServiceActionPerformed(evt);
            }
        });
        begin.add(btnBookService, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 120, 50));

        btnSearch.setBackground(new java.awt.Color(112, 26, 98));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TK.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        begin.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 50, 50));

        txtTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTKActionPerformed(evt);
            }
        });
        begin.add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 250, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        begin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(begin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(begin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        selectedIndex = tblBill.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                "Bạn chưa chọn hóa đơn cần check out!");
        } else {
            Bill bill = new Bill();
            bill = colist.get(selectedIndex);
            Checkout co = new Checkout();
            co.TakeCheckOut(bill);
            co.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnBookServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookServiceActionPerformed
        selectedIndex = tblBill.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                "Bạn chưa chọn hóa đơn cần đặt dịch vụ");
        } else {
            Bill bill = new Bill();
            bill = colist.get(selectedIndex);
            Datdichvu ddv = new Datdichvu();
            ddv.SetBookService(bill);
            ddv.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnBookServiceActionPerformed

    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        txtTK.setText("");
        colist = checkoutDAO.getCheckOutList();
        showTable();
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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(txtTK.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane, "Hãy nhập thông tin phòng cần Check out!");
        }else{
        colist = checkoutDAO.FindCheckOutList(txtTK.getText());
        showTable();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTKActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTKActionPerformed

    private void navHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navHomeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_navHomeMouseEntered

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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LK_Hoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnBookService;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JLabel btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblBill;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}

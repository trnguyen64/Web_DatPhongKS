package view;

import controller.CheckInDAO;
import controller.CheckOutDAO;
import controller.ServiceDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import model.Service;
import model.ServiceBill;


public class DS_HD_Thuephong extends javax.swing.JFrame {

    private ArrayList<Bill> billList;
    private ArrayList<Bill> billTK;
    private ArrayList<ServiceBill> svbills;
    private CheckInDAO checkinDAO = new CheckInDAO();
    private CheckOutDAO checkoutDAO = new CheckOutDAO();
    private ServiceDAO ServiceDAO = new ServiceDAO();
    private int selectedIndex;
    DefaultTableModel model1;
    DefaultTableModel model2;
    
    public DS_HD_Thuephong() {
        initComponents();
        this.setLocationRelativeTo(null);
        billList = checkinDAO.getListBill();
        model1 = (DefaultTableModel) tblBill.getModel();
        model1.setColumnIdentifiers(new Object[]{
            "STT", "Mã Hóa Đơn", "Mã Phòng", "Mã Đặt Phòng", "Mã Nhân Viên", "Ngày Check In", "Giờ Check In", "Ngày Chẹck Out", "Giờ Check Out",
            "Số Đêm", "Trạng Thái"
        });      
        model2 = (DefaultTableModel) tblService.getModel();
        model2.setColumnIdentifiers(new Object[]{
            "STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Ngày Dùng", "Đơn Giá", "Số Lượng", "Ghi Chú", "Đền Bù"
        });
        showResult();
    }

    public void showResult() {
        model1.setRowCount(0);
        int i = 1;
        for (Bill b : billList) {
            model1.addRow(new Object[]{
                i++, b.getBillID(), b.getRoomID(), b.getBookingID(), b.getEmployeeID(), b.getDateFrom(), b.getTimeFrom(), b.getDateTo(), b.getTimeTo(),
                b.getSoDem(), showStatus(b.isStatus())});
        }
    }

    public void showResultService() {
        model2.setRowCount(0);
        int i = 1;
        for (ServiceBill sb : svbills) {
            Service s = ServiceDAO.getSerivce(sb.getServiceID());
            model2.addRow(new Object[]{
                i++, sb.getServiceID(), s.getName(), sb.getServiceDay(), s.getPrice(), sb.getServiceAmount(), sb.getServiceNote(), sb.getCompensation()});
        }
    }

    public String showStatus(boolean status) {
        if (status) {
            return "Đã Thanh Toán";
        } else {
            return "Chưa Thanh Toán";
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        begin = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnRefesh = new javax.swing.JLabel();
        navHome = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dcDateFrom = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dcDateTo = new com.toedter.calendar.JDateChooser();
        txtSearch = new javax.swing.JTextField();
        btnSearchBill = new javax.swing.JButton();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnViewBill = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

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
        });
        jPanel3.add(navHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen2.jpg"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        begin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 640, 10));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("DANH SÁCH HÓA ĐƠN THUÊ PHÒNG");
        begin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Ngày Check In:");
        begin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        dcDateFrom.setDateFormatString("dd/MM/yyyy");
        begin.add(dcDateFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 130, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ngày Check Out:");
        begin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, 30));

        dcDateTo.setDateFormatString("dd/MM/yyyy");
        begin.add(dcDateTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 130, -1));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        begin.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 200, 40));

        btnSearchBill.setBackground(new java.awt.Color(112, 26, 98));
        btnSearchBill.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSearchBill.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TK.png"))); // NOI18N
        btnSearchBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBillActionPerformed(evt);
            }
        });
        begin.add(btnSearchBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 40, 40));

        cbStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Tất Cả", "Ðã Thanh Toán", "Chưa Thanh Toán" }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });
        begin.add(cbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Trạng Thái:");
        begin.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, -1, 30));

        btnViewBill.setBackground(new java.awt.Color(112, 26, 98));
        btnViewBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewBill.setForeground(new java.awt.Color(255, 255, 255));
        btnViewBill.setText("Xem Chi Tiết");
        btnViewBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBillActionPerformed(evt);
            }
        });
        begin.add(btnViewBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, -1, 40));

        tblBill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblBill);

        begin.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1020, 210));

        tblService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblService);

        begin.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 1020, 280));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 320, 10));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Danh Sách Dịch Vụ Sử Dụng");
        begin.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Danh Sách Hóa Đơn");
        begin.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, 40));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 230, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen.jpg"))); // NOI18N
        begin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

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

    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        dcDateFrom.setDate(null);
        dcDateTo.setDate(null);
        txtSearch.setText("");
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

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBillActionPerformed

        Bill b = new Bill();
        b.setRoomID(txtSearch.getText());
        b.setDateFrom(dcDateFrom.getDate());
        b.setDateTo(dcDateTo.getDate());
        String status = "";
        int index = cbStatus.getSelectedIndex();
        if (index == 1) {
            status = "1";
        } else if (index == 2) {
            status = "0";
        }
        billList = new CheckInDAO().getBillFound(txtSearch.getText(), b, status);
        showResult();
    }//GEN-LAST:event_btnSearchBillActionPerformed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        Bill b = new Bill();
        b.setDateFrom(dcDateFrom.getDate());
        b.setDateTo(dcDateTo.getDate());
        String status = "";
        int index = cbStatus.getSelectedIndex();
        if (index == 1) {
            status = "1";
        } else if (index == 2) {
            status = "0";
        }
        billList = checkinDAO.getBillFound(txtSearch.getText(), b ,status);
        showResult();
    }//GEN-LAST:event_cbStatusActionPerformed

    private void btnViewBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBillActionPerformed
        selectedIndex = tblBill.getSelectedRow();
        String svbills1 = (String) tblBill.getValueAt(selectedIndex, 1);
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Chưa chọn thông tin cần xem!");
        } else {
            svbills = checkoutDAO.getSerivceBill(svbills1);
            showResultService();
        }
    }//GEN-LAST:event_btnViewBillActionPerformed

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
            java.util.logging.Logger.getLogger(DS_HD_Thuephong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DS_HD_Thuephong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DS_HD_Thuephong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DS_HD_Thuephong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DS_HD_Thuephong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JLabel btnRefesh;
    private javax.swing.JButton btnSearchBill;
    private javax.swing.JButton btnViewBill;
    private javax.swing.JComboBox<String> cbStatus;
    private com.toedter.calendar.JDateChooser dcDateFrom;
    private com.toedter.calendar.JDateChooser dcDateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblService;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

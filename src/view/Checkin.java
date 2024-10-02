package view;

import controller.CheckInDAO;
import controller.BookingRoomDAO;
import controller.CheckOutDAO;
import controller.CustomerDAO;
import controller.RoomDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CustomerStay;

import model.Bill;
import model.BookingRoom;
import model.Customer;
import model.Room;

public class Checkin extends javax.swing.JFrame implements ActionListener {

    private CheckInDAO checkinDAO = new CheckInDAO();
    private ArrayList<CustomerStay> customerstays = new ArrayList<CustomerStay>();
    DefaultTableModel tblModel;
    
    public Checkin() {
        initComponents();
        setLocationRelativeTo(null);
        tblModel = (DefaultTableModel) tblStay.getModel();
        tblModel.setColumnIdentifiers(new Object[]{
            "STT", "Tên Khách", "CCCD", "Ngày sinh", "Quốc tịch"
        });
    }

    public void showResultStay() {
        tblModel.setRowCount(0);
        int i = 1;
        for (CustomerStay cs : customerstays) {
            tblModel.addRow(new Object[]{
                i++, cs.getName(), cs.getCCCD(), cs.getDateOfBirth().toString(), cs.getQuocTich()
            });
        }
    }

    public void TakeBooking(BookingRoom b) {
        Customer c = new CustomerDAO().getClient(b.getCustID());
        Room r = new RoomDAO().getRoom(b.getRoomID());
        txtMahd.setText(String.valueOf(checkinDAO.getBillId()));
        txtMaDat.setText(b.getBookingID());
        txtSdt.setText(c.getPhone());
        txtKH.setText(c.getName());
        txtRoomID.setText(b.getRoomID());
        txtLoaiPhong.setText(r.getType());
        txtSoGiuong.setText(String.valueOf(r.getNumberBed()));
        txtGia.setText(String.valueOf(r.getPrice()));
        lbDateFrom.setText(b.getDateFrom().toString());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        begin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMahd = new javax.swing.JTextField();
        txtKH = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        dcDateFrom = new com.toedter.calendar.JDateChooser();
        lbDateFrom = new javax.swing.JLabel();
        jbltra = new javax.swing.JLabel();
        txtCheckinTime = new javax.swing.JTextField();
        txtMaDat = new javax.swing.JTextField();
        txtRoomID = new javax.swing.JTextField();
        txtLoaiPhong = new javax.swing.JTextField();
        txtSoGiuong = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStay = new javax.swing.JTable();
        btnNhanPhong = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTenKHstay = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        txtAddKHStay = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRefesh = new javax.swing.JLabel();
        navHome = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách sạn");

        begin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mã Hóa Đơn:");
        begin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 97, -1));

        txtMahd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMahd.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtMahd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 190, -1));

        txtKH.setEditable(false);
        txtKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtKH.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 190, -1));

        txtSdt.setEditable(false);
        txtSdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSdt.setMinimumSize(new java.awt.Dimension(150, 30));
        txtSdt.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 190, -1));

        dcDateFrom.setDateFormatString("dd/MM/yyyy");
        dcDateFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(dcDateFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 190, 40));

        lbDateFrom.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lbDateFrom.setForeground(new java.awt.Color(0, 0, 0));
        lbDateFrom.setText("yyyy-dd-mm");
        begin.add(lbDateFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, 20));

        jbltra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbltra.setForeground(new java.awt.Color(0, 0, 0));
        jbltra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jbltra.setText("Giờ Check In:");
        begin.add(jbltra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 107, 24));

        txtCheckinTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCheckinTime.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtCheckinTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 190, -1));

        txtMaDat.setEditable(false);
        txtMaDat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaDat.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtMaDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 150, -1));
        txtMaDat.getAccessibleContext().setAccessibleDescription("");

        txtRoomID.setEditable(false);
        txtRoomID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRoomID.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtRoomID, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 150, -1));
        txtRoomID.getAccessibleContext().setAccessibleDescription("");

        txtLoaiPhong.setEditable(false);
        txtLoaiPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLoaiPhong.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 150, -1));
        txtLoaiPhong.getAccessibleContext().setAccessibleDescription("");

        txtSoGiuong.setEditable(false);
        txtSoGiuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoGiuong.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtSoGiuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 150, -1));
        txtSoGiuong.getAccessibleContext().setAccessibleDescription("");

        txtGia.setEditable(false);
        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGia.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 150, -1));
        txtGia.getAccessibleContext().setAccessibleDescription("");

        tblStay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblStay);

        begin.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 700, 290));

        btnNhanPhong.setBackground(new java.awt.Color(112, 26, 98));
        btnNhanPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnNhanPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanPhong.setText("Nhận Phòng");
        btnNhanPhong.setToolTipText("Click to save");
        btnNhanPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanPhongActionPerformed(evt);
            }
        });
        begin.add(btnNhanPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(856, 660, 150, 50));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 160, 10));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText(" Tên Khách Hàng:");
        begin.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 120, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("     Số Điện Thoại:");
        begin.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 120, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText(" Mã Phòng:");
        begin.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Mã Đặt Phòng:");
        begin.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("  Loại Phòng:");
        begin.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Số Giường:");
        begin.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 80, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Giá Phòng:");
        begin.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 80, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText(" Ngày Check In:");
        begin.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 110, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CHECK IN");
        begin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 60));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Họ Tên: ");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        txtTenKHstay.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(txtTenKHstay, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Số CCCD:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, -1));

        txtCCCD.setPreferredSize(new java.awt.Dimension(150, 40));
        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDActionPerformed(evt);
            }
        });
        jPanel2.add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Ngày Sinh:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txtNgaySinh.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Quốc Tịch:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, -1));

        txtCountry.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(txtCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        txtAddKHStay.setBackground(new java.awt.Color(112, 26, 98));
        txtAddKHStay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAddKHStay.setForeground(new java.awt.Color(255, 255, 255));
        txtAddKHStay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/KH.png"))); // NOI18N
        txtAddKHStay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddKHStayActionPerformed(evt);
            }
        });
        jPanel2.add(txtAddKHStay, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 50, 50));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen.jpg"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 260));

        begin.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 280, 260));

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Khách Hàng Ở Tại Phòng");
        begin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1020, 720));
        jLabel1.setMinimumSize(new java.awt.Dimension(1020, 720));
        jLabel1.setPreferredSize(new java.awt.Dimension(1020, 720));
        begin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void txtCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCCDActionPerformed

    private void txtAddKHStayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddKHStayActionPerformed

        CustomerStay cs = new CustomerStay();
        cs.setId(txtMahd.getText());
        cs.setName(txtTenKHstay.getText());
        cs.setCCCD(txtCCCD.getText());
        try {
            cs.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgaySinh.getText()));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        cs.setQuocTich(txtCountry.getText());
        customerstays.add(cs);
        showResultStay();
        txtTenKHstay.setText("");
        txtCountry.setText("");
        txtCCCD.setText("");
        txtNgaySinh.setText("");
    }//GEN-LAST:event_txtAddKHStayActionPerformed

    private void btnNhanPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanPhongActionPerformed
        // Luu hoa don
        Bill b = new Bill();
        b.setBillID(txtMahd.getText());
        b.setBookingID(txtMaDat.getText());
        b.setTimeFrom(txtCheckinTime.getText());
        b.setDateFrom(dcDateFrom.getDate());
        if (checkinDAO.addBill(b)) {
            for (CustomerStay cs : customerstays) {
                if (checkinDAO.addCustomerStay(cs)) {
                    customerstays = checkinDAO.getCustStay(txtMahd.getText());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Không thể thêm khách hàng ở tại phòng!");
                }
            }
            JOptionPane.showMessageDialog(rootPane, "Check In thành công!");
            new RoomDAO().updateStatusRoom("Đang sử dụng", txtRoomID.getText());
            new BookingRoomDAO().updateStatusBooking(b.getBookingID());
            new CheckOutDAO().updateStatusBill(b.getBillID(), "0");
            new TrangChu().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Check In thất bại! Vui lòng kiểm tra lại thông tin.");
        }
    }//GEN-LAST:event_btnNhanPhongActionPerformed

    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        dcDateFrom.setDate(null);
        txtCheckinTime.setText("");
        txtTenKHstay.setText("");
        txtCountry.setText("");
        txtCCCD.setText("");
        txtNgaySinh.setText("");
        customerstays.clear();
        showResultStay();
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
            java.util.logging.Logger.getLogger(Checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnNhanPhong;
    private javax.swing.JLabel btnRefesh;
    private com.toedter.calendar.JDateChooser dcDateFrom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jbltra;
    private javax.swing.JLabel lbDateFrom;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblStay;
    private javax.swing.JButton txtAddKHStay;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtCheckinTime;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtKH;
    private javax.swing.JTextField txtLoaiPhong;
    private javax.swing.JTextField txtMaDat;
    private javax.swing.JTextField txtMahd;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtRoomID;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSoGiuong;
    private javax.swing.JTextField txtTenKHstay;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

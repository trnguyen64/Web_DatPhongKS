package view;

import controller.BookingRoomDAO;
import controller.CustomerDAO;
import controller.RoomDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BookingRoom;
import model.Customer;
import model.FindRoom;
import model.Room;

public class Datphong extends javax.swing.JFrame {

    private ArrayList<Room> roomFound;
    private BookingRoomDAO bookingRoomDAO = new BookingRoomDAO();
    private int roomSelectedIndex;
    private boolean isEdit = false;
    DefaultTableModel modelRF;
    
    public Datphong() {
        initComponents();
        setLocationRelativeTo(null);
        modelRF = (DefaultTableModel) tblRoomFind.getModel();
    }

    public void showRoomFound() {
        for (Room r : roomFound) {
            modelRF.addRow(new Object[]{
                r.getID(), r.getName(), r.getType(), r.getNumberBed(), r.getPrice()
            });
        }
    }

    public void showResult() {
        modelRF.setRowCount(0);
        this.showRoomFound();
    }

    public void setCustData(Customer c) {
        txtClientId.setText(c.getID());
        txtCustumerName.setText(c.getName());
        txtPhoneNumber.setText(c.getPhone());
        txtBookingId.setText(String.valueOf(bookingRoomDAO.getBookingId()));
    }

    public void setEditBooking(BookingRoom b) {
        Customer c = new CustomerDAO().getClient(b.getCustID());
        Room r = new RoomDAO().getRoom(b.getRoomID());

        isEdit = true;
        txtBookingId.setText(b.getBookingID());
        txtBookingId.setEditable(false);
        
        txtClientId.setText(b.getCustID());
        txtCustumerName.setText(c.getName());
        txtPhoneNumber.setText(c.getPhone());      
        dcDateFrom.setDate(b.getDateFrom());
        dcDateTo.setDate(b.getDateTo());

        txtRoomId.setText(b.getRoomID());
        txtRoomName.setText(r.getName());
        txtType.setText(r.getType());
        txtBed.setText(String.valueOf(r.getNumberBed()));
        txtPrice.setText(String.valueOf(r.getPrice()));

        btnBook.setText("Lưu Lại");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        begin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnChooseKH = new javax.swing.JButton();
        btnChooseRoom = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnRefesh = new javax.swing.JLabel();
        navHome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtClientId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCustumerName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dcDateFrom = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        dcDateTo = new com.toedter.calendar.JDateChooser();
        txtBookingId = new javax.swing.JTextField();
        txtRoomId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRoomName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtBed = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbTypeFind = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtBedFind = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRoomFind = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách sạn");

        begin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ĐẶT PHÒNG");
        begin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, -2, -1, 60));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 210, 10));

        btnChooseKH.setBackground(new java.awt.Color(112, 26, 98));
        btnChooseKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChooseKH.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/KH.png"))); // NOI18N
        btnChooseKH.setPreferredSize(new java.awt.Dimension(150, 60));
        btnChooseKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseKHActionPerformed(evt);
            }
        });
        begin.add(btnChooseKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 50, 50));

        btnChooseRoom.setBackground(new java.awt.Color(112, 26, 98));
        btnChooseRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChooseRoom.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseRoom.setText("Chọn phòng");
        btnChooseRoom.setPreferredSize(new java.awt.Dimension(150, 60));
        btnChooseRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseRoomActionPerformed(evt);
            }
        });
        begin.add(btnChooseRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 160, -1));

        btnBook.setBackground(new java.awt.Color(112, 26, 98));
        btnBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBook.setForeground(new java.awt.Color(255, 255, 255));
        btnBook.setText("Đặt phòng");
        btnBook.setPreferredSize(new java.awt.Dimension(150, 60));
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });
        begin.add(btnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 160, -1));

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen2.jpg"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        begin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Mã Đặt Phòng:");
        begin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Mã Khách Hàng:");
        begin.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        txtClientId.setEditable(false);
        txtClientId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtClientId.setPreferredSize(new java.awt.Dimension(150, 40));
        txtClientId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientIdActionPerformed(evt);
            }
        });
        begin.add(txtClientId, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 140, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Tên Khách Hàng:");
        begin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        txtCustumerName.setEditable(false);
        txtCustumerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCustumerName.setMinimumSize(new java.awt.Dimension(150, 40));
        txtCustumerName.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtCustumerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 190, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("    Số Điện Thoại:");
        begin.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 120, -1));

        txtPhoneNumber.setEditable(false);
        txtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhoneNumber.setMinimumSize(new java.awt.Dimension(200, 26));
        txtPhoneNumber.setPreferredSize(new java.awt.Dimension(150, 40));
        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });
        begin.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 190, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Ngày Nhận:");
        begin.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, -1, -1));

        dcDateFrom.setDateFormatString("dd/MM/yyyy");
        dcDateFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dcDateFrom.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(dcDateFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 190, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Ngày Trả:");
        begin.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, -1, -1));

        dcDateTo.setDateFormatString("dd/MM/yyyy");
        dcDateTo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dcDateTo.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(dcDateTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 190, 40));

        txtBookingId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBookingId.setEnabled(false);
        txtBookingId.setPreferredSize(new java.awt.Dimension(150, 40));
        txtBookingId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookingIdActionPerformed(evt);
            }
        });
        begin.add(txtBookingId, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 190, -1));

        txtRoomId.setEditable(false);
        txtRoomId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRoomId.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtRoomId, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 190, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText(" Mã Phòng:");
        begin.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Tên Phòng:");
        begin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        txtRoomName.setEditable(false);
        txtRoomName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRoomName.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtRoomName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 190, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText(" Loại Phòng:");
        begin.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        txtType.setEditable(false);
        txtType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtType.setPreferredSize(new java.awt.Dimension(150, 40));
        txtType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTypeActionPerformed(evt);
            }
        });
        begin.add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 190, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Số Giường:");
        begin.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        txtBed.setEditable(false);
        txtBed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBed.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtBed, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 190, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Giá Phòng:");
        begin.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(0, 0, 0));
        txtPrice.setPreferredSize(new java.awt.Dimension(150, 40));
        begin.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 190, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Loại:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        cbTypeFind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standard", "Superior", "Deluxe", "Suite" }));
        jPanel1.add(cbTypeFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 90, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Giường:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, -1));
        jPanel1.add(txtBedFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 90, 40));

        jButton4.setBackground(new java.awt.Color(112, 26, 98));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TK.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 40, 40));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen.jpg"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 170));

        begin.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 160, 170));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 150, 10));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Tìm Phòng");
        begin.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Bảng Chọn Phòng");
        begin.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, -1, 30));

        tblRoomFind.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phòng", "Tên Phòng", "Loại Phòng", "Số Giường", "Giá"
            }
        ));
        jScrollPane2.setViewportView(tblRoomFind);

        begin.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 381, 840, 340));

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
            .addComponent(begin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtClientIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientIdActionPerformed

    private void txtBookingIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookingIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookingIdActionPerformed

    private void txtTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTypeActionPerformed

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        txtBookingId.setText("");
        txtClientId.setText("");
        txtCustumerName.setText("");
        txtPhoneNumber.setText("");
        txtRoomId.setText("");
        dcDateFrom.setDate(null);
        dcDateTo.setDate(null);
        txtRoomName.setText("");
        txtType.setText("");
        txtBed.setText("");
        txtPrice.setText("");
        dcDateFrom.setDate(null);
        dcDateTo.setDate(null);
        txtBedFind.setText("1");

        roomFound.clear();
        showResult();
    }//GEN-LAST:event_btnRefeshMouseClicked

    private void btnChooseKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseKHActionPerformed
        // TODO add your handling code here:
        if (isEdit) {
            JOptionPane.showMessageDialog(rootPane,
                    "Không thể thay đổi thông tin khách hàng!");
        } else {
            DS_Khachhang dskh = new DS_Khachhang();
            dskh.setVisible(true);
            dskh.setBookingClient();
            this.dispose();
        }
    }//GEN-LAST:event_btnChooseKHActionPerformed

    private void btnChooseRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseRoomActionPerformed
        // TODO add your handling code here:
        roomSelectedIndex = tblRoomFind.getSelectedRow();
        if (roomSelectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Chưa chọn phòng muốn đặt!");
        } else {
            Room roomSelect = new Room();
            roomSelect = roomFound.get(roomSelectedIndex);
            txtRoomId.setText(roomSelect.getID());
            txtRoomName.setText(roomSelect.getName());
            txtType.setText(roomSelect.getType());
            txtBed.setText(String.valueOf(roomSelect.getNumberBed()));
            txtPrice.setText(String.valueOf(roomSelect.getPrice()));
        }
    }//GEN-LAST:event_btnChooseRoomActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(txtBedFind.getText()) < 3 && Integer.parseInt(txtBedFind.getText()) > 0){
            FindRoom f = new FindRoom();
            f.setType(String.valueOf(cbTypeFind.getSelectedItem()));
            f.setBed(Integer.parseInt(txtBedFind.getText()));
            f.setDateFrom(dcDateFrom.getDate());
            f.setDateTo(dcDateTo.getDate());
            roomFound = bookingRoomDAO.getRoomFound(f);
            showResult();
        } else {
            JOptionPane.showMessageDialog(rootPane,"Chỉ có 1 giường và 2 giường !!!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
        BookingRoom booking = new BookingRoom();
        booking.setBookingID(txtBookingId.getText());
        booking.setCustID(txtClientId.getText());
        booking.setRoomID(txtRoomId.getText());
        booking.setStatus(false);
        booking.setDateFrom(dcDateFrom.getDate());
        booking.setDateTo(dcDateTo.getDate());
        if (txtBookingId.getText().equals("")
                || txtClientId.getText().equals("")
                || txtRoomId.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Hãy điền đầy đủ thông tin!");
        } else {
            if (isEdit) {
                if (bookingRoomDAO.editBooking(booking)) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Sửa thông tin thành công!");
                    new TrangChu().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane,
                            "Sửa thông tin không thành công! Vui lòng kiểm tra lại thông tin.");
                }
            } else {
                if (bookingRoomDAO.addBooking(booking)) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Đặt phòng thành công!");
                    new TrangChu().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane,
                            "Đặt phòng không thành công! Vui lòng kiểm tra lại thông tin.");
                }
            }
        }
    }//GEN-LAST:event_btnBookActionPerformed

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
                new Datphong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnChooseKH;
    private javax.swing.JButton btnChooseRoom;
    private javax.swing.JLabel btnRefesh;
    private javax.swing.JComboBox<String> cbTypeFind;
    private com.toedter.calendar.JDateChooser dcDateFrom;
    private com.toedter.calendar.JDateChooser dcDateTo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblRoomFind;
    private javax.swing.JTextField txtBed;
    private javax.swing.JTextField txtBedFind;
    private javax.swing.JTextField txtBookingId;
    private javax.swing.JTextField txtClientId;
    private javax.swing.JTextField txtCustumerName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtRoomId;
    private javax.swing.JTextField txtRoomName;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}

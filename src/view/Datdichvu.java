package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.CheckOutDAO;
import controller.CustomerDAO;
import controller.RoomDAO;
import controller.ServiceDAO;
import model.Bill;
import model.BookingRoom;
import model.Customer;
import model.CustomerStay;
import model.Room;
import model.Service;
import model.ServiceBill;

public class Datdichvu extends javax.swing.JFrame {

    DefaultTableModel modelServiceBooked;
    DefaultTableModel modelCust;
    DefaultTableModel modelService;
    private CheckOutDAO checkoutDAO = new CheckOutDAO();
    private ServiceDAO ServiceDAO = new ServiceDAO();
    private ArrayList<Service> listSv;
    private Bill bill = new Bill();
    private BookingRoom bookingRoom = new BookingRoom();
    private Room room = new Room();
    private int selectedIndex;
    
    public Datdichvu() {
        initComponents();
        setLocationRelativeTo(null);
        modelServiceBooked = (DefaultTableModel) tblServiceBooked.getModel();
        modelCust = (DefaultTableModel) tblCustStay.getModel();
        modelService = (DefaultTableModel) tblService.getModel();
        listSv = ServiceDAO.getListService();
        showServiceTable();
    }

    public void SetBookService(Bill b) {
        bill = b;
        bookingRoom = checkoutDAO.getBooking(bill.getBookingID());
        room = new RoomDAO().getRoom(bookingRoom.getRoomID());
        Customer c = new CustomerDAO().getClient(bookingRoom.getCustID());
        txtMaHD.setText(bill.getBillID());
        txtTenKH.setText(c.getName());
        txtSDT.setText(c.getPhone());
        txtDateFrom.setText(bill.getDateFrom().toString());
        char[] time = new char[5];
        bill.getTimeFrom().getChars(0, 5, time, 0);
        txtTimeFrom.setText(String.valueOf(time));
        txtDateTo.setText(bookingRoom.getDateTo().toString());
        txtRoomID.setText(room.getID());
        txtType.setText(room.getType());
        txtBed.setText(String.valueOf(room.getNumberBed()));
        showCustTable();
        showServiceBookedTable();

    }

    public void showServiceTable() {
        modelService.setRowCount(0);
        for (Service r : listSv) {
            modelService.addRow(new Object[]{
                r.getID(), r.getName(), r.getPrice(), r.getNote()
            });
        }
    }

    public void showCustTable() {
        modelCust.setRowCount(0);
        int i = 1;
        ArrayList<CustomerStay> clist = checkoutDAO.getCustStay(bill.getBillID());
        for (CustomerStay c : clist) {
            modelCust.addRow(new Object[]{
                i++, c.getName(), c.getCCCD(), c.getDateOfBirth(), c.getQuocTich()
            });
        }
    }

    public void showServiceBookedTable() {
        modelServiceBooked.setRowCount(0);
        int i = 1;
        ArrayList<ServiceBill> slist = checkoutDAO.getSerivceBill(bill.getBillID());
        for (ServiceBill sl : slist) {
            Service s = ServiceDAO.getSerivce(sl.getServiceID());
            modelServiceBooked.addRow(new Object[]{
                i++, sl.getServiceID(), s.getName(), sl.getServiceDay(), sl.getServiceAmount(), sl.getServiceNote(), sl.getCompensation()
            });
        }
        float serviceSalary = checkoutDAO.getServiceSalary(bill.getBillID());
        txtServicePrice.setText(String.valueOf(serviceSalary));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        begin = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustStay = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServiceBooked = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDateFrom = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTimeFrom = new javax.swing.JTextField();
        txtDateTo = new javax.swing.JTextField();
        txtNote = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dcDateUse = new com.toedter.calendar.JDateChooser();
        txtBed = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        txtRoomID = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();
        txtQuanity = new javax.swing.JTextField();
        txtCompensation = new javax.swing.JTextField();
        btnAddService = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtServicePrice = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnRefesh = new javax.swing.JLabel();
        navHome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách sạn");

        begin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCustStay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Khách Hàng", "CCCD", "Ngày Sinh", "Quốc Tịch"
            }
        ));
        jScrollPane1.setViewportView(tblCustStay);

        begin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 470, 270));

        tblServiceBooked.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Ngày Dùng", "Số Lượng", "Ghi Chú", "Đền Bù"
            }
        ));
        jScrollPane2.setViewportView(tblServiceBooked);

        begin.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 380, 540, 270));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText(" Mã Phòng:");
        begin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Tên Khách Hàng:");
        begin.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Số Giường:");
        begin.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText(" Loại Phòng:");
        begin.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("    Số Điện Thoại:");
        begin.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 120, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Mã Hóa Đơn:");
        begin.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 90, -1));

        txtMaHD.setEditable(false);
        txtMaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, 40));

        txtTenKH.setEditable(false);
        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 150, 40));

        txtSDT.setEditable(false);
        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 150, 40));

        txtDateFrom.setEditable(false);
        txtDateFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDateFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateFromActionPerformed(evt);
            }
        });
        begin.add(txtDateFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 150, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("  Giờ Check In:");
        begin.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 100, 22));

        txtTimeFrom.setEditable(false);
        txtTimeFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtTimeFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 150, 40));

        txtDateTo.setEditable(false);
        txtDateTo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDateTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateToActionPerformed(evt);
            }
        });
        begin.add(txtDateTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 150, 40));

        txtNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 150, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Ghi Chú(dịch vụ):");
        begin.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 120, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Ngày Dùng(dịch vụ):");
        begin.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ngày Trả (Dự kiến):");
        begin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        dcDateUse.setDateFormatString("dd/MM/yyyy");
        begin.add(dcDateUse, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 148, 40));

        txtBed.setEditable(false);
        txtBed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtBed, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 150, 40));

        txtType.setEditable(false);
        txtType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 150, 40));

        txtRoomID.setEditable(false);
        txtRoomID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRoomID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomIDActionPerformed(evt);
            }
        });
        begin.add(txtRoomID, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 150, 40));

        tblService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Dịch Vụ", "Tên Dịch Vụ", "Giá", "Ghi chú"
            }
        ));
        jScrollPane3.setViewportView(tblService);

        begin.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 400, 200));

        txtQuanity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtQuanity, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 150, 40));

        txtCompensation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCompensation.setText("0");
        begin.add(txtCompensation, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 150, 40));

        btnAddService.setBackground(new java.awt.Color(112, 26, 98));
        btnAddService.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddService.setForeground(new java.awt.Color(255, 255, 255));
        btnAddService.setText("Thêm Dịch Vụ");
        btnAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceActionPerformed(evt);
            }
        });
        begin.add(btnAddService, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 280, 130, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText(" Số Lượng:");
        begin.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 80, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Ngày Check In:");
        begin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 100, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Đền Bù:");
        begin.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 60, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tổng Tiền Dịch Vụ:");
        begin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 670, -1, -1));

        txtServicePrice.setEditable(false);
        txtServicePrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtServicePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicePriceActionPerformed(evt);
            }
        });
        begin.add(txtServicePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 660, 190, 50));

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

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 230, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 340, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 270, 10));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ĐẶT DỊCH VỤ");
        begin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, -2, -1, 60));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Danh Sách Dịch Vụ Đã Sử Dụng");
        begin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Danh Sách Khách Hàng Ở Trong Phòng");
        begin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 340, 30));

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
            .addComponent(begin, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateFromActionPerformed

    private void txtDateToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateToActionPerformed

    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        selectedIndex = tblService.getSelectedRow();
        Service sv = new Service();
        ServiceBill sb = new ServiceBill();
        sv = listSv.get(selectedIndex);
        sb.setBillID(txtMaHD.getText());
        sb.setServiceID(sv.getID());
        sb.setServiceDay(dcDateUse.getDate());
        sb.setServiceAmount(Integer.parseInt(txtQuanity.getText()));
        sb.setServiceNote(txtNote.getText());
        sb.setCompensation(Float.parseFloat(txtCompensation.getText()));

        if (ServiceDAO.addServiceBill(sb)) {
            JOptionPane.showMessageDialog(rootPane, "Đặt dịch vụ thành công!");
            dcDateUse.setDate(null);
            txtNote.setText("");
            txtCompensation.setText("0");
            txtQuanity.setText("");
            showServiceBookedTable();
        } else {
            JOptionPane.showMessageDialog(rootPane,
                "Đặt dịch vụ không thành công! Vui lòng kiểm tra lại thông tin.");
        }

    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        dcDateUse.setDate(null);
        txtNote.setText("");
        txtCompensation.setText("0");
        txtQuanity.setText("");
        showServiceTable();
        showCustTable();
        showServiceBookedTable();
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

    private void txtRoomIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomIDActionPerformed

    private void txtServicePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicePriceActionPerformed

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
            java.util.logging.Logger.getLogger(Datdichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datdichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datdichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datdichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datdichvu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnAddService;
    private javax.swing.JLabel btnRefesh;
    private com.toedter.calendar.JDateChooser dcDateUse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblCustStay;
    private javax.swing.JTable tblService;
    private javax.swing.JTable tblServiceBooked;
    private javax.swing.JTextField txtBed;
    private javax.swing.JTextField txtCompensation;
    private javax.swing.JTextField txtDateFrom;
    private javax.swing.JTextField txtDateTo;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtQuanity;
    private javax.swing.JTextField txtRoomID;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtServicePrice;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimeFrom;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}

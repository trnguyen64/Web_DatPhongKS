package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.CheckOutDAO;
import controller.CustomerDAO;
import controller.EmployeeDAO;
import controller.RoomDAO;
import controller.ServiceDAO;
import model.Bill;
import model.BookingRoom;
import model.Customer;
import model.CustomerStay;
import model.Room;
import model.Employee;
import model.ServiceBill;
import model.Service;

public class Checkout extends javax.swing.JFrame {

    DefaultTableModel modelService;
    DefaultTableModel modelCust;
    private CheckOutDAO checkoutDAO = new CheckOutDAO();
    private ServiceDAO ServiceDAO = new ServiceDAO();
    private Bill bill = new Bill();
    private BookingRoom bookingRoom = new BookingRoom();
    private Room room = new Room();
    private ArrayList<Employee> lt = new ArrayList<Employee>();
    
    public Checkout() {
        initComponents();
        setLocationRelativeTo(null);
        modelService = (DefaultTableModel) tblService.getModel();
        modelCust = (DefaultTableModel) tblCustStay.getModel();
    }

    public void setCbLT() {
        lt = new EmployeeDAO().getListNVLT();
        for (Employee e : lt) {
            cbEmployee.addItem(e.getID());
        }
    }

    public void TakeCheckOut(Bill b) {
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
        txtPrice.setText(String.valueOf(room.getPrice()));
        txtRoomID.setText(room.getID());
        txtType.setText(room.getType());
        txtBed.setText(String.valueOf(room.getNumberBed()));
        lbDateTo.setText(bookingRoom.getDateTo().toString());
        showCustTable();
        showServiceTable();
        setCbLT();
    }

    public void showCustTable() {
        modelService.setRowCount(0);
        int i = 1;
        ArrayList<CustomerStay> clist = checkoutDAO.getCustStay(bill.getBillID());
        for (CustomerStay c : clist) {
            modelCust.addRow(new Object[]{
                i++, c.getName(), c.getCCCD(), c.getDateOfBirth(), c.getQuocTich()
            });
        }
    }

    public void showServiceTable() {
        modelService.setRowCount(0);
        int i = 1;
        ArrayList<ServiceBill> slist = checkoutDAO.getSerivceBill(bill.getBillID());
        for (ServiceBill sl : slist) {
            Service s = ServiceDAO.getSerivce(sl.getServiceID());
            modelService.addRow(new Object[]{
                i++, sl.getServiceID(), s.getName(), sl.getServiceDay(), sl.getServiceAmount(), sl.getServiceNote(), sl.getCompensation()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        begin = new javax.swing.JPanel();
        txtSDT = new javax.swing.JTextField();
        txtDateFrom = new javax.swing.JTextField();
        txtRoomID = new javax.swing.JTextField();
        txtBed = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustStay = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtServicePrice = new javax.swing.JTextField();
        txtTimeFrom = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtTimeTo = new javax.swing.JTextField();
        cbEmployee = new javax.swing.JComboBox<>();
        lbDateTo = new javax.swing.JLabel();
        txtRoomPriceSum = new javax.swing.JTextField();
        dcDateTo = new com.toedter.calendar.JDateChooser();
        txtPayToWin = new javax.swing.JTextField();
        btnCheckOut = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSoDem = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        txtEmName = new javax.swing.JTextField();
        btnSum = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnRefesh = new javax.swing.JLabel();
        navHome = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách sạn");

        begin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSDT.setEditable(false);
        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 190, 40));

        txtDateFrom.setEditable(false);
        txtDateFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDateFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateFromActionPerformed(evt);
            }
        });
        begin.add(txtDateFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 190, 40));

        txtRoomID.setEditable(false);
        txtRoomID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtRoomID, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 190, 40));

        txtBed.setEditable(false);
        txtBed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtBed, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 190, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Ngày Check Out:");
        begin.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        tblCustStay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Khách Hàng", "CCCD", "Ngày Sinh", "Quốc Tịch"
            }
        ));
        jScrollPane1.setViewportView(tblCustStay);

        begin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 470, 160));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Mã Nhân Viên:");
        begin.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Giờ Check In:");
        begin.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 22));

        txtServicePrice.setEditable(false);
        txtServicePrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtServicePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicePriceActionPerformed(evt);
            }
        });
        begin.add(txtServicePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 190, 40));

        txtTimeFrom.setEditable(false);
        txtTimeFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtTimeFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 190, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Giờ Check Out:");
        begin.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, 22));

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        begin.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, 190, 40));

        txtTimeTo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtTimeTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 190, 40));

        cbEmployee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmployeeActionPerformed(evt);
            }
        });
        begin.add(cbEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 190, 40));

        lbDateTo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lbDateTo.setForeground(new java.awt.Color(0, 0, 0));
        lbDateTo.setText("yyyy-dd-mm");
        begin.add(lbDateTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, -1, -1));

        txtRoomPriceSum.setEditable(false);
        txtRoomPriceSum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRoomPriceSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomPriceSumActionPerformed(evt);
            }
        });
        begin.add(txtRoomPriceSum, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 190, 40));

        dcDateTo.setDateFormatString("dd/MM/yyyy");
        begin.add(dcDateTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 190, 40));

        txtPayToWin.setEditable(false);
        txtPayToWin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPayToWin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPayToWinActionPerformed(evt);
            }
        });
        begin.add(txtPayToWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 650, 190, 60));

        btnCheckOut.setBackground(new java.awt.Color(112, 26, 98));
        btnCheckOut.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btnCheckOut.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckOut.setText("Check Out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });
        begin.add(btnCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 590, 460, 90));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText(" Mã Hóa Đơn:");
        begin.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtMaHD.setEditable(false);
        txtMaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 190, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Số Đêm:");
        begin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, -1, -1));

        txtSoDem.setEditable(false);
        txtSoDem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtSoDem, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, 190, 40));

        txtType.setEditable(false);
        txtType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 190, 40));

        txtTenKH.setEditable(false);
        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 190, 40));

        tblService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Ngày dùng", "Số lượng", "Ghi chú", "Đền bù"
            }
        ));
        jScrollPane2.setViewportView(tblService);

        begin.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 390, 540, 160));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Tên Nhân Viên:");
        begin.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, -1, 20));

        txtEmName.setEditable(false);
        txtEmName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtEmName, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, 190, 40));

        btnSum.setBackground(new java.awt.Color(112, 26, 98));
        btnSum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSum.setForeground(new java.awt.Color(255, 255, 255));
        btnSum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TT.png"))); // NOI18N
        btnSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumActionPerformed(evt);
            }
        });
        begin.add(btnSum, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 280, 80, 60));

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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen2.jpg"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        begin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CHECK OUT");
        begin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 60));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 200, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tổng Tiền Dịch Vụ:");
        begin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 600, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Thành Tiền:");
        begin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, -1, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tổng Tiền Thuê Phòng:");
        begin.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText(" Mã Phòng:");
        begin.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("  Loại Phòng:");
        begin.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Số Giường:");
        begin.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 80, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Giá Phòng:");
        begin.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 80, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText(" Tên Khách Hàng:");
        begin.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 40));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("     Số Điện Thoại:");
        begin.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText(" Ngày Check In:");
        begin.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Danh Sách Khách Hàng Ở Trong Phòng");
        begin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 340, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 340, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Danh Sách Dịch Vụ Đã Sử Dụng");
        begin.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, -1, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 270, 10));

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

    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        txtMaHD.setText("");
        txtTenKH.setText("");
        txtSDT.setText("");
        txtDateFrom.setText("");
        txtTimeFrom.setText("");
        txtPrice.setText("");
        txtRoomID.setText("");
        txtType.setText("");
        txtBed.setText("");
        txtTimeTo.setText("");
        txtSoDem.setText("");
        txtRoomPriceSum.setText("");
        txtServicePrice.setText("");
        txtPayToWin.setText("");
        dcDateTo.setDate(null);
        modelService.setRowCount(0);
        modelCust.setRowCount(0);
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

    private void txtDateFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateFromActionPerformed

    private void txtServicePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicePriceActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void cbEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmployeeActionPerformed
        String employeeID = (String) cbEmployee.getSelectedItem();
        Employee nv = new EmployeeDAO().getEmpoyee(employeeID);
        txtEmName.setText(nv.getHo() + " " + nv.getTen());
    }//GEN-LAST:event_cbEmployeeActionPerformed

    private void txtRoomPriceSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomPriceSumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomPriceSumActionPerformed

    private void txtPayToWinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayToWinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPayToWinActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        new RoomDAO().updateStatusRoom("Chưa sẵn sàng", txtRoomID.getText());
        new CheckOutDAO().updateStatusBill(bill.getBillID(), "1");
        JOptionPane.showMessageDialog(rootPane, "Check out thành công!");
        new TrangChu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumActionPerformed
        bill.setDateTo(dcDateTo.getDate());
        String employee = (String) cbEmployee.getSelectedItem();
        bill.setEmployeeID(employee);
        bill.setTimeTo(txtTimeTo.getText());
        if (checkoutDAO.addBillToPay(bill)) {
            if (checkoutDAO.addSoDem(bill)) {
                bill.setSoDem(checkoutDAO.getSodem(bill.getBillID()));
                txtSoDem.setText(String.valueOf(bill.getSoDem()));
                float serviceSalary = checkoutDAO.getServiceSalary(bill.getBillID());
                txtServicePrice.setText(String.valueOf(serviceSalary));

                float roomSalary = bill.getSoDem() * room.getPrice();
                txtRoomPriceSum.setText(String.valueOf(roomSalary));

                float sum = roomSalary + serviceSalary;
                txtPayToWin.setText(String.valueOf(sum));
            }
        }
    }//GEN-LAST:event_btnSumActionPerformed

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
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JLabel btnRefesh;
    private javax.swing.JButton btnSum;
    private javax.swing.JComboBox<String> cbEmployee;
    private com.toedter.calendar.JDateChooser dcDateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbDateTo;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblCustStay;
    private javax.swing.JTable tblService;
    private javax.swing.JTextField txtBed;
    private javax.swing.JTextField txtDateFrom;
    private javax.swing.JTextField txtEmName;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtPayToWin;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtRoomID;
    private javax.swing.JTextField txtRoomPriceSum;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtServicePrice;
    private javax.swing.JTextField txtSoDem;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimeFrom;
    private javax.swing.JTextField txtTimeTo;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}

package view;

import controller.AccountDAO;
import controller.RoomDAO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Account;
import model.RoomStatus;


public class TrangChu extends javax.swing.JFrame {

    private ArrayList<RoomStatus> roomStatus = new ArrayList<RoomStatus>();
    private RoomDAO roomDAO = new RoomDAO();
    private AccountDAO accountDAO = new AccountDAO();
    private String position;
    
    public TrangChu() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        sroom.setVisible(true);
        btnSR.setVisible(false);
        btnSS.setVisible(false);       
        setRoomStatus();
    }
    
    public Account setAccount(Account acc) {
        return acc;
    }

    public void setColorEnter(JPanel J) {
        J.setBackground(new Color(234, 234, 234));
    }

    public void setColorExited(JPanel J) {
        J.setBackground(new Color(255, 255, 255));
    }

    private void updateSRoom(String status, String id) {
        if (roomDAO.updateStatusRoom(status, id)) {
            sroom.removeAll();
            sroom.setVisible(false);
            sroom.setVisible(true);
            setRoomStatus();
            JOptionPane.showMessageDialog(rootPane, "Cập nhật trạng thái thành công!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể cập nhật trạng thái phòng hiện tại!");
        }
    }

    private void setRoomStatus() {
        roomStatus = roomDAO.getRoomStatus();
        sroom.setLayout(new GridLayout(6, 5, 4, 3));
        for (int i = 0; i < roomStatus.size(); i++) {
            String id = roomStatus.get(i).getID();
            JButton rs = new JButton("P" + roomStatus.get(i).getID() + ": " + roomStatus.get(i).getStatus());
            rs.setCursor(new Cursor(Cursor.HAND_CURSOR));
            rs.setFont(new Font("Segeo UI", Font.ITALIC, 13));
            rs.setForeground(new Color(246, 246, 246));

            if (roomStatus.get(i).getStatus().equals("Sẵn sàng")) {
                rs.setBackground(new Color(0, 183, 54));
                rs.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int conf = JOptionPane.showConfirmDialog(null,
                                "Phòng đang ở trạng thái sẵn sàng, bạn có muốn cập nhật lại?",
                                "Cập nhật trạng thái phòng",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (conf == 0) {
                            String sInput = JOptionPane.showInputDialog(rootPane, "Trạng thái");
                            if (sInput != null) {
                                updateSRoom(sInput, id);
                            }
                        }
                    }
                });
            } else if (roomStatus.get(i).getStatus().equals("Đang sử dụng")) {
                String roomID = roomStatus.get(i).getID();
                rs.setBackground(new Color(18, 102, 241));
                rs.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String info = accountDAO.statusRoomInfo(roomID);
                        JOptionPane.showMessageDialog(null,
                                "Khách hàng: " + info, "Thông tin phòng hiện tại",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                });
            } else if (roomStatus.get(i).getStatus().equals("Chưa sẵn sàng")) {
                rs.setBackground(new Color(240, 169, 0));
                rs.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int conf = JOptionPane.showConfirmDialog(null,
                                "Bạn muốn cập nhận trạng thái phòng thành Sẵn sàng?",
                                "Cập nhật trạng thái phòng",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (conf == 0) {
                            updateSRoom("Sẵn sàng", id);
                        }

                    }
                });
            } else {
                rs.setBackground(new Color(249, 49, 84));
                rs.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int conf = JOptionPane.showConfirmDialog(null,
                                "Bạn có muốn cập nhật lại trạng thái phòng hiện tại?",
                                "Cập nhật trạng thái phòng",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (conf == 0) {
                            String sInput = JOptionPane.showInputDialog(rootPane, "Trạng thái");
                            if (sInput != null) {
                                updateSRoom(sInput, id);
                            }
                        }

                    }
                });
            }
            sroom.add(rs);

        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        begin = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnCheckin = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        btnCheckout = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnBookingList = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnCustList = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnBook = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnBookService = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnBillList = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSR = new javax.swing.JButton();
        btnSS = new javax.swing.JButton();
        btnEmployee = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnRoom = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnStatistical = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btnService = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sroom = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        navLogin = new javax.swing.JLabel();
        navHome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách sạn");

        begin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 20, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCheckin.setBackground(new java.awt.Color(255, 255, 255));
        btnCheckin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheckinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCheckinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCheckinMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Check In");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-hotel-check-in-32.png"))); // NOI18N

        javax.swing.GroupLayout btnCheckinLayout = new javax.swing.GroupLayout(btnCheckin);
        btnCheckin.setLayout(btnCheckinLayout);
        btnCheckinLayout.setHorizontalGroup(
            btnCheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCheckinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
        btnCheckinLayout.setVerticalGroup(
            btnCheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnCheckinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnCheckin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 114, 266, -1));

        btnCheckout.setBackground(new java.awt.Color(255, 255, 255));
        btnCheckout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setText("Check Out");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-hotel-check-out-32.png"))); // NOI18N

        javax.swing.GroupLayout btnCheckoutLayout = new javax.swing.GroupLayout(btnCheckout);
        btnCheckout.setLayout(btnCheckoutLayout);
        btnCheckoutLayout.setHorizontalGroup(
            btnCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnCheckoutLayout.setVerticalGroup(
            btnCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnCheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 171, 266, -1));

        btnBookingList.setBackground(new java.awt.Color(255, 255, 255));
        btnBookingList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBookingList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookingListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookingListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookingListMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Danh Sách Đặt Phòng");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-list-32 (1).png"))); // NOI18N

        javax.swing.GroupLayout btnBookingListLayout = new javax.swing.GroupLayout(btnBookingList);
        btnBookingList.setLayout(btnBookingListLayout);
        btnBookingListLayout.setHorizontalGroup(
            btnBookingListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBookingListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addGap(54, 54, 54))
        );
        btnBookingListLayout.setVerticalGroup(
            btnBookingListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnBookingListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnBookingList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 228, 266, -1));

        btnCustList.setBackground(new java.awt.Color(255, 255, 255));
        btnCustList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCustListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCustListMouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Danh Sách Khách Hàng");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-profile-32.png"))); // NOI18N

        javax.swing.GroupLayout btnCustListLayout = new javax.swing.GroupLayout(btnCustList);
        btnCustList.setLayout(btnCustListLayout);
        btnCustListLayout.setHorizontalGroup(
            btnCustListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCustListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        btnCustListLayout.setVerticalGroup(
            btnCustListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnCustListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnCustList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 342, 267, -1));

        btnBook.setBackground(new java.awt.Color(255, 255, 255));
        btnBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Đặt Phòng");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-booking-32.png"))); // NOI18N

        javax.swing.GroupLayout btnBookLayout = new javax.swing.GroupLayout(btnBook);
        btnBook.setLayout(btnBookLayout);
        btnBookLayout.setHorizontalGroup(
            btnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnBookLayout.setVerticalGroup(
            btnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanel1.add(btnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnBookService.setBackground(new java.awt.Color(255, 255, 255));
        btnBookService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBookService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookServiceMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Đặt Dịch Vụ");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reception.png"))); // NOI18N

        javax.swing.GroupLayout btnBookServiceLayout = new javax.swing.GroupLayout(btnBookService);
        btnBookService.setLayout(btnBookServiceLayout);
        btnBookServiceLayout.setHorizontalGroup(
            btnBookServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBookServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
        );
        btnBookServiceLayout.setVerticalGroup(
            btnBookServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnBookServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnBookService, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, -1, -1));

        btnBillList.setBackground(new java.awt.Color(255, 255, 255));
        btnBillList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBillList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBillListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBillListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBillListMouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Danh Sách Hóa Đơn Thuê Phòng");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-list-view-32.png"))); // NOI18N

        javax.swing.GroupLayout btnBillListLayout = new javax.swing.GroupLayout(btnBillList);
        btnBillList.setLayout(btnBillListLayout);
        btnBillListLayout.setHorizontalGroup(
            btnBillListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBillListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnBillListLayout.setVerticalGroup(
            btnBillListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(btnBillListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnBillList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 285, 266, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen2.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 440));

        jTabbedPane1.addTab("Khách sạn", jPanel1);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnSR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSR.setText("Theo Phòng");
        btnSR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSRActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 40, 0, 0);
        jPanel2.add(btnSR, gridBagConstraints);

        btnSS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSS.setText("Theo dịch vụ");
        btnSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 10, 0, 0);
        jPanel2.add(btnSS, gridBagConstraints);

        btnEmployee.setBackground(new java.awt.Color(255, 255, 255));
        btnEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setText("Nhân Viên");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-employees-32.png"))); // NOI18N

        javax.swing.GroupLayout btnEmployeeLayout = new javax.swing.GroupLayout(btnEmployee);
        btnEmployee.setLayout(btnEmployeeLayout);
        btnEmployeeLayout.setHorizontalGroup(
            btnEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnEmployeeLayout.setVerticalGroup(
            btnEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 1, 1, 1);
        jPanel2.add(btnEmployee, gridBagConstraints);

        btnRoom.setBackground(new java.awt.Color(255, 255, 255));
        btnRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRoom.setPreferredSize(new java.awt.Dimension(261, 51));
        btnRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRoomMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRoomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRoomMouseExited(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel29.setText("Phòng Khách Sạn");
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-bed-32.png"))); // NOI18N

        javax.swing.GroupLayout btnRoomLayout = new javax.swing.GroupLayout(btnRoom);
        btnRoom.setLayout(btnRoomLayout);
        btnRoomLayout.setHorizontalGroup(
            btnRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73))
        );
        btnRoomLayout.setVerticalGroup(
            btnRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 1, 1, 1);
        jPanel2.add(btnRoom, gridBagConstraints);

        btnStatistical.setBackground(new java.awt.Color(255, 255, 255));
        btnStatistical.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStatistical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatisticalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStatisticalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStatisticalMouseExited(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel32.setText("Thống Kê");

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-statistics-32.png"))); // NOI18N

        javax.swing.GroupLayout btnStatisticalLayout = new javax.swing.GroupLayout(btnStatistical);
        btnStatistical.setLayout(btnStatisticalLayout);
        btnStatisticalLayout.setHorizontalGroup(
            btnStatisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnStatisticalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnStatisticalLayout.setVerticalGroup(
            btnStatisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnStatisticalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 1, 1, 1);
        jPanel2.add(btnStatistical, gridBagConstraints);

        btnService.setBackground(new java.awt.Color(255, 255, 255));
        btnService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnServiceMouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setText("Dịch Vụ");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-service-32-l.png"))); // NOI18N

        javax.swing.GroupLayout btnServiceLayout = new javax.swing.GroupLayout(btnService);
        btnService.setLayout(btnServiceLayout);
        btnServiceLayout.setHorizontalGroup(
            btnServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnServiceLayout.setVerticalGroup(
            btnServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 1, 1, 1);
        jPanel2.add(btnService, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen2.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipadx = -1000;
        gridBagConstraints.ipady = -280;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        jTabbedPane1.addTab("Quản lý", jPanel2);

        begin.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 270, 450));

        sroom.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout sroomLayout = new javax.swing.GroupLayout(sroom);
        sroom.setLayout(sroomLayout);
        sroomLayout.setHorizontalGroup(
            sroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        sroomLayout.setVerticalGroup(
            sroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        begin.add(sroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 730, 420));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        navLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-account-32.png"))); // NOI18N
        navLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navLoginMouseClicked(evt);
            }
        });
        jPanel3.add(navLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

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

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("WELCOME !!!");
        begin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        begin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 490));

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

    private void btnBookServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookServiceMouseClicked
        LK_Hoadon lk = new LK_Hoadon();
        lk.setVisible(true);
        lk.setBookService();
        this.dispose();
    }//GEN-LAST:event_btnBookServiceMouseClicked

    private void btnBookServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookServiceMouseEntered
        setColorEnter(btnBookService);
    }//GEN-LAST:event_btnBookServiceMouseEntered

    private void btnBookServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookServiceMouseExited
        setColorExited(btnBookService);
    }//GEN-LAST:event_btnBookServiceMouseExited

    private void btnCheckinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckinMouseClicked
        DS_Datphong dsdp = new DS_Datphong();
        dsdp.setVisible(true);
        dsdp.setCheckin();
        this.dispose();
    }//GEN-LAST:event_btnCheckinMouseClicked

    private void btnCheckinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckinMouseEntered
        setColorEnter(btnCheckin);
    }//GEN-LAST:event_btnCheckinMouseEntered

    private void btnCheckinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckinMouseExited
        setColorExited(btnCheckin);
    }//GEN-LAST:event_btnCheckinMouseExited

    private void btnBookingListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookingListMouseClicked
        new DS_Datphong().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBookingListMouseClicked

    private void btnBookingListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookingListMouseEntered
        setColorEnter(btnBookingList);
    }//GEN-LAST:event_btnBookingListMouseEntered

    private void btnBookingListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookingListMouseExited
        setColorExited(btnBookingList);
    }//GEN-LAST:event_btnBookingListMouseExited

    private void btnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseClicked
        new Datphong().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBookMouseClicked

    private void btnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseEntered
        setColorEnter(btnBook);
    }//GEN-LAST:event_btnBookMouseEntered

    private void btnBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseExited
        setColorExited(btnBook);
    }//GEN-LAST:event_btnBookMouseExited

    private void btnBillListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBillListMouseClicked
        new DS_HD_Thuephong().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBillListMouseClicked

    private void btnBillListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBillListMouseEntered
        setColorEnter(btnBillList);
    }//GEN-LAST:event_btnBillListMouseEntered

    private void btnBillListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBillListMouseExited
        setColorExited(btnBillList);
    }//GEN-LAST:event_btnBillListMouseExited

    private void btnCheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseClicked
        LK_Hoadon lk = new LK_Hoadon();
        lk.setVisible(true);
        lk.setCheckOut();
        this.dispose();
    }//GEN-LAST:event_btnCheckoutMouseClicked

    private void btnCheckoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseEntered
        setColorEnter(btnCheckout);
    }//GEN-LAST:event_btnCheckoutMouseEntered

    private void btnCheckoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseExited
        setColorExited(btnCheckout);
    }//GEN-LAST:event_btnCheckoutMouseExited

    private void btnCustListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustListMouseClicked
        new DS_Khachhang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCustListMouseClicked

    private void btnCustListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustListMouseEntered
        setColorEnter(btnCustList);
    }//GEN-LAST:event_btnCustListMouseEntered

    private void btnCustListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustListMouseExited
        setColorExited(btnCustList);
    }//GEN-LAST:event_btnCustListMouseExited

    private void btnServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceMouseClicked
        new Dichvu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnServiceMouseClicked

    private void btnServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceMouseEntered
        setColorEnter(btnService);
    }//GEN-LAST:event_btnServiceMouseEntered

    private void btnServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceMouseExited
        setColorExited(btnService);
    }//GEN-LAST:event_btnServiceMouseExited

    private void btnEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseClicked
        new DS_Nhanvien().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEmployeeMouseClicked

    private void btnEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseEntered
        setColorEnter(btnEmployee);
    }//GEN-LAST:event_btnEmployeeMouseEntered

    private void btnEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseExited
        setColorExited(btnEmployee);
    }//GEN-LAST:event_btnEmployeeMouseExited

    private void btnRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRoomMouseClicked
        new P_Khachsan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRoomMouseClicked

    private void btnRoomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRoomMouseEntered
        setColorEnter(btnRoom);
    }//GEN-LAST:event_btnRoomMouseEntered

    private void btnRoomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRoomMouseExited
        setColorExited(btnRoom);
    }//GEN-LAST:event_btnRoomMouseExited

    private void btnStatisticalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisticalMouseClicked
        btnSR.setVisible(true);
        btnSS.setVisible(true);
    }//GEN-LAST:event_btnStatisticalMouseClicked

    private void btnStatisticalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisticalMouseEntered
        setColorEnter(btnStatistical);
    }//GEN-LAST:event_btnStatisticalMouseEntered

    private void btnStatisticalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisticalMouseExited
        setColorExited(btnStatistical);
    }//GEN-LAST:event_btnStatisticalMouseExited

    private void btnSRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSRActionPerformed
        new TK_DT_Phong().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSRActionPerformed

    private void btnSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSSActionPerformed
        new TK_DT_Dichvu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSSActionPerformed

    private void navLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navLoginMouseClicked
        int conf = JOptionPane.showConfirmDialog(null,
                "Bạn có chắc chắn muốn đăng xuất?",
                "Thông báo",
                JOptionPane.YES_OPTION);
        if (conf == 0) {
            new Dangnhap_dangky().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_navLoginMouseClicked

    private void navHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navHomeMouseClicked

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
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JPanel btnBillList;
    private javax.swing.JPanel btnBook;
    private javax.swing.JPanel btnBookService;
    private javax.swing.JPanel btnBookingList;
    private javax.swing.JPanel btnCheckin;
    private javax.swing.JPanel btnCheckout;
    private javax.swing.JPanel btnCustList;
    private javax.swing.JPanel btnEmployee;
    private javax.swing.JPanel btnRoom;
    private javax.swing.JButton btnSR;
    private javax.swing.JButton btnSS;
    private javax.swing.JPanel btnService;
    private javax.swing.JPanel btnStatistical;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel navHome;
    private javax.swing.JLabel navLogin;
    private javax.swing.JPanel sroom;
    // End of variables declaration//GEN-END:variables

}

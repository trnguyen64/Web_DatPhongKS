package view;

import controller.RoomDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Room;
import model.RoomStatus;

public class P_Khachsan extends javax.swing.JFrame {

    private RoomDAO roomDAO = new RoomDAO();
    private ArrayList<Room> list;
    DefaultTableModel model;
    private int selectedIndex;
    
    public P_Khachsan() {
        initComponents();
        this.setLocationRelativeTo(null);
        list = roomDAO.getListRoom();
        model = (DefaultTableModel) tblRoom.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "ID", "Tên phòng", "Loại phòng", "Số giường", "Giá"
        });
        showResult();
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        begin = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnRefesh = new javax.swing.JLabel();
        navHome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        txtBed = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbSX = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRoom = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
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
        });
        jPanel3.add(navHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen2.jpg"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        begin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Phòng Khách Sạn");
        begin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, 50));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 290, 10));

        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPriceMouseClicked(evt);
            }
        });
        begin.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 190, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(" Giá Phòng:");
        begin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText(" Tên Phòng:");
        begin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });
        begin.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 190, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mã Phòng:");
        begin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, -1));

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIDMouseClicked(evt);
            }
        });
        begin.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 190, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Loại Phòng:");
        begin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        txtType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTypeMouseClicked(evt);
            }
        });
        begin.add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 190, 40));

        txtBed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBedMouseClicked(evt);
            }
        });
        begin.add(txtBed, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 190, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText(" Số giường:");
        begin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 80, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("SẮP XẾP THEO:");
        begin.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        cbbSX.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Từ thấp đến cao", "Từ cao đến thấp", "Số giường", "Giá phòng", "Loại phòng" }));
        cbbSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSXActionPerformed(evt);
            }
        });
        begin.add(cbbSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 167, 40));

        tblRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblRoom);

        begin.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 107, 710, 610));

        btnAdd.setBackground(new java.awt.Color(112, 26, 98));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/them.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        begin.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 70, 70));

        btnEdit.setBackground(new java.awt.Color(112, 26, 98));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sua.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        begin.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 70, 70));

        btnUpdate.setBackground(new java.awt.Color(112, 26, 98));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/chinhsua.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        begin.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 610, 70, 70));

        btnDelete.setBackground(new java.awt.Color(112, 26, 98));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        begin.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 70, 70));

        btnSearch.setBackground(new java.awt.Color(112, 26, 98));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TK.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        begin.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 280, 50));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 280, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 280, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Phòng");
        begin.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 112, -1, 40));

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

    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        txtID.setText("");
        txtName.setText("");
        txtType.setText("");
        txtBed.setText("");
        txtPrice.setText("");
        list = roomDAO.getListRoom();
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

    private void txtPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPriceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceMouseClicked

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameMouseClicked

    private void txtIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMouseClicked

    private void txtTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTypeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTypeMouseClicked

    private void txtBedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBedMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBedMouseClicked

    private ArrayList<Room> list1, list2, list3, list4;

    public void showResultSort(ArrayList<Room> l) {
        model.setRowCount(0);
        int i = 1;
        for (Room r : l) {
            model.addRow(new Object[]{
                i++, r.getID(), r.getName(), r.getType(), r.getNumberBed(), r.getPrice()
            });
        }
    }
    
    private void cbbSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSXActionPerformed
        int index = cbbSX.getSelectedIndex();
        if (index == 0) {
            showResult();
        } else if (index == 1) {
            list1 = roomDAO.getListCBBSX1();
            showResultSort(list1);
        } else if (index == 2) {
            list2 = roomDAO.getListCBBSX2();
            showResultSort(list2);

        } else if (index == 3) {
            list3 = roomDAO.getListCBBSX3();
            showResultSort(list3);

        } else if (index == 4) {
            list4 = roomDAO.getListCBBSX4();
            showResultSort(list4);
        }
    }//GEN-LAST:event_cbbSXActionPerformed

    public void showResult() {
        model.setRowCount(0);
        int i = 1;
        for (Room r : list) {
            model.addRow(new Object[]{
                i++, r.getID(), r.getName(), r.getType(), r.getNumberBed(), r.getPrice()
            });
        }
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtID.getText().equals("") || txtName.getText().equals("") || txtType.getText().equals("")
                || txtBed.getText().equals("") || txtPrice.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Hãy điền đầy đủ thông tin của phòng!");
        } else {
            Room r = new Room();
            RoomStatus rs = new RoomStatus();
            rs.setID_R(txtID.getText());
            r.setID(txtID.getText());
            r.setName(txtName.getText());
            r.setType(txtType.getText());
            r.setNumberBed(Integer.parseInt(txtBed.getText()));
            r.setPrice(Float.parseFloat(txtPrice.getText()));
            if (roomDAO.addRoom(r) && roomDAO.addRoomStatus(rs)) {
                JOptionPane.showMessageDialog(rootPane, "Thêm phòng thành công!");
                list.add(r);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm phòng không thành công, hãy kiểm tra lại thông tin!");
            }
            showResult();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Room roomSelect = new Room();
        selectedIndex = tblRoom.getSelectedRow();
        roomSelect = list.get(selectedIndex);
        txtID.setText(roomSelect.getID());
        txtID.setEditable(false);
        txtName.setText(roomSelect.getName());
        txtType.setText(roomSelect.getType());
        txtBed.setText(String.valueOf(roomSelect.getNumberBed()));
        txtPrice.setText(String.valueOf(roomSelect.getPrice()));
        showResult();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Room r = new Room();
        r.setID(txtID.getText());
        r.setName(txtName.getText());
        r.setType(txtType.getText());
        r.setNumberBed(Integer.parseInt(txtBed.getText()));
        r.setPrice(Float.parseFloat(txtPrice.getText()));
        if (roomDAO.editRoom(r, txtID.getText())) {
            roomDAO.editRoom(r, txtID.getText());
            JOptionPane.showMessageDialog(rootPane, "Cập nhật phòng thành công!");
            list.clear();
            list = roomDAO.getListRoom();
            showResult();
            //reset text field
            txtID.setEditable(true);
            txtID.setText("");
            txtName.setText("");
            txtType.setText("");
            txtBed.setText("");
            txtPrice.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật phòng không thành công!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String id = tblRoom.getValueAt(tblRoom.getSelectedRow(), 1).toString();
         String id1 = tblRoom.getValueAt(tblRoom.getSelectedRow(), 1).toString();
        int DelIndex = tblRoom.getSelectedRow();
        if (roomDAO.deleteRoom(id) && roomDAO.deleteRoomStatus(id1)) {
            list.remove(DelIndex);
            showResult();
            JOptionPane.showMessageDialog(rootPane, "Xóa phòng thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Xóa phòng không thành công");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private ArrayList<Room> listTK;

    public void showResultTK() {
        model.setRowCount(0);
        int i = 1;
        for (Room r : listTK) {
            model.addRow(new Object[]{
                i++, r.getID(), r.getName(), r.getType(), r.getNumberBed(), r.getPrice()
            });
        }
    }
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        list = roomDAO.getListTKRoom(txtID.getText(), txtType.getText(), txtBed.getText());
        showResult();
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(P_Khachsan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P_Khachsan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P_Khachsan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P_Khachsan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P_Khachsan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbSX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblRoom;
    private javax.swing.JTextField txtBed;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}

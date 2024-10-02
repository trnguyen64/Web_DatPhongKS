package view;

import controller.ServiceDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Service;
import java.sql.ResultSet;
import javax.swing.JFrame;

public class Dichvu extends javax.swing.JFrame {

    private ServiceDAO SvDAO = new ServiceDAO();
    private ArrayList<Service> list;
    private ArrayList<Service> listTK;
    DefaultTableModel model;
    private int selectedIndex;
    
    public Dichvu() {
        initComponents();
        this.setLocationRelativeTo(null);
        list = SvDAO.getListService();
        model = (DefaultTableModel) tblService.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "Mã Dịch Vụ", "Tên Dịch Vu", "Giá", "Ghi chú"
        });
        showTable();
    }

    public void showTable() {
        int i = 1;
        for (Service r : list) {
            model.addRow(new Object[]{
                i++, r.getID(), r.getName(), r.getPrice(), r.getNote()
            });
        }
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
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();
        btnAdd1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtTK = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
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

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 150, 10));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DỊCH VỤ");
        begin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, 50));

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 190, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mã dịch vụ:");
        begin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 80, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tên dịch vụ:");
        begin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 90, 21));

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, 40));

        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 190, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Giá:");
        begin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 30, 24));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Ghi chú:");
        begin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        txtNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 190, 40));

        tblService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Giá tiền", "Ghi chú"
            }
        ));
        jScrollPane1.setViewportView(tblService);

        begin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1020, 550));

        btnAdd1.setBackground(new java.awt.Color(112, 26, 98));
        btnAdd1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd1.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/them.png"))); // NOI18N
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        begin.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 70, 70));

        btnDelete1.setBackground(new java.awt.Color(112, 26, 98));
        btnDelete1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete1.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        begin.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 70, 70));

        btnEdit.setBackground(new java.awt.Color(112, 26, 98));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sua.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        begin.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 70, 70));

        btnUpdate.setBackground(new java.awt.Color(112, 26, 98));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/chinhsua.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        begin.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 70, 70));

        txtTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTKActionPerformed(evt);
            }
        });
        begin.add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 250, 50));

        btnSearch.setBackground(new java.awt.Color(112, 26, 98));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TK.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        begin.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 50, 50));

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
        txtNote.setText("");
        txtPrice.setText("");
        txtTK.setText("");
        list = SvDAO.getListService();
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

    public void showResult() {
        model.setRowCount(0);
        int i = 1;
        for (Service r : list) {
            model.addRow(new Object[]{
               i++, r.getID(), r.getName(), r.getPrice(), r.getNote()
            });
        }
    }
    
    public void showResultTK() {
        model.setRowCount(0);
        int i = 1;
        for (Service DV : listTK) {
            model.addRow(new Object[]{
                i++, DV.getID(), DV.getName(), DV.getPrice(), DV.getNote()});
        }
    }
    
    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        ServiceDAO SvInfomationDAO = new ServiceDAO();
        Service r = new Service();
        txtID.setText(String.valueOf(SvDAO.getServiceId()));
        r.setID(txtID.getText());
        r.setName(txtName.getText());
        r.setPrice(txtPrice.getText());
        r.setNote(txtNote.getText());
        try {
            if (txtID.getText().equals("") || txtName.getText().equals("")
                    || txtPrice.getText().equals("") || txtNote.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Hãy điền đầy đủ thông tin!");
            } else if (SvInfomationDAO.addService(r)) {
                list.add(r);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm dịch vụ thành công!");
                showResult();
                txtID.setText("");
                txtName.setText("");
                txtPrice.setText("");
                txtNote.setText("");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Lỗi ko thêm được dịch vụ!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        String id = tblService.getValueAt(tblService.getSelectedRow(), 1).toString();
        if (SvDAO.deleteService(id)) {
            int DelIndex = tblService.getSelectedRow();
            list.remove(DelIndex);
            showResult();
            JOptionPane.showMessageDialog(rootPane, "Xóa dịch vụ thành công!");        // TODO add your handling code here:
        } else {
            JOptionPane.showMessageDialog(rootPane, "Xoá dịch vụ không thành công!");        // TODO add your handling code here:
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Service serviceSelect = new Service();
        selectedIndex = tblService.getSelectedRow();
        serviceSelect = list.get(selectedIndex);
        txtID.setText(serviceSelect.getID());
        txtName.setText(serviceSelect.getName());
        txtPrice.setText(serviceSelect.getPrice());
        txtNote.setText(String.valueOf(serviceSelect.getNote()));
        showResult();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Service r = new Service();
        r.setID(txtID.getText());
        r.setName(txtName.getText());
        r.setPrice(txtPrice.getText());
        r.setNote(txtNote.getText());

        try {
            if (txtID.getText().equals("") || txtName.getText().equals("")
                    || txtPrice.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Hãy điền đầy đủ thông tin!");
            } else {
                SvDAO.editService(r, txtID.getText());
                JOptionPane.showMessageDialog(rootPane, "Cập nhập dịch vụ thành công!");
                list.clear();
                list = SvDAO.getListService();
                showResult();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTKActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtTK.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập dịch vụ cần tìm!");
        } else {
            list = SvDAO.getListServicetk(txtTK.getText());
            showResult();
        }
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
            java.util.logging.Logger.getLogger(Dichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dichvu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblService;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}

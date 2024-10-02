package view;

import controller.EmployeeDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DS_Nhanvien extends javax.swing.JFrame {

    ResultSet result;
    private int selectedIndex;
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ArrayList<Employee> list;
    private ArrayList<Employee> listTK;
    DefaultTableModel model;
    
    public DS_Nhanvien() {
        initComponents();
        this.setLocationRelativeTo(null);
        list = employeeDAO.getListNV();
        model = (DefaultTableModel) tblNV.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "ID", "Họ", "Tên", "CCCD", "Chức vụ", "Lương", "Giới tính", "Địa chỉ", "SĐT"
        });
        showTable();
    }

    public void showTable() {
        int i = 1;
        for (Employee nv : list) {
            model.addRow(new Object[]{
                i++, nv.getID(), nv.getHo(), nv.getTen(),
                nv.getCCCD(), nv.getCV(), nv.getLuong(), nv.getGT(), nv.getDC(), nv.getSDT()
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        txtTEN = new javax.swing.JTextField();
        txtHONV = new javax.swing.JTextField();
        txt2 = new javax.swing.JLabel();
        txt1 = new javax.swing.JLabel();
        txtIDNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtGT = new javax.swing.JTextField();
        txtL = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDC = new javax.swing.JTextField();
        txtCV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbSX = new javax.swing.JComboBox<>();
        btnAdd1 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        txtTK = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
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
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 420, 10));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DANH SÁCH NHÂN VIÊN");
        begin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 60));

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblNV);

        begin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1020, 410));

        txtTEN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtTEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 190, 40));

        txtHONV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtHONV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 190, 40));

        txt2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt2.setForeground(new java.awt.Color(0, 0, 0));
        txt2.setText("Họ Nhân Viên: ");
        begin.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        txt1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt1.setForeground(new java.awt.Color(0, 0, 0));
        txt1.setText("Mã Nhân Viên:");
        begin.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 97, -1));

        txtIDNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDNVActionPerformed(evt);
            }
        });
        begin.add(txtIDNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 190, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tên Nhân Viên: ");
        begin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 190, 110, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Giới tính:");
        begin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 70, -1));

        txtGT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtGT, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 190, 40));

        txtL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLActionPerformed(evt);
            }
        });
        begin.add(txtL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 190, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(" Lương:");
        begin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 60, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CCCD:");
        begin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 190, 40));

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 190, 40));

        txtDC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 190, 40));

        txtCV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCVActionPerformed(evt);
            }
        });
        begin.add(txtCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 190, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Chức Vụ:");
        begin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Địa Chỉ:");
        begin.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 51, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("SÐT:");
        begin.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("SẮP XẾP THEO:");
        begin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, 110, -1));

        cbbSX.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Từ thấp đến cao", "Từ cao đến thấp", "Chức vụ", "Lương", "Địa chỉ" }));
        cbbSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSXActionPerformed(evt);
            }
        });
        begin.add(cbbSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, 147, 40));

        btnAdd1.setBackground(new java.awt.Color(112, 26, 98));
        btnAdd1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd1.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/them.png"))); // NOI18N
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        begin.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 70, 70));

        btnEdit.setBackground(new java.awt.Color(112, 26, 98));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sua.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        begin.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 70, 70));

        btnUpdate.setBackground(new java.awt.Color(112, 26, 98));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/chinhsua.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        begin.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 70, 70));

        btnDelete1.setBackground(new java.awt.Color(112, 26, 98));
        btnDelete1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete1.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        begin.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 70, 70));

        txtTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTKActionPerformed(evt);
            }
        });
        begin.add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 250, 50));

        btnSearch.setBackground(new java.awt.Color(112, 26, 98));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TK.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        begin.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 50, 50));

        btnXuatFile.setBackground(new java.awt.Color(112, 26, 98));
        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xuatfile.png"))); // NOI18N
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });
        begin.add(btnXuatFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 70, 70));

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
        txtIDNV.setText("");
        txtHONV.setText("");
        txtTEN.setText("");
        txtCCCD.setText("");
        txtL.setText("");
        txtGT.setText("");
        txtCV.setText("");
        txtSDT.setText("");
        txtDC.setText("");
        txtTK.setText("");
        list = employeeDAO.getListNV();
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

    private void txtIDNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDNVActionPerformed

    private void txtLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLActionPerformed

    private void txtCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCVActionPerformed

    private void cbbSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSXActionPerformed
        // TODO add your handling code here:
        EmployeeDAO SXDAO = new EmployeeDAO();
        int index = cbbSX.getSelectedIndex();
        if (index == 0) {
            showResult();
        } else if (index == 1) {
            list = SXDAO.getListCBBSX1();
            showResult();
        } else if (index == 2) {
            list = SXDAO.getListCBBSX2();
            showResult();
        } else if (index == 3) {
            list = SXDAO.getListCBBSX3();
            showResult();
        } else if (index == 4) {
            list = SXDAO.getListCBBSX4();
            showResult();
        }
    }//GEN-LAST:event_cbbSXActionPerformed

    public void showResult() {
        model.setRowCount(0);
        int i = 1;
        for (Employee nv : list) {
            model.addRow(new Object[]{
                i++, nv.getID(), nv.getHo(), nv.getTen(),
                nv.getCCCD(), nv.getCV(), nv.getLuong(), nv.getGT(), nv.getDC(), nv.getSDT()
            });
        }
    }
    
    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        if (txtIDNV.getText().equals("") || txtHONV.getText().equals("")
                || txtTEN.getText().equals("") || txtCCCD.getText().equals("") || txtL.getText().equals("")
                || txtGT.getText().equals("") || txtCV.getText().equals("") || txtDC.getText().equals("")
                || txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập đầy đủ thông tin!");
        } else {
            Employee r = new Employee();
            r.setID(txtIDNV.getText());
            r.setHo(txtHONV.getText());
            r.setTen(txtTEN.getText());
            r.setCCCD(txtCCCD.getText());
            r.setLuong(Float.parseFloat(txtL.getText()));
            r.setGT(txtGT.getText());
            r.setCV(txtCV.getText());
            r.setDC(txtDC.getText());
            r.setSDT(txtSDT.getText());
            if (employeeDAO.addNV(r)) {
                JOptionPane.showMessageDialog(rootPane, "Thêm nhân viên thành công!");
                list.add(r);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm nhân viên không thành công, hãy kiểm tra lại thông tin!");
            }
            showResult();
        }
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Employee roomSelect = new Employee();
        selectedIndex = tblNV.getSelectedRow();
        roomSelect = list.get(selectedIndex);
        txtIDNV.setEditable(false);
        txtIDNV.setText(roomSelect.getID());
        txtHONV.setText(roomSelect.getHo());
        txtTEN.setText(roomSelect.getTen());
        txtCCCD.setText(roomSelect.getCCCD());
        txtL.setText(String.valueOf(roomSelect.getLuong()));
        txtGT.setText(roomSelect.getGT());
        txtCV.setText(roomSelect.getCV());
        txtSDT.setText(roomSelect.getSDT());
        txtDC.setText(roomSelect.getDC());
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Employee r = new Employee();
        txtIDNV.setEditable(false);
        r.setID(txtIDNV.getText());
        r.setHo(txtHONV.getText());
        r.setTen(txtTEN.getText());
        r.setCCCD(txtCCCD.getText());
        r.setLuong(Float.parseFloat(txtL.getText()));
        r.setGT(txtGT.getText());
        r.setCV(txtCV.getText());
        r.setDC(txtDC.getText());
        r.setSDT(txtSDT.getText());
        if (employeeDAO.editNV(r, txtIDNV.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");
            list.clear();
            list = employeeDAO.getListNV();
            showResult();
            //reset text field
            txtIDNV.setText("");
            txtIDNV.setEditable(true);
            txtHONV.setText("");
            txtTEN.setText("");
            txtCCCD.setText("");
            txtL.setText("");
            txtGT.setText("");
            txtCV.setText("");
            txtSDT.setText("");
            txtDC.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật không thành công!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        String id = tblNV.getValueAt(tblNV.getSelectedRow(), 1).toString();
        if (employeeDAO.deleteNV(id)) {
            int DelIndex = tblNV.getSelectedRow();
            list.remove(DelIndex);
            showResult();
            JOptionPane.showMessageDialog(rootPane, "Xóa nhân viên thành công!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Xóa nhân viên không thành công!");
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void txtTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTKActionPerformed

    public void showResultTK() {
        model.setRowCount(0);
        int i = 1;
        for (Employee nv : listTK) {
            model.addRow(new Object[]{
                i++, nv.getID(), nv.getHo(), nv.getTen(),
                nv.getCCCD(), nv.getCV(), nv.getLuong(), nv.getGT(), nv.getDC(), nv.getSDT()
            });
        }
    }
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtTK.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập thông tin cần tìm!");
        } else {
            listTK = employeeDAO.getListTKNV(txtTK.getText());
            showResultTK();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        //Tạo một đối tượng JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        //Tạo một bộ lọc để chỉ hiển thị các file excel
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
        fileChooser.setFileFilter(filter);
        //Hiển thị hộp thoại chọn File và lấy kết quả trả về từ người dùng
        int returnValue = fileChooser.showSaveDialog(this);
        //Kiểm tra xem người dùng đã chọn một thư mục để lưu không
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                //Lay duong dan tu nguoi dung
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                // Tạo workbook mới
                Workbook workbook = new XSSFWorkbook();
                // Tạo sheet mới
                Sheet sheet = workbook.createSheet("Danh sách nhân viên");

                // Tiêu đề các cột
                Row headerRow = sheet.createRow(0);
                String[] columns = {"STT", "ID", "Họ", "Tên", "CCCD", "Chức vụ", "Lương", "Giới tính", "Địa chỉ", "SĐT"};
                for (int i = 0; i < columns.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(columns[i]);
                }

                // Dữ liệu
                int rowNum = 1;
                for (Employee nv : list) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(rowNum - 1);
                    row.createCell(1).setCellValue(nv.getID());
                    row.createCell(2).setCellValue(nv.getHo());
                    row.createCell(3).setCellValue(nv.getTen());
                    row.createCell(4).setCellValue(nv.getCCCD());
                    row.createCell(5).setCellValue(nv.getCV());
                    row.createCell(6).setCellValue(nv.getLuong());
                    row.createCell(7).setCellValue(nv.getGT());
                    row.createCell(8).setCellValue(nv.getDC());
                    row.createCell(9).setCellValue(nv.getSDT());
                }

                // Lưu workbook vào một file
                FileOutputStream fileOut = new FileOutputStream(filePath + ".xlsx");
                workbook.write(fileOut);
                fileOut.close();

                // Đóng workbook
                workbook.close();

                // Thông báo xuất excel thành công (tùy chọn)
                JOptionPane.showMessageDialog(this, "Xuất Excel thành công!");

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Xuất Excel thất bại: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnXuatFileActionPerformed

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
            java.util.logging.Logger.getLogger(DS_Nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DS_Nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DS_Nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DS_Nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DS_Nhanvien().setVisible(true);
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
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JComboBox<String> cbbSX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblNV;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtCV;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtGT;
    private javax.swing.JTextField txtHONV;
    private javax.swing.JTextField txtIDNV;
    private javax.swing.JTextField txtL;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTEN;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}

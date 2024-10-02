package view;

import controller.CustomerDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DS_Khachhang extends javax.swing.JFrame {
    
    private CustomerDAO clientsDAO = new CustomerDAO();
    private ArrayList<Customer> list;
    DefaultTableModel model;
    private boolean Choose = false;
    private int selectedIndex;
    
    public DS_Khachhang() {
        initComponents();
        this.setLocationRelativeTo(null);
        list = clientsDAO.getListClient();
        model = (DefaultTableModel) tblClient.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "ID", "Tên", "Địa chỉ", "SĐT"
        });
        showTable();
        btnBook.setVisible(false);
    }

    public void showTable() {
        int i = 1;
        for (Customer r : list) {
            model.addRow(new Object[]{
                i++, r.getID(), r.getName(), r.getAddress(), r.getPhone()
            });
        }
    }

    private boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    public void setBookingClient() {
        txtTitle.setText("CHỌN KHÁCH HÀNG");
        btnBook.setVisible(true);
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
        txtTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtTK = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClient = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnBook = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
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
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 390, 10));

        txtTitle.setBackground(new java.awt.Color(0, 0, 0));
        txtTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(0, 0, 0));
        txtTitle.setText("Danh Sách Khách Hàng");
        begin.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mã khách hàng:");
        begin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 24));

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 190, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(" Tên khách hàng:");
        begin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 120, 40));

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 190, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Số điện thoại:");
        begin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 100, 40));

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 190, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText(" Địa chỉ:");
        begin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 60, 40));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        begin.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 190, 40));

        btnAdd.setBackground(new java.awt.Color(112, 26, 98));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/them.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        begin.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 70, 70));

        btnDelete.setBackground(new java.awt.Color(112, 26, 98));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        begin.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 70, 70));

        btnSearch.setBackground(new java.awt.Color(112, 26, 98));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TK.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        begin.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 50, 50));

        btnXuatFile.setBackground(new java.awt.Color(112, 26, 98));
        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xuatfile.png"))); // NOI18N
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });
        begin.add(btnXuatFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 70, 70));

        btnUpdate.setBackground(new java.awt.Color(112, 26, 98));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/chinhsua.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        begin.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 70, 70));

        txtTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTKActionPerformed(evt);
            }
        });
        begin.add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 250, 50));

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        tblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ"
            }
        ));
        tblClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblClient);

        begin.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 75, 700, 640));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Khách Hàng Đặt Phòng");
        begin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        btnBook.setBackground(new java.awt.Color(112, 26, 98));
        btnBook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnBook.setForeground(new java.awt.Color(255, 255, 255));
        btnBook.setText("Đặt Phòng");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });
        begin.add(btnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 120, 46));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 260, 10));

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
        txtTK.setText("");
        txtID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        model.setRowCount(0);
        showResult1();
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

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String SDT = txtPhone.getText();
        Customer r = new Customer();
        txtID.setText(String.valueOf(clientsDAO.getClientId()));
        r.setID(txtID.getText());
        r.setName(txtName.getText());
        r.setAddress(txtAddress.getText());
        r.setPhone(txtPhone.getText());
        try {
            if (txtID.getText().equals("") || txtName.getText().equals("")
                || txtAddress.getText().equals("") || txtPhone.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Hãy điền đầy đủ thông tin!");
            } else if (!isNumeric(txtPhone.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số cho số điện thoại!");
            } else if(isNumeric(txtName.getText())){
                JOptionPane.showMessageDialog(rootPane, "Phần tên không được ghi số");
            } else if(clientsDAO.checkTrungSDT(SDT)){
                JOptionPane.showMessageDialog(rootPane, "Số điện thoại đã tồn tại");
            } else if(clientsDAO.addClient(r)){
                list.add(r);
                JOptionPane.showMessageDialog(rootPane, "Thêm khách hàng thành công!");
                showResult1();
                txtID.setText("");
                txtName.setText("");
                txtAddress.setText("");
                txtPhone.setText("");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm khách hàng không thành công!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    public void showResult() {
        model.setRowCount(0);
        int i = 1;
        for (Customer r : list1) {
            model.addRow(new Object[]{
                i++, r.getID(), r.getName(), r.getAddress(), r.getPhone()
            });
        }
    }//GEN-LAST:event_btnAddActionPerformed

    public void showResult1() {
        model.setRowCount(0);
        int i = 1;
        for (Customer r : list) {
            model.addRow(new Object[]{
                i++, r.getID(), r.getName(), r.getAddress(), r.getPhone()
            });
        }
    }     
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String id = tblClient.getValueAt(tblClient.getSelectedRow(), 1).toString();
        if (clientsDAO.deleteClient(id)) {
            int DelIndex = tblClient.getSelectedRow();
            list.remove(DelIndex);
            showResult1();
            JOptionPane.showMessageDialog(rootPane, "Xóa khách hàng thành công!");        // TODO add your handling code here:
        } else {
            JOptionPane.showMessageDialog(rootPane, "Xoá khách hàng không thành công!");        // TODO add your handling code here:
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private ArrayList<Customer> list1;
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtTK.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập thông tin khách hàng cần tìm!");
        } else {
            list1 = clientsDAO.getListClienttk(txtTK.getText());
            Choose = true;
            showResult();
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        //Tạo một bộ lọc để chỉ hiển thị các file excel
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
        fileChooser.setFileFilter(filter);
        //Hiển thị hộp thoại chọn File và lấy kết quả trả về từ người dùng
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Danh sách Thông tin khách hàng đặt");

                Row title = sheet.createRow(0);
                title.setHeight((short) 400);
                Cell o = title.createCell(0, CellType.STRING);
                o.setCellValue("DANH SÁCH KHÁCH HÀNG");
                
                if(Choose = true){
                    Row headerRow = sheet.createRow(2);
                    String[] columns = {"STT", "Mã khách hàng", "Tên khách hàng", "SĐT","Địa chỉ"};
                    for (int i = 0; i < columns.length; i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(columns[i]);
                    }
                    int rowNum = 3;
                    for (Customer KH : list1) {
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(rowNum - 3);
                        row.createCell(1).setCellValue(KH.getID());
                        row.createCell(2).setCellValue(KH.getName());
                        row.createCell(3).setCellValue(KH.getPhone());
                        row.createCell(4).setCellValue(KH.getAddress());
                    }
                } else {
                    Row headerRow = sheet.createRow(2);
                    String[] columns = {"STT", "Mã khách hàng", "Tên khách hàng", "SĐT","Địa chỉ"};
                    for (int i = 0; i < columns.length; i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(columns[i]);
                    }
                    int rowNum = 3;
                    for (Customer KH : list) {
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(rowNum - 3);
                        row.createCell(1).setCellValue(KH.getID());
                        row.createCell(2).setCellValue(KH.getName());
                        row.createCell(3).setCellValue(KH.getPhone());
                        row.createCell(4).setCellValue(KH.getAddress());
                    }
                }
                // Lưu workbook vào một file
                FileOutputStream fileOut = new FileOutputStream(filePath + ".xlsx");
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
                JOptionPane.showMessageDialog(this, "Xuất Excel thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Xuất Excel thất bại: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String SDT = txtPhone.getText();
        Customer r = new Customer();
        r.setID(txtID.getText());
        r.setName(txtName.getText());
        r.setAddress(txtAddress.getText());
        r.setPhone(txtPhone.getText());

        try {
             if (txtID.getText().equals("") || txtName.getText().equals("")
                || txtAddress.getText().equals("") || txtPhone.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Hãy điền đầy đủ thông tin!");
            } else if (!isNumeric(txtPhone.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số cho số điện thoại!");
            } else if(isNumeric(txtName.getText())){
                JOptionPane.showMessageDialog(rootPane, "Phần tên không được ghi số");
            } else if(clientsDAO.checkTrungSDT(SDT)){
                JOptionPane.showMessageDialog(rootPane, "Số điện thoại đã tồn tại");
            } else {
                clientsDAO.editClient(r, txtID.getText());
                JOptionPane.showMessageDialog(rootPane, "Cập nhập thành công!");
                list.clear();
                list = clientsDAO.getListClient();
                showResult1();
                //reset text field
                txtID.setText("");
                txtName.setText("");
                txtAddress.setText("");
                txtPhone.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật khách hàng không thành công!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTKActionPerformed

    private void tblClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientMouseClicked
        // TODO add your handling code here:
        Customer clientSelect = new Customer();
        selectedIndex = tblClient.getSelectedRow();

        clientSelect = list.get(selectedIndex);
        txtID.setText(clientSelect.getID());
        txtName.setText(clientSelect.getName());
        txtAddress.setText(clientSelect.getAddress());
        txtPhone.setText(String.valueOf(clientSelect.getPhone()));
        showResult1();
    }//GEN-LAST:event_tblClientMouseClicked

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        Customer clientSelect = new Customer();
        selectedIndex = tblClient.getSelectedRow();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                "Bạn chưa chọn khách hàng cần đặt phòng!");
        } else {
            clientSelect = list.get(selectedIndex);
            Datphong dt = new Datphong();
            dt.setCustData(clientSelect);
            dt.setVisible(true);
            this.dispose();
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
            java.util.logging.Logger.getLogger(DS_Khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DS_Khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DS_Khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DS_Khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DS_Khachhang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblClient;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtTK;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}

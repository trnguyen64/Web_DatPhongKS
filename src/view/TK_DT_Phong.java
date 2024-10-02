package view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import controller.StatisticalDAO;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.StatisticalRoom;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TK_DT_Phong extends javax.swing.JFrame {

    private ArrayList<StatisticalRoom> list;
    private StatisticalDAO stDAO = new StatisticalDAO();
    private boolean Choose = false;
    DefaultTableModel model;
    
    public TK_DT_Phong() {
        initComponents();
        this.setLocationRelativeTo(null);

        list = stDAO.getListDT();
        model = (DefaultTableModel) tblTHK.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "ID", "Tên Phòng", "Loại", "Số Giường", "Giá(/Đêm)", "Ngày nhận", "Ngày trả", "Số đêm", "Thành tiền"
        });
        showTable();
        SumDT();
    }

    public void showTable() {
        int i = 1;
        for (StatisticalRoom r : list) {
            model.addRow(new Object[]{
                i++, r.getID(), r.getTen_R(), r.getLoai_R(), r.getSoGiuong_R(), r.getGia_R(),
                r.getNgayNhan(), r.getNgayTra(), r.getSoDem(), r.getThanhtien()
            });
        }
    }

    public void showTable1() {
        int i = 1;
        model.setRowCount(0);
        for (StatisticalRoom r : list1) {
            model.addRow(new Object[]{
                i++, r.getID(), r.getTen_R(), r.getLoai_R(), r.getSoGiuong_R(), r.getGia_R(),
                r.getNgayNhan(), r.getNgayTra(), r.getSoDem(), r.getThanhtien()
            });
        }
    }

    public void SumDT() {
        DecimalFormat x = new DecimalFormat("###,###,###,###,###,###,###,###,###");
        float Tong = 0;
        for (int i = 0; i < tblTHK.getRowCount(); i++) {
            Tong += Float.parseFloat((tblTHK.getValueAt(i, 9)).toString());
        }
        txtDT.setText(x.format(Tong) + " " + "VND");
        txtDT.setEditable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        begin = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        navHome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dcDateFrom = new com.toedter.calendar.JDateChooser();
        ThongKe = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dcDateTo = new com.toedter.calendar.JDateChooser();
        btnXuatFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTHK = new javax.swing.JTable();
        txtDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách sạn");

        begin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        begin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 550, 10));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("THỐNG KÊ DOANH THU PHÒNG");
        begin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 60));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-reset-32.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

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

        dcDateFrom.setDateFormatString("dd/MM/yyyy");
        dcDateFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(dcDateFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 190, 50));

        ThongKe.setBackground(new java.awt.Color(112, 26, 98));
        ThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ThongKe.setForeground(new java.awt.Color(255, 255, 255));
        ThongKe.setText("Xem Thống kê");
        ThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKeActionPerformed(evt);
            }
        });
        begin.add(ThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 147, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Từ ngày:");
        begin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Đến ngày:");
        begin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, 30));

        dcDateTo.setDateFormatString("dd/MM/yyyy");
        dcDateTo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        begin.add(dcDateTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 190, 50));

        btnXuatFile.setBackground(new java.awt.Color(112, 26, 98));
        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xuatfile.png"))); // NOI18N
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });
        begin.add(btnXuatFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 70, 70));

        tblTHK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblTHK);

        begin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1020, 510));

        txtDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDTActionPerformed(evt);
            }
        });
        begin.add(txtDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 660, 260, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tổng doanh thu:");
        begin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 660, -1, 50));

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

    private ArrayList<StatisticalRoom> list1;
    private void ThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKeActionPerformed
        StatisticalRoom sr = new StatisticalRoom();
        sr.setDateFrom(dcDateFrom.getDate());
        sr.setDateTo(dcDateTo.getDate());
        list1 = stDAO.getListDT(sr);
        Choose = true;
        showTable1();
        SumDT();
    }//GEN-LAST:event_ThongKeActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        // TODO add your handling code here:
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
                Sheet sheet = workbook.createSheet("Thống kê doanh thu phòng");

                Row title = sheet.createRow(0);
                title.setHeight((short) 400);
                Cell o = title.createCell(0, CellType.STRING);
                o.setCellValue("THỐNG KÊ DOANH THU PHÒNG");

                if(Choose == true){
                    Row headerRow = sheet.createRow(2);
                    String[] columns = {"STT", "ID", "Tên Phòng", "Loại", "Số Giường", "Giá(/Đêm)", "Ngày nhận", "Ngày trả", "Số đêm", "Thành tiền"};
                    for (int i = 0; i < columns.length; i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(columns[i]);
                    }
                    int rowNum = 3;
                    for (StatisticalRoom P : list1) {
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(rowNum - 3);
                        row.createCell(1).setCellValue(P.getID());
                        row.createCell(2).setCellValue(P.getTen_R());
                        row.createCell(3).setCellValue(P.getLoai_R());
                        row.createCell(4).setCellValue(P.getSoGiuong_R());
                        row.createCell(5).setCellValue(P.getGia_R());
                        row.createCell(6).setCellValue(P.getNgayNhan());
                        row.createCell(7).setCellValue(P.getNgayTra());
                        row.createCell(8).setCellValue(P.getSoDem());
                        row.createCell(9).setCellValue(P.getThanhtien());
                    }
                    
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue("Tổng tiền");
                    row.createCell(1).setCellFormula("SUM(OFFSET(J3,1,0,COUNT(J:J)))");
                } else {
                    Row headerRow = sheet.createRow(2);
                    String[] columns = {"STT", "ID", "Tên Phòng", "Loại", "Số Giường", "Giá(/Đêm)", "Ngày nhận", "Ngày trả", "Số đêm", "Thành tiền"};
                    for (int i = 0; i < columns.length; i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(columns[i]);
                    }
                    int rowSo = 3;
                    for (StatisticalRoom P : list) {
                        Row row = sheet.createRow(rowSo++);
                        row.createCell(0).setCellValue(rowSo - 3);
                        row.createCell(1).setCellValue(P.getID());
                        row.createCell(2).setCellValue(P.getTen_R());
                        row.createCell(3).setCellValue(P.getLoai_R());
                        row.createCell(4).setCellValue(P.getSoGiuong_R());
                        row.createCell(5).setCellValue(P.getGia_R());
                        row.createCell(6).setCellValue(P.getNgayNhan());
                        row.createCell(7).setCellValue(P.getNgayTra());
                        row.createCell(8).setCellValue(P.getSoDem());
                        row.createCell(9).setCellValue(P.getThanhtien());
                    }
                    Row row = sheet.createRow(rowSo++);
                    row.createCell(0).setCellValue("Tổng tiền");
                    row.createCell(1).setCellFormula("SUM(OFFSET(J3,1,0,COUNT(J:J)))");
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

    private void txtDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDTActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:\
        dcDateFrom.setDate(null);
        dcDateTo.setDate(null);
        model.setRowCount(0);
        showTable();
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(TK_DT_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TK_DT_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TK_DT_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TK_DT_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TK_DT_Phong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ThongKe;
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnXuatFile;
    private com.toedter.calendar.JDateChooser dcDateFrom;
    private com.toedter.calendar.JDateChooser dcDateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel navHome;
    private javax.swing.JTable tblTHK;
    private javax.swing.JTextField txtDT;
    // End of variables declaration//GEN-END:variables
}

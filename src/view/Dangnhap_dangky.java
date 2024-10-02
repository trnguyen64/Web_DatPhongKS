package view;

import controller.AccountDAO;
import javax.swing.JOptionPane;
import model.Account;

public class Dangnhap_dangky extends javax.swing.JFrame {

    private AccountDAO accountDAO = new AccountDAO();
    private String position;
    
    public Dangnhap_dangky() {
        initComponents();
        this.setLocationRelativeTo(null);
        signup.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        begin = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsernameLogin = new javax.swing.JTextField();
        txtPasswordLogin = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        signup = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();
        txtPhone = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        cbPosition = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách sạn");

        begin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        login.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 50, 10));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Sign Up");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        login.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ĐĂNG NHẬP");
        login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tài khoản:");
        login.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        txtUsernameLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsernameLogin.setMinimumSize(new java.awt.Dimension(200, 30));
        login.add(txtUsernameLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 190, 40));

        txtPasswordLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        login.add(txtPasswordLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 190, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mật khẩu:");
        login.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        btnLogin.setBackground(new java.awt.Color(112, 26, 98));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Log In");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        login.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen2.jpg"))); // NOI18N
        login.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 540));

        begin.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 380, 540));

        signup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        signup.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 50, 10));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText(" Sign In");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        signup.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 50, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ĐĂNG KÝ");
        signup.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Họ tên:");
        signup.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsername.setMinimumSize(new java.awt.Dimension(200, 30));
        signup.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 190, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tài khoản:");
        signup.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 70, -1));

        btnSignup.setBackground(new java.awt.Color(112, 26, 98));
        btnSignup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSignup.setForeground(new java.awt.Color(255, 255, 255));
        btnSignup.setText("Sign Up");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        signup.add(btnSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, 40));

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPhone.setMinimumSize(new java.awt.Dimension(200, 30));
        signup.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 190, 40));

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtName.setMinimumSize(new java.awt.Dimension(200, 30));
        signup.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 190, 40));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signup.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 190, 40));

        cbPosition.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên" }));
        signup.add(cbPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 190, 40));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mật khẩu:");
        signup.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 70, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Chức vụ:");
        signup.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 60, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("    SDT:");
        signup.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 60, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen2.jpg"))); // NOI18N
        signup.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 540));

        jLabel15.setText("jLabel15");
        signup.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        begin.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 380, 540));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/anh5.png"))); // NOI18N
        begin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 80, 580, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maunen.jpg"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(666, 504));
        jLabel1.setPreferredSize(new java.awt.Dimension(666, 504));
        begin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -10, 1060, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(begin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(begin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        login.setVisible(false);
        signup.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if (txtUsernameLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                "Username không được để trống!", "Login không thành công", JOptionPane.ERROR_MESSAGE);
        } else if (txtPasswordLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                "Password không được để trống!", "Login không thành công", JOptionPane.ERROR_MESSAGE);
        } else {
            Account accLogin = new Account();
            accLogin.setUsername(txtUsernameLogin.getText());
            accLogin.setPassword(txtPasswordLogin.getText());
            Account account = accountDAO.login(accLogin);
            if (account == null) {
                JOptionPane.showMessageDialog(null,
                    "Username hoặc password không chính xác!", "Đăng nhập không thành công", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                    "Xin chào " + account.getName(), "Đăng nhập thành công", JOptionPane.INFORMATION_MESSAGE);
                this.position = account.getPosition();
                new TrangChu().setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        login.setVisible(true);
        signup.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        // TODO add your handling code here:
        if (txtUsername.getText().equals("") || txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Hãy điền đầy đủ thông tin cần thiết!");
        } else {
            Account acc = new Account();
            acc.setUsername(txtUsername.getText());
            acc.setPassword(txtPassword.getText());
            acc.setName(txtName.getText());
            acc.setPosition(cbPosition.getSelectedItem().toString());
            acc.setPhone(txtPhone.getText());

            Account a = accountDAO.register(acc);
            if (a == null) {
                JOptionPane.showMessageDialog(null,
                    "Vui lòng xem lại thông tin!", "Đăng ký không thành công", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                    "Đăng ký thành công!, xin chào " + acc.getName(), "Đăng ký thành công", JOptionPane.INFORMATION_MESSAGE);
                this.position = a.getPosition();
                login.setVisible(true);
                signup.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnSignupActionPerformed

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
                new Dangnhap_dangky().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel begin;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JComboBox<String> cbPosition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel login;
    private javax.swing.JPanel signup;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordLogin;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernameLogin;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.ConfigreBusiness;
import Business.Customer.Customer;
import Business.Admin;
import Business.Retailer.Retailer;
import Business.UserAccount;
import Interface.Admin.MainAdminPanel;
import Interface.Customer.MainCustomerPanel;
import Interface.Retailer.MainRetailerPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author mahajan
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private Admin masterClass;

    public MainFrame() {
        initComponents();
        masterClass = ConfigreBusiness.intialize();
        resetFields();
    }

    public void resetFields() {
        usernameTF.setText("");
        passwordTF.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cards = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        usernameLbl = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        passwordLbl = new javax.swing.JLabel();
        passwordTF = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        AddUser = new javax.swing.JButton();
        logoImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        Cards.setLayout(new java.awt.CardLayout());

        usernameLbl.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        usernameLbl.setText("Username");

        passwordLbl.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        passwordLbl.setText("Password");

        loginBtn.setBackground(new java.awt.Color(0, 0, 0));
        loginBtn.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        AddUser.setText("Sign Up Here");
        AddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserActionPerformed(evt);
            }
        });

        logoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Admin/shoppers-stop.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLbl)
                            .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(231, 231, 231))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(logoImage)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(317, 317, 317))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(AddUser)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLbl)
                    .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLbl))
                .addGap(18, 18, 18)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddUser)
                .addGap(64, 64, 64))
        );

        Cards.add(jPanel1, "card2");

        getContentPane().add(Cards, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserActionPerformed
        SignUpCustomerPanel signUpCustomerPanel = new SignUpCustomerPanel(Cards, masterClass.getUserAccountDirectory());
        Cards.add("SignUpCustomerPanel", signUpCustomerPanel);
        CardLayout cl = (CardLayout) Cards.getLayout();
        cl.next(Cards);
    }//GEN-LAST:event_AddUserActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        UserAccount ua = masterClass.getUserAccountDirectory().getUserAccount(usernameTF.getText());
        if (ua != null) {
            if (ua.getPassword().equals(passwordTF.getText())) {
                String role = ua.getRole();
                switch (role) {
                    case "admin": {
                        MainAdminPanel mainAdminPanel = new MainAdminPanel(Cards, masterClass);
                        Cards.add("MainAdminPanel", mainAdminPanel);
                        CardLayout cl = (CardLayout) Cards.getLayout();
                        cl.next(Cards);
                        break;
                    }

                    case "retailer": {
                        if (ua.getUserType() instanceof Retailer) {
                            Retailer retailer = (Retailer) ua.getUserType();
                            MainRetailerPanel mainRetailerPanel = new MainRetailerPanel(Cards, retailer);
                            Cards.add("MainAdminPanel", mainRetailerPanel);
                            CardLayout cl = (CardLayout) Cards.getLayout();
                            cl.next(Cards);
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect User");
                        }
                        break;
                    }

                    case "customer": {
                        if (ua.getUserType() instanceof Customer) {
                            Customer customer = (Customer) ua.getUserType();
                            MainCustomerPanel mainCustomerPanel = new MainCustomerPanel(Cards, customer, masterClass);
                            Cards.add("MainAdminPanel", mainCustomerPanel);
                            CardLayout cl = (CardLayout) Cards.getLayout();
                            cl.next(Cards);
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect User");
                        }
                        break;

                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
        } else {
            JOptionPane.showMessageDialog(null, "User with username " + usernameTF.getText() + " not found!");
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUser;
    private javax.swing.JPanel Cards;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel logoImage;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JLabel usernameLbl;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}

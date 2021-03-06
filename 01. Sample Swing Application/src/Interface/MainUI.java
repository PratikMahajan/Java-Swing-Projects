/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BusinessLogic.PersonInfo;

/**
 *
 * @author mahajan
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    private PersonInfo personInfo;
    
    public MainUI() {
        initComponents();
        
        personInfo= new PersonInfo();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitJPanel = new javax.swing.JSplitPane();
        buttonJPanel = new javax.swing.JPanel();
        viewJPanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout buttonJPanelLayout = new javax.swing.GroupLayout(buttonJPanel);
        buttonJPanel.setLayout(buttonJPanelLayout);
        buttonJPanelLayout.setHorizontalGroup(
            buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );
        buttonJPanelLayout.setVerticalGroup(
            buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        splitJPanel.setRightComponent(buttonJPanel);

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        viewButton.setText(" View ");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewJPanelLayout = new javax.swing.GroupLayout(viewJPanel);
        viewJPanel.setLayout(viewJPanelLayout);
        viewJPanelLayout.setHorizontalGroup(
            viewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createButton)
                    .addComponent(viewButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewJPanelLayout.setVerticalGroup(
            viewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(createButton)
                .addGap(18, 18, 18)
                .addComponent(viewButton)
                .addContainerGap(357, Short.MAX_VALUE))
        );

        splitJPanel.setLeftComponent(viewJPanel);

        getContentPane().add(splitJPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        
        CreateProfile createProfile = new CreateProfile(personInfo);
        splitJPanel.setRightComponent(createProfile);
        
    }//GEN-LAST:event_createButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
        ViewProfile viewProfile = new ViewProfile(personInfo);
        splitJPanel.setRightComponent(viewProfile);
        
    }//GEN-LAST:event_viewButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonJPanel;
    private javax.swing.JButton createButton;
    private javax.swing.JSplitPane splitJPanel;
    private javax.swing.JButton viewButton;
    private javax.swing.JPanel viewJPanel;
    // End of variables declaration//GEN-END:variables
}

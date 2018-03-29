/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Customer;

import Business.Customer.Customer;
import Business.Admin;
import Business.Retailer.RetailerCatalogue;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author mahajan
 */
public class MainCustomerPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainCustomerPanel
     */
    private JPanel userProcessContainer;
    private Customer cust;
    private RetailerCatalogue retCal;

    public MainCustomerPanel(JPanel Cards, Customer customer, Admin masterClass) {
        initComponents();
        userProcessContainer = Cards;
        this.cust = customer;
        this.retCal= masterClass.getRetailerCatalogue();
        lblHeader.setText("Welcome "+customer.getCustName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBooked = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnBooking = new javax.swing.JButton();
        btnPrevOrder = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        btnBooked.setText("View Cart");
        btnBooked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookedActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update Information");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBooking.setText("Order Items");
        btnBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingActionPerformed(evt);
            }
        });

        btnPrevOrder.setText("View Previous Orders");
        btnPrevOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevOrderActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Welcome");

        btnLogout.setForeground(new java.awt.Color(255, 0, 102));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrevOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addComponent(btnBooking, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBooked, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(212, 212, 212))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBooked, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrevOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookedActionPerformed

        ViewBooked cm= new ViewBooked(userProcessContainer,cust, retCal);
        userProcessContainer.add("viewCart",cm);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnBookedActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        ViewCustInfo cm= new ViewCustInfo(userProcessContainer,cust);
        userProcessContainer.add("UpdateCustomer",cm);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingActionPerformed

        BuyProduct bp = new BuyProduct(userProcessContainer, cust, retCal);
        userProcessContainer.add("BuyProduct",bp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnBookingActionPerformed

    private void btnPrevOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevOrderActionPerformed
        
        ViewBooked cm= new ViewBooked(userProcessContainer,cust,1);
        userProcessContainer.add("viewPrevOrders",cm);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
    }//GEN-LAST:event_btnPrevOrderActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        
        userProcessContainer.remove(this);
        
        CardLayout layout= (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
        
                                          
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooked;
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPrevOrder;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblHeader;
    // End of variables declaration//GEN-END:variables
}
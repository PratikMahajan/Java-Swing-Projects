/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Customer;

import Business.Customer.Customer;
import Business.Customer.CustomerCatalogue;
import Business.OperatorCatalogue;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author mahajan
 */
public class CustomerLoggedPanel extends javax.swing.JPanel {

    private OperatorCatalogue operatorCat;
    JPanel userProcessContainer;
    private Customer cust;
    CustomerLoggedPanel(JPanel userProcessContainer, OperatorCatalogue operatorCat, Customer cust) {
        initComponents();
        lblHeader.setText("Welcome "+cust.getCustomerName());
        this.userProcessContainer=userProcessContainer;
        this.cust=cust;
        this.operatorCat=operatorCat;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        btnBooked = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnBooking = new javax.swing.JButton();

        lblHeader.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText(" ");

        btnBooked.setText("View Booked Tickets");
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

        btnBooking.setText("Book Ticket");
        btnBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(109, 109, 109))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBooked, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnBooked, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingActionPerformed
        
        BookingPanel cm= new BookingPanel(userProcessContainer,operatorCat,cust);
        userProcessContainer.add("BookingCustomer",cm);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
        
    }//GEN-LAST:event_btnBookingActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        ViewCustInfo cm= new ViewCustInfo(userProcessContainer,cust);
        userProcessContainer.add("UpdateCustomer",cm);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBookedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookedActionPerformed
        
        ViewBooked cm= new ViewBooked(userProcessContainer,operatorCat,cust);
        userProcessContainer.add("viewBooked",cm);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
        
    }//GEN-LAST:event_btnBookedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooked;
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblHeader;
    // End of variables declaration//GEN-END:variables
}

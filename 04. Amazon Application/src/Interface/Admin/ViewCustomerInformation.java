/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Admin;

import Business.Customer.CartProduct;
import Business.Customer.Customer;
import java.awt.CardLayout;
import java.util.Collections;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karanracca
 */
public class ViewCustomerInformation extends javax.swing.JPanel {

    /**
     * Creates new form ViewCustomerInformation
     */
    private JPanel cards;
    private Customer customer;
    

    ViewCustomerInformation(JPanel cards, Customer c) {
        initComponents();
        this.cards = cards;
        this.customer = c;
        headingCustomer.setText(c.getCustName());
        populateTable();
        totalSpendLbl.setText("Total Spent amount ($) "+String.valueOf(this.customer.getPrevOrders().totalPrice()));
    }
    
    private void populateTable() {
        //System.out.println("Max Product" + this.retailer.getProductCatalogue().getMostProductSold());
        DefaultTableModel dtm = (DefaultTableModel) productsTable.getModel();
        dtm.setRowCount(0);

        for (CartProduct cp : customer.getPrevOrders().getCartCat()) {
            Object row[] = new Object[3];
            row[0] = cp.getProduct().getProductName();
            row[1] = cp.getItemNo();
            row[2] = cp.getPrice();
            dtm.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headingCustomer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        sortQuantity = new javax.swing.JButton();
        sortPrice = new javax.swing.JButton();
        totalSpendLbl = new javax.swing.JLabel();

        headingCustomer.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        headingCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingCustomer.setText("Customer Name");

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(productsTable);

        backBtn.setText("< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        sortQuantity.setText("Sort by Quantity");
        sortQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortQuantityActionPerformed(evt);
            }
        });

        sortPrice.setText("Sort by Price");
        sortPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortPriceActionPerformed(evt);
            }
        });

        totalSpendLbl.setText("Total Spend ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headingCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backBtn)
                            .addComponent(sortQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sortPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(totalSpendLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(sortQuantity)
                .addGap(26, 26, 26)
                .addComponent(sortPrice)
                .addGap(26, 26, 26)
                .addComponent(totalSpendLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        cards.remove(this);
        CardLayout cLayout = (CardLayout) cards.getLayout();
        cLayout.previous(cards);
    }//GEN-LAST:event_backBtnActionPerformed

    private void sortQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortQuantityActionPerformed
        Collections.sort(customer.getPrevOrders().getCartCat() , CartProduct.ByItemNo);
        populateTable();
    }//GEN-LAST:event_sortQuantityActionPerformed

    private void sortPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortPriceActionPerformed
        Collections.sort(customer.getPrevOrders().getCartCat() , CartProduct.ByPrice);
        populateTable();
    }//GEN-LAST:event_sortPriceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel headingCustomer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton sortPrice;
    private javax.swing.JButton sortQuantity;
    private javax.swing.JLabel totalSpendLbl;
    // End of variables declaration//GEN-END:variables
}

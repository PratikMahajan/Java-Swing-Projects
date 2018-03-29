/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Operator;

import Business.Aeroplane;
import Business.AeroplaneCatalogue;
import Business.FleetCatalogue;
import Business.Flight;
import Business.Validation;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mahajan
 */
public class AddFlights extends javax.swing.JPanel {

    JPanel userProcessContainer;
    private FleetCatalogue fc;
    private AeroplaneCatalogue apc;
    
    public AddFlights(JPanel userProcessContainer, FleetCatalogue fleetCat,AeroplaneCatalogue apc) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.fc=fleetCat;
        this.apc=apc;
        displayOptions();
    }

    
    private void displayOptions()
    {
        boxSelect.removeAllItems();
        for(Aeroplane ap:apc.getAirCat())
        {
            boxSelect.addItem(ap);
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

        lblResult = new javax.swing.JLabel();
        lblFrom = new javax.swing.JLabel();
        lblTo = new javax.swing.JLabel();
        lblDist = new javax.swing.JLabel();
        lblArrival = new javax.swing.JLabel();
        lblAirplane = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtFrom = new javax.swing.JTextField();
        txtTo = new javax.swing.JTextField();
        txtDist = new javax.swing.JTextField();
        txtArrival = new javax.swing.JTextField();
        btnBack2 = new javax.swing.JButton();
        boxSelect = new javax.swing.JComboBox();
        lblDept = new javax.swing.JLabel();
        txtDept = new javax.swing.JTextField();

        lblResult.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResult.setText("Add Flight");

        lblFrom.setText("From Location");

        lblTo.setText("To Location");

        lblDist.setText("Distance");

        lblArrival.setText("Arrival Time");

        lblAirplane.setText("Airplane");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnBack2.setText("<<Back");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        boxSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSelectActionPerformed(evt);
            }
        });

        lblDept.setText("Departure Time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnBack2)
                .addGap(349, 349, 349)
                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblArrival, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAirplane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtArrival)
                    .addComponent(txtTo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDist)
                    .addComponent(txtDept)
                    .addComponent(boxSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFrom, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrom)
                    .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTo)
                    .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDist)
                    .addComponent(txtDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDept)
                    .addComponent(txtDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArrival)
                    .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAirplane)
                    .addComponent(boxSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout= (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void boxSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSelectActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       
        Validation vl=new Validation();
        String from= txtFrom.getText();
        String tod= txtTo.getText();
        boolean a1=vl.stringCheck(from, "From");
        boolean a2=vl.stringCheck(tod, "To");
        boolean a4=vl.doubleCheck(txtDist.getText(), "Distance");
        boolean a3=vl.stringCheck(txtDept.getText(), "Departure");
        boolean a5=vl.stringCheck(txtArrival.getText(), "Arrival");
        if(a1&&a2&&a3&&a4&&a5)
        {
        double dist= Double.parseDouble(txtDist.getText());
        Flight ff= new Flight(from,tod,dist);
        ff.setAeroplane((Aeroplane)boxSelect.getSelectedItem());
        ff.setDeptT(txtDept.getText());
        ff.setArrT(txtArrival.getText());
        
        fc.addAeroplane(ff);
            JOptionPane.showMessageDialog(null, "Flight Added");
            
            txtArrival.setText("");
            txtDept.setText("");
            txtDist.setText("");
            txtFrom.setText("");
            txtTo.setText("");
        }
        
        
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxSelect;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack2;
    private javax.swing.JLabel lblAirplane;
    private javax.swing.JLabel lblArrival;
    private javax.swing.JLabel lblDept;
    private javax.swing.JLabel lblDist;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTo;
    private javax.swing.JTextField txtArrival;
    private javax.swing.JTextField txtDept;
    private javax.swing.JTextField txtDist;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Customer;

import Business.Customer.Customer;
import Business.Customer.CustomerCatalogue;
import Business.Validation;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mahajan
 */
public class CreateCustomer extends javax.swing.JPanel {

    Validation vl=new Validation();
    JPanel userProcessContainer;
    CustomerCatalogue custCat;
    
    public CreateCustomer(JPanel userProcessContainer, CustomerCatalogue custCat) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.custCat=custCat;
        
    }
    
    private void addData(){
        
        if((txtName.getText().equals(""))&&(txtPassport.getText().equals(""))&&(txtDOB.getText().equals("")))
        {
            JOptionPane.showMessageDialog(null, "Enter all Fields");
        }
        else
        {
        boolean a1=vl.stringCheck(txtName.getText(), "Name");
        boolean a2=vl.stringCheck(txtPassport.getText(), "Passport");
        boolean a3=vl.dateCheckTillToday(txtDOB.getText(), "DOB");
        if(a1&&a2&&a3){
        Customer cp= new Customer();
        cp.setCustomerName(txtName.getText());
        cp.setPassportNo(txtPassport.getText());
        cp.setDob(txtDOB.getText());
        
        custCat.addCustomer(cp);
            JOptionPane.showMessageDialog(null, "Customer Added Successfully");
            
        txtName.setText("");
        txtDOB.setText("");
        txtPassport.setText("");
        
        }
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

        lblFrom = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblResult = new javax.swing.JLabel();
        lblTo = new javax.swing.JLabel();
        lblDist = new javax.swing.JLabel();
        txtPassport = new javax.swing.JTextField();
        txtDOB = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        lblFrom.setText("Name");

        lblResult.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResult.setText("New Customer");

        lblTo.setText("Date of Birth");

        lblDist.setText("Passport");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(196, 196, 196))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblDist, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFrom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDOB)
                            .addComponent(txtName)
                            .addComponent(txtPassport)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)))
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrom)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTo)
                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDist)
                    .addComponent(txtPassport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnBack))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        addData();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CustomerMain cm = (CustomerMain) component;
        cm.displayOptions();
        CardLayout layout= (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblDist;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTo;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassport;
    // End of variables declaration//GEN-END:variables
}

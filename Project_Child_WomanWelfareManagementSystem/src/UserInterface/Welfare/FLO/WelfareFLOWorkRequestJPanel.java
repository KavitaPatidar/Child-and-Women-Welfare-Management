/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Welfare.FLO;

import Business.EcoSystem;
import Business.Enterprise.WelfareEnterprise;
import Business.Organization.Organization;
import Business.Organization.WelfareFLOOrganization;
import Business.Organization.WelfareOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WelfareBLOWorkRequest;
import Business.WorkQueue.WelfareFLOWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class WelfareFLOWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WelfareFLOWorkRequestJPanel
     */
    JPanel userProcessContainer;
    EcoSystem system; 
    WelfareEnterprise enterprise;
    Organization organization;
    UserAccount account;
    public WelfareFLOWorkRequestJPanel(JPanel userProcessContainer, WelfareEnterprise enterprise, Organization organization,EcoSystem system, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system=system;
        this.organization=organization;
        this.account= account;
        lblEntName.setText(enterprise.getName());
        PopulateTable();
        PopulateAssignedTable();
    }
    public void PopulateTable(){
        DefaultTableModel model = (DefaultTableModel) tblWork.getModel();
        model.setRowCount(0);
        WelfareFLOOrganization org = (WelfareFLOOrganization) organization;
        for(WorkRequest request : org.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request.getSender();
            row[2] = request.getStatus();
            row[3] = request.getReceiver();
            row[4] = ((WelfareFLOWorkRequest) request).getPatient();
            model.addRow(row);
        }
    }
    public void PopulateAssignedTable(){
        DefaultTableModel model = (DefaultTableModel) tblAssigned.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            String result = ((WelfareBLOWorkRequest) request).getTestResult();
            row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEntName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWork = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnAssign = new javax.swing.JButton();
        btnProceed = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAssigned = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Field Level Officer Work Request");

        jLabel2.setText("Enterprise");

        lblEntName.setText("Ent Name");

        tblWork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Status", "Reciever", "Patient"
            }
        ));
        jScrollPane1.setViewportView(tblWork);

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAssign.setText("Assign To Me");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        tblAssigned.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Status", "Reciever", "Result"
            }
        ));
        jScrollPane2.setViewportView(tblAssigned);

        jLabel3.setText("Assigned Work");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblEntName))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBack)
                                        .addGap(68, 68, 68)
                                        .addComponent(btnAssign)
                                        .addGap(72, 72, 72)
                                        .addComponent(btnProceed))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblEntName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnAssign)
                    .addComponent(btnProceed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        int selectedRow = tblWork.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        WelfareFLOWorkRequest request = (WelfareFLOWorkRequest)tblWork.getValueAt(selectedRow, 0);

        ProcessFLOWorkRequestJPanel processFLOWorkRequestJPanel = new ProcessFLOWorkRequestJPanel(userProcessContainer, request,(WelfareOrganization)organization,account,enterprise);
        userProcessContainer.add("processFLOWorkRequestJPanel", processFLOWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnProceedActionPerformed

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        int selectedRow = tblWork.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        WorkRequest request = (WorkRequest)tblWork.getValueAt(selectedRow, 0);
        request.setReceiver(account);
        request.setStatus("Pending");
        PopulateTable();
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProceed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEntName;
    private javax.swing.JTable tblAssigned;
    private javax.swing.JTable tblWork;
    // End of variables declaration//GEN-END:variables
}

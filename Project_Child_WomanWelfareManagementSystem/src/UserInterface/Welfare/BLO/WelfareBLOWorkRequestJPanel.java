/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Welfare.BLO;

import Business.EcoSystem;
import Business.Enterprise.WelfareEnterprise;
import Business.Logger;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.WelfareBLOOrganization;
import Business.Organization.WelfareOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HospitalDoctorWorkRequest;
import Business.WorkQueue.SupervisorWorkRequest;
import Business.WorkQueue.WelfareBLOWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class WelfareBLOWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WelfareBLOWorkRequestJPanel
     */
    JPanel userProcessContainer;
    EcoSystem system; 
    WelfareEnterprise enterprise;
    Organization organization;
    UserAccount account;
    Network network;
    WelfareBLOWorkRequest bloRequest;
    public WelfareBLOWorkRequestJPanel(JPanel userProcessContainer, WelfareEnterprise enterprise, Organization organization,EcoSystem system, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system=system;
        this.organization=organization;
        this.account= account;
        lblEntName.setText(enterprise.getName());
        network = GetNetwork();
        PopulateTable();
        PopulateAssignTable();
    }
    private Network GetNetwork(){
        Network thisNetwork = null;
        for(Network net: system.getNetworkList()){
            for(WelfareEnterprise wel : net.getEnterpriseDirectory().getWelfareEnterpriseList()){
                if(enterprise.equals(wel)){
                    thisNetwork= net;
                }
            }
        }
        return thisNetwork;
    }
    public void PopulateTable(){
        try{
            DefaultTableModel model = (DefaultTableModel) tblwork.getModel();
            model.setRowCount(0);
            WelfareBLOOrganization org = (WelfareBLOOrganization) organization;
            for(WorkRequest request : org.getWorkQueue().getWorkRequestList()){
                bloRequest = (WelfareBLOWorkRequest) request;
                if(bloRequest.getFund() == 0.0){
                    Object[] row = new Object[5];
                    row[0] = request;
                    row[1] = request.getSender();
                    row[2] = request.getStatus();
                    row[3] = request.getReceiver();
                    row[4] = bloRequest.getTestResult()== null ? "waiting" : bloRequest.getTestResult();
                    model.addRow(row);
                }
            }
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
        }
    }
    public void PopulateAssignTable(){
        try{
            DefaultTableModel model = (DefaultTableModel) tblAssign.getModel();
            model.setRowCount(0);
            SupervisorWorkRequest supRequest = null;
            HospitalDoctorWorkRequest hosRequest = null;
            //WelfareBLOOrganization org = (WelfareBLOOrganization) organization;
            for(WorkRequest request : account.getWorkQueue().getWorkRequestList()){
                if(request instanceof SupervisorWorkRequest){
                supRequest = (SupervisorWorkRequest) request;
                Object[] row = new Object[5];
                row[0] = supRequest;
                row[1] = supRequest.getSender();
                row[2] = supRequest.getStatus();
                row[3] = supRequest.getReceiver();
                row[4] = supRequest.getResult()== null ? "waiting" : supRequest.getResult();
                model.addRow(row);
                }
                if(request instanceof HospitalDoctorWorkRequest){
                hosRequest = (HospitalDoctorWorkRequest) request;
                Object[] row = new Object[5];
                row[0] = hosRequest;
                row[1] = hosRequest.getSender();
                row[2] = hosRequest.getStatus();
                row[3] = hosRequest.getReceiver();
                row[4] = hosRequest.getResult()== null ? "waiting" : hosRequest.getResult();
                model.addRow(row);
                }
            }
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
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

        lblEntName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblwork = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtAssign = new javax.swing.JButton();
        btnProceed = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAssign = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 102, 102));

        lblEntName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblEntName.setText("Ent Name");

        tblwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Status", "Reciever", "Result"
            }
        ));
        jScrollPane1.setViewportView(tblwork);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Enterprise");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Block Level Officer Work Request");

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtAssign.setText("Assign To Me");
        txtAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAssignActionPerformed(evt);
            }
        });

        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        tblAssign.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Status", "Reciever", "Result"
            }
        ));
        jScrollPane2.setViewportView(tblAssign);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(lblEntName)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(74, 74, 74)
                        .addComponent(txtAssign)
                        .addGap(64, 64, 64)
                        .addComponent(btnProceed))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblEntName))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(txtAssign)
                    .addComponent(btnProceed))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        try{
            int selectedRow = tblwork.getSelectedRow();
            if (selectedRow < 0){
                JOptionPane.showMessageDialog(null, "Please select a row to proceed","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            WelfareBLOWorkRequest request = (WelfareBLOWorkRequest)tblwork.getValueAt(selectedRow, 0);
            if(request.getReceiver() != null && request.getReceiver().equals(account)){
                ProcessBLOWorkRequestJPanel processBLOWorkRequestJPanel = new ProcessBLOWorkRequestJPanel(userProcessContainer, (WelfareOrganization)organization,account,enterprise,network,request);
                userProcessContainer.add("processBLOWorkRequestJPanel", processBLOWorkRequestJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select a request assigned to you.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
        }
    }//GEN-LAST:event_btnProceedActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAssignActionPerformed
       try{
            int selectedRow = tblwork.getSelectedRow();
            if (selectedRow < 0){
                return;
            }
            boolean flag = true;
            WelfareBLOOrganization org = (WelfareBLOOrganization) organization;
            for(WorkRequest workRequest : org.getWorkQueue().getWorkRequestList()){
                if(workRequest.getReceiver()==account && !workRequest.getStatus().equalsIgnoreCase("completed")){
                    flag = false;
                    break;
                }
            }
            WorkRequest request = (WorkRequest)tblwork.getValueAt(selectedRow, 0);
            if(flag){
                if(!request.getStatus().equalsIgnoreCase("completed")){
                    if(!request.getStatus().equalsIgnoreCase("Pending") && request.getReceiver()== null){
                        request.setReceiver(account);
                        request.setStatus("Pending");
                        PopulateTable();
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Someone else is working on this request");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "This request is completed. Select some other request");
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "You have assigned task. Please complete before taking another");
            }
       }
       catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
        }
    }//GEN-LAST:event_txtAssignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProceed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEntName;
    private javax.swing.JTable tblAssign;
    private javax.swing.JTable tblwork;
    private javax.swing.JButton txtAssign;
    // End of variables declaration//GEN-END:variables
}

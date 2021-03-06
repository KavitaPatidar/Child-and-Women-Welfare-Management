/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Hospital.Doctor;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Logger;
import Business.Network.Network;
import Business.Organization.HospitalDoctorOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HospitalDoctorWorkRequest;
import Business.WorkQueue.LabAssistantWorkRequest;
import Business.WorkQueue.NurseWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kavit
 */
public class DoctorManageRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorManageRequestJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private HospitalEnterprise enterprise;
    private EcoSystem system;
    private Organization organization;
    Network network;
    public DoctorManageRequestJPanel(JPanel userProcessContainer, EcoSystem system, HospitalEnterprise enterprise, UserAccount account,Organization organization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=account;
        this.enterprise=enterprise;
        this.system=system;
        this.organization=organization;
        network = GetNetwork();
        populateTable();
        poupulateStatusTable();
        
    }
    private Network GetNetwork(){
        Network thisNetwork = null;
        for(Network net: system.getNetworkList()){
            for(HospitalEnterprise wel : net.getEnterpriseDirectory().getHospitalnterpriseList()){
                if(enterprise.equals(wel)){
                    thisNetwork= net;
                }
            }
        }
        return thisNetwork;
    }
    public void populateTable(){
        try{
            DefaultTableModel model = (DefaultTableModel)workRequestJTable1.getModel();
            model.setRowCount(0);
            HospitalDoctorOrganization hosDocOrg=null;
            for(HospitalEnterprise hos : network.getEnterpriseDirectory().getHospitalnterpriseList()){
                for(HospitalOrganization hosOrg : hos.getHospitalOrganizationDirectory().getHospitalOrganizationList()){
                    if(hosOrg instanceof HospitalDoctorOrganization)
                    hosDocOrg=(HospitalDoctorOrganization) hosOrg;
                }
            }
            for(WorkRequest request : hosDocOrg.getWorkQueue().getWorkRequestList()){

              Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getStatus();
                row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                Patient patient = ((HospitalDoctorWorkRequest)request).getPatient();

                row[4] = patient != null? patient : "N/A";
                model.addRow(row);   
            }
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }
    public void poupulateStatusTable()
    {
        try{
            DefaultTableModel model = (DefaultTableModel)requestRespondJPanel.getModel();

            model.setRowCount(0);
            for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){

              Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getStatus();
                row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                String result=request instanceof LabAssistantWorkRequest?((LabAssistantWorkRequest)request).getResult():((NurseWorkRequest)request).getResult();
                row[4]= result == null ? "Waiting" : result;
                model.addRow(row); 
            }
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }

    /** .
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAssignToMe = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        requestRespondJPanel = new javax.swing.JTable();
        btnProceed = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Manage Request");

        btnAssignToMe.setText("Assign to me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Status", "Receiver", "Patient"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(workRequestJTable1);

        requestRespondJPanel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Status", "Receiver", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(requestRespondJPanel);

        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(118, 118, 118)
                        .addComponent(btnAssignToMe)
                        .addGap(154, 154, 154)
                        .addComponent(btnProceed)))
                .addGap(81, 81, 81))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabel1)
                .addGap(346, 346, 346))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssignToMe)
                    .addComponent(btnBack)
                    .addComponent(btnProceed))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        try{
        int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!");
            return;
        }
        boolean flag = true;
        HospitalDoctorOrganization org=(HospitalDoctorOrganization) organization;
         for(WorkRequest workRequest : org.getWorkQueue().getWorkRequestList()){
                if(workRequest!= null && workRequest.getReceiver()==userAccount && !workRequest.getStatus().equalsIgnoreCase("completed")){
                    flag = false;
                    break;
                }
            }
        
        WorkRequest request = (WorkRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        if(flag){
                if(!request.getStatus().equalsIgnoreCase("completed")){
                    if(!request.getStatus().equalsIgnoreCase("Pending") && request.getReceiver()== null){
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateTable();
        poupulateStatusTable();
        JOptionPane.showMessageDialog(null, "Request Assigned");
        Logger.getInstance().writeLogs("RequestAssigned");
        
        }
        else{
                    JOptionPane.showMessageDialog(null, "Someone else is working on this request");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "This request is completed. Please select other request");
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "You have already assigned a task. Please complete it before taking another");
            }     
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
        }
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try{
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed
            catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }
    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        try{
            int selectedRow = workRequestJTable1.getSelectedRow();

            if (selectedRow < 0){
                JOptionPane.showMessageDialog(null, "Please select a row!!");
                return;
            }
            HospitalDoctorWorkRequest request = (HospitalDoctorWorkRequest)workRequestJTable1.getValueAt(selectedRow, 0);
            if(request.getReceiver().getEmployee().getId() == userAccount.getEmployee().getId()){
            request.setStatus("Processing");
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("RequestWorkJPanel", new RequestWorkJPanel(userProcessContainer, system, enterprise, userAccount,organization,request,network));
            layout.next(userProcessContainer);
            }
            else{
        
             JOptionPane.showMessageDialog(null, "Please assign a request to you before proceeding!");
        }
            
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }//GEN-LAST:event_btnProceedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProceed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable requestRespondJPanel;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables
}

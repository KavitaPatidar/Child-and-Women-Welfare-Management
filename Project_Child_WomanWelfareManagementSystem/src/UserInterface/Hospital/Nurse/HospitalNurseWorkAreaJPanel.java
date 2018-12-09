/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Hospital.Nurse;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Logger;
import Business.Network.Network;
import Business.Organization.HospitaNurseOrganization;
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
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kavit
 */
public class HospitalNurseWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NurseWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private HospitalEnterprise enterprise;
    private EcoSystem system;
    private Organization organization;
    Network network;
    
    public HospitalNurseWorkAreaJPanel(JPanel userProcessContainer, EcoSystem system, HospitalEnterprise enterprise,Organization organization, UserAccount account) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=account;
        this.enterprise=enterprise;
        this.system=system;
        this.organization=organization;
        network = GetNetwork();
        populateTable();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Patient Name", "Age", "Disease", "Servce Provided", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(assignJButton)
                .addGap(120, 120, 120)
                .addComponent(processJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignJButton)
                    .addComponent(processJButton))
                .addContainerGap(152, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        try{
            int selectedRow = workRequestJTable.getSelectedRow();

            if (selectedRow < 0){
                return;
            }

            WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
            request.setReceiver(userAccount);
            request.setStatus("Pending");
            populateTable();
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
        }
    }//GEN-LAST:event_assignJButtonActionPerformed

    public void populateTable(){
        try{
            DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
            model.setRowCount(0);
            HospitaNurseOrganization hosNurseOrg=null;
            for(HospitalEnterprise hos : network.getEnterpriseDirectory().getHospitalnterpriseList()){
                for(HospitalOrganization hosOrg : hos.getHospitalOrganizationDirectory().getHospitalOrganizationList()){
                    if(hosOrg instanceof HospitaNurseOrganization)
                    hosNurseOrg=(HospitaNurseOrganization) hosOrg;
                    if(hosNurseOrg!= null)
                    break;
                }
                if(hosNurseOrg!= null)
                    break;
            }
            for(WorkRequest request : hosNurseOrg.getWorkQueue().getWorkRequestList()){
              // eduTeacherOrg.getWorkQueue().remove(request);
              Object[] row = new Object[8];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                Patient patient = ((NurseWorkRequest)request).getPatient();

                row[3] = patient.getName();
                row[4] = patient.getAge();
                row[5] = patient.getProblem();
                row[6] = patient.getServiceProvided();
                String result=((NurseWorkRequest)request).getResult();
                row[7]= result == null ? "Waiting" : result;

                model.addRow(row);
            }
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
        }
    }
    
    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        try{
            int selectedRow = workRequestJTable.getSelectedRow();

            if (selectedRow < 0){
                return;
            }

            NurseWorkRequest request = (NurseWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);

            request.setStatus("Processing");

            NurseProcessWorkRequestJPanel processWorkRequestJPanel = new NurseProcessWorkRequestJPanel(userProcessContainer, request);
            userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
        }
    }//GEN-LAST:event_processJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}

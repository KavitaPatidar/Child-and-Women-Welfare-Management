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
import Business.Organization.HospitaNurseOrganization;
import Business.Organization.HospitalLabAssistantOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabAssistantWorkRequest;
import Business.WorkQueue.NurseWorkRequest;
import Business.WorkQueue.HospitalDoctorWorkRequest;
import static com.db4o.qlin.QLinSupport.p;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author kavit
 */
public class RequestWorkJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private HospitalEnterprise enterprise;
    private EcoSystem system;
    private Organization organization;
    private HospitalDoctorWorkRequest request;
    Network network;
    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestWorkJPanel(JPanel userProcessContainer, EcoSystem system, HospitalEnterprise enterprise, UserAccount account,Organization organization,HospitalDoctorWorkRequest request, Network network) {
        initComponents();
        
        this.userProcessContainer=userProcessContainer;
        this.userAccount=account;
        this.enterprise=enterprise;
        this.system=system;
        this.organization=organization;
        this.request=request;
        this.network=network;
        lblEntName.setText(enterprise.getName());
        populateFields();
        
    }
    public void populateFields(){
        try{
            txtAge.setText(String.valueOf(request.getPatient().getAge()));
            txtPatient.setText(request.getPatient().getName());
            txtProblem.setText(request.getPatient().getProblem());
            txtAge.setEnabled(false);
            txtPatient.setEnabled(false);
            txtProblem.setEnabled(false);
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

        btnAssign = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        lblEntName = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        assignToDropDown = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPatient = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtProblem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 102));

        btnAssign.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnAssign.setText("Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        lblEntName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblEntName.setText("<value>");

        enterpriseLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        assignToDropDown.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        assignToDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lab Organization", "Nurse Organization" }));
        assignToDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToDropDownActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Message");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Assign To");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Patient Name");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Patient Age");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Patient Disease");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addGap(315, 315, 315))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(backJButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAssign))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProblem, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(messageJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(assignToDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPatient, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAge, javax.swing.GroupLayout.Alignment.LEADING)))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEntName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEntName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProblem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(assignToDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(btnAssign))
                .addGap(244, 244, 244))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        try{
            String message = messageJTextField.getText();
            String assignee = (String) assignToDropDown.getSelectedItem();
            NurseWorkRequest nurseWorkRequest = new NurseWorkRequest() ;
            LabAssistantWorkRequest labWorkRequest = new LabAssistantWorkRequest() ;
            HospitalOrganization org = null;
            if(assignee!=null){
                for (HospitalOrganization organization : enterprise.getHospitalOrganizationDirectory().getHospitalOrganizationList()){
                  if(assignee.equals(HospitalOrganization.Type.Lab.getValue()))
                    {
                        if (organization instanceof HospitalLabAssistantOrganization){
                        org = organization;
                        break;
                        }
                    }
                    if(assignee.equals(HospitalOrganization.Type.Nurse.getValue()))
                    {
                        if (organization instanceof HospitaNurseOrganization){
                        org = organization;
                        break;
                        }
                    }
                }
                if (org!=null && org instanceof HospitaNurseOrganization ){
                    nurseWorkRequest.setMessage(message);
                    nurseWorkRequest.setSender(userAccount);
                    nurseWorkRequest.setStatus("Sent");
                    nurseWorkRequest.setPatient(request.getPatient());
                    org.getWorkQueue().getWorkRequestList().add(nurseWorkRequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(nurseWorkRequest);
                    Logger.getInstance().writeLogs("nurseWorkRequest Work request created");
                }
                if (org!=null && org instanceof HospitalLabAssistantOrganization ){
                    labWorkRequest.setMessage(message);
                    labWorkRequest.setSender(userAccount);
                    labWorkRequest.setStatus("Sent");
                    labWorkRequest.setPatient(request.getPatient());
                    org.getWorkQueue().getWorkRequestList().add(labWorkRequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(labWorkRequest);
                    Logger.getInstance().writeLogs("labWorkRequest Work request created");
                }
                request.setResolveDate(new Date());
                request.setStatus("Completed");
                request.setResult("Assigned to "+assignee);
            }
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        try{
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorAssignedWorkJPanel manageReq = (DoctorAssignedWorkJPanel) component;
        manageReq.populateTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    
    }//GEN-LAST:event_backJButtonActionPerformed
            catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }
    private void assignToDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignToDropDownActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox assignToDropDown;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnAssign;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblEntName;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtPatient;
    private javax.swing.JTextField txtProblem;
    // End of variables declaration//GEN-END:variables
}
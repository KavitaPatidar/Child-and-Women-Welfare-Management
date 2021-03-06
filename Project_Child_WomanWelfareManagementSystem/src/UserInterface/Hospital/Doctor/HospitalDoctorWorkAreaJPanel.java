/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Hospital.Doctor;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Logger;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author kavit
 */
public class HospitalDoctorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HospitalDoctorWorkAreaJPanel
     */
     private JPanel userProcessContainer;
    private UserAccount userAccount;
    private HospitalEnterprise enterprise;
    private EcoSystem system;
    private Organization organization;
    public HospitalDoctorWorkAreaJPanel(JPanel userProcessContainer, EcoSystem system, HospitalEnterprise enterprise,Organization organization, UserAccount account) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=account;
        this.enterprise=enterprise;
        this.system=system;
        this.organization=organization;
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
        btnManageRequest = new javax.swing.JButton();
        btnAssignedWork = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Doctor's Work Area");

        btnManageRequest.setText("Manage Request");
        btnManageRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageRequestActionPerformed(evt);
            }
        });

        btnAssignedWork.setText("Assigned Work");
        btnAssignedWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignedWorkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(btnManageRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAssignedWork, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(228, 228, 228))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnManageRequest)
                .addGap(18, 18, 18)
                .addComponent(btnAssignedWork)
                .addGap(166, 166, 166))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageRequestActionPerformed
        try{
        DoctorManageRequestJPanel manageReq = new DoctorManageRequestJPanel(userProcessContainer, system, enterprise, userAccount,organization);
        userProcessContainer.add("manageReq", manageReq);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageRequestActionPerformed
            catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }
    private void btnAssignedWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignedWorkActionPerformed
        try{
        DoctorAssignedWorkJPanel manageReq = new DoctorAssignedWorkJPanel(userProcessContainer, system, enterprise, userAccount,organization);
        userProcessContainer.add("manageReq", manageReq);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAssignedWorkActionPerformed
            catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignedWork;
    private javax.swing.JButton btnManageRequest;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Welfare.FLO;

import Business.EcoSystem;
import Business.Enterprise.WelfareEnterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Welfare.DLO.WelfareDLOWorkRequestJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class WelfareFLOWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WelfareFLOWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem system; 
    WelfareEnterprise enterprise;
    Organization organization;
    UserAccount account;
    public WelfareFLOWorkAreaJPanel(JPanel userProcessContainer,EcoSystem system, WelfareEnterprise enterprise, Organization organization,UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system=system;
        this.organization=organization;
        this.account=account;
        lblEntName.setText(enterprise.getName());
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
        btnRequest = new javax.swing.JButton();
        btnChild = new javax.swing.JButton();
        btnWomen = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();

        jLabel1.setText("Field Level Officer Work Area");

        jLabel2.setText("Enterprise");

        lblEntName.setText("Ent Name");

        btnRequest.setText("Manage Request");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        btnChild.setText("Attend Children");
        btnChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChildActionPerformed(evt);
            }
        });

        btnWomen.setText("Attend Women");
        btnWomen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWomenActionPerformed(evt);
            }
        });

        btnReport.setText("Provide Report");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblEntName))
                    .addComponent(btnRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWomen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(250, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChild)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnWomen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReport)
                .addContainerGap(119, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        WelfareFLOWorkRequestJPanel welfareFLOWorkRequestJPanel=new WelfareFLOWorkRequestJPanel(userProcessContainer, enterprise,organization, system, account);
        userProcessContainer.add("welfareFLOWorkRequestJPanel",welfareFLOWorkRequestJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChildActionPerformed
        WelfareFLOChildJPanel welfareFLOChildJPanel=new WelfareFLOChildJPanel(userProcessContainer, enterprise,organization, system, account);
        userProcessContainer.add("welfareFLOChildJPanel",welfareFLOChildJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnChildActionPerformed

    private void btnWomenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWomenActionPerformed
        WelfareFLOWomenJPanel welfareFLOWomenJPanel=new WelfareFLOWomenJPanel(userProcessContainer, enterprise,organization, system, account);
        userProcessContainer.add("welfareFLOWomenJPanel",welfareFLOWomenJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnWomenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChild;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnWomen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblEntName;
    // End of variables declaration//GEN-END:variables
}

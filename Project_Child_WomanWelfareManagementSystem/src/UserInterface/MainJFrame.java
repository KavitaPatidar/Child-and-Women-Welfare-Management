/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.EducationEnterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.WelfareEnterprise;
import Business.Logger;
import Business.Network.Network;
import Business.Organization.EducationOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.WelfareOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public MainJFrame() {
        initComponents();
        system = dB4OUtil.retrieveSystem();
        this.setSize(1680, 1050);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 447));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("UserName");

        txtUserName.setBackground(new java.awt.Color(51, 51, 51));
        txtUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUserName.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("Password");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(51, 51, 51));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUserName)
            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(106, 106, 106))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnLogin)
                .addGap(26, 26, 26)
                .addComponent(btnLogout)
                .addGap(89, 89, 89))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        container.setBackground(new java.awt.Color(255, 102, 102));
        container.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Get user name
        String userName = txtUserName.getText();
        // Get Password
        char[] passwordCharArray = txtPassword.getPassword();
        String password = String.valueOf(passwordCharArray);
        
        //Step1: Check in the system admin user account directory if you have the user
        UserAccount userAccount= null;
        WelfareEnterprise welfareEnterprise=null;
        EducationEnterprise educationEnterprise=null;
        HospitalEnterprise hospitalEnterprise=null;
        Organization inOrganization=null;
        boolean flag = false;
        try{
        if(userName.equals("sysAdmin") && password.equals("sysAdmin"))
        {
            for(Network net: system.getNetworkList())
            {
                for(WelfareEnterprise wel : net.getEnterpriseDirectory().getWelfareEnterpriseList()){
                    for(WelfareOrganization org :wel.getWelfareOrganizationDirectory().getWelfareOrganizationList()){
                        userAccount= org.getUserAccountDirectory().authenticateUser(userName, password);
                        if(userAccount!= null)
                            flag = true;
                        if(flag)
                            break;
                    }
                    if(flag)
                            break;
                }
                if(flag)
                            break;
            }
        }
        if(userAccount != null){
            CardLayout layout=(CardLayout)container.getLayout();
            container.add("workArea",userAccount.getRole().createWorkArea(container, userAccount, inOrganization, system));
            layout.next(container);
        }
        else if(userAccount == null){
            for(Network net : system.getNetworkList()){
                if(!net.getName().equals("System Administrator")){
                    if(!flag){
                        for(WelfareEnterprise wel : net.getEnterpriseDirectory().getWelfareEnterpriseList()){
                            for(WelfareOrganization org :wel.getWelfareOrganizationDirectory().getWelfareOrganizationList()){
                                userAccount= org.getUserAccountDirectory().authenticateUser(userName, password);
                                if(userAccount!= null){
                                        flag = true;
                                        welfareEnterprise = wel;
                                        inOrganization = org;
                                }
                                if(flag)
                                    break;
                            }
                            if(flag)
                                break;
                        }
                        if(flag){
                            CardLayout layout=(CardLayout)container.getLayout();
                                container.add("workArea",userAccount.getRole().createWelfareWorkArea(container, userAccount, inOrganization,welfareEnterprise, system));
                            layout.next(container);
                            break;
                        }
                    }
                    if(!flag){
                        for(EducationEnterprise ed : net.getEnterpriseDirectory().getEducationnterpriseList()){
                            for(EducationOrganization org :ed.getEducationOrganizationDirectory().getEducationOrganizationList()){
                            userAccount= org.getUserAccountDirectory().authenticateUser(userName, password);
                            if(userAccount!= null){
                                flag = true;
                                educationEnterprise = ed;
                                inOrganization= org;
                            }
                            if(flag)
                                break;
                            }
                            if(flag)
                                break;
                        }
                        if(flag){
                            CardLayout layout=(CardLayout)container.getLayout();
                            container.add("workArea",userAccount.getRole().createEducationWorkArea(container, userAccount, inOrganization,educationEnterprise, system));
                            layout.next(container);
                            break;
                        }
                }
                if(!flag){
                    for(HospitalEnterprise hos : net.getEnterpriseDirectory().getHospitalnterpriseList()){
                        for(HospitalOrganization org :hos.getHospitalOrganizationDirectory().getHospitalOrganizationList()){
                        userAccount= org.getUserAccountDirectory().authenticateUser(userName, password);
                        if(userAccount!= null){
                            flag = true;
                            hospitalEnterprise = hos;
                            inOrganization= org;
                        }
                        if(flag)
                            break;
                        }
                        if(flag)
                                break;
                    }
                    if(flag){
                        CardLayout layout=(CardLayout)container.getLayout();
                        container.add("workArea",userAccount.getRole().createHospitalWorkArea(container, userAccount, inOrganization,hospitalEnterprise, system));
                        layout.next(container);
                        break;
                    }
                }
            }  
        }  
            
    }//GEN-LAST:event_btnLoginActionPerformed
        else{
            JOptionPane.showMessageDialog(null, "Invalid Credentials","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!flag){
            JOptionPane.showMessageDialog(null, "Invalid Credentials","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        btnLogin.setEnabled(false);
        btnLogout.setEnabled(true);
        txtUserName.setEnabled(false);
        txtPassword.setEnabled(false);
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
        }
    }
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        btnLogout.setEnabled(false);
        txtUserName.setEnabled(true);
        txtPassword.setEnabled(true);
        btnLogin.setEnabled(true);

        txtUserName.setText("");
        txtPassword.setText("");

        container.removeAll();
        JPanel blankJP = new JPanel();
        container.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_btnLogoutActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}

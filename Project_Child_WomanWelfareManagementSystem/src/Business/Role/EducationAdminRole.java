/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.EducationEnterprise;
import Business.Logger;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Education.Administrator.EducationAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class EducationAdminRole extends EducationRole{
    @Override
    public JPanel createEducationWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,EducationEnterprise enterprise, EcoSystem system) {
        Logger.getInstance().writeLogs(account.getEmployee().getName()+ " Logs in");
        return new EducationAdminWorkAreaJPanel(userProcessContainer, system,enterprise);
    }
}

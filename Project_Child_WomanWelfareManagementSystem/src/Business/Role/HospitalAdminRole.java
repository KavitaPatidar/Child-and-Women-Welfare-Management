/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Hospital.Administrator.HospitalAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class HospitalAdminRole extends HospitalRole{
    @Override
    public JPanel createHospitalWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,HospitalEnterprise enterprise, EcoSystem system) {
        return new HospitalAdminWorkAreaJPanel(userProcessContainer, system);
    }
}

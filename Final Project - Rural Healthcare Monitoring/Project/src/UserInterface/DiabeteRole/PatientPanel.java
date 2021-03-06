/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DiabeteRole;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.Organization.Hospital.DiabeteOrganization;
import Business.Organization.Hospital.Organization;
import Business.Organization.Hospital.PatientOrganization;
import Business.Patient.Patient;
import Business.Person.Person;
import UserInterface.DoctorRole.GraphRepresentation;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class PatientPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private DiabeteOrganization diabeteOrganization;
    private PatientOrganization patientOrganization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    
    /**
     * Creates new form PatientPanel
     */
    public PatientPanel(JPanel userProcessContainer, UserAccount userAccount, DiabeteOrganization diabeteOrganization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.diabeteOrganization = diabeteOrganization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())   {
            if(org instanceof PatientOrganization)
                patientOrganization = (PatientOrganization)org;
            break;
                
        }
        
        docLabel.setText("Doctor Name: " + userAccount.getUsername());
        valueLabel.setText("Hospital Name: " + enterprise.getName());  
         
        
        populatePatientCombo();
    }
    
    public void populatePatientCombo()  {
        patientComboBox.removeAllItems();
        
        for(Organization organizaton : enterprise.getOrganizationDirectory().getOrganizationList())  {
            if(organizaton instanceof PatientOrganization)  {
                for(Person person : organizaton.getPersonDirectory().getPersonList())   {
                    patientComboBox.addItem((Patient)person);
                }
            }
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

        enterpriseLabel = new javax.swing.JLabel();
        patientComboBox = new javax.swing.JComboBox();
        goBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        docLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        patientLabel = new javax.swing.JLabel();

        enterpriseLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        enterpriseLabel.setText("Select Patient:");

        patientComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        patientComboBox.setToolTipText("Patient List");
        patientComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientComboBoxActionPerformed(evt);
            }
        });

        goBtn.setText("Go >>");
        goBtn.setToolTipText("Add Patient in Queue");
        goBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBtnActionPerformed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon("/Users/hpanjwani/Documents/NEU/1st Sem/5100 AED Lab/panjwani_hari_001664735/Project/images/back.png")); // NOI18N
        backBtn.setToolTipText("Go to Previous Page");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("PATIENT PANEL FOR APPOINTMENT");

        docLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        docLabel.setText("<doctorName>");

        valueLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        valueLabel.setText("<value>");

        patientLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(431, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterpriseLabel)
                        .addGap(18, 18, 18)
                        .addComponent(patientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(goBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(docLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                        .addComponent(valueLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(426, 426, 426))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(docLabel)
                .addGap(29, 29, 29)
                .addComponent(valueLabel)
                .addGap(27, 27, 27)
                .addComponent(patientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(goBtn))))
                .addGap(18, 18, 18)
                .addComponent(backBtn)
                .addContainerGap(211, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void patientComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientComboBoxActionPerformed
        // TODO add your handling code here:
        Patient patient = (Patient) patientComboBox.getSelectedItem();
        if(patient != null)
        patientLabel.setText("Patient Name: " + patient.getName());
    }//GEN-LAST:event_patientComboBoxActionPerformed

    private void goBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBtnActionPerformed
        // TODO add your handling code here:
        Patient patient = (Patient) patientComboBox.getSelectedItem();
        
        if(patient != null) {
            GraphRepresentation graphRepresentation = new GraphRepresentation(userProcessContainer, userAccount, enterprise, patient);
            userProcessContainer.add("GraphRepresentation", graphRepresentation);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(this, "Please selec a patient!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_goBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel docLabel;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton goBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox patientComboBox;
    private javax.swing.JLabel patientLabel;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HospitalAdminRole;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Organization.Hospital.Organization;
import Business.Organization.Hospital.PatientOrganization;
import Business.Organization.Hospital.ReceptionistOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.UserPriviligeWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author hpanjwani
 */
public class GrantPriviligesPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Business business;
    private UserAccount userAccount;
    private ReceptionistOrganization receptionistOrganization;
    private PatientOrganization patientOrganization;

    /**
     * Creates new form GrantPriviligesPanel
     */
    public GrantPriviligesPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;

        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof ReceptionistOrganization) {
                receptionistOrganization = (ReceptionistOrganization) org;
            }
            else if(org instanceof PatientOrganization)
                patientOrganization = (PatientOrganization)org;
        }

        populatePatientTable();
    }

    public void populatePatientTable() {

        DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
        model.setRowCount(0);

        for (WorkRequest request : patientOrganization.getWorkQueue().getWorkRequestList()) {
            
            Object[] row = new Object[7];
            row[0] = request;
            row[1] = request.getSender();
            row[2] = request.getReceiver();
            row[3] = ((UserPriviligeWorkRequest) request).getPatient();
            row[4] = request.getRequestDate();
            row[5] = request.getResolveDate();
            row[6] = request.getStatus();
//            row[2] = request.getSender().getEmployee().getName();
//            row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
//            row[4] = request.getStatus();
//            row[5] = request.getRequestDate();

            model.addRow(row);
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

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        assignBtn = new javax.swing.JButton();
        requestBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        rejectBtn = new javax.swing.JButton();

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel6.setText("GRANT USER PRIVILIGES");

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Receptionist Name", "Hospital Admin Name", "Patient Name", "Request Date", "Resolve Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                patientTableMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patientTable);

        assignBtn.setText("Assign Me");
        assignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBtnActionPerformed(evt);
            }
        });

        requestBtn.setText("Process Application >>");
        requestBtn.setEnabled(false);
        requestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestBtnActionPerformed(evt);
            }
        });

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        rejectBtn.setText("REJECT");
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(requestBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rejectBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(assignBtn)))
                        .addGap(227, 227, 227))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(455, 455, 455))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rejectBtn)
                    .addComponent(assignBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(requestBtn))
                .addContainerGap(277, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBtnActionPerformed
        // TODO add your handling code here:

        int selectedRow = patientTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;

        } else {

            //patientTable.setRowSelectionAllowed(false);
            WorkRequest request = (WorkRequest) patientTable.getValueAt(selectedRow, 0);
            request.setReceiver(userAccount);
            request.setStatus("Processing");
            populatePatientTable();

            assignBtn.setEnabled(false);
            requestBtn.setEnabled(true); 
        }
    }//GEN-LAST:event_assignBtnActionPerformed

    private void requestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestBtnActionPerformed
        // TODO add your handling code here:

        int selectedRow = patientTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else    {
            
            UserPriviligeWorkRequest request = (UserPriviligeWorkRequest) patientTable.getValueAt(selectedRow, 0);
            request.setReceiver(userAccount);
            //request.setStatus("Processing");

            CreatePatientUserAccount createPatientUserAccount = new CreatePatientUserAccount(userProcessContainer, enterprise, request, business);
            userProcessContainer.add("CreatePatientUserAccount", createPatientUserAccount);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_requestBtnActionPerformed

    private void patientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_patientTableMouseClicked

    private void patientTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientTableMousePressed
        // TODO add your handling code here:
        int selectedRow = patientTable.getSelectedRow();

        TableCellRenderer renderer = patientTable.getCellRenderer(selectedRow, 6);
        Component component = patientTable.prepareRenderer(renderer, selectedRow, 6);
        Object value = (String) patientTable.getModel().getValueAt(selectedRow, 6);

        if (value.toString().equals("Processing")) {
            
            UserAccount account = (UserAccount)patientTable.getModel().getValueAt(selectedRow, 2);
            
            //Include if the user itself has assigned him that patient
            if(userAccount.equals(account))   {
                assignBtn.setEnabled(false);
                requestBtn.setEnabled(true);
                rejectBtn.setEnabled(true);
            }
            else    {
                JOptionPane.showMessageDialog(this, "The patient is already being processed by " + account, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                assignBtn.setEnabled(false);
                requestBtn.setEnabled(false);
                rejectBtn.setEnabled(false);
            }
        } else if (value.toString().equals("Access Grant")) {
            JOptionPane.showMessageDialog(this, "The patient is already being granted access!!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            assignBtn.setEnabled(false);
            requestBtn.setEnabled(false);
            rejectBtn.setEnabled(false);
        } else  {
            assignBtn.setEnabled(true);
            requestBtn.setEnabled(false);
            rejectBtn.setEnabled(true);
        }

    }//GEN-LAST:event_patientTableMousePressed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = patientTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else    {
            
            UserPriviligeWorkRequest request = (UserPriviligeWorkRequest) patientTable.getValueAt(selectedRow, 0);
            Patient patient = ((UserPriviligeWorkRequest)request).getPatient();
            
            patientOrganization.getWorkQueue().getWorkRequestList().remove(request);
            patientOrganization.getPersonDirectory().getPersonList().remove(patient);
            JOptionPane.showMessageDialog(this, patient + " has been denied access!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            populatePatientTable();
        }
    }//GEN-LAST:event_rejectBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientTable;
    private javax.swing.JButton rejectBtn;
    private javax.swing.JButton requestBtn;
    // End of variables declaration//GEN-END:variables

}

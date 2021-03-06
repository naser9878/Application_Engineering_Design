package UserInterface.DiabeteRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Hospital.DiabeteOrganization;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hpanjwani
 */
public class AppointmentRequestPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private DiabeteOrganization diabeteOrganization;

    /**
     * Creates new form RequestPanel
     */
    public AppointmentRequestPanel(JPanel userProcessContainer, UserAccount userAccount, DiabeteOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.diabeteOrganization = organization;

        docLabel.setText("Doctor Name: " + userAccount.getUsername());
        valueLabel.setText("Hospital Name: "  + enterprise.getName());        

        populateRequestTable();
    }

    public void populateRequestTable() {

        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();
        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if ((request.getStatus().equals("Referred")) || (request.getStatus().equals("Request Received"))
                    || (request.getStatus().equals("Appointment Booked")) || (request.getStatus().equals("Appointment Cancel"))) {
            Object[] row = new Object[7];
            //request.setStatus("RequestAmbulance");
            //request.setMessage("")
            row[0] = request;
            row[1] = request.getSender();
            row[2] = request.getReceiver();
            row[3] = ((UserPriviligeWorkRequest) request).getPatient();
            row[4] = request.getRequestDate();
            row[5] = request.getStatus();
            row[6] = ((UserPriviligeWorkRequest) request).getTestResult();

            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        assignBtn1 = new javax.swing.JButton();
        requestBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        patientLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        docLabel = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("PATIENT REQUEST PANEL");

        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Reffered Doctor Name", "Doctor Name", "Patient Name", "Request Date", "Status", "Appointment Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        requestTable.setToolTipText("Reffred Patient Table");
        requestTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                requestTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(requestTable);

        backBtn.setIcon(new javax.swing.ImageIcon("/Users/hpanjwani/Documents/NEU/1st Sem/5100 AED Lab/panjwani_hari_001664735/Project/images/back.png")); // NOI18N
        backBtn.setToolTipText("Go to Previous Page");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        assignBtn1.setText("Review Patient");
        assignBtn1.setToolTipText("Review Medical History");
        assignBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBtn1ActionPerformed(evt);
            }
        });

        requestBtn.setText("Reschedule an Appointment");
        requestBtn.setToolTipText("Reschedule an Appointment");
        requestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel Appointment");
        cancelBtn.setToolTipText("Cancel Appointment");
        cancelBtn.setEnabled(false);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        patientLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        valueLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        valueLabel.setText("<value>");

        docLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        docLabel.setText("<doctorName>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(assignBtn1)
                                    .addComponent(backBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cancelBtn)
                                    .addComponent(requestBtn)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(306, 306, 306)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(patientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(docLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(411, 411, 411)
                                    .addComponent(jLabel1))))
                        .addGap(284, 284, 284)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(docLabel)
                .addGap(25, 25, 25)
                .addComponent(valueLabel)
                .addGap(27, 27, 27)
                .addComponent(patientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(assignBtn1)
                        .addGap(18, 18, 18)
                        .addComponent(backBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(requestBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestTableMousePressed
        // TODO add your handling code here:
        int selectedRow = requestTable.getSelectedRow();

        TableCellRenderer renderer = requestTable.getCellRenderer(selectedRow, 5);
        Component component = requestTable.prepareRenderer(renderer, selectedRow, 5);
        Object value = (String) requestTable.getModel().getValueAt(selectedRow, 5);
        
        Object req = (WorkRequest)requestTable.getModel().getValueAt(selectedRow, 0);
        Patient patient = ((UserPriviligeWorkRequest) req).getPatient();
        
        patientLabel.setText("Patient Name: " + patient.getName());
        
        if (value.toString().equals("Referred")) {
            requestBtn.setEnabled(false);
            assignBtn1.setEnabled(true);
        } else if (value.toString().equals("Request Received")) {
            requestBtn.setEnabled(true);
            assignBtn1.setEnabled(false);
        } else if(value.toString().equals("Appointment Booked")){
            requestBtn.setEnabled(false);
            assignBtn1.setEnabled(false);
            cancelBtn.setEnabled(true);
            
            JOptionPane.showMessageDialog(this, "Appointment is already booked!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        } else if(value.toString().equals("Appointment Cancel")){
            requestBtn.setEnabled(true);
            assignBtn1.setEnabled(true);
        }
        else    {
            requestBtn.setEnabled(false);
            assignBtn1.setEnabled(false);
        }
    }//GEN-LAST:event_requestTableMousePressed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void assignBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBtn1ActionPerformed

        int selectedRow = requestTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            WorkRequest request = (WorkRequest) requestTable.getValueAt(selectedRow, 0);
            request.setReceiver(userAccount);            
            request.setStatus("Request Received");
            
             populateRequestTable();
            
            Patient patient = ((UserPriviligeWorkRequest) request).getPatient();
            
            MedicalHistory medicalHistory = new MedicalHistory(userProcessContainer, userAccount, enterprise, patient);
            userProcessContainer.add("MedicalHistory", medicalHistory);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_assignBtn1ActionPerformed

    private void requestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestBtnActionPerformed

        int selectedRow = requestTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            UserPriviligeWorkRequest request = (UserPriviligeWorkRequest) requestTable.getValueAt(selectedRow, 0);
            //request.setStatus("Attended");

            AppointmentDetailPanel appointmentDetailPanel = new AppointmentDetailPanel(userProcessContainer, userAccount, enterprise, request);
            userProcessContainer.add("AppointmentDetailPanel", appointmentDetailPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_requestBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            UserPriviligeWorkRequest request = (UserPriviligeWorkRequest) requestTable.getValueAt(selectedRow, 0);
            request.setStatus("Appointment Cancel");
            
            populateRequestTable();
            JOptionPane.showMessageDialog(this, "Appointment has been cancelled and user has been notified!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cancelBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignBtn1;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel docLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel patientLabel;
    private javax.swing.JButton requestBtn;
    private javax.swing.JTable requestTable;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}

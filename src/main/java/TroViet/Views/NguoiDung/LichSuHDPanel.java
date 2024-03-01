/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TroViet.Views.NguoiDung;

import TroViet.DAO.SessionDAO;
import TroViet.Model.SessionEntity;
import TroViet.Utils.SessionManager;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS
 */
public class LichSuHDPanel extends javax.swing.JPanel {

    /**
     * Creates new form LichSuHDPanel
     */
    DefaultTableModel tblModel;
    SessionDAO sessionDAO = new SessionDAO();
    public LichSuHDPanel() throws SQLException {
        initComponents();
        initTable();
        fillTableSession();
    }
    
    public void initTable() {
        tblModel = (DefaultTableModel) tblLichSuHD.getModel();
        String[] columns = {"ID", "ID người dùng", "Thời gian đăng nhập", "Thời gian đăng xuất", "Nội dung"};
        tblModel.setColumnIdentifiers(columns);
    }
    
    public void fillTableSession() throws SQLException {
        tblModel.setRowCount(0);
        Long idUser = SessionManager.getSession().getUser().getId();
        for (SessionEntity session : sessionDAO.getSessionUser(idUser)) {
            Vector vec = new Vector();
            vec.add(session.getId());
            vec.add(session.getIdUser());
            vec.add(session.getStartTime());
            vec.add(session.getEndTime());
            vec.add(session.getMessage());
            tblModel.addRow(vec);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLichSuHD = new javax.swing.JTable();

        setBackground(new java.awt.Color(40, 46, 62));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 205, 31));
        jLabel1.setText("LỊCH SỬ HOẠT ĐỘNG");

        tblLichSuHD.setBackground(new java.awt.Color(207, 243, 243));
        tblLichSuHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblLichSuHD.setForeground(new java.awt.Color(40, 46, 62));
        tblLichSuHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLichSuHD.setSelectionBackground(new java.awt.Color(46, 56, 86));
        tblLichSuHD.setSelectionForeground(new java.awt.Color(255, 205, 31));
        jScrollPane1.setViewportView(tblLichSuHD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(420, 420, 420))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLichSuHD;
    // End of variables declaration//GEN-END:variables
}

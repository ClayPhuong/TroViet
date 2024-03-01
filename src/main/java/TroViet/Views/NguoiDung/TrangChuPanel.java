/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TroViet.Views.NguoiDung;

import static TroViet.Connect.SQL_Connection.con;
import TroViet.DAO.PhongTroDAO;
import TroViet.DAO.SessionDAO;
import TroViet.Model.SessionEntity;
import TroViet.Model.UserEntity;
import TroViet.Utils.SessionManager;
import static TroViet.Utils.SessionManager.setSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS
 */
public class TrangChuPanel extends javax.swing.JPanel {

    /**
     * Creates new form TrangChuPanel
     */
    
    UserEntity user = SessionManager.getSession().getUser();
    DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    UserEntity userSS = SessionManager.getSession().getUser();
    static SessionDAO sessionDao = new SessionDAO();
    public static String IdPhong;
    
    
    public TrangChuPanel() throws SQLException {
        initComponents();
        initTable();
        fillToPhongTrong();
        hienThi();
    }
    
    public String returnIdPhong() {
        return txtIDPhong.getText();
    }
    
    public void initTable() {
        tblModel = (DefaultTableModel) tblPhongTrong.getModel();
        String[] columns = {"ID Phòng", "Tên phòng", "Diện tích", "Giá phòng", "Địa chỉ", "Mô tả", "Đánh giá", "Nội dung"};
        tblModel.setColumnIdentifiers(columns);
    }
    
    public void fillToPhongTrong() throws SQLException {
        tblModel.setRowCount(0);
        String query = "select pt.Id, pt.TenPhong, pt.DienTich, pt.GiaPhong, pt.DiaChi, pt.MoTa, dg.DanhGia, dg.NoiDung\n" +
                            "from PhongTro pt join DanhGia dg on pt.Id = dg.IdMaPhongTro\n" +
                            "where pt.Status=0;";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(rs.getString(1));
            vec.add(rs.getString(2));
            vec.add(rs.getDouble(3)+"");
            vec.add(rs.getDouble(4)+"");
            vec.add(rs.getString(5));
            vec.add(rs.getString(6));
            vec.add(rs.getInt(7)+"");
            vec.add(rs.getString(8));
            tblModel.addRow(vec);
             int danhGia = Integer.parseInt(rs.getString(7));
        String stars = "*".repeat(danhGia);
        vec.add(stars);
        vec.add(rs.getString(7));
        tblModel.addRow(vec);
        }
    }
    
    public void hienThi() throws SQLException {
        String query = "select HopDong.IdMaPhongTro, NguoiDung.HoTen from NguoiDung join HopDong on NguoiDung.Id = HopDong.IdNguoiDung where NguoiDung.Id = ?;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user.getId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lblIDPhong.setText(rs.getString("IdMaPhongTro"));
            lblTenNguoiThue.setText(rs.getString("HoTen"));
        }
        
        String queryHD = "select top 1\n"
                + "hdon.Id, hdong.Id, hdon.NgayBatDau, hdon.NgayKetThuc, hdon.NgayTao, hdon.NguoiTao,\n"
                + "hdon.SoDienMoi, hdon.SoDienCu, \n"
                + "((hdon.SoDienMoi - hdon.SoDienCu)*hdong.GiaDien) as 'Tien dien', \n"
                + "hdon.SoNuocMoi, hdon.SoNuocCu,\n"
                + "((hdon.SoNuocMoi - hdon.SoNuocCu)*hdong.GiaNuoc) as 'Tien nuoc', \n"
                + "(hdong.GiaInternet), (hdong.GiaRac), (hdong.GiaPhong), (hdon.KhauTru), (hdon.TienNo),\n"
                + "( ((hdon.SoDienMoi - hdon.SoDienCu)*hdong.GiaDien) + ((hdon.SoNuocMoi - hdon.SoNuocCu)*hdong.GiaNuoc) +\n"
                + "(hdong.GiaInternet) + (hdong.GiaRac) + (hdong.GiaPhong) + (hdon.TienNo) - (hdon.KhauTru)) as 'Tong cong', hdon.Status\n"
                + "from HoaDon hdon join HopDong hdong on hdon.IdHopDong = hdong.Id join NguoiDung nd on hdong.IdNguoiDung = nd.Id\n"
                + "where nd.Id = ? order by NgayKetThuc desc;";
        PreparedStatement pss = con.prepareStatement(queryHD);
        pss.setLong(1, user.getId());
        ResultSet rss = pss.executeQuery();
        while (rss.next()) {
            lblTongTien.setText(formatter.format(rss.getFloat(18)));
        }
    }
    
    public long getSelectedID() {
        long selectedRow = tblPhongTrong.getSelectedRow();
        if (selectedRow < 0) {
            return -1;
        }
        long id = (long) tblPhongTrong.getValueAt((int) selectedRow, 0);
        return id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhongTrong = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblThang = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtIDPhong = new javax.swing.JTextField();
        btnDangKy = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblIDPhong = new javax.swing.JLabel();
        lblTenNguoiThue = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(40, 46, 62));

        tblPhongTrong.setBackground(new java.awt.Color(207, 243, 243));
        tblPhongTrong.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPhongTrong.setGridColor(new java.awt.Color(255, 255, 255));
        tblPhongTrong.setSelectionBackground(new java.awt.Color(40, 46, 62));
        tblPhongTrong.setSelectionForeground(new java.awt.Color(255, 205, 31));
        tblPhongTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongTrongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhongTrong);

        jPanel1.setBackground(new java.awt.Color(46, 56, 86));

        lblThang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblThang.setForeground(new java.awt.Color(255, 205, 31));
        lblThang.setText("MỚI NHẤT");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HÓA ĐƠN");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 205, 31));
        lblTongTien.setText("XXXXXXX");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblThang)
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(lblTongTien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblThang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTongTien)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(46, 56, 86));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Phòng:");

        txtIDPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDPhong.setForeground(new java.awt.Color(40, 46, 62));

        btnDangKy.setBackground(new java.awt.Color(255, 205, 31));
        btnDangKy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(40, 46, 62));
        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtIDPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnDangKy)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIDPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangKy))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID phòng:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tên người thuê:");

        lblIDPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIDPhong.setForeground(new java.awt.Color(255, 205, 31));
        lblIDPhong.setText("XX");

        lblTenNguoiThue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenNguoiThue.setForeground(new java.awt.Color(255, 205, 31));
        lblTenNguoiThue.setText("Họ tên");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DANH SÁCH PHÒNG TRỐNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(24, 24, 24)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTenNguoiThue)
                                        .addComponent(lblIDPhong))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblIDPhong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblTenNguoiThue))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        // TODO add your handling code here:
        IdPhong = txtIDPhong.getText();
        DangKyPhong dk = new DangKyPhong();
        dk.setVisible(true);
//        try {
//            long idPhong = Long.parseLong(txtIDPhong.getText());
//            long idNguoiDung = user.getId();
//            int ret = JOptionPane.showConfirmDialog(null, "Đăng ký phòng này?", "Thông báo", JOptionPane.YES_NO_OPTION);
//            if (ret == JOptionPane.NO_OPTION) {
//                return;
//            }
//            PhongTroDAO ptDAO = new PhongTroDAO();
//            if (ptDAO.dangKyPhong(idNguoiDung, idPhong) == true) {
//                JOptionPane.showMessageDialog(null, "Đăng ký phòng thành công! Vui lòng đợi, chủ trọ sẽ liên lạc sau!");
//                return;
//            } else {
//                JOptionPane.showMessageDialog(null, "Đăng ký phòng thất bại! Nếu bạn đã thuê phòng, có nhu cầu chuyển phòng hoặc có thắc mắc khác vui lòng liên hệ chủ trọ để nhận hỗ trợ! Cám ơn!");
//            }
//            fillToPhongTrong();
//            SessionEntity ss = new SessionEntity();
//            ss.setUser(userSS);
//            ss.setMessage("Đăng ký phòng trọ");
//            ss.setStartTime(new Timestamp(System.currentTimeMillis()));
//            sessionDao.save(ss);
//            SessionEntity sss = sessionDao.getLast(userSS.getId());
//            setSession(sss);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void tblPhongTrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongTrongMouseClicked
        // TODO add your handling code here:
        int row = tblPhongTrong.getSelectedRow();
        txtIDPhong.setText((String) tblPhongTrong.getValueAt(row, 0));
    }//GEN-LAST:event_tblPhongTrongMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIDPhong;
    private javax.swing.JLabel lblTenNguoiThue;
    private javax.swing.JLabel lblThang;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblPhongTrong;
    private javax.swing.JTextField txtIDPhong;
    // End of variables declaration//GEN-END:variables
}

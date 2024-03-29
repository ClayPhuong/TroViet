/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TroViet.Views.ChuTro;

import TroViet.DAO.KhuVucDAO;
import TroViet.DAO.LoaiPhongDAO;
import TroViet.DAO.SessionDAO;
import TroViet.Model.KhuVuc;
import TroViet.Model.LoaiPhong;
import TroViet.Model.SessionEntity;
import TroViet.Model.UserEntity;
import TroViet.Utils.SessionManager;
import static TroViet.Utils.SessionManager.setSession;
import static TroViet.Views.ChuTro.HopDongPanel.sessionDao;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WINDOWS
 */
public class KhuVucLoaiPhongPanel extends javax.swing.JPanel {

    /**
     * Creates new form KhuVucLoaiPhongPanel
     */
    
    DefaultTableModel modelKV, modelLP;
    KhuVucDAO kvDAO = new KhuVucDAO();
    LoaiPhongDAO lpDAO = new LoaiPhongDAO();
    KhuVuc kv = new KhuVuc();
    LoaiPhong lp = new LoaiPhong();
    UserEntity userSS = SessionManager.getSession().getUser();
    static SessionDAO sessionDao = new SessionDAO();
    
    public KhuVucLoaiPhongPanel() throws SQLException {
        initComponents();
        initKhuVuc();
        initLoaiPhong();
        fillToKV();
        fillToLP();
    }
    
    public void initKhuVuc() {
        modelKV = (DefaultTableModel) tblKhuVuc.getModel();
        String[] columns = {"Id", "Tên khu vực", "Tầng", "Dãy"};
        modelKV.setColumnIdentifiers(columns);
    }
    
    public void initLoaiPhong() {
        modelLP = (DefaultTableModel) tblLoaiPhong.getModel();
        String[] columns = {"Id", "Tên loại phòng"};
        modelLP.setColumnIdentifiers(columns);
    }
    
    public void fillToKV() throws SQLException {
        modelKV.setRowCount(0);
        for (KhuVuc kv : kvDAO.getALL()) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(kv.getId());
            vec.add(kv.getTenKhuVuc());
            vec.add(kv.getTang());
            vec.add(kv.getDay());
            modelKV.addRow(vec);
        }
    }
    
    public void fillToLP() throws SQLException {
        modelLP.setRowCount(0);
        for (LoaiPhong lp : lpDAO.getAll()) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(lp.getId());
            vec.add(lp.getTenLoaiPhong());
            modelLP.addRow(vec);
        }
    }
    
    public int getIDKV() {
        int row = tblKhuVuc.getSelectedRow();
        if (row < 0) {
            return -1;
        }
        int idKV = (int) tblKhuVuc.getValueAt(row, 0);
        return idKV;
    }
    
    public int getIDLP() {
        int row = tblLoaiPhong.getSelectedRow();
        if (row < 0) {
            return -1;
        }
        int idLP = (int) tblLoaiPhong.getValueAt(row, 0);
        return idLP;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelKhuVuc = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblMaKhuVuc = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenKhuVuc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDay = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuVuc = new javax.swing.JTable();
        btnThemKV = new javax.swing.JButton();
        btnSuaKV = new javax.swing.JButton();
        btnXoaKV = new javax.swing.JButton();
        btnResetKV = new javax.swing.JButton();
        jPanelLoaiPhong = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMaLoaiPhong = new javax.swing.JLabel();
        txtTenLoaiPhong = new javax.swing.JTextField();
        btnThemLP = new javax.swing.JButton();
        btnSuaLP = new javax.swing.JButton();
        btnXoaLP = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiPhong = new javax.swing.JTable();
        btnResetLP = new javax.swing.JButton();

        setBackground(new java.awt.Color(40, 46, 62));

        jPanelKhuVuc.setBackground(new java.awt.Color(46, 56, 86));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 205, 31));
        jLabel2.setText("KHU VỰC");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã khu vực:");

        lblMaKhuVuc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMaKhuVuc.setForeground(new java.awt.Color(255, 205, 31));
        lblMaKhuVuc.setText("XX");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên khu vực:");

        txtTenKhuVuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenKhuVuc.setForeground(new java.awt.Color(40, 46, 62));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tầng:");

        txtTang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTang.setForeground(new java.awt.Color(40, 46, 62));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dãy:");

        txtDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDay.setForeground(new java.awt.Color(40, 46, 62));

        tblKhuVuc.setBackground(new java.awt.Color(207, 243, 243));
        tblKhuVuc.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhuVuc.setGridColor(new java.awt.Color(255, 255, 255));
        tblKhuVuc.setSelectionBackground(new java.awt.Color(40, 46, 62));
        tblKhuVuc.setSelectionForeground(new java.awt.Color(255, 205, 31));
        tblKhuVuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuVucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuVuc);

        btnThemKV.setBackground(new java.awt.Color(255, 205, 31));
        btnThemKV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TroViet/Icon/add.png"))); // NOI18N
        btnThemKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKVActionPerformed(evt);
            }
        });

        btnSuaKV.setBackground(new java.awt.Color(255, 205, 31));
        btnSuaKV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TroViet/Icon/edit.png"))); // NOI18N
        btnSuaKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKVActionPerformed(evt);
            }
        });

        btnXoaKV.setBackground(new java.awt.Color(255, 205, 31));
        btnXoaKV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TroViet/Icon/litter.png"))); // NOI18N
        btnXoaKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKVActionPerformed(evt);
            }
        });

        btnResetKV.setBackground(new java.awt.Color(255, 205, 31));
        btnResetKV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TroViet/Icon/return.png"))); // NOI18N
        btnResetKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetKVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelKhuVucLayout = new javax.swing.GroupLayout(jPanelKhuVuc);
        jPanelKhuVuc.setLayout(jPanelKhuVucLayout);
        jPanelKhuVucLayout.setHorizontalGroup(
            jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhuVucLayout.createSequentialGroup()
                .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKhuVucLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel2))
                    .addGroup(jPanelKhuVucLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelKhuVucLayout.createSequentialGroup()
                                .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaKhuVuc)
                                    .addComponent(txtTenKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelKhuVucLayout.createSequentialGroup()
                                .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanelKhuVucLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelKhuVucLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btnThemKV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaKV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaKV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnResetKV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanelKhuVucLayout.setVerticalGroup(
            jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhuVucLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaKhuVuc)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanelKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemKV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaKV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetKV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelLoaiPhong.setBackground(new java.awt.Color(46, 56, 86));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 205, 31));
        jLabel1.setText("LOẠI PHÒNG");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mã loại phòng:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tên loại phòng:");

        lblMaLoaiPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMaLoaiPhong.setForeground(new java.awt.Color(255, 205, 31));
        lblMaLoaiPhong.setText("XX");

        txtTenLoaiPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenLoaiPhong.setForeground(new java.awt.Color(40, 46, 62));

        btnThemLP.setBackground(new java.awt.Color(255, 205, 31));
        btnThemLP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TroViet/Icon/add.png"))); // NOI18N
        btnThemLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLPActionPerformed(evt);
            }
        });

        btnSuaLP.setBackground(new java.awt.Color(255, 205, 31));
        btnSuaLP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TroViet/Icon/edit.png"))); // NOI18N
        btnSuaLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLPActionPerformed(evt);
            }
        });

        btnXoaLP.setBackground(new java.awt.Color(255, 205, 31));
        btnXoaLP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TroViet/Icon/litter.png"))); // NOI18N
        btnXoaLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLPActionPerformed(evt);
            }
        });

        tblLoaiPhong.setBackground(new java.awt.Color(207, 243, 243));
        tblLoaiPhong.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLoaiPhong.setGridColor(new java.awt.Color(255, 255, 255));
        tblLoaiPhong.setSelectionBackground(new java.awt.Color(40, 46, 62));
        tblLoaiPhong.setSelectionForeground(new java.awt.Color(255, 205, 31));
        tblLoaiPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiPhong);

        btnResetLP.setBackground(new java.awt.Color(255, 205, 31));
        btnResetLP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TroViet/Icon/return.png"))); // NOI18N
        btnResetLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetLPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoaiPhongLayout = new javax.swing.GroupLayout(jPanelLoaiPhong);
        jPanelLoaiPhong.setLayout(jPanelLoaiPhongLayout);
        jPanelLoaiPhongLayout.setHorizontalGroup(
            jPanelLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoaiPhongLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanelLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoaiPhongLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoaiPhongLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoaiPhongLayout.createSequentialGroup()
                        .addGroup(jPanelLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaLoaiPhong)
                            .addComponent(txtTenLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoaiPhongLayout.createSequentialGroup()
                        .addComponent(btnThemLP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaLP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaLP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnResetLP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))))
        );
        jPanelLoaiPhongLayout.setVerticalGroup(
            jPanelLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoaiPhongLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanelLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaLoaiPhong)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanelLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemLP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaLP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaLP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetLP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanelKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhuVucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuVucMouseClicked
        // TODO add your handling code here:
        int idKV = getIDKV();
        try {
            KhuVuc kv = kvDAO.get(idKV);
            lblMaKhuVuc.setText(kv.getId()+"");
            txtTenKhuVuc.setText(kv.getTenKhuVuc());
            txtTang.setText(kv.getTang()+"");
            txtDay.setText(kv.getDay()+"");
            if (idKV < 0) {
                JOptionPane.showInternalMessageDialog(null, "Vui lòng chọn khu vực cần hiển thị!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuVucLoaiPhongPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblKhuVucMouseClicked

    private void btnThemKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKVActionPerformed
        // TODO add your handling code here:
        try {
            if (txtTenKhuVuc.getText().isEmpty() && txtDay.getText().isEmpty() && txtTang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của khu vực!");
                return;
            }
            try {
                Integer.parseInt(txtTang.getText());
                Integer.parseInt(txtDay.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Số tầng, số dãy nhà phải là số nguyên!");
            }
            if (kvDAO.existsKV(txtTenKhuVuc.getText())!=null) {
                JOptionPane.showMessageDialog(null, "Tên khu vực đã tồn tại!");
                return;
            }
            int choice = JOptionPane.showConfirmDialog(null, "Thêm khu vực mới?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                return;
            }
            kv.setTenKhuVuc(txtTenKhuVuc.getText());
            kv.setTang(Integer.parseInt(txtTang.getText()));
            kv.setDay(Integer.parseInt(txtDay.getText()));

            try {
                kvDAO.saveKV(kv);
                lblMaKhuVuc.setText("XX");
                txtDay.setText("");
                txtTang.setText("");
                txtTenKhuVuc.setText("");
                JOptionPane.showMessageDialog(null, "Thêm khu vực mới thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Thêm khu vực mới thất bại!");
                e.printStackTrace();
            }
            fillToKV();
            SessionEntity ss = new SessionEntity();
            ss.setUser(userSS);
            ss.setMessage("Thêm khu vực mới");
            ss.setStartTime(new Timestamp(System.currentTimeMillis()));
            sessionDao.save(ss);
            SessionEntity sss = sessionDao.getLast(userSS.getId());
            setSession(sss);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemKVActionPerformed

    private void btnSuaKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKVActionPerformed
        // TODO add your handling code here:
        try {
            int choice = JOptionPane.showConfirmDialog(null, "Cập nhật thông tin khu vực này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                return;
            }
            kv.setTenKhuVuc(txtTenKhuVuc.getText());
            kv.setTang(Integer.parseInt(txtTang.getText()));
            kv.setDay(Integer.parseInt(txtDay.getText()));
            kv.setId(Integer.parseInt(lblMaKhuVuc.getText()));
            if(kvDAO.updateKVByID(kv)>0) {
                JOptionPane.showMessageDialog(null, "Cập nhật khu vực thành công!");
                fillToKV();
                lblMaKhuVuc.setText("XX");
                txtDay.setText("");
                txtTang.setText("");
                txtTenKhuVuc.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật khu vực thất bại!");
            }
            SessionEntity ss = new SessionEntity();
            ss.setUser(userSS);
            ss.setMessage("Cập nhật khu vực");
            ss.setStartTime(new Timestamp(System.currentTimeMillis()));
            sessionDao.save(ss);
            SessionEntity sss = sessionDao.getLast(userSS.getId());
            setSession(sss);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaKVActionPerformed

    private void btnXoaKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKVActionPerformed
        try {
            // TODO add your handling code here:
            int idKV = getIDKV();
            int choice = JOptionPane.showConfirmDialog(null, "Xóa khu vực này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                try {
                    kvDAO.deleteKVById(idKV);
                    fillToKV();
                    lblMaKhuVuc.setText("XX");
                    txtDay.setText("");
                    txtTang.setText("");
                    txtTenKhuVuc.setText("");
                    JOptionPane.showMessageDialog(null, "Xóa khu vực thành công!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Xóa khu vực thất bại!");
                    e.printStackTrace();
                }
            }
            SessionEntity ss = new SessionEntity();
            ss.setUser(userSS);
            ss.setMessage("Xóa khu vực");
            ss.setStartTime(new Timestamp(System.currentTimeMillis()));
            sessionDao.save(ss);
            SessionEntity sss = sessionDao.getLast(userSS.getId());
            setSession(sss);
        } catch (SQLException ex) {
            Logger.getLogger(KhuVucLoaiPhongPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaKVActionPerformed

    private void btnResetKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetKVActionPerformed
        // TODO add your handling code here:
        lblMaKhuVuc.setText("XX");
        txtDay.setText("");
        txtTang.setText("");
        txtTenKhuVuc.setText("");
    }//GEN-LAST:event_btnResetKVActionPerformed

    private void btnThemLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLPActionPerformed
        // TODO add your handling code here:
        try {
            if (txtTenLoaiPhong.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của loại phòng!");
                return;
            }
            if (lpDAO.existsLP(txtTenLoaiPhong.getText())!=null) {
                JOptionPane.showMessageDialog(null, "Tên loại phòng đã tồn tại!");
                return;
            }
            int choice = JOptionPane.showConfirmDialog(null, "Thêm loại phòng mới?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                return;
            }
            lp.setTenLoaiPhong(txtTenLoaiPhong.getText());
            try {
                lpDAO.saveLP(lp);
                lblMaLoaiPhong.setText("XX");
                txtTenLoaiPhong.setText("");
                JOptionPane.showMessageDialog(null, "Thêm loại phòng mới thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Thêm loại phòng mới thất bại!");
                e.printStackTrace();
            }
            fillToLP();
            SessionEntity ss = new SessionEntity();
            ss.setUser(userSS);
            ss.setMessage("Thêm loại phòng mới");
            ss.setStartTime(new Timestamp(System.currentTimeMillis()));
            sessionDao.save(ss);
            SessionEntity sss = sessionDao.getLast(userSS.getId());
            setSession(sss);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemLPActionPerformed

    private void btnSuaLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLPActionPerformed
        // TODO add your handling code here:
        try {
            int choice = JOptionPane.showConfirmDialog(null, "Cập nhật thông tin loại phòng này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                return;
            }
            lp.setTenLoaiPhong(txtTenLoaiPhong.getText());
            lp.setId(Integer.parseInt(lblMaLoaiPhong.getText()));
            if(lpDAO.updateLPByID(lp)>0) {
                JOptionPane.showMessageDialog(null, "Cập nhật loại phòng thành công!");
                fillToLP();
                lblMaLoaiPhong.setText("XX");
                txtTenLoaiPhong.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật loại phòng thất bại!");
            }
            SessionEntity ss = new SessionEntity();
            ss.setUser(userSS);
            ss.setMessage("Cập nhật thông tin loại phòng");
            ss.setStartTime(new Timestamp(System.currentTimeMillis()));
            sessionDao.save(ss);
            SessionEntity sss = sessionDao.getLast(userSS.getId());
            setSession(sss);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaLPActionPerformed

    private void btnXoaLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLPActionPerformed
        try {
            // TODO add your handling code here:
            int idLP = getIDLP();
            int choice = JOptionPane.showConfirmDialog(null, "Xóa loại phòng này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                try {
                    lpDAO.deleteLPById(idLP);
                    fillToLP();
                    lblMaLoaiPhong.setText("XX");
                    txtTenLoaiPhong.setText("");
                    JOptionPane.showMessageDialog(null, "Xóa loại phòng thành công!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Xóa loại phòng thất bại!");
                    e.printStackTrace();
                }
            }
            SessionEntity ss = new SessionEntity();
            ss.setUser(userSS);
            ss.setMessage("Xóa loại phòng");
            ss.setStartTime(new Timestamp(System.currentTimeMillis()));
            sessionDao.save(ss);
            SessionEntity sss = sessionDao.getLast(userSS.getId());
            setSession(sss);
        } catch (SQLException ex) {
            Logger.getLogger(KhuVucLoaiPhongPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaLPActionPerformed

    private void tblLoaiPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiPhongMouseClicked
        // TODO add your handling code here:
        int idLP = getIDLP();
        try {
            LoaiPhong lp = lpDAO.get(idLP);
            lblMaLoaiPhong.setText(lp.getId()+"");
            txtTenLoaiPhong.setText(lp.getTenLoaiPhong());
            if (idLP < 0) {
                JOptionPane.showInternalMessageDialog(null, "Vui lòng chọn khu vực cần hiển thị!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuVucLoaiPhongPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblLoaiPhongMouseClicked

    private void btnResetLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetLPActionPerformed
        // TODO add your handling code here:
        lblMaLoaiPhong.setText("XX");
        txtTenLoaiPhong.setText("");
    }//GEN-LAST:event_btnResetLPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResetKV;
    private javax.swing.JButton btnResetLP;
    private javax.swing.JButton btnSuaKV;
    private javax.swing.JButton btnSuaLP;
    private javax.swing.JButton btnThemKV;
    private javax.swing.JButton btnThemLP;
    private javax.swing.JButton btnXoaKV;
    private javax.swing.JButton btnXoaLP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanelKhuVuc;
    private javax.swing.JPanel jPanelLoaiPhong;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMaKhuVuc;
    private javax.swing.JLabel lblMaLoaiPhong;
    private javax.swing.JTable tblKhuVuc;
    private javax.swing.JTable tblLoaiPhong;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtTang;
    private javax.swing.JTextField txtTenKhuVuc;
    private javax.swing.JTextField txtTenLoaiPhong;
    // End of variables declaration//GEN-END:variables
}

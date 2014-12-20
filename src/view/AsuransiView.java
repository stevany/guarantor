package view;

import controller.ReportController;
import dao.AsuransiDAO;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import model.AsuransiModel;
import javax.swing.table.DefaultTableModel;
import model.ReportAsuransiModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class AsuransiView extends javax.swing.JFrame {
    
    private DefaultTableModel tbl;
    dao.AsuransiDAO dao = new AsuransiDAO();
    int id_asuransi;
    Boolean otorisasi = KlsParameter.kelas.getOtorisasi();
    String nama, alamat, kota, email, c_person, telp1, telp2, fax1, fax2;
    
    public AsuransiView() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        tampil(false, cmbCari.getSelectedIndex());
        TxtID.setEnabled(false);
        TxtKdAsuransi.setEnabled(false);
        setLocationRelativeTo(this);
        LblUser.setText(KlsParameter.kelas.getUser());
        //     TxtNama.setFocusable(true);
        cmbCari.removeAllItems();
        cmbCari.addItem("Kode Asuransi");
        cmbCari.addItem("Nama");
        this.setTitle("Master Asuransi");
        String currentDir = System.getProperty("user.dir");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(currentDir + "\\src\\pict\\health.jpg"));
        if (otorisasi) {
            BtnCetak.setVisible(true);
            BtnHapus.setVisible(true);
            BtnTambah.setVisible(true);
            cmdSimpan.setVisible(true);
        } else {
            BtnCetak.setVisible(false);
            BtnHapus.setVisible(false);
            BtnTambah.setVisible(false);
            cmdSimpan.setVisible(false);
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_asuransi = new javax.swing.JTable();
        TxtCari = new javax.swing.JTextField();
        BtnCari = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        BtnRefresh = new javax.swing.JButton();
        Hdr = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        TxtID = new javax.swing.JTextField();
        TxtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtAlamat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtKota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtCPerson = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtTelp1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtTelp2 = new javax.swing.JTextField();
        TxtFax1 = new javax.swing.JTextField();
        TxtFax2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TxtKdAsuransi = new javax.swing.JTextField();
        lblUserUpdate = new javax.swing.JLabel();
        lblUserUpdateHdr = new javax.swing.JLabel();
        BtnTambah = new javax.swing.JButton();
        LblUser = new javax.swing.JLabel();
        BtnHapus = new javax.swing.JButton();
        cmbCari = new javax.swing.JComboBox();
        BtnCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Asuransi");

        cmdSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/floppy-copy-icon.png"))); // NOI18N
        cmdSimpan.setText("Simpan");
        cmdSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSimpanActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        tbl_asuransi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_asuransi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_asuransiMouseClicked(evt);
            }
        });
        tbl_asuransi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_asuransiKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_asuransi);

        TxtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCariActionPerformed(evt);
            }
        });
        TxtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCariKeyTyped(evt);
            }
        });

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/Magnifier-icon.png"))); // NOI18N
        BtnCari.setText("Cari");
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });

        jLabel11.setText("Pencarian");

        BtnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/view_refresh.png"))); // NOI18N
        BtnRefresh.setText("Refresh");
        BtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRefreshActionPerformed(evt);
            }
        });

        jLabel12.setText("Id Asuransi");

        TxtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNamaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        TxtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtAlamatActionPerformed(evt);
            }
        });

        jLabel4.setText("Kota");

        TxtKota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtKotaActionPerformed(evt);
            }
        });

        jLabel5.setText("Email");

        TxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtEmailActionPerformed(evt);
            }
        });

        jLabel6.setText("CPerson");

        TxtCPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCPersonActionPerformed(evt);
            }
        });

        jLabel7.setText("Telp 1");

        TxtTelp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTelp1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Telp 2");

        TxtTelp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTelp2ActionPerformed(evt);
            }
        });

        TxtFax1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFax1ActionPerformed(evt);
            }
        });

        TxtFax2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFax2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Fax 1");

        jLabel10.setText("Fax 2");

        javax.swing.GroupLayout HdrLayout = new javax.swing.GroupLayout(Hdr);
        Hdr.setLayout(HdrLayout);
        HdrLayout.setHorizontalGroup(
            HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HdrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HdrLayout.createSequentialGroup()
                        .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtKdAsuransi, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(lblUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TxtFax1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(TxtTelp2, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(TxtTelp1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(TxtCPerson, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(TxtKota, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(TxtAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(TxtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(TxtFax2, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HdrLayout.createSequentialGroup()
                    .addGap(245, 245, 245)
                    .addComponent(lblUserUpdateHdr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(245, 245, 245)))
        );
        HdrLayout.setVerticalGroup(
            HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HdrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtKdAsuransi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtCPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtTelp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TxtTelp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFax1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(TxtFax2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HdrLayout.createSequentialGroup()
                    .addGap(122, 122, 122)
                    .addComponent(lblUserUpdateHdr, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(122, Short.MAX_VALUE)))
        );

        BtnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/Actions-list-add-icon.png"))); // NOI18N
        BtnTambah.setText("Tambah");
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        LblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblUser.setText("jLabel1");

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/trash_can.png"))); // NOI18N
        BtnHapus.setText("Hapus");
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BtnCetak.setText("cetak");
        BtnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCari, 0, 118, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnHapus)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Hdr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                            .addComponent(LblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Hdr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BtnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCari)
                    .addComponent(BtnRefresh)
                    .addComponent(BtnHapus)
                    .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblUser)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void tampil(Boolean cari, int nilai) {
        tbl = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl_asuransi.setModel(tbl);
        tbl.getDataVector().removeAllElements();
        tbl.fireTableDataChanged();
        tbl.addColumn("Id");
        tbl.addColumn("Kode Asuransi");
        tbl.addColumn("Nama");
        tbl.addColumn("Alamat");
        tbl.addColumn("Kota");
        tbl.addColumn("Contact Person");
        tbl.addColumn("Email");
        tbl.addColumn("Telp 1");
        tbl.addColumn("Telp 2");
        tbl.addColumn("Fax 1");
        tbl.addColumn("Fax 2");
        
        tbl_asuransi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl_asuransi.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbl_asuransi.getColumnModel().getColumn(0).setMinWidth(0);
        tbl_asuransi.getColumnModel().getColumn(0).setMaxWidth(0);
        tbl_asuransi.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbl_asuransi.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbl_asuransi.getColumnModel().getColumn(3).setPreferredWidth(200);
        tbl_asuransi.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbl_asuransi.getColumnModel().getColumn(5).setPreferredWidth(150);
        tbl_asuransi.getColumnModel().getColumn(6).setPreferredWidth(100);
        tbl_asuransi.getColumnModel().getColumn(7).setPreferredWidth(100);
        tbl_asuransi.getColumnModel().getColumn(8).setPreferredWidth(100);
        tbl_asuransi.getColumnModel().getColumn(9).setPreferredWidth(100);
        tbl_asuransi.getColumnModel().getColumn(10).setPreferredWidth(100);
        tbl_asuransi.setRowHeight(20);
        
        List<AsuransiModel> data;
        
        data = (cari == true) ? (nilai == 0) ? dao.getKode(TxtCari.getText().trim()) : dao.getNama(TxtCari.getText().trim()) : dao.getAll();
        Iterator it = data.iterator();
        while (it.hasNext()) {
            AsuransiModel as = (AsuransiModel) it.next();
            Object[] o = new Object[11];
            o[0] = as.getId_asuransi();
            o[1] = as.getKd_asuransi();
            o[2] = as.getNama();
            o[3] = as.getAlamat();
            o[4] = as.getKota();
            o[5] = as.getC_person();
            o[6] = as.getEmail();
            o[7] = as.getTelp1();
            o[8] = as.getTelp2();
            o[9] = as.getFax1();
            o[10] = as.getFax2();
            tbl.addRow(o);
        }
    }
private void cmdSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSimpanActionPerformed
    AsuransiModel as = new AsuransiModel();
    if (TxtID.getText().equals("")) {
        KlsParameter.code.buatKode(TxtNama.getText().trim(), 1);
        as.setKd_asuransi(KlsParameter.kelas.getKodeTabel());
    } else {
        as.setId_asuransi(Integer.parseInt(TxtID.getText()));
        as.setKd_asuransi(TxtKdAsuransi.getText().trim());
    }
    as.setNama(TxtNama.getText().trim());
    as.setAlamat(TxtAlamat.getText().trim());
    as.setKota(TxtKota.getText().trim());
    as.setC_person(TxtCPerson.getText().trim());
    as.setEmail(TxtEmail.getText().trim());
    as.setTelp1(TxtTelp1.getText().trim());
    as.setTelp2(TxtTelp2.getText().trim());
    as.setFax1(TxtFax1.getText().trim());
    as.setFax2(TxtFax2.getText().trim());
    as.setUsrUpdate(LblUser.getText().trim());
    as.setTglUpdate(new Date(System.currentTimeMillis()));
    dao.saveOrUpdate(as);
    tampil(false, cmbCari.getSelectedIndex());
    TxtID.setText(Integer.toString(as.getId_asuransi()));
    TxtKdAsuransi.setText(as.getKd_asuransi());
}//GEN-LAST:event_cmdSimpanActionPerformed

private void tbl_asuransiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_asuransiMouseClicked
    
    int i = tbl_asuransi.getSelectedRow();
    if (i == -1) {
        return;
    } else {
        id_asuransi = (Integer) tbl.getValueAt(i, 0);
        TxtID.setText((Integer.toString(id_asuransi)));
        
        AsuransiModel mod = dao.takeId(id_asuransi);
        TxtNama.setText(mod.getNama());
        TxtAlamat.setText(mod.getAlamat());
        TxtKota.setText(mod.getKota());
        TxtEmail.setText(mod.getEmail());
        TxtCPerson.setText(mod.getC_person());
        TxtTelp1.setText(mod.getTelp1());
        TxtTelp2.setText(mod.getTelp2());
        TxtFax1.setText(mod.getFax1());
        TxtFax2.setText(mod.getFax2());
        TxtKdAsuransi.setText(mod.getKd_asuransi());
        lblUserUpdate.setText(mod.getUsrUpdate().trim() + " " + mod.getTglUpdate());
        
    }
}//GEN-LAST:event_tbl_asuransiMouseClicked

private void tbl_asuransiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_asuransiKeyReleased
    /*int i = tbl_asuransi.getSelectedRow();

     if (i == - 1){ return;}else{
     id_asuransi = (Integer)tbl.getValueAt(i, 0);
     AsuransiModel mod = dao.takeId(id_asuransi);
     int jwb = JOptionPane.showConfirmDialog(this, "Apakah data asuransi '" + mod.getNama().trim() + "'" + " akan di hapus?", "Warning!",JOptionPane.YES_NO_OPTION);
     if (jwb == 0){ dao.deletebyId(id_asuransi); }else{return;}
     }
     tampil();*/
}//GEN-LAST:event_tbl_asuransiKeyReleased

    private void TxtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCariKeyTyped
        tampil(true, cmbCari.getSelectedIndex());

    }//GEN-LAST:event_TxtCariKeyTyped

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil(true, cmbCari.getSelectedIndex());
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshActionPerformed
        tampil(false, cmbCari.getSelectedIndex());
    }//GEN-LAST:event_BtnRefreshActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        KlsParameter.code.kosongText(Hdr);
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        int i = tbl_asuransi.getSelectedRow();
        if (i == - 1) {
            return;
        } else {
            id_asuransi = (Integer) tbl.getValueAt(i, 0);
            AsuransiModel mod = dao.takeId(id_asuransi);
            int jwb = JOptionPane.showConfirmDialog(this, "Apakah data asuransi '" + mod.getNama().trim() + "'" + " akan di hapus?", "Warning!", JOptionPane.YES_NO_OPTION);
            if (jwb == 0) {
                dao.deletebyId(id_asuransi);
            } else {
                return;
            }
        }
        tampil(false, cmbCari.getSelectedIndex());
    }//GEN-LAST:event_BtnHapusActionPerformed

private void TxtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCariActionPerformed
    tampil(true, cmbCari.getSelectedIndex());
}//GEN-LAST:event_TxtCariActionPerformed

private void TxtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNamaActionPerformed
    TxtAlamat.requestFocus(true);
}//GEN-LAST:event_TxtNamaActionPerformed

private void TxtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAlamatActionPerformed
    TxtKota.requestFocus(true);
}//GEN-LAST:event_TxtAlamatActionPerformed

private void TxtKotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtKotaActionPerformed
    TxtEmail.requestFocus();
}//GEN-LAST:event_TxtKotaActionPerformed

private void TxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtEmailActionPerformed
    TxtCPerson.requestFocus();
}//GEN-LAST:event_TxtEmailActionPerformed

private void TxtCPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCPersonActionPerformed
    TxtTelp1.requestFocus();
}//GEN-LAST:event_TxtCPersonActionPerformed

private void TxtTelp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTelp1ActionPerformed
    TxtTelp2.requestFocus();
}//GEN-LAST:event_TxtTelp1ActionPerformed

private void TxtTelp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTelp2ActionPerformed
    TxtFax1.requestFocus();
}//GEN-LAST:event_TxtTelp2ActionPerformed

private void TxtFax1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFax1ActionPerformed
    TxtFax2.requestFocus();
}//GEN-LAST:event_TxtFax1ActionPerformed

private void TxtFax2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFax2ActionPerformed
    cmdSimpanActionPerformed(evt);
}//GEN-LAST:event_TxtFax2ActionPerformed

    private void BtnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCetakActionPerformed
        try {
            // TODO add your handling code here:

            System.out.println(new java.io.File(".").getCanonicalPath());
            Map parameter = new HashMap();
            parameter.put("tahun", "2012");
            
            List<AsuransiModel> asuransiModels = dao.getAll();
            //  .getAll();
            Iterator it = asuransiModels.iterator();
            List<ReportAsuransiModel> reportAsuransiModels = new ArrayList<ReportAsuransiModel>();
            while (it.hasNext()) {
                ReportAsuransiModel reportAsuransiModel = new ReportAsuransiModel();
                AsuransiModel as = (AsuransiModel) it.next();
                reportAsuransiModel.setId_asuransi(1);
                reportAsuransiModel.setNama(as.getNama());
                reportAsuransiModel.setAlamat(as.getAlamat());
                reportAsuransiModel.setKota(as.getKota());
                reportAsuransiModel.setEmail(as.getEmail());
                reportAsuransiModel.setC_person(as.getC_person());
                reportAsuransiModel.setFax1(as.getFax1());
                reportAsuransiModel.setFax2(as.getFax2());
                reportAsuransiModel.setKd_asuransi(as.getKd_asuransi());
                reportAsuransiModel.setTelp1(as.getTelp1());
                reportAsuransiModel.setTelp2(as.getTelp2());
                reportAsuransiModels.add(reportAsuransiModel);
            }
            File f = new File("laporan/report1.jasper");
            System.out.println(f.getCanonicalFile());
            if (!f.exists()) {
                System.out.println(f.getCanonicalFile() + " not found ");
            }
            
            ReportController.PreviewLap("laporan/report1.jasper", parameter, reportAsuransiModels, "judul");
            //        ReportController.CetakLap("laporan/report1.jasper", parameter, asuransiModel, "judul");
        } catch (IOException ex) {
            Logger.getLogger(AsuransiView.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_BtnCetakActionPerformed
    void Cari() {
        List<AsuransiModel> data = dao.getNama(TxtCari.getText().trim());
        Iterator it = data.iterator();
        tbl.getDataVector().removeAllElements();
        tbl.fireTableDataChanged();
        while (it.hasNext()) {
            AsuransiModel as = (AsuransiModel) it.next();
            Object[] o = new Object[11];
            o[0] = as.getId_asuransi();
            o[1] = as.getKd_asuransi();
            o[2] = as.getNama();
            o[3] = as.getAlamat();
            o[4] = as.getKota();
            o[5] = as.getC_person();
            o[6] = as.getEmail();
            o[7] = as.getTelp1();
            o[8] = as.getTelp2();
            o[9] = as.getFax1();
            o[10] = as.getFax2();
            tbl.addRow(o);
        }
    }
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AsuransiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsuransiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsuransiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsuransiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsuransiView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnCetak;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnRefresh;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JPanel Hdr;
    private javax.swing.JLabel LblUser;
    private javax.swing.JTextField TxtAlamat;
    private javax.swing.JTextField TxtCPerson;
    private javax.swing.JTextField TxtCari;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtFax1;
    private javax.swing.JTextField TxtFax2;
    private javax.swing.JTextField TxtID;
    private javax.swing.JTextField TxtKdAsuransi;
    private javax.swing.JTextField TxtKota;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JTextField TxtTelp1;
    private javax.swing.JTextField TxtTelp2;
    private javax.swing.JComboBox cmbCari;
    private javax.swing.JButton cmdSimpan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblUserUpdate;
    private javax.swing.JLabel lblUserUpdateHdr;
    private javax.swing.JTable tbl_asuransi;
    // End of variables declaration//GEN-END:variables
}

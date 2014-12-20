package view;

import model.PerusahaanModel;
import dao.PerusahaanDAO;
import java.awt.Toolkit;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class PerusahaanView extends javax.swing.JFrame {

    PerusahaanDAO dao = new PerusahaanDAO();
    private DefaultTableModel tbl;
    private boolean cari;
    private Boolean otorisasi = KlsParameter.kelas.getOtorisasi();

    public PerusahaanView() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        TxtID.setEnabled(false);
        TxtKdPerusahaan.setEnabled(false);
        setLocationRelativeTo(this);
        LblUser.setText(KlsParameter.kelas.getUser());
        // TxtNama.setFocusable(true);
        cmbPerusahaan.removeAllItems();
        cmbPerusahaan.addItem("Kode Perusahaan");
        cmbPerusahaan.addItem("Nama");
        tampil(false, cmbPerusahaan.getSelectedIndex());
        this.setTitle("Master Perusahaan");
        String currentDir = System.getProperty("user.dir");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(currentDir + "\\src\\pict\\building_icon.jpg"));
        if (otorisasi) {
            BtnCetak.setVisible(true);
            BtnHapus.setVisible(true);
            cmdTambah.setVisible(true);
            cmdSimpan.setVisible(true);
        } else {
            BtnCetak.setVisible(false);
            BtnHapus.setVisible(false);
            cmdTambah.setVisible(false);
            cmdSimpan.setVisible(false);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_perusahaan = new javax.swing.JTable();
        cmdTambah = new javax.swing.JButton();
        Hdr = new javax.swing.JPanel();
        TxtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtAlamat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtKota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        TxtCPerson = new javax.swing.JTextField();
        TxtTelp1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtTelp2 = new javax.swing.JTextField();
        TxtFax1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtFax2 = new javax.swing.JTextField();
        TxtKdPerusahaan = new javax.swing.JTextField();
        lblUserUpdate = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TxtCari = new javax.swing.JTextField();
        cmdCari = new javax.swing.JButton();
        cmdRefresh = new javax.swing.JButton();
        LblUser = new javax.swing.JLabel();
        BtnHapus = new javax.swing.JButton();
        cmbPerusahaan = new javax.swing.JComboBox();
        BtnCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmdSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/floppy-copy-icon.png"))); // NOI18N
        cmdSimpan.setText("Simpan");
        cmdSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSimpanActionPerformed(evt);
            }
        });

        tbl_perusahaan.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_perusahaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_perusahaanMouseClicked(evt);
            }
        });
        tbl_perusahaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_perusahaanKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_perusahaan);

        cmdTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/Actions-list-add-icon.png"))); // NOI18N
        cmdTambah.setText("Tambah");
        cmdTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTambahActionPerformed(evt);
            }
        });

        jLabel1.setText("Id Perusahan");

        TxtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNamaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        TxtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtAlamatActionPerformed(evt);
            }
        });

        jLabel3.setText("Alamat");

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

        TxtCPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCPersonActionPerformed(evt);
            }
        });

        TxtTelp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTelp1ActionPerformed(evt);
            }
        });

        jLabel6.setText("CPerson");

        jLabel7.setText("Telp 1");

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

        jLabel10.setText("Fax 2");

        jLabel9.setText("Fax 1");

        TxtFax2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFax2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HdrLayout = new javax.swing.GroupLayout(Hdr);
        Hdr.setLayout(HdrLayout);
        HdrLayout.setHorizontalGroup(
            HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HdrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(32, 32, 32)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtFax1)
                    .addComponent(TxtTelp2)
                    .addComponent(TxtTelp1)
                    .addComponent(TxtCPerson, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtFax2)
                    .addGroup(HdrLayout.createSequentialGroup()
                        .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtKdPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TxtEmail)
                    .addComponent(TxtKota)
                    .addComponent(TxtAlamat)
                    .addComponent(TxtNama))
                .addContainerGap())
        );
        HdrLayout.setVerticalGroup(
            HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HdrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtKdPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                    .addComponent(jLabel9)
                    .addComponent(TxtFax1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HdrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TxtFax2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel11.setText("Pencarian");

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

        cmdCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/Magnifier-icon.png"))); // NOI18N
        cmdCari.setText("Cari");
        cmdCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCariActionPerformed(evt);
            }
        });

        cmdRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/view_refresh.png"))); // NOI18N
        cmdRefresh.setText("Refresh");
        cmdRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefreshActionPerformed(evt);
            }
        });

        LblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblUser.setText("jLabel12");

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/trash_can.png"))); // NOI18N
        BtnHapus.setText("Hapus");
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        cmbPerusahaan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Hdr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmdSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdTambah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnCetak))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdCari)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdRefresh)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnHapus)))
                                .addGap(0, 82, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnCetak, cmdTambah});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Hdr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BtnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCari)
                    .addComponent(cmdRefresh)
                    .addComponent(BtnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cmdSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSimpanActionPerformed
    PerusahaanModel pers = new PerusahaanModel();

    if (TxtID.getText().equals("")) {
        KlsParameter.code.buatKode(TxtNama.getText().trim(), 2);
        pers.setKd_perusahaan(KlsParameter.kelas.getKodeTabel());
    } else {
        pers.setId_perusahaan(Integer.parseInt(TxtID.getText().trim()));
        pers.setKd_perusahaan(TxtKdPerusahaan.getText().trim());
    }

    pers.setNama(TxtNama.getText().trim());
    pers.setAlamat(TxtAlamat.getText().trim());
    pers.setKota(TxtKota.getText().trim());
    pers.setC_person(TxtCPerson.getText().trim());
    pers.setEmail(TxtEmail.getText().trim());
    pers.setTelp1(TxtTelp1.getText().trim());
    pers.setTelp2(TxtTelp2.getText().trim());
    pers.setFax1(TxtFax1.getText().trim());
    pers.setFax2(TxtFax2.getText().trim());
    pers.setTglUpdate(new Date(System.currentTimeMillis()));
    pers.setUsrUpdate(LblUser.getText().trim());
    dao.saveOrUpdate(pers);
    tampil(false, cmbPerusahaan.getSelectedIndex());
    TxtID.setText(Integer.toString(pers.getId_perusahaan()));
    TxtKdPerusahaan.setText(pers.getKd_perusahaan());
}//GEN-LAST:event_cmdSimpanActionPerformed

    private void cmdCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCariActionPerformed
        tampil(true, cmbPerusahaan.getSelectedIndex());
    }//GEN-LAST:event_cmdCariActionPerformed

    private void cmdRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefreshActionPerformed
        tampil(false, cmbPerusahaan.getSelectedIndex());
    }//GEN-LAST:event_cmdRefreshActionPerformed

    private void tbl_perusahaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_perusahaanMouseClicked
        int i = tbl_perusahaan.getSelectedRow();
        PerusahaanModel pers = dao.takeId(Integer.parseInt(tbl.getValueAt(i, 0).toString()));
        TxtID.setText(Integer.toString(pers.getId_perusahaan()));
        TxtKdPerusahaan.setText(pers.getKd_perusahaan().trim());
        TxtNama.setText(pers.getNama());
        TxtAlamat.setText(pers.getAlamat());
        TxtKota.setText(pers.getKota());
        TxtCPerson.setText(pers.getC_person());
        TxtEmail.setText(pers.getEmail());
        TxtTelp1.setText(pers.getTelp1());
        TxtTelp2.setText(pers.getTelp2());
        TxtFax1.setText(pers.getFax1());
        TxtFax2.setText(pers.getFax2());
        lblUserUpdate.setText(pers.getUsrUpdate().trim() + " " + pers.getTglUpdate());
        
        
    }//GEN-LAST:event_tbl_perusahaanMouseClicked

    private void TxtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCariKeyTyped
        tampil(true, cmbPerusahaan.getSelectedIndex());
    }//GEN-LAST:event_TxtCariKeyTyped

    private void cmdTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTambahActionPerformed
        KlsParameter.code.kosongText(Hdr);
    }//GEN-LAST:event_cmdTambahActionPerformed

    private void tbl_perusahaanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_perusahaanKeyReleased
        /* int i = tbl_perusahaan.getSelectedRow();
         if(i == -1 ){return;}else{
         int id_perusahaan = (Integer) tbl.getValueAt(i, 0);
         PerusahaanModel per = dao.takeId(id_perusahaan);
         int jwb = JOptionPane.showConfirmDialog(this, "Apakah data Perusahaan " + (String) tbl.getValueAt(i, 2) + " akan di hapus? ", "Warning!", JOptionPane.YES_NO_OPTION);
         if(jwb == 0 ){ dao.deletebyId(id_perusahaan);}else{ return;}
         }   
         tampil(false);*/
    }//GEN-LAST:event_tbl_perusahaanKeyReleased

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        int i = tbl_perusahaan.getSelectedRow();
        if (i == -1) {
            return;
        } else {
            int id_perusahaan = (Integer) tbl.getValueAt(i, 0);
            PerusahaanModel per = dao.takeId(id_perusahaan);
            int jwb = JOptionPane.showConfirmDialog(this, "Apakah data Perusahaan " + (String) tbl.getValueAt(i, 2) + " akan di hapus? ", "Warning!", JOptionPane.YES_NO_OPTION);
            if (jwb == 0) {
                dao.deletebyId(id_perusahaan);
            } else {
                return;
            }
        }

        tampil(false, cmbPerusahaan.getSelectedIndex());
    }//GEN-LAST:event_BtnHapusActionPerformed

private void TxtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNamaActionPerformed
    TxtAlamat.requestFocus();
}//GEN-LAST:event_TxtNamaActionPerformed

private void TxtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAlamatActionPerformed
    TxtKota.requestFocus();
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

private void TxtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCariActionPerformed
    tampil(true, cmbPerusahaan.getSelectedIndex());
}//GEN-LAST:event_TxtCariActionPerformed

    private void BtnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCetakActionPerformed
        // TODO add your handling code here:
        List<PerusahaanModel> dataSource = dao.getAll();
        Map map = new HashMap();
        controller.ReportController.PreviewLap("laporan/reportPerusahaan.jasper", map, dataSource, "Laporan per Perusahaan");
    }//GEN-LAST:event_BtnCetakActionPerformed
    void tampil(Boolean cari, int nilai) {
        SessionFactory sess = HibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        List<PerusahaanModel> r;
        tbl = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl_perusahaan.setModel(tbl);
        tbl.getDataVector().removeAllElements();
        tbl.fireTableDataChanged();
        tbl.addColumn("Id Perusahaan");
        tbl.addColumn("Kode Perusahaan");
        tbl.addColumn("Nama");
        tbl.addColumn("Alamat");
        tbl.addColumn("Kota");
        tbl.addColumn("C_Person");
        tbl.addColumn("Email");
        tbl.addColumn("Telp1");
        tbl.addColumn("Telp2");
        tbl.addColumn("Fax1");
        tbl.addColumn("Fax2");
        tbl_perusahaan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl_perusahaan.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbl_perusahaan.getColumnModel().getColumn(0).setMinWidth(0);
        tbl_perusahaan.getColumnModel().getColumn(0).setMaxWidth(0);
        tbl_perusahaan.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbl_perusahaan.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbl_perusahaan.getColumnModel().getColumn(3).setPreferredWidth(250);
        tbl_perusahaan.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbl_perusahaan.getColumnModel().getColumn(5).setPreferredWidth(100);
        tbl_perusahaan.getColumnModel().getColumn(6).setPreferredWidth(100);
        tbl_perusahaan.getColumnModel().getColumn(7).setPreferredWidth(100);
        tbl_perusahaan.getColumnModel().getColumn(8).setPreferredWidth(100);
        tbl_perusahaan.getColumnModel().getColumn(9).setPreferredWidth(100);
        tbl_perusahaan.getColumnModel().getColumn(10).setPreferredWidth(100);
        r = (cari == true) ? (nilai == 0) ? dao.getKode(TxtCari.getText().trim()) : dao.getNama(TxtCari.getText().trim()) : dao.getAll();
        //   if (cmbPerusahaan.getSelectedIndex() == 0){r = dao.getNama(TxtCari.getText().trim());}else{  r = dao.getAll();}
        //  r = (nilai == 0) ?  dao.getNama(TxtCari.getText().trim()): dao.getKode(TxtCari.getText().trim());
        //  if(cari) 
        //     r = dao.getNama(TxtCari.getText().trim());}
        //else{
        //   r = dao.getAll();}



        Iterator it = r.iterator();
        while (it.hasNext()) {
            PerusahaanModel pers = (PerusahaanModel) it.next();
            Object[] o = new Object[11];
            o[0] = pers.getId_perusahaan();
            o[1] = pers.getKd_perusahaan();
            o[2] = pers.getNama();
            o[3] = pers.getAlamat();
            o[4] = pers.getKota();
            o[5] = pers.getC_person();
            o[6] = pers.getEmail();
            o[7] = pers.getTelp1();
            o[8] = pers.getTelp2();
            o[9] = pers.getFax1();
            o[10] = pers.getFax2();
            tbl.addRow(o);
        }
    }

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
            java.util.logging.Logger.getLogger(PerusahaanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerusahaanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerusahaanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerusahaanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerusahaanView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCetak;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JPanel Hdr;
    private javax.swing.JLabel LblUser;
    private javax.swing.JTextField TxtAlamat;
    private javax.swing.JTextField TxtCPerson;
    private javax.swing.JTextField TxtCari;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtFax1;
    private javax.swing.JTextField TxtFax2;
    private javax.swing.JTextField TxtID;
    private javax.swing.JTextField TxtKdPerusahaan;
    private javax.swing.JTextField TxtKota;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JTextField TxtTelp1;
    private javax.swing.JTextField TxtTelp2;
    private javax.swing.JComboBox cmbPerusahaan;
    private javax.swing.JButton cmdCari;
    private javax.swing.JButton cmdRefresh;
    private javax.swing.JButton cmdSimpan;
    private javax.swing.JButton cmdTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUserUpdate;
    private javax.swing.JTable tbl_perusahaan;
    // End of variables declaration//GEN-END:variables
}

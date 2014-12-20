/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.PerusahaanDAO;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.PerusahaanModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author user
 */
public class cariPerusahaan extends javax.swing.JFrame {
private DefaultTableModel tbl;
private KerjaSama kerjasama;
dao.PerusahaanDAO dao = new PerusahaanDAO(); 
KelasParameter kelaspar = new KelasParameter();
    public cariPerusahaan() {
         try{
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        TxtCari.setText(KlsParameter.kelas.getIdPerusahaan());
        tampilTbl();
        kerjasama = KlsParameter.kelas.getKerjasama();
        setLocationRelativeTo(this);
        this.setTitle("Cari Perusahaan");
    }

void tampilTbl(){
    SessionFactory sess = HibernateUtil.getSessionFactory();
    Session session = sess.openSession();
    tbl = new DefaultTableModel();
    TblPers.setModel(tbl);
    tbl.addColumn("Id Perusahaan");
    tbl.addColumn("Kode Perusahaan");
    tbl.addColumn("                                                             Nama Perusahan");
    //tbl.addColumn("Alamat");
    //tbl.addColumn("Kota");
    tbl.getDataVector().removeAllElements();
    tbl.fireTableDataChanged();
    TblPers.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    TblPers.getColumnModel().getColumn(0).setPreferredWidth(0);
    TblPers.getColumnModel().getColumn(0).setMinWidth(0);
    TblPers.getColumnModel().getColumn(0).setMaxWidth(0);
    TblPers.getColumnModel().getColumn(1).setPreferredWidth(80);
    TblPers.getColumnModel().getColumn(2).setPreferredWidth(500);
    Query q = session.createQuery(" from PerusahaanModel where nama like '" + TxtCari.getText().trim() + "%'");
    Iterator it = q.list().iterator();
    while(it.hasNext()){
        Object [] o = new Object[3];
        PerusahaanModel pers = (PerusahaanModel) it.next();
        o[0] = pers.getId_perusahaan();
        o[1] = pers.getKd_perusahaan();
        o[2] = pers.getNama();
       // o[2] = pers.getAlamat();
       // o[3] = pers.getKota();
        tbl.addRow(o);
    }
    
}    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtCari = new javax.swing.JTextField();
        BtnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblPers = new javax.swing.JTable();
        BtnPilih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pencarian");

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/Magnifier-icon.png"))); // NOI18N
        BtnCari.setText("Cari");
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });

        TblPers.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TblPers);

        BtnPilih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/3d_web_vector_icon_ai_web_icon_illustrator_photoshop_web_icon_illustrator_ai.png"))); // NOI18N
        BtnPilih.setText("Pilih");
        BtnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPilihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                    .addComponent(BtnPilih))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCari))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnPilih)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPilihActionPerformed
    KlsParameter.kelas.setIdPerusahaan(tbl.getValueAt(TblPers.getSelectedRow(), 0).toString());
    KlsParameter.kelas.setKdPerusahaan(tbl.getValueAt(TblPers.getSelectedRow(), 1).toString());
    KlsParameter.kelas.setNmPerusahaan(tbl.getValueAt(TblPers.getSelectedRow(), 2).toString());
    kerjasama.getidPerusahaan();
    dispose();
    }//GEN-LAST:event_BtnPilihActionPerformed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampilTbl();
    }//GEN-LAST:event_BtnCariActionPerformed

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
            java.util.logging.Logger.getLogger(cariPerusahaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cariPerusahaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cariPerusahaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cariPerusahaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cariPerusahaan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnPilih;
    private javax.swing.JTable TblPers;
    private javax.swing.JTextField TxtCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

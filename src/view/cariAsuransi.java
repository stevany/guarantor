/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AsuransiDAO;
import java.util.Iterator;
import java.util.List;
import javassist.bytecode.Descriptor;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument;
import model.AsuransiModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author user
 */
public class cariAsuransi extends javax.swing.JFrame {
private DefaultTableModel tbl;
dao.AsuransiDAO dao = new AsuransiDAO();
//private Hdr_KerjasamaView hdr_kerjasama;
private KerjaSama kerjasama;
SessionFactory session = HibernateUtil.getSessionFactory();
    /**
     * Creates new form cariAsuransi
     */
    public cariAsuransi() {
         try{
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        txtCari.setText(KlsParameter.kelas.getIdAsuransi());
        tampilTabel();
        kerjasama = KlsParameter.kelas.getKerjasama();
        setLocationRelativeTo(this);
        this.setTitle("Cari Asuransi");
    }
   /* public cariAsuransi(String parameter, KerjaSama kerjasama){
        initComponents();
        txtCari.setText(parameter);
        tampilTabel();
        this.kerjasama = kerjasama;
    }*/

   void tampilTabel(){
     //  SessionFactory sess = HibernateUtil.getSessionFactory();
       Session sess = session.openSession();
       tbl = new DefaultTableModel();
       tblAsuransi.setModel(tbl);
       tbl.addColumn("id asuransi");
       tbl.addColumn("Kode Asuransi");
       tbl.addColumn("                                                          Nama Asuransi");
       Query q =sess.createQuery(" from AsuransiModel where nama like '" + txtCari.getText().trim() + "%' ");
       List<AsuransiModel> data = q.list();
       Iterator it = data.iterator();
       tbl.getDataVector().removeAllElements();
       tbl.fireTableDataChanged();
       tblAsuransi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       tblAsuransi.getColumnModel().getColumn(0).setPreferredWidth(0);
       tblAsuransi.getColumnModel().getColumn(0).setMinWidth(0);
       tblAsuransi.getColumnModel().getColumn(0).setMaxWidth(0);
       tblAsuransi.getColumnModel().getColumn(1).setPreferredWidth(80);
       tblAsuransi.getColumnModel().getColumn(2).setPreferredWidth(500);
       
       while(it.hasNext()){
           Object [] o = new Object[3];
           AsuransiModel as =  (AsuransiModel) it.next();
           o[0] = as.getId_asuransi();
           o[1] = as.getKd_asuransi();
           o[2] = as.getNama();
           tbl.addRow(o);
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        BtnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsuransi = new javax.swing.JTable();
        BtnPilih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pencarian");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/Magnifier-icon.png"))); // NOI18N
        BtnCari.setText("Cari");
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });

        tblAsuransi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAsuransi);

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
                    .addComponent(BtnPilih)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(BtnCari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnPilih)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
       
    }//GEN-LAST:event_txtCariKeyTyped

    private void BtnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPilihActionPerformed
       KlsParameter.kelas.setIdAsuransi(tbl.getValueAt(tblAsuransi.getSelectedRow(), 0).toString());
       KlsParameter.kelas.setKdAsuransi(tbl.getValueAt(tblAsuransi.getSelectedRow(), 1).toString());
       KlsParameter.kelas.setNmAsuransi(tbl.getValueAt(tblAsuransi.getSelectedRow(), 2).toString());
       kerjasama.getidAsuransi();
       dispose();
    }//GEN-LAST:event_BtnPilihActionPerformed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
    tampilTabel();
    }//GEN-LAST:event_BtnCariActionPerformed

   
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
            java.util.logging.Logger.getLogger(cariAsuransi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cariAsuransi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cariAsuransi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cariAsuransi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cariAsuransi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnPilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAsuransi;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}

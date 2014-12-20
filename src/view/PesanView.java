/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.PesanModel;
import model.UserModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author altaire
 */
public class PesanView extends javax.swing.JFrame {

    private DefaultTableModel tbl;
    private Boolean otorisasi = KlsParameter.kelas.getOtorisasi();

    /**
     * Creates new form PesanView
     */
    public PesanView() {
        initComponents();
        jLabel1.setText(KlsParameter.kelas.getUser());
        txtPesan.setText("");
        jTabbedPane1.setSelectedIndex(0);
        Calendar cal = Calendar.getInstance();
        Tgl1.setDate(cal.getTime());
        Tgl2.setDate(cal.getTime());
        jLabel2.setVisible(false);
        if(otorisasi){
            jLabel2.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPesan = new javax.swing.JTextArea();
        btnKirim = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesan = new javax.swing.JTable();
        TxtCari = new javax.swing.JTextField();
        BtnCari = new javax.swing.JButton();
        Tgl1 = new com.toedter.calendar.JDateChooser();
        Tgl2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        chkPencarian = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(200, 300));

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtPesan.setColumns(20);
        txtPesan.setRows(5);
        jScrollPane2.setViewportView(txtPesan);

        btnKirim.setText("Kirim");
        btnKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKirim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKirim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pesan", jPanel2);

        tblPesan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesan);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/trash-full-icon.png"))); // NOI18N
        BtnCari.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BtnCari.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });

        Tgl1.setDateFormatString("dd-MMM-yyyy");

        Tgl2.setDateFormatString("dd-MMM-yyyy");

        jLabel3.setText("s/d");

        chkPencarian.setText("Pencarian");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnCari)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Tgl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtCari)
                                .addComponent(Tgl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(chkPencarian))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesanMouseClicked
       int Idpsn;
        if (otorisasi) {
            SessionFactory sess = HibernateUtil.getSessionFactory();
            Session session = sess.openSession();
            jTabbedPane1.setSelectedIndex(0);
            Idpsn =(Integer)tblPesan.getValueAt(tblPesan.getSelectedRow(),0);
            PesanModel pesan = (PesanModel) session.load(PesanModel.class, Idpsn);
            txtPesan.setText(pesan.getPesan());
            jLabel2.setText(pesan.getUsrUpdate() + " " + pesan.getTglUpdate());
        }
    }//GEN-LAST:event_tblPesanMouseClicked

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        if (otorisasi) {
            tampil();
        }
    }//GEN-LAST:event_BtnCariActionPerformed

    private void btnKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimActionPerformed
        Date tanggal = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String formattedDate = sdf.format(tanggal);
        //System.out.println(formattedDate);
        SessionFactory sess = HibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        PesanModel pesan = new PesanModel();
        pesan.setPesan(txtPesan.getText());
        pesan.setUsrUpdate(jLabel1.getText());
        pesan.setTglUpdate(tanggal);
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(pesan);
        t.commit();
        JOptionPane.showMessageDialog(this, "Data berhasil di simpan!");
        session.close();
    }//GEN-LAST:event_btnKirimActionPerformed
    void tampil() {
        SessionFactory sess = HibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        String query = " from PesanModel pesan ";
        String tgl1, tgl2;
        String tanggal = "yyyy-MM-dd";

        SimpleDateFormat sdf = new SimpleDateFormat(tanggal);
        tgl1 = sdf.format(Tgl1.getDate());
        tgl2 = sdf.format(Tgl2.getDate());
        Query q = null;
        tbl = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblPesan.setModel(tbl);
        tbl.getDataVector().removeAllElements();
        tbl.fireTableDataChanged();
        tbl.addColumn("ID Pesan");
        tbl.addColumn("Tgl");
        tbl.addColumn("Pengirim");
        tblPesan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblPesan.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblPesan.getColumnModel().getColumn(0).setMinWidth(0);
        tblPesan.getColumnModel().getColumn(0).setMaxWidth(0);
        tblPesan.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblPesan.getColumnModel().getColumn(2).setPreferredWidth(300);
        query = chkPencarian.isSelected() ? query + " where pesan.tglUpdate between '" + tgl1 + "' and '" + tgl2 + "' and usrUpdate like '" + TxtCari.getText().trim() + "%'" : query + " where usrUpdate like '" + TxtCari.getText().trim() + "%' ";
        query = query + " order by  tglUpdate ";
        q = session.createQuery(query);
        Iterator it = q.iterate();
        while (it.hasNext()) {
            PesanModel pesan = (PesanModel) it.next();
            Object[] o = new Object[3];
            o[0] = pesan.getIdPesan();
            o[1] = pesan.getTglUpdate();
            o[2] = pesan.getUsrUpdate();
            tbl.addRow(o);
        }
        session.close();
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
            java.util.logging.Logger.getLogger(PesanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesanView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCari;
    private com.toedter.calendar.JDateChooser Tgl1;
    private com.toedter.calendar.JDateChooser Tgl2;
    private javax.swing.JTextField TxtCari;
    private javax.swing.JButton btnKirim;
    private javax.swing.JCheckBox chkPencarian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblPesan;
    private javax.swing.JTextArea txtPesan;
    // End of variables declaration//GEN-END:variables
}

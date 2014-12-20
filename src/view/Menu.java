/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import javax.swing.UIManager;
import model.AsuransiModel;

/**
 *
 * @author user
 */
public class Menu extends javax.swing.JFrame {

    private Boolean otorisasi = KlsParameter.kelas.getOtorisasi();

    /**
     * Creates new form Menu
     */
    public Menu() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        setLocationRelativeTo(this);
        jLabel1.setText(KlsParameter.kelas.getUser());
        this.setTitle("Menu Utama");
        String currentDir = System.getProperty("user.dir");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(currentDir + "\\src\\pict\\flying_grass.png"));
        if (otorisasi) {
            mnuKerjaSama.setEnabled(true);
            mnuUser.setEnabled(true);
       //     mnuUpdate.setVisible(true);
        } else {
            mnuKerjaSama.setEnabled(false);
            mnuUser.setEnabled(false);
        //    mnuUpdate.setVisible(false);

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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuMasterAsuransi = new javax.swing.JMenuItem();
        mnuMasterPerusahaan = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuKerjaSama = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnuUser = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mnuKerjaSamaView = new javax.swing.JMenuItem();
        mnuPesan = new javax.swing.JMenuItem();
        mnuUpdate = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu7.setText("File");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar3.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/health-care-changes.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jMenu1.setText("Menu");
        jMenu1.add(jSeparator1);

        mnuMasterAsuransi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/health.jpg"))); // NOI18N
        mnuMasterAsuransi.setText("Master Asuransi");
        mnuMasterAsuransi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMasterAsuransiActionPerformed(evt);
            }
        });
        jMenu1.add(mnuMasterAsuransi);

        mnuMasterPerusahaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/building_icon.jpg"))); // NOI18N
        mnuMasterPerusahaan.setText("Master Perusahaan");
        mnuMasterPerusahaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMasterPerusahaanActionPerformed(evt);
            }
        });
        jMenu1.add(mnuMasterPerusahaan);
        jMenu1.add(jSeparator2);

        mnuKerjaSama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/1641131_shakehand_.jpg"))); // NOI18N
        mnuKerjaSama.setText("Kerja Sama");
        mnuKerjaSama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuKerjaSamaActionPerformed(evt);
            }
        });
        jMenu1.add(mnuKerjaSama);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Utility");

        mnuUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/diseased-icon.png"))); // NOI18N
        mnuUser.setText("User");
        mnuUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUserActionPerformed(evt);
            }
        });
        jMenu5.add(mnuUser);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("View");

        mnuKerjaSamaView.setText("View Kerjasama");
        mnuKerjaSamaView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuKerjaSamaViewActionPerformed(evt);
            }
        });
        jMenu6.add(mnuKerjaSamaView);

        mnuPesan.setText("Pesan");
        mnuPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPesanActionPerformed(evt);
            }
        });
        jMenu6.add(mnuPesan);

        mnuUpdate.setText("Update");
        mnuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUpdateActionPerformed(evt);
            }
        });
        jMenu6.add(mnuUpdate);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Exit");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/logout-icon.png"))); // NOI18N
        jMenuItem4.setText("Keluar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    System.exit(0);
}//GEN-LAST:event_jMenuItem4ActionPerformed

private void mnuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUserActionPerformed
    User user = new User();
    user.setVisible(true);
}//GEN-LAST:event_mnuUserActionPerformed

private void mnuMasterAsuransiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMasterAsuransiActionPerformed
    AsuransiView asuransi = new AsuransiView();
    asuransi.setVisible(true);
}//GEN-LAST:event_mnuMasterAsuransiActionPerformed

private void mnuMasterPerusahaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMasterPerusahaanActionPerformed
    PerusahaanView pers = new PerusahaanView();
    pers.setVisible(true);
}//GEN-LAST:event_mnuMasterPerusahaanActionPerformed

private void mnuKerjaSamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuKerjaSamaActionPerformed
    cariKerjasama cari = new cariKerjasama();
    cari.setVisible(true);

}//GEN-LAST:event_mnuKerjaSamaActionPerformed

    private void mnuKerjaSamaViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuKerjaSamaViewActionPerformed
        // TODO add your handling code here:
        KerjasamaView kerjasamaView = new KerjasamaView();
        kerjasamaView.setVisible(true);

    }//GEN-LAST:event_mnuKerjaSamaViewActionPerformed

    private void mnuPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPesanActionPerformed
      PesanView pesan  = new PesanView();
      pesan.setVisible(true);
    }//GEN-LAST:event_mnuPesanActionPerformed

    private void mnuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUpdateActionPerformed
       UpdateKerjaSama update = new UpdateKerjaSama();
       update.setVisible(true);
    }//GEN-LAST:event_mnuUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem mnuKerjaSama;
    private javax.swing.JMenuItem mnuKerjaSamaView;
    private javax.swing.JMenuItem mnuMasterAsuransi;
    private javax.swing.JMenuItem mnuMasterPerusahaan;
    private javax.swing.JMenuItem mnuPesan;
    private javax.swing.JMenuItem mnuUpdate;
    private javax.swing.JMenuItem mnuUser;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import model.AsuransiModel;
import model.Dtl_KerjasamaModel;
import model.Hdr_KerjasamaModel;
import model.PerusahaanModel;
import model.ReportKerjasamaModel;
import model.ViewDtlModel;
import model.ViewHdrModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

/**
 *
 * @author user
 */
public class cariKerjasama extends javax.swing.JFrame {

    private DefaultTableModel tbl;
    private DefaultTableModel tbldtl;
//SessionFactory session = HibernateUtil.getSessionFactory();
    String tanggal1, tanggal2;

    /**
     * Creates new form cariKerjasama
     */
    public cariKerjasama() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        Calendar cal = Calendar.getInstance();
        Tgl1.setDate(cal.getTime());
        Tgl2.setDate(cal.getTime());
        setLocationRelativeTo(this);
        this.setTitle("Kerja Sama");
        jLabel3.setText(KlsParameter.kelas.getUser());
        // tampilHdr();
    }

    private class CheckBoxCellEditor extends AbstractCellEditor implements TableCellEditor {

        protected JCheckBox checkBox;

        public CheckBoxCellEditor() {
            checkBox = new JCheckBox();
            checkBox.setHorizontalAlignment(SwingConstants.CENTER);
            checkBox.setBackground(Color.white);
        }

        public Component getTableCellEditorComponent(
                JTable table,
                Object value,
                boolean isSelected,
                int row,
                int column) {

            checkBox.setSelected(((Boolean) value).booleanValue());

//            Component c = table.getDefaultRenderer(String.class).getTableCellRendererComponent(table, value, isSelected, false, row, column);
//            if (c != null) {
//                checkBox.setBackground(c.getBackground());
//            }

            return checkBox;
        }

        public Object getCellEditorValue() {
            return Boolean.valueOf(checkBox.isSelected());
        }
    }

    private class CWCheckBoxRenderer extends JCheckBox implements TableCellRenderer {

        Border border = new EmptyBorder(1, 2, 1, 2);

        public CWCheckBoxRenderer() {
            super();
            setOpaque(true);
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            if (value instanceof Boolean) {
                setSelected(((Boolean) value).booleanValue());
                setEnabled(table.isCellEditable(row, column));

                if (isSelected) {
                    setBackground(table.getSelectionBackground());
                    setForeground(table.getSelectionForeground());
                } else {
                    setForeground(table.getForeground());
                    setBackground(table.getBackground());
                }
            } else {
//setSelected(false);
//setEnabled(false);
                return null;
            }

            return this;
        }
    }

    void tampilHdr() {
        SessionFactory session = HibernateUtil.getSessionFactory();
        Session sess = session.openSession();
        tbl = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TblKerjasamaHdr.setModel(tbl);
        tbl.getDataVector().removeAllElements();
        tbl.fireTableDataChanged();
        tbl.addColumn("Id Kerjasama");
        tbl.addColumn("Asuransi");
        tbl.addColumn("Keterangan");
        tbl.addColumn("Tgl Mulai");
        tbl.addColumn("Tgl Selesai");
        TblKerjasamaHdr.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TblKerjasamaHdr.getColumnModel().getColumn(0).setPreferredWidth(30);
        TblKerjasamaHdr.getColumnModel().getColumn(0).setMinWidth(0);
        TblKerjasamaHdr.getColumnModel().getColumn(0).setMaxWidth(0);
        TblKerjasamaHdr.getColumnModel().getColumn(1).setPreferredWidth(400);
        TblKerjasamaHdr.getColumnModel().getColumn(2).setPreferredWidth(300);
        TblKerjasamaHdr.getColumnModel().getColumn(3).setPreferredWidth(100);
        TblKerjasamaHdr.getColumnModel().getColumn(4).setPreferredWidth(100);

        TblKerjasamaHdr.setRowHeight(30);
        SimpleDateFormat sdf;
        SimpleDateFormat d;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = new SimpleDateFormat("dd MMM yyyy");
        Date tg1 = Tgl1.getDate();
        Date tg2 = Tgl2.getDate();
        String tanggal1 = sdf.format(tg1);
        String tanggal2 = sdf.format(tg2);
        String query = " from Hdr_KerjasamaModel hdr inner join hdr.asuransiModel asuransi where  asuransi.nama like '" + TxtCari.getText().trim() + "%' ";
        query = chkTgl.isSelected() ? query + " and hdr.tglSelesai between '" + tanggal1 + "' and  '" + tanggal2 + "'" : query;
        //   query = CmbCari.getSelectedIndex() == 0 ? query + " and hdr.kd_asuransi like '" + TxtCari.getText().trim() + "%'" : query + "and asuransi.nama like '" + TxtCari.getText().trim() + "%'";
        Query q = sess.createQuery(query + " order by asuransi.nama");
        Iterator it = q.iterate();
        while (it.hasNext()) {
            Object[] row = (Object[]) it.next();
            Hdr_KerjasamaModel hdr = (Hdr_KerjasamaModel) row[0];
            AsuransiModel as = (AsuransiModel) row[1];
            Object[] o = new Object[5];
            o[0] = hdr.getId_kerjasama();
            o[1] = as.getNama();
            o[2] = hdr.getKeterangan();
            o[3] = d.format(hdr.getTglMulai());
            o[4] = d.format(hdr.getTglSelesai());
            tbl.addRow(o);
        }

    }

    void tampildtl(String id_kerjasama) {
        SessionFactory session = HibernateUtil.getSessionFactory();
        Session sess = session.openSession();
        tbldtl = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TblKerjasamaDtl.setModel(tbldtl);
        tbldtl.getDataVector().removeAllElements();
        tbldtl.fireTableDataChanged();
        tbldtl.addColumn("Id kerjasamaDtl");
        tbldtl.addColumn("Nama Perusahaan");
        tbldtl.addColumn("Keterangan");
        tbldtl.addColumn("Excess");
        tbldtl.addColumn("Ket Excess");
        tbldtl.addColumn("Vitamin");
        tbldtl.addColumn("Ket Vitamin");
        tbldtl.addColumn("Supplemen");
        tbldtl.addColumn("Ket Supplemen");
        tbldtl.addColumn("RI");
        tbldtl.addColumn("Ket RI");
        tbldtl.addColumn("RJ");
        tbldtl.addColumn("Ket RJ");
        tbldtl.addColumn("Melahirkan");
        tbldtl.addColumn("Ket Melahirkan");
        tbldtl.addColumn("RG");
        tbldtl.addColumn("Ket RG");
        tbldtl.addColumn("Maternity");
        tbldtl.addColumn("Ket Maternity");
        tbldtl.addColumn("MCU");
        tbldtl.addColumn("Ket MCU");
        tbldtl.addColumn("Keterangan");
        tbldtl.addColumn("Aktif");
        tbldtl.addColumn("Syarat");

        TblKerjasamaDtl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TblKerjasamaDtl.getColumnModel().getColumn(0).setPreferredWidth(0);
        TblKerjasamaDtl.getColumnModel().getColumn(0).setMinWidth(0);
        TblKerjasamaDtl.getColumnModel().getColumn(0).setMaxWidth(0);
        TblKerjasamaDtl.getColumnModel().getColumn(1).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(2).setPreferredWidth(100);
        TblKerjasamaDtl.getColumnModel().getColumn(3).setPreferredWidth(30);
        TblKerjasamaDtl.getColumnModel().getColumn(3).setCellEditor(new CheckBoxCellEditor());
        TblKerjasamaDtl.getColumnModel().getColumn(3).setCellRenderer(new CWCheckBoxRenderer());
        TblKerjasamaDtl.getColumnModel().getColumn(4).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(5).setPreferredWidth(30);
        TblKerjasamaDtl.getColumnModel().getColumn(5).setCellEditor(new CheckBoxCellEditor());
        TblKerjasamaDtl.getColumnModel().getColumn(5).setCellRenderer(new CWCheckBoxRenderer());
        TblKerjasamaDtl.getColumnModel().getColumn(6).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(7).setPreferredWidth(30);
        TblKerjasamaDtl.getColumnModel().getColumn(7).setCellEditor(new CheckBoxCellEditor());
        TblKerjasamaDtl.getColumnModel().getColumn(7).setCellRenderer(new CWCheckBoxRenderer());
        TblKerjasamaDtl.getColumnModel().getColumn(8).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(9).setPreferredWidth(30);
        TblKerjasamaDtl.getColumnModel().getColumn(9).setCellEditor(new CheckBoxCellEditor());
        TblKerjasamaDtl.getColumnModel().getColumn(9).setCellRenderer(new CWCheckBoxRenderer());
        TblKerjasamaDtl.getColumnModel().getColumn(10).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(11).setPreferredWidth(30);
        TblKerjasamaDtl.getColumnModel().getColumn(11).setCellEditor(new CheckBoxCellEditor());
        TblKerjasamaDtl.getColumnModel().getColumn(11).setCellRenderer(new CWCheckBoxRenderer());
        TblKerjasamaDtl.getColumnModel().getColumn(12).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(13).setPreferredWidth(30);
        TblKerjasamaDtl.getColumnModel().getColumn(13).setCellEditor(new CheckBoxCellEditor());
        TblKerjasamaDtl.getColumnModel().getColumn(13).setCellRenderer(new CWCheckBoxRenderer());
        TblKerjasamaDtl.getColumnModel().getColumn(14).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(15).setPreferredWidth(30);
        TblKerjasamaDtl.getColumnModel().getColumn(15).setCellEditor(new CheckBoxCellEditor());
        TblKerjasamaDtl.getColumnModel().getColumn(15).setCellRenderer(new CWCheckBoxRenderer());
        TblKerjasamaDtl.getColumnModel().getColumn(16).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(17).setPreferredWidth(30);
        TblKerjasamaDtl.getColumnModel().getColumn(17).setCellEditor(new CheckBoxCellEditor());
        TblKerjasamaDtl.getColumnModel().getColumn(17).setCellRenderer(new CWCheckBoxRenderer());
        TblKerjasamaDtl.getColumnModel().getColumn(18).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(19).setPreferredWidth(30);
        TblKerjasamaDtl.getColumnModel().getColumn(19).setCellEditor(new CheckBoxCellEditor());
        TblKerjasamaDtl.getColumnModel().getColumn(19).setCellRenderer(new CWCheckBoxRenderer());
        TblKerjasamaDtl.getColumnModel().getColumn(20).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(21).setPreferredWidth(150);
        TblKerjasamaDtl.getColumnModel().getColumn(22).setPreferredWidth(30);
        TblKerjasamaDtl.getColumnModel().getColumn(22).setCellEditor(new CheckBoxCellEditor());
        TblKerjasamaDtl.getColumnModel().getColumn(22).setCellRenderer(new CWCheckBoxRenderer());
        TblKerjasamaDtl.getColumnModel().getColumn(23).setPreferredWidth(150);



        /*TblKerjasamaHdr.getColumnModel().getColumn(4).setPreferredWidth(10);
         TblKerjasamaHdr.getColumnModel().getColumn(5).setPreferredWidth(10);
         TblKerjasamaHdr.getColumnModel().getColumn(6).setPreferredWidth(10);*/

        Query d = sess.createQuery(" from Dtl_KerjasamaModel dtl inner join dtl.perusahaanModel pers where dtl.hdr_kerjasama = '" + id_kerjasama.trim() + "' order by pers.nama");
        Iterator it = d.list().iterator();
        while (it.hasNext()) {
            Object[] row = (Object[]) it.next();
            Dtl_KerjasamaModel dtl = (Dtl_KerjasamaModel) row[0];
            PerusahaanModel pers = (PerusahaanModel) row[1];
            Object[] o = new Object[24];
            o[0] = dtl.getId_kerjaSamaDetil();
            o[1] = pers.getNama();
            o[2] = dtl.getKet();
            o[3] = (dtl.getExcess_b() == 1 ? new Boolean(true) : new Boolean(false));
            o[4] = dtl.getExcess_s();
            o[5] = (dtl.getVitamin_b() == 1 ? new Boolean(true) : new Boolean(false));
            o[6] = dtl.getVitamin_s();
            o[7] = (dtl.getSupplemen_b() == 1 ? new Boolean(true) : new Boolean(false));
            o[8] = dtl.getSupplemen_s();
            o[9] = (dtl.getRi_b() == 1 ? new Boolean(true) : new Boolean(false));
            o[10] = dtl.getRi_s();
            o[11] = (dtl.getRj_b() == 1 ? new Boolean(true) : new Boolean(false));
            o[12] = dtl.getRj_s();
            o[13] = (dtl.getMelahirkan_b() == 1 ? new Boolean(true) : new Boolean(false));
            o[14] = dtl.getMelahirkan_s();
            o[15] = (dtl.getRg_b() == 1 ? new Boolean(true) : new Boolean(false));
            o[16] = dtl.getRg_s();
            o[17] = (dtl.getMaternity_b() == 1 ? new Boolean(true) : new Boolean(false));
            o[18] = dtl.getMaternity_s();
            o[19] = (dtl.getMcu_b() == 1 ? new Boolean(true) : new Boolean(false));
            o[20] = dtl.getMcu_s();
            o[21] = dtl.getKet();
            o[22] = (dtl.getAktif().equals(1) ? new Boolean(true) : new Boolean(false));
            o[23] = dtl.getSyarat();


            tbldtl.addRow(o);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TblKerjasamaHdr = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblKerjasamaDtl = new javax.swing.JTable();
        BtnTambahkerjaSama = new javax.swing.JButton();
        BtnUbah = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnKeluar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BtnCari = new javax.swing.JButton();
        BtnTambahDetil = new javax.swing.JButton();
        BtnHapusDtl = new javax.swing.JButton();
        BtnUbahDetil = new javax.swing.JButton();
        Tgl1 = new com.toedter.calendar.JDateChooser();
        Tgl2 = new com.toedter.calendar.JDateChooser();
        chkTgl = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        TxtCari = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BtnCetak = new javax.swing.JButton();
        BtnCetakDetil = new javax.swing.JButton();
        btnLapAsuransi = new javax.swing.JButton();
        btnLapPers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kerja Sama");

        TblKerjasamaHdr.setModel(new javax.swing.table.DefaultTableModel(
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
        TblKerjasamaHdr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblKerjasamaHdrMouseClicked(evt);
            }
        });
        TblKerjasamaHdr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TblKerjasamaHdrKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TblKerjasamaHdr);

        TblKerjasamaDtl.setModel(new javax.swing.table.DefaultTableModel(
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
        TblKerjasamaDtl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TblKerjasamaDtlKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TblKerjasamaDtl);

        BtnTambahkerjaSama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/Actions-list-add-icon.png"))); // NOI18N
        BtnTambahkerjaSama.setText("Tambah Kerja Sama");
        BtnTambahkerjaSama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahkerjaSamaActionPerformed(evt);
            }
        });

        BtnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/edit.png"))); // NOI18N
        BtnUbah.setText("Ubah Kerja Sama");
        BtnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUbahActionPerformed(evt);
            }
        });

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/trash_can.png"))); // NOI18N
        BtnHapus.setText("Hapus");
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/gnome_session_logout.png"))); // NOI18N
        BtnKeluar.setText("Keluar");
        BtnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnKeluar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });

        jLabel2.setText("s/d");

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/Magnifier-icon.png"))); // NOI18N
        BtnCari.setText("Cari");
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });

        BtnTambahDetil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/Actions-list-add-icon.png"))); // NOI18N
        BtnTambahDetil.setText("Tambah Detil");
        BtnTambahDetil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahDetilActionPerformed(evt);
            }
        });

        BtnHapusDtl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/trash_can.png"))); // NOI18N
        BtnHapusDtl.setText("Hapus");
        BtnHapusDtl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusDtlActionPerformed(evt);
            }
        });

        BtnUbahDetil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/write_document.png"))); // NOI18N
        BtnUbahDetil.setText("Ubah Detil");
        BtnUbahDetil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUbahDetilActionPerformed(evt);
            }
        });

        Tgl1.setDateFormatString("dd/MM/yyyy");

        Tgl2.setDateFormatString("dd/MM/yyyy");

        chkTgl.setText("Tanggal");

        jLabel1.setText("Pencarian");

        TxtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCariKeyTyped(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");

        BtnCetak.setText("Cetak");
        BtnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCetakActionPerformed(evt);
            }
        });

        BtnCetakDetil.setText("cetak");
        BtnCetakDetil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCetakDetilActionPerformed(evt);
            }
        });

        btnLapAsuransi.setText("KerjaSama Asuransi Berakhir");
        btnLapAsuransi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapAsuransiActionPerformed(evt);
            }
        });

        btnLapPers.setText("KerjaSama Perusahaan Berakhir");
        btnLapPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapPersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chkTgl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCari))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnTambahDetil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnUbahDetil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnHapusDtl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnCetakDetil, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLapPers, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnTambahkerjaSama)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnUbah)
                                .addGap(18, 18, 18)
                                .addComponent(BtnHapus)
                                .addGap(12, 12, 12)
                                .addComponent(BtnKeluar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLapAsuransi, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(BtnTambahkerjaSama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLapAsuransi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(chkTgl)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnCari)
                        .addComponent(jLabel1)
                        .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnTambahDetil)
                            .addComponent(BtnUbahDetil)
                            .addComponent(BtnHapusDtl)))
                    .addComponent(BtnCetakDetil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLapPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnTambahkerjaSamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahkerjaSamaActionPerformed
        KlsParameter.kelas.setTambahHdr(true);
        KlsParameter.kelas.setTambahDtl(true);
        /*Hdr_KerjasamaView hdr_kerjasama = new Hdr_KerjasamaView();
         hdr_kerjasama.setVisible(true);*/
        KerjaSama kerjasama = new KerjaSama();
        kerjasama.setVisible(true);

    }//GEN-LAST:event_BtnTambahkerjaSamaActionPerformed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampilHdr();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        KlsParameter.kelas.setTambahHdr(true);
        KlsParameter.kelas.setTambahDtl(false);
        KlsParameter.kelas.setIdHdr(tbl.getValueAt(TblKerjasamaHdr.getSelectedRow(), 0).toString());
        /* Hdr_KerjasamaView hdr_kerjasama = new Hdr_KerjasamaView();
         hdr_kerjasama.setVisible(true);*/
        KerjaSama kerjasama = new KerjaSama();
        kerjasama.setVisible(true);
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void TblKerjasamaHdrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblKerjasamaHdrMouseClicked
        tampildtl(tbl.getValueAt(TblKerjasamaHdr.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_TblKerjasamaHdrMouseClicked

    private void TblKerjasamaHdrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TblKerjasamaHdrKeyReleased
        /*
         int jwb = JOptionPane.showConfirmDialog(this, "Apakah data Kerjasama asuransi " +TblKerjasamaHdr.getValueAt(TblKerjasamaHdr.getSelectedRow(), 1) +  " akan di hapus?","Perhatian!", JOptionPane.YES_NO_OPTION);
         if (jwb == 0){
         String idhdr = TblKerjasamaHdr.getValueAt(TblKerjasamaHdr.getSelectedRow(), 0).toString().trim();
         deleteHdr(Integer.parseInt(idhdr));
         //  deleteHdr(Integer.parseInt(id));
         }
         tampilHdr();
         tbldtl.fireTableDataChanged();
         tbldtl.getDataVector().removeAllElements();*/
    }//GEN-LAST:event_TblKerjasamaHdrKeyReleased

    private void BtnTambahDetilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahDetilActionPerformed
        KlsParameter.kelas.setTambahDtl(true);
        KlsParameter.kelas.setTambahHdr(false);
        KlsParameter.kelas.setIdHdr(tbl.getValueAt(TblKerjasamaHdr.getSelectedRow(), 0).toString());
        //      KlsParameter.kelas.setIdDtl(tbl.getValueAt(TblKerjasamaDtl.getSelectedRow(), 0).toString());
        KerjaSama kerjasama = new KerjaSama();
        kerjasama.setVisible(true);
    }//GEN-LAST:event_BtnTambahDetilActionPerformed

    private void TblKerjasamaDtlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TblKerjasamaDtlKeyReleased
        /*      int i = TblKerjasamaDtl.getSelectedRow();
         int jwb = JOptionPane.showConfirmDialog(this,"Data perusahaan " + tbldtl.getValueAt(i, 1) + " akan di hapus?", "Perhatian", JOptionPane.YES_NO_OPTION);
         if(jwb == 0){
         String id = tbldtl.getValueAt(TblKerjasamaDtl.getSelectedRow(), 0).toString();
         deleteDtl(Integer.parseInt(id));
         }else {return;}*/
    }//GEN-LAST:event_TblKerjasamaDtlKeyReleased

    private void BtnUbahDetilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahDetilActionPerformed
        KlsParameter.kelas.setTambahHdr(false);
        KlsParameter.kelas.setTambahDtl(false);
        KlsParameter.kelas.setIdHdr(tbl.getValueAt(TblKerjasamaHdr.getSelectedRow(), 0).toString());
        KlsParameter.kelas.setIdDtl(tbldtl.getValueAt(TblKerjasamaDtl.getSelectedRow(), 0).toString());
        KerjaSama kerjasama = new KerjaSama();
        kerjasama.setVisible(true);

    }//GEN-LAST:event_BtnUbahDetilActionPerformed

    private void BtnHapusDtlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusDtlActionPerformed

        int id = (Integer) TblKerjasamaDtl.getValueAt(TblKerjasamaDtl.getSelectedRow(), 0);
        int hd = TblKerjasamaDtl.getSelectedRow();
        int i = TblKerjasamaHdr.getSelectedRow();
        int jwb = JOptionPane.showConfirmDialog(this, "Apakah data Perusahaan " + (String) tbldtl.getValueAt(hd, 1) + " \n "
                + " untuk kerjasama dengan asuransi " + (String) tbl.getValueAt(i, 1) + " akan dihapus ? ", "Warning!", JOptionPane.YES_NO_OPTION);
        if (jwb == 0) {
            deleteDtl(id);
        } else {
            return;
        }
     //   deleteDtl(id);

    }//GEN-LAST:event_BtnHapusDtlActionPerformed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        int jwb = JOptionPane.showConfirmDialog(this, "Apakah data Kerjasama asuransi " + TblKerjasamaHdr.getValueAt(TblKerjasamaHdr.getSelectedRow(), 1) + " akan di hapus?", "Perhatian!", JOptionPane.YES_NO_OPTION);
        if (jwb == 0) {
            String idhdr = TblKerjasamaHdr.getValueAt(TblKerjasamaHdr.getSelectedRow(), 0).toString().trim();
            deleteHdr(Integer.parseInt(idhdr));
        }
        tampilHdr();
        tbldtl.fireTableDataChanged();
        tbldtl.getDataVector().removeAllElements();
    }//GEN-LAST:event_BtnHapusActionPerformed

private void TxtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCariKeyTyped
    tampilHdr();
}//GEN-LAST:event_TxtCariKeyTyped

    private void BtnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCetakActionPerformed
        // TODO add your handling code here:
        Preview("-");
    }

    private void Preview(String noKerjasama) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String s_query = new String();
        s_query = "from Hdr_KerjasamaModel hdr"
                + " inner join hdr.dtl_kerjasama dt "
                + " inner join hdr.asuransiModel a "
                + " inner join dt.perusahaanModel p ";
        if (!noKerjasama.equals("-")) {
            s_query = s_query + " where hdr.id_kerjasama = '" + noKerjasama + "' ";
        }
        s_query = s_query + " order by a.id_asuransi ";
        //, p.id_perusahaan ";


        Query query = session.createQuery(s_query);

        Iterator iterator = query.iterate();

        List<ReportKerjasamaModel> isilap = new ArrayList<ReportKerjasamaModel>();
        while (iterator.hasNext()) {
            Object objects[] = (Object[]) iterator.next();
            Hdr_KerjasamaModel hdr_KerjasamaModel = (Hdr_KerjasamaModel) objects[0];
            Dtl_KerjasamaModel dtl_KerjasamaModel = (Dtl_KerjasamaModel) objects[1];
            AsuransiModel asuransiModel = (AsuransiModel) objects[3];
            PerusahaanModel perusahaanModel = (PerusahaanModel) objects[2];

            ReportKerjasamaModel kerjasamaModel = new ReportKerjasamaModel();
            kerjasamaModel.setId_kerjaSama(hdr_KerjasamaModel.getId_kerjasama());
            kerjasamaModel.setTglMulaiAsuransi(hdr_KerjasamaModel.getTglMulai());
            kerjasamaModel.setTglSelesaiAsuransi(hdr_KerjasamaModel.getTglSelesai());
            kerjasamaModel.setKeterangan(hdr_KerjasamaModel.getKeterangan().trim());
            kerjasamaModel.setNamaAsuransi(asuransiModel.getNama().trim());
            //   kerjasamaModel.setPengecualian_hdr(hdr_KerjasamaModel.getPengecualian().trim());
            kerjasamaModel.setNamaPerusahaan(perusahaanModel.getNama().trim());
            kerjasamaModel.setTglMulaiPerusahaan(dtl_KerjasamaModel.getTglMulai());
            kerjasamaModel.setTglSelesaiPerusahaan(dtl_KerjasamaModel.getTglSelesai());
            kerjasamaModel.setExcess_b(dtl_KerjasamaModel.getExcess_b() == 1 ? true : false);
            kerjasamaModel.setExcess_s(dtl_KerjasamaModel.getExcess_s().trim());
            kerjasamaModel.setVitamin_b(dtl_KerjasamaModel.getVitamin_b() == 1 ? true : false);
            kerjasamaModel.setVitamin_s(dtl_KerjasamaModel.getVitamin_s());
            kerjasamaModel.setSupplemen_b(dtl_KerjasamaModel.getSupplemen_b() == 1 ? true : false);
            kerjasamaModel.setSupplemen_s(dtl_KerjasamaModel.getSupplemen_s().trim());
            kerjasamaModel.setRj_b(dtl_KerjasamaModel.getRj_b() == 1 ? true : false);
            kerjasamaModel.setRj_s(dtl_KerjasamaModel.getRj_s().trim());
            kerjasamaModel.setRi_b(dtl_KerjasamaModel.getRi_b() == 1 ? true : false);
            kerjasamaModel.setRi_s(dtl_KerjasamaModel.getRi_s().trim());
            kerjasamaModel.setRg_b(dtl_KerjasamaModel.getRg_b() == 1 ? true : false);
            kerjasamaModel.setRg_s(dtl_KerjasamaModel.getRg_s().trim());
            kerjasamaModel.setMelahirkan_b(dtl_KerjasamaModel.getMelahirkan_b() == 1 ? true : false);
            kerjasamaModel.setMelahirkan_s(dtl_KerjasamaModel.getMelahirkan_s().trim());
            kerjasamaModel.setMaternity_b(dtl_KerjasamaModel.getMaternity_b() == 1 ? true : false);
            kerjasamaModel.setMaternity_s(dtl_KerjasamaModel.getMaternity_s().trim());
            kerjasamaModel.setMcu_b(dtl_KerjasamaModel.getMcu_b() == 1 ? true : false);
            kerjasamaModel.setMcu_s(dtl_KerjasamaModel.getMcu_s().trim());
            kerjasamaModel.setAktif_detil(dtl_KerjasamaModel.getAktif());
            kerjasamaModel.setAktif_hdr(hdr_KerjasamaModel.getAktif() == 1 ? true : false);
            kerjasamaModel.setSyarat_hdr(hdr_KerjasamaModel.getSyarat().trim());
            kerjasamaModel.setSyarat_dt(dtl_KerjasamaModel.getSyarat().trim());
            kerjasamaModel.setKet_dt(dtl_KerjasamaModel.getKet().trim());

            isilap.add(kerjasamaModel);

        }
        Map map = new HashMap();

        controller.ReportController.PreviewLap("laporan/LapKsm.jasper", map, isilap, "laporan kerjasama");

    }//GEN-LAST:event_BtnCetakActionPerformed

    private void BtnCetakDetilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCetakDetilActionPerformed
        // TODO add your handling code here:
        Preview((tbl.getValueAt(TblKerjasamaHdr.getSelectedRow(), 0).toString()));
    }//GEN-LAST:event_BtnCetakDetilActionPerformed

    private void btnLapAsuransiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapAsuransiActionPerformed

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        SimpleDateFormat sdf;
        SimpleDateFormat d;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = new SimpleDateFormat("dd MMM yyyy");
        Date tg1 = Tgl1.getDate();
        Date tg2 = Tgl2.getDate();
        String tanggal1 = sdf.format(tg1);
        String tanggal2 = sdf.format(tg2);
        String s_query = new String();
        s_query = "from Hdr_KerjasamaModel hdr "
                + " inner join hdr.asuransiModel a ";

        //  if (!idHdr.equals("-")) {
        s_query = s_query + " where hdr.tglSelesai between '" + tanggal1 + "' and '" + tanggal2 + "' ";
        // }
        s_query = s_query + " order by a.id_asuransi ";
        //, p.id_perusahaan ";


        Query query = session.createQuery(s_query);

        Iterator iterator = query.iterate();

        List<ViewHdrModel> isilap = new ArrayList<ViewHdrModel>();
        while (iterator.hasNext()) {
            Object objects[] = (Object[]) iterator.next();
            //Dtl_KerjasamaModel dtl_KerjasamaModel = (Dtl_KerjasamaModel) objects[0];
            Hdr_KerjasamaModel hdr_KerjasamaModel = (Hdr_KerjasamaModel) objects[0];

            AsuransiModel asuransiModel = (AsuransiModel) objects[1];

            ViewHdrModel kerjasamaModel = new ViewHdrModel();
           // kerjasamaModel.setId_kerjasama(hdr_KerjasamaModel.getId_kerjasama());
            kerjasamaModel.setTglMulai(hdr_KerjasamaModel.getTglMulai());
            kerjasamaModel.setTglSelesai(hdr_KerjasamaModel.getTglSelesai());
            kerjasamaModel.setAsuransiModel(asuransiModel.getNama());
            kerjasamaModel.setAktif(hdr_KerjasamaModel.getAktif() == 1 ? true : false);
         
            isilap.add(kerjasamaModel);

        }

        Map<String, Object> parameter = new HashMap<String, Object>();
        Date tanggal = new Date();
        SimpleDateFormat sdt = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String formattedDate = sdt.format(tanggal);
        String usr = KlsParameter.kelas.getUser() + " " + formattedDate;
        parameter.put("usr", usr);
        controller.ReportController.PreviewLap("laporan/RptAsuransi.jasper", parameter, isilap, "Kerja Sama Asuransi ");


    }//GEN-LAST:event_btnLapAsuransiActionPerformed

    private void btnLapPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapPersActionPerformed
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        SimpleDateFormat sdf;
        SimpleDateFormat d;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = new SimpleDateFormat("dd MMM yyyy");
        Date tg1 = Tgl1.getDate();
        Date tg2 = Tgl2.getDate();
        String tanggal1 = sdf.format(tg1);
        String tanggal2 = sdf.format(tg2);
        String jdl="";
        String s_query = new String();
        s_query = "from Dtl_KerjasamaModel dt "
                + " inner join dt.hdr_kerjasama hdr "
                + " inner join hdr.asuransiModel a "
                + " inner join dt.perusahaanModel p where dt.TglSelesai between  '" + tanggal1 + "' and '" + tanggal2 + "' order by dt.TglSelesai ";
       


        Query query = session.createQuery(s_query);

        Iterator iterator = query.iterate();

        List<ViewDtlModel> isilap = new ArrayList<ViewDtlModel>();
        while (iterator.hasNext()) {
            Object objects[] = (Object[]) iterator.next();
            Dtl_KerjasamaModel dtl_KerjasamaModel = (Dtl_KerjasamaModel) objects[0];
            Hdr_KerjasamaModel hdr_KerjasamaModel = (Hdr_KerjasamaModel) objects[1];
            AsuransiModel asuransiModel = (AsuransiModel) objects[2];
            PerusahaanModel perusahaanModel = (PerusahaanModel) objects[3];

            ViewDtlModel kerjasamaModel = new ViewDtlModel();
           // kerjasamaModel.setId_kerjaSamaDetil(dtl_KerjasamaModel.getId_kerjaSamaDetil());
            kerjasamaModel.setNamaAsuransi(asuransiModel.getNama().trim());
            kerjasamaModel.setNamaPerusahaan(perusahaanModel.getNama().trim());
            kerjasamaModel.setTglMulaiPerusahaan(dtl_KerjasamaModel.getTglMulai());
            kerjasamaModel.setTglSelesaiPerusahaan(dtl_KerjasamaModel.getTglSelesai());
            kerjasamaModel.setAktif_detil(dtl_KerjasamaModel.getAktif());
            jdl ="KERJA SAMA PERUSAHAAN  "  ;
            isilap.add(kerjasamaModel);

        }
      
        Map<String, Object> parameter = new HashMap<String, Object>();
        Date tanggal = new Date();
        SimpleDateFormat sdt = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String formattedDate = sdt.format(tanggal);
        String usr = KlsParameter.kelas.getUser() + " " + formattedDate;
        parameter.put("jdl", jdl);
        parameter.put("usr", usr);
        
        controller.ReportController.PreviewLap("laporan/RptPerusahaan.jasper", parameter , isilap, "Kerja Sama Peserta Asuransi / Perusahaan ");

    }//GEN-LAST:event_btnLapPersActionPerformed
    void deleteHdr(int id) {
        SessionFactory sess = HibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        //  Hdr_KerjasamaModel hdr = (Hdr_KerjasamaModel) session.load(Hdr_KerjasamaModel.class, id);
        Query q = session.createQuery("delete from Dtl_KerjasamaModel dtl where dtl.hdr_kerjasama = '" + id + "'");
        Query c = session.createQuery("delete from Hdr_KerjasamaModel hdr where hdr.id_kerjasama = '" + id + "'");
        Transaction t = session.beginTransaction();
        int resultDtl = q.executeUpdate();
        int resultHdr = c.executeUpdate();
        t.commit();
    }

    void deleteDtl(int id) {
        SessionFactory sess = HibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        Query q = session.createQuery("delete from Dtl_KerjasamaModel dtl where dtl.id_kerjaSamaDetil = '" + id + "'");

        Transaction t = session.beginTransaction();
        int result = q.executeUpdate();
        t.commit();
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
            java.util.logging.Logger.getLogger(cariKerjasama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cariKerjasama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cariKerjasama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cariKerjasama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cariKerjasama().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnCetak;
    private javax.swing.JButton BtnCetakDetil;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnHapusDtl;
    private javax.swing.JButton BtnKeluar;
    private javax.swing.JButton BtnTambahDetil;
    private javax.swing.JButton BtnTambahkerjaSama;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JButton BtnUbahDetil;
    private javax.swing.JTable TblKerjasamaDtl;
    private javax.swing.JTable TblKerjasamaHdr;
    private com.toedter.calendar.JDateChooser Tgl1;
    private com.toedter.calendar.JDateChooser Tgl2;
    private javax.swing.JTextField TxtCari;
    private javax.swing.JButton btnLapAsuransi;
    private javax.swing.JButton btnLapPers;
    private javax.swing.JCheckBox chkTgl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

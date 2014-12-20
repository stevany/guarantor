/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.AsuransiModel;
import model.Dtl_KerjasamaModel;
import model.Hdr_KerjasamaModel;
import model.PerusahaanModel;
import model.ReportKerjasamaModel;
import model.ViewDtlModel;
import model.ViewHdrModel;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author user
 */
public class KerjasamaView extends javax.swing.JFrame {

    /**
     * Creates new form KerjasamaView
     */
    private DefaultTableModel modelTabelAsuransi;

    public KerjasamaView() {
        initComponents();
        KondisiAwal();

    }

    private void KondisiAwal() {
        Calendar cal = Calendar.getInstance();


//        tglMulai.setDate(cal.getTime());
//        tglSelesai.setDate(cal.getTime());

        cmbCariAsuransi.removeAllItems();
        cmbCariAsuransi.addItem("Id");
        cmbCariAsuransi.addItem("Nama");
        cmbCariAsuransi.setSelectedIndex(1);

        CmbCariDetil.removeAllItems();
        CmbCariDetil.addItem("Id");
        CmbCariDetil.addItem("nama");
        CmbCariDetil.setSelectedIndex(1);

        cmbStatus.removeAllItems();
        cmbStatus.addItem("all");
        cmbStatus.addItem("Aktif");
        cmbStatus.addItem("Non Aktif");
        //cmbStatus.setSelectedIndex(1);

        CmbStatusDetil.removeAllItems();
        CmbStatusDetil.addItem("all");
        CmbStatusDetil.addItem("aktif");
        CmbStatusDetil.addItem("non aktif");

        setTabelAsuransi();

        setLocationRelativeTo(this);

    }

    private void setTabelAsuransi() {
        SessionFactory session = HibernateUtil.getSessionFactory();
        Session sess = session.openSession();
        modelTabelAsuransi = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int columnIndex) {
                return getValueAt(0, columnIndex).getClass();
            }

            @Override
            public int getRowCount() {
                return super.getRowCount();
            }

            @Override
            public int getColumnCount() {
                return super.getColumnCount();
            }

            @Override
            public String getColumnName(int column) {
                return super.getColumnName(column);
            }

            @Override
            public Object getValueAt(int row, int column) {
                return super.getValueAt(row, column);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblAsuransi.setModel(modelTabelAsuransi);

        modelTabelAsuransi.getDataVector().removeAllElements();
        modelTabelAsuransi.fireTableDataChanged();

        modelTabelAsuransi.addColumn("Id_Asuransi");
        modelTabelAsuransi.addColumn("Asuransi");
        modelTabelAsuransi.addColumn("Tgl Mulai");
        modelTabelAsuransi.addColumn("Tgl Selesai");
        modelTabelAsuransi.addColumn("Aktif");
        modelTabelAsuransi.addColumn("Keterangan");
        modelTabelAsuransi.addColumn("Syarat");
        modelTabelAsuransi.addColumn(" id ");

        tblAsuransi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblAsuransi.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblAsuransi.getColumnModel().getColumn(0).setMaxWidth(0);
        tblAsuransi.getColumnModel().getColumn(0).setMinWidth(0);
        tblAsuransi.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblAsuransi.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblAsuransi.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblAsuransi.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblAsuransi.getColumnModel().getColumn(5).setPreferredWidth(350);
        tblAsuransi.getColumnModel().getColumn(6).setPreferredWidth(350);
        tblAsuransi.getColumnModel().getColumn(7).setPreferredWidth(0);
        String q = " from Hdr_KerjasamaModel h inner join h.asuransiModel a where ";

        q = cmbCariAsuransi.getSelectedIndex() == 0 ? q + " a.id_asuransi like '" + txtCariAsuransi.getText().trim() + "%' " : q + " a.nama like '%" + txtCariAsuransi.getText().trim() + "%' ";
        switch (cmbStatus.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                q = q + " and h.aktif = 1 ";
                break;
            case 2:
                q = q + " and h.aktif = 0 ";
                break;
        }
//        if ( ChkTglMulai.isSelected()==true ){
//            q = q + " and tglMulai between '" + t +  "' and '' "
//        }
        SimpleDateFormat sdf;
        SimpleDateFormat d;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = new SimpleDateFormat("dd MMM yyyy");
        Query query = sess.createQuery(q);
        Iterator it = query.iterate();
        while (it.hasNext()) {
            Object row[] = (Object[]) it.next();
            Hdr_KerjasamaModel hdr = (Hdr_KerjasamaModel) row[0];
            AsuransiModel as = (AsuransiModel) row[1];
            Object[] o = new Object[8];
            o[0] = hdr.getAsuransiModel().getKd_asuransi();
            o[1] = as.getNama();
            o[2] = d.format(hdr.getTglMulai());
            o[3] = d.format(hdr.getTglSelesai());
            o[4] = (hdr.getAktif()==1  ? "Aktif" : "Non Aktif ");
            o[5] = hdr.getKeterangan().trim();
            o[6] = hdr.getSyarat().trim();
            o[7] = hdr.getId_kerjasama();
            modelTabelAsuransi.addRow(o);
        }


    }

    private void setKerjasamaDetil(Integer idKerjasamaCari) {

        DefaultTableModel TableModelDetil = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TableModelDetil.getDataVector().removeAllElements();
        TableModelDetil.fireTableDataChanged();

        TableModelDetil.addColumn("id Perusahaan");
        TableModelDetil.addColumn("Nama Perusahaan");
        TableModelDetil.addColumn("Tgl Mulai");
        TableModelDetil.addColumn("Tgl Selesai");
        TableModelDetil.addColumn("Status");
        TableModelDetil.addColumn("-id-");
        TableModelDetil.addColumn("-idHdr-");

        tblPerusahaan.setModel(TableModelDetil);
        tblPerusahaan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblPerusahaan.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblPerusahaan.getColumnModel().getColumn(0).setMaxWidth(0);
        tblPerusahaan.getColumnModel().getColumn(0).setMinWidth(0);
        tblPerusahaan.getColumnModel().getColumn(1).setPreferredWidth(700);
        tblPerusahaan.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblPerusahaan.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblPerusahaan.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblPerusahaan.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblPerusahaan.getColumnModel().getColumn(5).setMinWidth(0);
        tblPerusahaan.getColumnModel().getColumn(5).setMaxWidth(0);
        tblPerusahaan.getColumnModel().getColumn(6).setPreferredWidth(0);
        tblPerusahaan.getColumnModel().getColumn(6).setMinWidth(0);
        tblPerusahaan.getColumnModel().getColumn(6).setMaxWidth(0);
        cek_hdr(idKerjasamaCari);
        String queryString = "select p.id_perusahaan, p.nama, d.TglMulai, d.TglSelesai, d.aktif   , d.id_kerjaSamaDetil, d.hdr_kerjasama.id_kerjasama from Dtl_KerjasamaModel d inner join d.perusahaanModel p "
                + " where d.hdr_kerjasama = " + idKerjasamaCari + " ";

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(queryString);
        Iterator iterator = query.iterate();
        SimpleDateFormat sdf;
        SimpleDateFormat d;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = new SimpleDateFormat("dd MMM yyyy");
        while (iterator.hasNext()) {
            Object row[] = (Object[]) iterator.next();
            Object[] objects = new Object[7];
            objects[0] = row[0];
            objects[1] = row[1];
            objects[2] = d.format(row[2]);
            objects[3] = d.format(row[3]);
            objects[4] = (Boolean) row[4] == true ? "Aktif" : "Non Aktif";
            objects[5] = row[5];
            objects[6] = row[6];
//            TableModelDetil.addRow(row);
            TableModelDetil.addRow(objects);
        }
        tblPerusahaan.setModel(TableModelDetil);

    }

    private void setKerjasamaDetil(Integer idKerjasamaCari, String cari) {

        DefaultTableModel TableModelDetil = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TableModelDetil.getDataVector().removeAllElements();
        TableModelDetil.fireTableDataChanged();

        TableModelDetil.addColumn("id Perusahaan");
        TableModelDetil.addColumn("Nama Perusahaan");
        TableModelDetil.addColumn("Tgl Mulai");
        TableModelDetil.addColumn("Tgl Selesai");
        TableModelDetil.addColumn("Status");
        TableModelDetil.addColumn("-id-");
        TableModelDetil.addColumn("-idHdr-");
        tblPerusahaan.setModel(TableModelDetil);
        tblPerusahaan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblPerusahaan.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblPerusahaan.getColumnModel().getColumn(0).setMaxWidth(0);
        tblPerusahaan.getColumnModel().getColumn(0).setMinWidth(0);
        tblPerusahaan.getColumnModel().getColumn(1).setPreferredWidth(700);
        tblPerusahaan.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblPerusahaan.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblPerusahaan.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblPerusahaan.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblPerusahaan.getColumnModel().getColumn(5).setMinWidth(0);
        tblPerusahaan.getColumnModel().getColumn(5).setMaxWidth(0);
        tblPerusahaan.getColumnModel().getColumn(6).setPreferredWidth(0);
        tblPerusahaan.getColumnModel().getColumn(6).setMinWidth(0);
        tblPerusahaan.getColumnModel().getColumn(6).setMaxWidth(0);
        //        String queryString="select p.id_perusahaan, p.nama, d.TglMulai, d.TglSelesai, d.aktif   , d.id_kerjaSamaDetil from Dtl_KerjasamaModel d inner join d.perusahaanModel p " +
//                " where d.hdr_kerjasama = " + idKerjasamaCari + " " ;
        cek_hdr(idKerjasamaCari);
        String queryString = "select p.id_perusahaan, p.nama, d.TglMulai, d.TglSelesai, d.aktif   , d.id_kerjaSamaDetil, d.hdr_kerjasama.id_kerjasama  from Dtl_KerjasamaModel d inner join d.perusahaanModel p "
                + " where ";
        if (CmbCariDetil.getSelectedIndex() == 0) {
            queryString = queryString + "  p.id_perusahaan like '" + TxtCariDetil.getText().trim() + "%' ";
        } else {
            queryString = queryString + "  p.nama like '%" + TxtCariDetil.getText().trim() + "%' ";
        }

        switch (CmbStatusDetil.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                queryString = queryString + " and d.aktif = true ";
                break;
            case 2:
                queryString = queryString + " and d.aktif = false ";
                break;
        }
        if (chkHeader.isSelected()) {
            queryString = queryString + " and d.hdr_kerjasama like '" + idKerjasamaCari + "%' ";
        } else {
            queryString = queryString;
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(queryString);
        Iterator iterator = query.iterate();
        SimpleDateFormat sdf;
        SimpleDateFormat d;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = new SimpleDateFormat("dd MMM yyyy");
        while (iterator.hasNext()) {
            Object row[] = (Object[]) iterator.next();
            Object[] objects = new Object[7];
            objects[0] = row[0];
            objects[1] = row[1];
            objects[2] = d.format(row[2]);
            objects[3] = d.format(row[3]);
            objects[4] = (Boolean) row[4] == true ? "Aktif" : "Non Aktif";
            objects[5] = row[5];
            objects[6] = row[6];
//            TableModelDetil.addRow(row);
            TableModelDetil.addRow(objects);
        }
        tblPerusahaan.setModel(TableModelDetil);

    }

    private void IsiDetil(Integer id_kerjasam_detil_Cari) {
        String queryString = "from Dtl_KerjasamaModel d  "
                + " where d.id_kerjaSamaDetil = " + id_kerjasam_detil_Cari + " ";


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        //Query query = session.createQuery(queryString);     
        //Iterator iterator = query.iterate();
        //Iterator iterator = criteria.list().iterator();

        Criteria criteria = session.createCriteria(Dtl_KerjasamaModel.class, "dtl_kerjasama");
        criteria.createAlias("dtl_kerjasama.perusahaanModel", "perusahaanModel");
        criteria.createAlias("dtl_kerjasama.hdr_kerjasama", "hdr_kerjasama");
        criteria.createAlias("hdr_kerjasama.asuransiModel", "asuransiModel");
        criteria.add(Restrictions.eq("dtl_kerjasama.id_kerjaSamaDetil", id_kerjasam_detil_Cari));
        switch (CmbStatusDetil.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                criteria.add(Restrictions.eq("dtl_kerjasama.aktif", true));
                break;
            case 2:
                criteria.add(Restrictions.eq("dtl_kerjasama.aktif", false));
                break;
        }
        if (CmbCariDetil.getSelectedIndex() == 0) {
            criteria.add(Restrictions.like("perusahaanModel.id_perusahaan", TxtCariDetil.getText().trim() + "%"));
        } else {
            criteria.add(Restrictions.like("perusahaanModel.nama", "%" + TxtCariDetil.getText().trim() + "%"));
        }

        Iterator iterator = criteria.list().iterator();
        if (iterator.hasNext()) {
            Dtl_KerjasamaModel dtl_KerjasamaModel = (Dtl_KerjasamaModel) iterator.next();
//            lblTgl.setText(dtl_KerjasamaModel.getTglMulai().toString() + " s/d " + dtl_KerjasamaModel.getTglSelesai().toString());

            chkExcess.setSelected(dtl_KerjasamaModel.getExcess_b() == 1 ? true : false);
            lblExcess.setText( dtl_KerjasamaModel.getExcess_s().trim());
            if (dtl_KerjasamaModel.getAktif().equals(false)) {
                JOptionPane.showMessageDialog(this, "Kerjasama dengan perusahaan " + dtl_KerjasamaModel.getPerusahaanModel().getNama().trim() + " tidak aktif!");
            }
            cek_hdr(dtl_KerjasamaModel.getHdr_kerjasama().getId_kerjasama());
            chkRJ.setSelected(dtl_KerjasamaModel.getRj_b() == 1 ? true : false);
            lblRJ.setText(dtl_KerjasamaModel.getRj_s().trim());

            chkRI.setSelected(dtl_KerjasamaModel.getRi_b() == 1 ? true : false);
            lblRI.setText(dtl_KerjasamaModel.getRi_s().trim());

            chkRG.setSelected(dtl_KerjasamaModel.getRg_b() == 1 ? true : false);
            lblRG.setText(dtl_KerjasamaModel.getRg_s().trim());

            chkVitamin.setSelected(dtl_KerjasamaModel.getVitamin_b() == 1 ? true : false);
            lblVit.setText(dtl_KerjasamaModel.getVitamin_s().trim());

            chkMelahirkan.setSelected(dtl_KerjasamaModel.getMelahirkan_b() == 1 ? true : false);
            lblMelahirkan.setText(dtl_KerjasamaModel.getMelahirkan_s().trim());

            chkSupplemen.setSelected(dtl_KerjasamaModel.getSupplemen_b() == 1 ? true : false);
            lblSupplemen.setText(dtl_KerjasamaModel.getSupplemen_s().trim());

            chkMaternity.setSelected(dtl_KerjasamaModel.getMaternity_b() == 1 ? true : false);
            lblMaternity.setText(dtl_KerjasamaModel.getMaternity_s().trim());

            chkMCU.setSelected(dtl_KerjasamaModel.getMcu_b() == 1 ? true : false);
            lblMCU.setText(dtl_KerjasamaModel.getMcu_s().trim());

            lblKeterangan.setText(dtl_KerjasamaModel.getKet().trim());
            lblSyarat.setText(dtl_KerjasamaModel.getSyarat().trim());
        }

    }

    void cek_hdr(int idhdr) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Hdr_KerjasamaModel where id_kerjasama = '" + idhdr + "'");
        Iterator iterator = query.iterate();
        if (iterator.hasNext()) {
            Hdr_KerjasamaModel hdr = (Hdr_KerjasamaModel) iterator.next();
            if (hdr.getAktif()==0) {
                JOptionPane.showMessageDialog(this, " Kerjasama dengan asuransi " + hdr.getAsuransiModel().getNama() + " tidak ada");
            }
        }


    }

    private void Preview(String idHdr, String idDtl) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String s_query = new String();
        s_query = "from Dtl_KerjasamaModel dt "
                + " inner join dt.hdr_kerjasama hdr "
                + " inner join hdr.asuransiModel a "
                + " inner join dt.perusahaanModel p ";
        if (!idHdr.equals("-")) {
            s_query = s_query + " where dt.hdr_kerjasama = '" + idHdr + "' and dt.id_kerjaSamaDetil = '" + idDtl + "' ";
        }
        s_query = s_query + " order by a.id_asuransi ";
        //, p.id_perusahaan ";


        Query query = session.createQuery(s_query);

        Iterator iterator = query.iterate();

        List<ReportKerjasamaModel> isilap = new ArrayList<ReportKerjasamaModel>();
        while (iterator.hasNext()) {
            Object objects[] = (Object[]) iterator.next();
            Dtl_KerjasamaModel dtl_KerjasamaModel = (Dtl_KerjasamaModel) objects[0];
            Hdr_KerjasamaModel hdr_KerjasamaModel = (Hdr_KerjasamaModel) objects[1];

            AsuransiModel asuransiModel = (AsuransiModel) objects[2];
            PerusahaanModel perusahaanModel = (PerusahaanModel) objects[3];

            ReportKerjasamaModel kerjasamaModel = new ReportKerjasamaModel();
            kerjasamaModel.setId_kerjaSama(hdr_KerjasamaModel.getId_kerjasama());
            kerjasamaModel.setTglMulaiAsuransi(hdr_KerjasamaModel.getTglMulai());
            kerjasamaModel.setTglSelesaiAsuransi(hdr_KerjasamaModel.getTglSelesai());
            kerjasamaModel.setKeterangan(hdr_KerjasamaModel.getKeterangan().trim());
            kerjasamaModel.setNamaAsuransi(asuransiModel.getNama().trim());
            kerjasamaModel.setPengecualian_hdr(hdr_KerjasamaModel.getPengecualian().trim());
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
            kerjasamaModel.setAktif_hdr(hdr_KerjasamaModel.getAktif()==1 ? true : false);
            kerjasamaModel.setSyarat_hdr(hdr_KerjasamaModel.getSyarat().trim());
            kerjasamaModel.setSyarat_dt(dtl_KerjasamaModel.getSyarat().trim());
            kerjasamaModel.setKet_dt(dtl_KerjasamaModel.getKet().trim());
            kerjasamaModel.setPengecualian_dtl(dtl_KerjasamaModel.getPengecualian().trim());

            isilap.add(kerjasamaModel);

        }
        Map map = new HashMap();

        controller.ReportController.PreviewLap("laporan/LapKerjasama.jasper", map, isilap, "laporan kerjasama");

    }

    private void PreviewHdr(String idHdr) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String s_query = new String();
        s_query = "from Hdr_KerjasamaModel hdr "
                + " inner join hdr.asuransiModel a ";

        //  if (!idHdr.equals("-")) {
        s_query = s_query + " where hdr.id_kerjasama= '" + idHdr + "' ";
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
            kerjasamaModel.setId_kerjasama(hdr_KerjasamaModel.getId_kerjasama());
            kerjasamaModel.setTglMulai(hdr_KerjasamaModel.getTglMulai());
            kerjasamaModel.setTglSelesai(hdr_KerjasamaModel.getTglSelesai());
            kerjasamaModel.setKeterangan(hdr_KerjasamaModel.getKeterangan().trim());
            kerjasamaModel.setAsuransiModel(asuransiModel.getNama());
            kerjasamaModel.setPengecualian(hdr_KerjasamaModel.getPengecualian().trim());
            kerjasamaModel.setAktif(hdr_KerjasamaModel.getAktif()==1 ? true : false);
            kerjasamaModel.setSyarat(hdr_KerjasamaModel.getSyarat().trim());

            isilap.add(kerjasamaModel);

        }

        Map<String, Object> parameter = new HashMap<String, Object>();
        Date tanggal = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String formattedDate = sdf.format(tanggal);
        String usr = KlsParameter.kelas.getUser() + " " + formattedDate;
        parameter.put("usr", usr);
        controller.ReportController.PreviewLap("laporan/RptHdr.jasper", parameter, isilap, "Kerja Sama Asuransi ");

    }
 private void PreviewDtl(String idDtl) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        String jdl="";
        String s_query = new String();
        s_query = "from Dtl_KerjasamaModel dt "
                + " inner join dt.hdr_kerjasama hdr "
                + " inner join hdr.asuransiModel a "
                + " inner join dt.perusahaanModel p where dt.id_kerjaSamaDetil= '" + idDtl + "'  ";
       


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
            kerjasamaModel.setId_kerjaSamaDetil(dtl_KerjasamaModel.getId_kerjaSamaDetil());
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
            kerjasamaModel.setSyarat_dt(dtl_KerjasamaModel.getSyarat().trim());
            kerjasamaModel.setKet_dt(dtl_KerjasamaModel.getKet().trim());
            kerjasamaModel.setPengecualian_dtl(dtl_KerjasamaModel.getPengecualian().trim());
            jdl ="KERJA SAMA ASURANSI  " + asuransiModel.getNama().toUpperCase() ;
            isilap.add(kerjasamaModel);

        }
      
        Map<String, Object> parameter = new HashMap<String, Object>();
        Date tanggal = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String formattedDate = sdf.format(tanggal);
        String usr = KlsParameter.kelas.getUser() + " " + formattedDate;
        parameter.put("jdl", jdl);
        parameter.put("usr", usr);
        
        controller.ReportController.PreviewLap("laporan/RptDtl.jasper", parameter , isilap, "Kerja Sama Peserta Asuransi / Perusahaan ");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbCariAsuransi = new javax.swing.JComboBox();
        txtCariAsuransi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsuransi = new javax.swing.JTable();
        cmdRefresh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        chkMaternity = new javax.swing.JCheckBox();
        chkRI = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        chkExcess = new javax.swing.JCheckBox();
        chkVitamin = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        chkSupplemen = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        chkRJ = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        chkMelahirkan = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        chkRG = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        chkMCU = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblRI = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        lblRJ = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        lblRG = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        lblMaternity = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        lblMelahirkan = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        lblVit = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        lblSupplemen = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        lblMCU = new javax.swing.JTextArea();
        lblKeterangan = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        lblSyarat = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        lblExcess = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPerusahaan = new javax.swing.JTable();
        CmbCariDetil = new javax.swing.JComboBox();
        TxtCariDetil = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CmbStatusDetil = new javax.swing.JComboBox();
        btnCariDtl = new javax.swing.JButton();
        chkHeader = new javax.swing.JCheckBox();
        btnCetak = new javax.swing.JButton();
        btnPers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbCariAsuransi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
        tblAsuransi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsuransiMouseClicked(evt);
            }
        });
        tblAsuransi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblAsuransiKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblAsuransiKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblAsuransi);

        cmdRefresh.setText("Cari");
        cmdRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefreshActionPerformed(evt);
            }
        });

        chkMaternity.setText("Ya");
        chkMaternity.setPreferredSize(new java.awt.Dimension(37, 17));

        chkRI.setText("Ya");
        chkRI.setPreferredSize(new java.awt.Dimension(37, 17));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setText("Excess");

        chkExcess.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        chkExcess.setText("Ya");
        chkExcess.setPreferredSize(new java.awt.Dimension(37, 17));

        chkVitamin.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        chkVitamin.setText("Ya");
        chkVitamin.setPreferredSize(new java.awt.Dimension(37, 17));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setText("Vitamin");

        chkSupplemen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        chkSupplemen.setText("Ya");
        chkSupplemen.setPreferredSize(new java.awt.Dimension(37, 17));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setText("Supplemen");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setText("Rawat Inap");

        chkRJ.setText("Ya");
        chkRJ.setPreferredSize(new java.awt.Dimension(37, 17));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("Rawat Jalan");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setText("Melahirkan");

        chkMelahirkan.setText("Ya");
        chkMelahirkan.setPreferredSize(new java.awt.Dimension(37, 17));
        chkMelahirkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMelahirkanActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setText("Rawat Gigi");

        chkRG.setText("Ya");
        chkRG.setPreferredSize(new java.awt.Dimension(37, 17));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel20.setText("Maternity");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel21.setText("MCU");

        chkMCU.setText("Ya");
        chkMCU.setPreferredSize(new java.awt.Dimension(37, 17));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel22.setText("Keterangan");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel23.setText("Syarat");

        lblRI.setColumns(20);
        lblRI.setRows(5);
        jScrollPane3.setViewportView(lblRI);

        lblRJ.setColumns(20);
        lblRJ.setRows(5);
        jScrollPane4.setViewportView(lblRJ);

        lblRG.setColumns(20);
        lblRG.setRows(5);
        jScrollPane5.setViewportView(lblRG);

        lblMaternity.setColumns(20);
        lblMaternity.setRows(5);
        jScrollPane6.setViewportView(lblMaternity);

        lblMelahirkan.setColumns(20);
        lblMelahirkan.setRows(5);
        jScrollPane8.setViewportView(lblMelahirkan);

        lblVit.setColumns(20);
        lblVit.setRows(5);
        jScrollPane9.setViewportView(lblVit);

        lblSupplemen.setColumns(20);
        lblSupplemen.setRows(5);
        jScrollPane10.setViewportView(lblSupplemen);

        lblMCU.setColumns(20);
        lblMCU.setRows(5);
        jScrollPane11.setViewportView(lblMCU);

        lblSyarat.setColumns(20);
        lblSyarat.setRows(5);
        jScrollPane12.setViewportView(lblSyarat);

        lblExcess.setColumns(20);
        lblExcess.setRows(5);
        jScrollPane13.setViewportView(lblExcess);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblKeterangan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkRI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkRJ, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkRG, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkMelahirkan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkMaternity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkExcess, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkVitamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkSupplemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkMCU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11)))
                    .addComponent(jScrollPane12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {chkExcess, chkMCU, chkMaternity, chkMelahirkan, chkRG, chkRI, chkRJ, chkSupplemen, chkVitamin});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(chkRI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(chkRJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(chkRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(chkMelahirkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(chkMaternity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(chkExcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(chkVitamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(chkSupplemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(chkMCU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Status");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblPerusahaan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPerusahaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPerusahaanMouseClicked(evt);
            }
        });
        tblPerusahaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPerusahaanKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblPerusahaanKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tblPerusahaan);

        CmbCariDetil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Status");

        CmbStatusDetil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCariDtl.setText("Cari");
        btnCariDtl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariDtlActionPerformed(evt);
            }
        });

        btnCetak.setText("Asuransi");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnPers.setText("Perusahaan");
        btnPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCariAsuransi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCariAsuransi, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CmbCariDetil, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtCariDetil, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CmbStatusDetil, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCariDtl, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCetak)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPers))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(680, 680, 680)
                        .addComponent(cmdRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkHeader)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCariAsuransi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCariAsuransi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdRefresh)))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbCariDetil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCariDetil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(CmbStatusDetil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariDtl)
                    .addComponent(btnPers)
                    .addComponent(btnCetak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefreshActionPerformed
        // TODO add your handling code here:
        setTabelAsuransi();
    }//GEN-LAST:event_cmdRefreshActionPerformed

    private void tblAsuransiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsuransiMouseClicked
        // TODO add your handling code here:
        setKerjasamaDetil((Integer) tblAsuransi.getValueAt(tblAsuransi.getSelectedRow(), 7));
        //JOptionPane.showMessageDialog(null, tblAsuransi.getValueAt(tblAsuransi.getSelectedRow() , 7)  );
    }//GEN-LAST:event_tblAsuransiMouseClicked

    private void tblPerusahaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPerusahaanMouseClicked
        // TODO add your handling code here
        IsiDetil((Integer) tblPerusahaan.getValueAt(tblPerusahaan.getSelectedRow(), 5));
        //JOptionPane.showMessageDialog(null, tblPerusahaan.getValueAt(tblPerusahaan.getSelectedRow(), 5) );
    }//GEN-LAST:event_tblPerusahaanMouseClicked

    private void tblAsuransiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAsuransiKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAsuransiKeyTyped

    private void tblPerusahaanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPerusahaanKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPerusahaanKeyTyped

    private void tblAsuransiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAsuransiKeyReleased
        // TODO add your handling code here:
        setKerjasamaDetil((Integer) tblAsuransi.getValueAt(tblAsuransi.getSelectedRow(), 7));

    }//GEN-LAST:event_tblAsuransiKeyReleased

    private void chkMelahirkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMelahirkanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkMelahirkanActionPerformed

    private void tblPerusahaanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPerusahaanKeyReleased
        // TODO add your handling code here:
        IsiDetil((Integer) tblPerusahaan.getValueAt(tblPerusahaan.getSelectedRow(), 5));
    }//GEN-LAST:event_tblPerusahaanKeyReleased

    private void btnCariDtlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariDtlActionPerformed
        // TODO add your handling code here:
        if (chkHeader.isSelected()) {
            setKerjasamaDetil((Integer) tblAsuransi.getValueAt(tblAsuransi.getSelectedRow(), 7), "cari");
        } else {
            setKerjasamaDetil(0, "cari");

        }
    }//GEN-LAST:event_btnCariDtlActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        PreviewHdr(tblPerusahaan.getValueAt(tblPerusahaan.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersActionPerformed
       PreviewDtl(tblPerusahaan.getValueAt(tblPerusahaan.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_btnPersActionPerformed

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
            java.util.logging.Logger.getLogger(KerjasamaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KerjasamaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KerjasamaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KerjasamaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KerjasamaView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CmbCariDetil;
    private javax.swing.JComboBox CmbStatusDetil;
    private javax.swing.JTextField TxtCariDetil;
    private javax.swing.JButton btnCariDtl;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnPers;
    private javax.swing.JCheckBox chkExcess;
    private javax.swing.JCheckBox chkHeader;
    private javax.swing.JCheckBox chkMCU;
    private javax.swing.JCheckBox chkMaternity;
    private javax.swing.JCheckBox chkMelahirkan;
    private javax.swing.JCheckBox chkRG;
    private javax.swing.JCheckBox chkRI;
    private javax.swing.JCheckBox chkRJ;
    private javax.swing.JCheckBox chkSupplemen;
    private javax.swing.JCheckBox chkVitamin;
    private javax.swing.JComboBox cmbCariAsuransi;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JButton cmdRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea lblExcess;
    private javax.swing.JTextField lblKeterangan;
    private javax.swing.JTextArea lblMCU;
    private javax.swing.JTextArea lblMaternity;
    private javax.swing.JTextArea lblMelahirkan;
    private javax.swing.JTextArea lblRG;
    private javax.swing.JTextArea lblRI;
    private javax.swing.JTextArea lblRJ;
    private javax.swing.JTextArea lblSupplemen;
    private javax.swing.JTextArea lblSyarat;
    private javax.swing.JTextArea lblVit;
    private javax.swing.JTable tblAsuransi;
    private javax.swing.JTable tblPerusahaan;
    private javax.swing.JTextField txtCariAsuransi;
    // End of variables declaration//GEN-END:variables
}

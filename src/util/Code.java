/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import java.util.Iterator;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.AsuransiModel;
import model.PerusahaanModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import view.KelasParameter;
import view.KlsParameter;


public class Code {
    int no;
    String nomor;
    String kode;
    public void kosongText(JPanel t){
         for (Component component : t.getComponents()){
	            if (component.getClass().getSimpleName().equalsIgnoreCase("JTextField")){
	                JTextField field = (JTextField) component;
	                field.setText("");
	            }
   }
    }
    public void enableText(JPanel t, boolean e){
         for (Component component : t.getComponents()){
	            if (component.getClass().getSimpleName().equalsIgnoreCase("JTextField")){
	                JTextField field = (JTextField) component;
	                field.setEnabled(e);
	            }
   }
    }
    public void kosongCheckbox(JPanel c){
         for (Component component : c.getComponents()){
	            if (component.getClass().getSimpleName().equalsIgnoreCase("JCheckBox")){
	                JCheckBox check = (JCheckBox) component;
	                check.setSelected(false);
	            }
   }
    }
    public void enableCheckbox(JPanel c, boolean e){
         for (Component component : c.getComponents()){
	            if (component.getClass().getSimpleName().equalsIgnoreCase("JCheckBox")){
	                JCheckBox check = (JCheckBox) component;
	                check.setEnabled(e);
	            }
   }
    }
    
    public void visibleCheckBox(JPanel c, boolean e){
         for (Component component : c.getComponents()){
	            if (component.getClass().getSimpleName().equalsIgnoreCase("JCheckBox")){
	                JCheckBox check = (JCheckBox) component;
	                check.setVisible(e);
	            }
   }
    }
    public void visibleLabel(JPanel c, boolean e){
         for (Component component : c.getComponents()){
	            if (component.getClass().getSimpleName().equalsIgnoreCase("JLabel")){
	                JLabel label = (JLabel) component;
	                label.setVisible(e);
	            }
   }
    }
     public void visibleText(JPanel c, boolean e){
         for (Component component : c.getComponents()){
	            if (component.getClass().getSimpleName().equalsIgnoreCase("JTextField")){
	                JTextField text = (JTextField) component;
	                text.setVisible(e);
	            }
   }
    }
    public void buatKode(String text, int tipe){
        SessionFactory sess = HibernateUtil.getSessionFactory();
        Session session;
        Query q = null;
        Iterator it;
        switch(tipe){
            case 1:
            session = sess.openSession();    
            q = session.createQuery(" from AsuransiModel asuransi where asuransi.kd_asuransi like '" + text.substring(0, 3) + "%' order by asuransi.id_asuransi desc ").setMaxResults(1);
            it = q.list().iterator();
            if(it.hasNext()){
            AsuransiModel as = (AsuransiModel)it.next();
            no = Integer.parseInt(as.getKd_asuransi().substring(4, 7)) + 1;
            nomor = Integer.toString(no);
            kode = "0";
            for(int i = 1; i < 4 - nomor.length(); i++ ){
            
                kode = kode + "0";
            }
            KlsParameter.kelas.setKodeTabel(text.substring(0,3).toUpperCase() + kode + no);
    }else{
            KlsParameter.kelas.setKodeTabel(text.substring(0,3).toUpperCase()+ "0001");
            
    }session.close(); break;
            case 2:
            session = sess.openSession();
            q = session.createQuery(" from PerusahaanModel pers where pers.kd_perusahaan like '" + text.substring(0, 3) + "%' order by pers.id_perusahaan desc ").setMaxResults(1);
            it = q.list().iterator();
            if(it.hasNext()){
                PerusahaanModel pers = (PerusahaanModel)it.next();
                no = Integer.parseInt(pers.getKd_perusahaan().substring(4, 7)) + 1;
                nomor = Integer.toString(no);
                kode = "0";
                for(int i = 1; i < 4 - nomor.length(); i++ ){
            
                    kode = kode + "0";
                 }
                    KlsParameter.kelas.setKodeTabel(text.substring(0,3).toUpperCase() + kode + no);
                }else{
                    KlsParameter.kelas.setKodeTabel(text.substring(0,3).toUpperCase()+ "0001");
   
    }session.close();break;    
        }
    }
}

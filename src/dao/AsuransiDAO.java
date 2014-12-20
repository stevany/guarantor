
package dao;

import java.util.Iterator;
import java.util.List;
import model.AsuransiModel;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import view.AsuransiView;

public class AsuransiDAO {
 SessionFactory session = HibernateUtil.getSessionFactory();
 
 public Session OpenSession(){
     return session.openSession();
 }
 
 public void save (AsuransiModel x){
     Session sess = this.OpenSession();
     Transaction tx = sess.beginTransaction();
     sess.save(x);
     tx.commit();
 }
 public void saveOrUpdate(AsuransiModel x){
     Session sess = this.OpenSession();
     Transaction tx = sess.beginTransaction();
     sess.saveOrUpdate(x);
     tx.commit();
 }
 public List<AsuransiModel> getAll(){
     Session sess = this.OpenSession();  
     Criteria c = sess.createCriteria(AsuransiModel.class).addOrder(Order.asc("id_asuransi"));
     List <AsuransiModel> data = c.list();
     return data;
     
 }
 
 public AsuransiModel takeId(int x){
     Session sess = this.OpenSession();
     return (AsuransiModel) sess.load(AsuransiModel.class, x);
     
 }
 public void deletebyId(int x){
     Session sess = this.OpenSession();
     Transaction t = sess.beginTransaction();
     AsuransiModel mod = (AsuransiModel) this.takeId(x);
     sess.delete(mod);
     t.commit();
 }
 public List<AsuransiModel> getNama(String carinama){
     Session sess = this.OpenSession();
    
     Query q = sess.createQuery(" from AsuransiModel where  nama like  '" + carinama.trim() + "%' ");
     List<AsuransiModel> data = q.list();
     return data;
     
 }
 public List<AsuransiModel> getKode(String kode){
     Session sess = this.OpenSession();
     Criteria c = sess.createCriteria(AsuransiModel.class).add(Restrictions.like("kd_asuransi", "%" +  kode.trim() + ""));
     List<AsuransiModel> data = c.list();
     return data;
 }
 public List<AsuransiModel> getCritNama(String carinama, String carikota){
     Session sess = this.OpenSession();
     List c = sess.createCriteria(AsuransiModel.class)
             .add(Restrictions.like("nama", carinama.trim() + "%" ))
             .add(Restrictions.eq("kota", carikota.trim()))
             .list() ;
     return c;
             
     
 }
 
}

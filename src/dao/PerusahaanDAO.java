
package dao;
import java.util.List;
import model.PerusahaanModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
public class PerusahaanDAO {
    SessionFactory session = HibernateUtil.getSessionFactory();
    
   public Session OpenSession(){
       return session.openSession();
   }
   public void save (PerusahaanModel p){
       Session sess = this.OpenSession();
       Transaction tp = sess.beginTransaction();
       sess.save(p);
       tp.commit();
   }
   public void saveOrUpdate(PerusahaanModel p){
       Session sess = this.OpenSession();
       Transaction tp = sess.beginTransaction();
       sess.saveOrUpdate(p);
       tp.commit();
   }
   public PerusahaanModel takeId(int x){
       Session sess = this.OpenSession();
       return (PerusahaanModel) sess.load(PerusahaanModel.class, x);
       
   }
   public List <PerusahaanModel> getAll(){
       Session sess = this.OpenSession();
       Criteria c = sess.createCriteria(PerusahaanModel.class).addOrder(Order.asc("kd_perusahaan"));
       List <PerusahaanModel> data = c.list();
       
       return data;
   }
   public List<PerusahaanModel> getNama(String nama){
       Session sess = this.OpenSession();
       List c = sess.createCriteria(PerusahaanModel.class).add(Restrictions.like("nama",  "" + nama.trim() + "%" )).list();
       return c;
   }
   public List<PerusahaanModel> getKode(String kode){
       Session sess = this.OpenSession();
       Criteria c = sess.createCriteria(PerusahaanModel.class).add(Restrictions.like("kd_perusahaan",   "" + kode.trim() + "%" ));
       List<PerusahaanModel> data = c.list();
       return data;
   }
   public void deletebyId(int x){
       Session sess = this.OpenSession();
       Transaction t = sess.beginTransaction();
       PerusahaanModel pers = (PerusahaanModel) this.takeId(x);
       sess.delete(pers);
       t.commit();
       
   }
}

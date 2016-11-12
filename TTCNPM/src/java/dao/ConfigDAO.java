package dao;

import entity.Config;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

@Transactional(rollbackFor = Exception.class)
public class ConfigDAO {
    private static final String TABLE = "cau_hinh";
    
    public Config getConfig() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where id = 1");
        Config config = (Config) query.uniqueResult();
        
        transaction.commit();
        return config;
    }
    
    public void updateConfig(Config config){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.update(config);
        transaction.commit();
    }
}

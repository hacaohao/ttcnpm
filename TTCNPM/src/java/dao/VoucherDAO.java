package dao;

import entity.Voucher;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

@Transactional(rollbackFor = Exception.class)
public class VoucherDAO {
    private static final String TABLE = "ma_giam_gia";
    
    public ArrayList<Voucher> getAllVoucher() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE);
        ArrayList<Voucher> list = (ArrayList<Voucher>) query.list();
        
        transaction.commit();
        return list;
    }
    
    public int getVoucherValue(String code){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("select gia_tri from " + TABLE + " where ma_giam_gia = :code");
        query.setString("code", code);
        transaction.commit();
        
        int value = (int) query.uniqueResult();
        return value;
    }
    
    public void deleteVoucher(String code){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where ma_giam_gia = :code");
        query.setString("code", code);
        
        Voucher voucher = (Voucher) query.uniqueResult();
        session.delete(voucher);
        transaction.commit();
    }
    
    public void addVoucher(Voucher voucher){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(voucher);
        transaction.commit();
    }
    
    public String createCode(){
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }
}

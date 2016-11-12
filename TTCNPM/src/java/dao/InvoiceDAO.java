package dao;

import constant.ConfigParameter;
import entity.Invoice;
import util.StringUtil;
import java.util.ArrayList;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

@Transactional(rollbackFor = Exception.class)
public class InvoiceDAO {
    private static final String TABLE = "don_hang";
    private static final String CODE_PREFIX = "DH";
    private static final int CODE_LENGTH = 10;
    
    public ArrayList<Invoice> getAllInvoice(int page){
        int numOfBookPerPages = ConfigParameter.NUM_OF_LINE_PER_PAGE;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE);
        query.setFirstResult((page - 1) * numOfBookPerPages);
        query.setMaxResults(numOfBookPerPages);
        
        ArrayList<Invoice> list = (ArrayList<Invoice>) query.list();
        transaction.commit();
        
        return list;
    }
   
    public ArrayList<Invoice> getAllInvoiceByUserName(int page, String userName){
        int numOfBookPerPages = ConfigParameter.NUM_OF_LINE_PER_PAGE;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where ho_ten_nguoi_mua = :userName");
        query.setString("userName", userName);
        query.setFirstResult((page - 1) * numOfBookPerPages);
        query.setMaxResults(numOfBookPerPages);
        
        ArrayList<Invoice> list = (ArrayList<Invoice>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public Invoice getInvoiceByID(int invoiceID){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where id = :id");
        query.setInteger("id", invoiceID);
        
        Invoice invoice = (Invoice) query.uniqueResult();
        if(invoice != null) Hibernate.initialize(invoice.getInvoiceItems()); 
        
        transaction.commit();
        return invoice;
    }
    
    public void deleteInvoice(Invoice invoice){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.delete(invoice);
        transaction.commit();
    }
    
    public void insertInvoice(Invoice invoice){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(invoice);
        transaction.commit();
    }
    
    public void updateInvoice(Invoice invoice){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.update(invoice);
        transaction.commit();
    }
    
    public String createCode(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("select max(id) from " + TABLE);
        
        Object result = query.uniqueResult();
        transaction.commit();
        
        int maxId = 0;
        if(result != null){
            maxId = (int) result;
        }    
        
        return StringUtil.createCode(CODE_PREFIX, maxId + 1, CODE_LENGTH);
    }
}

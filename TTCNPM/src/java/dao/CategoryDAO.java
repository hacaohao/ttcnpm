package dao;

import entity.Category;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

@Transactional(rollbackFor = Exception.class)
public class CategoryDAO {
    private static final String TABLE = "the_loai_sach";
    
    public ArrayList<Category> getAllCategory() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE);
        ArrayList<Category> list = (ArrayList<Category>) query.list();
        
        transaction.commit();
        return list;
    }
    
    public ArrayList<Category> getAllCategoryByName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where ten_the_loai_sach like %:name%");
        query.setString("name", name);
        ArrayList<Category> list = (ArrayList<Category>) query.list();
        
        transaction.commit();
        return list;
    }
    
    public void addCategory(Category category){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(category);
        transaction.commit();
    }
    
    public void deleteCategory(int categoryID){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where id = :id");
        query.setInteger("id", categoryID);
        Category category = (Category) query.uniqueResult();
        session.delete(category);
        
        transaction.commit();
    }
    
    public void updateCategory(Category category){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.update(category);
        transaction.commit();
    }
    
    public boolean checkUniqueName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where ten_the_loai_sach = :name");
        query.setString("name", name);
        
        Category category = (Category) query.uniqueResult();
        transaction.commit();
        
        return category != null;
    }
}

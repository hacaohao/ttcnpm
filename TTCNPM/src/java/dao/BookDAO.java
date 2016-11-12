package dao;

import constant.ConfigParameter;
import entity.Book;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

@Transactional(rollbackFor = Exception.class)
public class BookDAO {
    private static final String TABLE = "sach";
    
    public ArrayList<Book> getAllBook(int page){
        int numOfBookPerPages = ConfigParameter.NUM_OF_LINE_PER_PAGE;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE);
        query.setFirstResult((page - 1) * numOfBookPerPages);
        query.setMaxResults(numOfBookPerPages);
        
        ArrayList<Book> list = (ArrayList<Book>) query.list();
        transaction.commit();
        
        return list;
    }
   
    public ArrayList<Book> getAllBookByCategoryID(int categoryID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where the_loai_sach_id = :categoryID");
        query.setInteger("categoryID", categoryID);
        
        ArrayList<Book> list = (ArrayList<Book>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public ArrayList<Book> getLimitedBookByCategoryID(int categoryID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where the_loai_sach_id = :categoryID");
        query.setInteger("categoryID", categoryID);
        query.setMaxResults(ConfigParameter.NUM_OF_BOOKS_PER_CATEGORY_ON_INDEX);
        
        ArrayList<Book> list = (ArrayList<Book>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public ArrayList<Book> getRelativeBook(int categoryID , int bookID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where the_loai_sach_id = :categoryID and id != :bookID");
        query.setInteger("categoryID", categoryID);
        query.setInteger("bookID", bookID);
        query.setMaxResults(4);
        
        ArrayList<Book> list = (ArrayList<Book>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public ArrayList<Book> getAllBookByName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where ten_sach like \'%" + name + "%\'");
        
        ArrayList<Book> list = (ArrayList<Book>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public ArrayList<Book> getLimitedBestSeller(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " order by so_nguoi_mua desc");
        query.setMaxResults(ConfigParameter.NUM_OF_BEST_SELLER);
        
        ArrayList<Book> list = (ArrayList<Book>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public ArrayList<Book> getAllBestSeller(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " order by so_nguoi_mua desc");
        query.setMaxResults(ConfigParameter.NUM_OF_LINE_PER_PAGE);
        
        ArrayList<Book> list = (ArrayList<Book>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public Book getBookByID(int bookID){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where id = :id");
        query.setInteger("id", bookID);
        
        Book book = (Book) query.uniqueResult();
        transaction.commit();
        return book;
    }
    
    public void addBook(Book book){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(book);
        transaction.commit();
    }
    
    public void deleteBook(Book book){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.delete(book);
        transaction.commit();
    }
    
    public void updateBook(Book book){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.update(book);
        transaction.commit();
    }
    
    public boolean checkUniqueName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where ten_sach = :name");
        query.setString("name", name);
        
        Book book = (Book) query.uniqueResult();
        transaction.commit();
        return book != null;
    }
    
    public Book updatePoint(Book book, int ratePoint){ 
        int oldRater = book.getRater();
        double oldTotalPoint = book.getPoint() * oldRater;
        
        int newRater = oldRater + 1;
        double newPoint = (oldTotalPoint + ratePoint)/newRater;
        
        book.setPoint(newPoint);
        book.setRater(newRater);
        
        return book;
    }
}

package dao;

import entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import util.EncodeUtil;
import util.HibernateUtil;
import util.StringUtil;

@Transactional(rollbackFor = Exception.class)
public class UserDAO {
    private static final String TABLE = "user";
    private static final int ADMIN_ROLE = 1;
    private static final int BUSINESS_EMPLOYEE_ROLE = 2;
    private static final int SECRETARY_EMPLOYEE_ROLE = 3;
    private static final int MEMBER_ROLE = 4;
    
    
    public void addUser(User user){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(user);
        transaction.commit();
    }
    
    public void deleteUser(User user){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.delete(user);
        transaction.commit();
    }
    
    public void updateUser(User user){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.update(user);
        transaction.commit();
    }
    
    public boolean checkUniqueEmail(String email){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where email = :email");
        query.setString("email", email);
        
        User user = (User) query.uniqueResult();
        transaction.commit();
        
        return user == null;
    }
    
    public void updatePassword(String email){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where email = :email");
        query.setString("email", email);
        
        User user = (User) query.uniqueResult();
        transaction.commit();
        
        String newPassword = StringUtil.newPassword();
        user.setPassword(newPassword);
        
        updateUser(user);
    }
    
    public User checkAccount(String email, String password){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        String newPassword = EncodeUtil.md5Formatter(password);
        
        Query query = (Query) session.createQuery("from " + TABLE + " where email = :email and password = :password");
        query.setString("email", email);
        query.setString("password", newPassword);
        
        User user = (User) query.uniqueResult();
        transaction.commit();
        
        if(user != null){
            if(user.getRole() == MEMBER_ROLE){
                Hibernate.initialize(user.getMember());
            }else{
                Hibernate.initialize(user.getEmployee());
            }
        }
                
        return user;
    }
}

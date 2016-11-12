package dao;

import constant.ConfigParameter;
import entity.Employee;
import util.StringUtil;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EmployeeDAO {
    private static final String TABLE = "nhan_vien";
    private static final String CODE_PREFIX = "NV";
    private static final int CODE_LENGTH = 7;
    
    public ArrayList<Employee> getAllEmployee(int page) {
        int numOfBookPerPages = ConfigParameter.NUM_OF_LINE_PER_PAGE;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from nhan_vien");
        query.setFirstResult((page - 1) * numOfBookPerPages);
        query.setMaxResults(numOfBookPerPages);
        
        ArrayList<Employee> list = (ArrayList<Employee>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public ArrayList<Employee> getAllEmployeeByName(int page, String name){
        int numOfBookPerPages = ConfigParameter.NUM_OF_LINE_PER_PAGE;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from nhan_vien where ten_nhan_vien like %:name%");
        query.setString("name", name);
        query.setFirstResult((page - 1) * numOfBookPerPages);
        query.setMaxResults(numOfBookPerPages);
        
        ArrayList<Employee> list = (ArrayList<Employee>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public Employee getEmployeeByID(int employeeID){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from nhan_vien where id = :id");
        query.setInteger("id", employeeID);
        
        Employee employee = (Employee) query.uniqueResult();
        transaction.commit();
        return employee;
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

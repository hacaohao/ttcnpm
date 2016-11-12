package dao;

import constant.ConfigParameter;
import entity.Member;
import util.StringUtil;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MemberDAO {
    private static final String TABLE = "thanh_vien";
    private static final String CODE_PREFIX = "TV";
    private static final int CODE_LENGTH = 8;
    
    public ArrayList<Member> getAllMember(int page) {
        int numOfBookPerPages = ConfigParameter.NUM_OF_LINE_PER_PAGE;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE);
        query.setFirstResult((page - 1) * numOfBookPerPages);
        query.setMaxResults(numOfBookPerPages);
        
        ArrayList<Member> list = (ArrayList<Member>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public ArrayList<Member> getAllMemberByName(int page, String name){
        int numOfBookPerPages = ConfigParameter.NUM_OF_LINE_PER_PAGE;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where ten_thanh_vien like %:name%");
        query.setString("name", name);
        query.setFirstResult((page - 1) * numOfBookPerPages);
        query.setMaxResults(numOfBookPerPages);
        
        ArrayList<Member> list = (ArrayList<Member>) query.list();
        transaction.commit();
        
        return list;
    }
    
    public Member getMemberByID(int memberID){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where id = :id");
        query.setInteger("id", memberID);
        
        Member member = (Member) query.uniqueResult();
        transaction.commit();
        return member;
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
    
    public void updateMember(Member member){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.update(member);
        transaction.commit();
    }
    
    public Member updatePoint(Member member, int invoiceValue){
        int point = member.getPoint() + (int)(invoiceValue / 10000);
        member.setPoint(point);
        
        return member;
    }
    
    public Member updateTotalPoint(Member member, int invoiceValue){
        long totalPoint = member.getTotalPoint() + (int)(invoiceValue / 10000);
        member.setTotalPoint(totalPoint);
        
        return member;
    }
}

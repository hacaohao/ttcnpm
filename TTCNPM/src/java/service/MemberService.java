package service;

import dao.MemberDAO;
import entity.Member;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberService {
    
    @Autowired
    MemberDAO memberDAO;
    
    public ArrayList<Member> getAllMember(int page) {
        return memberDAO.getAllMember(page);
    }
    
    public ArrayList<Member> getAllMemberByName(int page, String name){
        return memberDAO.getAllMemberByName(page, name);
    }
    
    public Member getMemberByID(int memberID){
        return memberDAO.getMemberByID(memberID);
    }
    
    public String createCode(){
        return memberDAO.createCode();
    }
    
    public void updateMember(Member member){
        memberDAO.updateMember(member);
    }
    
    public Member updatePoint(Member member, int invoiceValue){
        return memberDAO.updatePoint(member, invoiceValue);
    }
    
    public Member updateTotalPoint(Member member, int point){
        return memberDAO.updateTotalPoint(member, point);
    }
}

package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name = "user")
public class User implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "mat_khau")
    private String password;
    
    @Column(name = "chuc_vu")
    private int role;
    
    @Column(name = "cap_nhat_mat_khau_ngay")
    private Date updatedPasswordAt;
    
    @OneToOne
    @Cascade({CascadeType.ALL})
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @Cascade({CascadeType.ALL})
    @JoinColumn(name = "employee_id")
    private Employee employee;
            
    public User() {
    }

    public User(int id, String email, String password, int role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUpdatedPasswordAt() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        return sdf.format(updatedPasswordAt);
    }

    public void setUpdatedPasswordAt(Date updatedPasswordAt) {
        this.updatedPasswordAt = updatedPasswordAt;
    }
   
}

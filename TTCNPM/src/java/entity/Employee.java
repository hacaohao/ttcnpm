package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "nhan_vien")
public class Employee implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "ma_nhan_vien")
    private String code;
    
    @Column(name = "ten_nhan_vien")
    private String name;
    
    @Column(name = "so_dien_thoai")
    private String phone;
    
    @Column(name = "ngay_sinh")
    private Date DoB;
    
    @Column(name = "gioi_tinh")
    private boolean sex;
    
    @Column(name = "ngay_gia_nhap")
    private Date createdAt;
    
    @Column(name = "ngan_hang_chuyen_khoan")
    private String bank;
    
    @Column(name = "so_tai_khoan_chuyen_khoan")
    private String bankAccount;
    
    @Column(name = "anh_dai_dien")
    private String avatar;

    public Employee() {
    }

    public Employee(int id, String code, String name, String phone, Date DoB, boolean sex, Date createdAt, String bank, String bankAccount, String avatar) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.DoB = DoB;
        this.sex = sex;
        this.createdAt = createdAt;
        this.bank = bank;
        this.bankAccount = bankAccount;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "ngay_sinh")
    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date DoB) {
        this.DoB = DoB;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}

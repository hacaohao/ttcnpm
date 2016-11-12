package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "thanh_vien")
public class Member implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "ma_thanh_vien")
    private String code;
    
    @Column(name = "ten_thanh_vien")
    private String name;
    
    @Column(name = "so_dien_thoai")
    private String phone;
    
    @Column(name = "ngay_sinh")
    private Date DoB;
    
    @Column(name = "gioi_tinh")
    private boolean sex;
    
    @Column(name = "ngay_dang_ki")
    private Date createdAt;
    
    @Column(name = "diem")
    private int point;
    
    @Column(name = "tong_diem")
    private long totalPoint;
    
    @Column(name = "anh_dai_dien")
    private String avatar;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "thanh_vien_id")
    private List<CartItem> cartItems;

    public Member() {
    }

    public Member(int id, String code, String name, String phone, Date DoB, boolean sex, Date createdAt, int point, long totalPoint, String avatar) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.DoB = DoB;
        this.sex = sex;
        this.createdAt = createdAt;
        this.point = point;
        this.totalPoint = totalPoint;
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
    public Date getDoB(){
        return this.DoB;
    }
    
    public String getStringDoB() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        return sdf.format(DoB);
    }
    
    public String getInputDoB() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        return sdf.format(DoB);
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

    public String getCreatedAt() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        return sdf.format(createdAt);
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public long getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(long totalPoint) {
        this.totalPoint = totalPoint;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ArrayList<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    
}

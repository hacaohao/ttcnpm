package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name = "don_hang")
public class Invoice implements Serializable {
    public static final int WAITING = 0;
    public static final int ACCEPTED = 1;
    public static final int OK = 2;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "ma_don_hang")
    private String code;
    
    @Column(name = "ho_ten_nguoi_mua")
    private String customerName;
    
    @Column(name = "so_dien_thoai")
    private String customerPhone;
    
    @Column(name = "dia_chi")
    private String customerAddress;
    
    @Column(name = "email")
    private String customerEmail;
    
    @Column(name = "ngay_dat_hang")
    private Date boughtAt;
    
    @Column(name = "ngay_giao_hang")
    private Date deliveredAt;
    
    @Column(name = "hinh_thuc_thanh_toan")
    private boolean payment;
    
    @Column(name = "trang_thai")
    private int stage;
    
    @OneToMany
    @JoinColumn(name = "don_hang_id")
    @Cascade({CascadeType.ALL})
    private List<InvoiceItem> invoiceItems;

    public Invoice() {
    }

    public Invoice(int id, String code, String customerName, String customerPhone, String customerAddress, String customerEmail, Date boughtAt, boolean payment, int stage) {
        this.id = id;
        this.code = code;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.boughtAt = boughtAt;
        this.payment = payment;
        this.stage = stage;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getBoughtAt() {
        return boughtAt;
    }
    
    public String getStringBoughtAt(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        return sdf.format(boughtAt);
    }

    public void setBoughtAt(Date boughtAt) {
        this.boughtAt = boughtAt;
    }

    public boolean getPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public Date getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(Date deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }
      
    public long getTotalPrice(){
        long totalPrice = 0;
        
        for(InvoiceItem item : invoiceItems){
            totalPrice += item.getPrice() * item.getQuantity();
        }
        
        return totalPrice;
    }
}

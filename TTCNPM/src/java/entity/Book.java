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
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity(name = "sach")
public class Book implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "ten_sach")
    private String name;
    
    @Column(name = "tac_gia")
    private String writer;
    
    @Column(name = "ngon_ngu")
    private String language;
    
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message="Số lượng phải là số dương")
    @Column(name = "so_luong")
    private int quantity;
    
    @Min(value=0, message = "Giá phải là số dương")
    @Column(name = "gia")
    private int price;
    
    @Column(name = "tom_tat")
    private String description;
    
    @Column(name = "bia_sach")
    private String image;
    
    @Column(name = "ngay_phat_hanh")
    private Date publishDay;
    
    @Column(name = "nha_xuat_ban")
    private String publisher;
    
    @Column(name = "nha_phat_hanh")
    private String contributor;
    
    @Column(name = "kich_thuoc")
    private String size;
    
    @Column(name = "dinh_dang")
    private String format;
    
    @Column(name = "khoi_luong")
    private int weight;
    
    @Column(name = "so_trang")
    private int page;
    
    @Column(name = "danh_gia")
    private double point;
    
    @Column(name = "so_nguoi_danh_gia")
    private int rater;
    
    @Column(name = "so_nguoi_mua")
    private int numOfCustomer;
    
    @Column(name = "giam_gia")
    private int discount;
    
    @Column(name = "alias")
    private String alias;
    
    @ManyToOne
    @JoinColumn(name = "the_loai_sach_id")
    private Category category;

    public Book() {
    }

    public Book(int id, String name, String writer, String language, int quantity, int price, String description, String image, Date publishDay, String publisher, int page, double point, int numOfCustomer, int discount, String alias) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.language = language;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.image = image;
        this.publishDay = publishDay;
        this.publisher = publisher;
        this.page = page;
        this.point = point;
        this.numOfCustomer = numOfCustomer;
        this.discount = discount;
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublishDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        return sdf.format(publishDay);
    }

    public void setPublishDay(Date publishDay) {
        this.publishDay = publishDay;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public int getNumOfCustomer() {
        return numOfCustomer;
    }

    public void setNumOfCustomer(int numOfCustomer) {
        this.numOfCustomer = numOfCustomer;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getRater() {
        return rater;
    }

    public void setRater(int rater) {
        this.rater = rater;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
 
    public int getSalePrice(){
        return (int) Math.ceil(price * (100 - discount) / 100);
    }
    
    public int getSavedPrice(){
        return (int) Math.ceil(price * discount / 100);
    }
}

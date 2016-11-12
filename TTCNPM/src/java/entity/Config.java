package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "cau_hinh")
public class Config implements Serializable {
    
    private int id;
    private String facebook;
    private String ggmap;
    private String address;
    private String email;

    public Config() {
    }

    public Config(int id, String facebook, String ggmap, String address, String email) {
        this.id = id;
        this.facebook = facebook;
        this.ggmap = ggmap;
        this.address = address;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getGgmap() {
        return ggmap;
    }

    public void setGgmap(String ggmap) {
        this.ggmap = ggmap;
    }

    @Column(name = "dia_chi")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

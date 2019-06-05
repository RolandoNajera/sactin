package mx.globaltade.products.sactin.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "profiles")
public class Profile {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    private String name;

    private String mail;

    private String phone;

    private String address;

    private String createAt;

    public Profile() {
        super();
    }

    public Profile(Long key, String name, String mail, String phone, String address, String createAt) {
        this.key = key;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @PrePersist
    public void prePersis() {
        this.createAt = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    @Override
    public String toString() {
        return "Profile{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}

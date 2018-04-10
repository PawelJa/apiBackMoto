package pl.motoevent.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String firstName;

    private String lastName;

    private String adress;

    private String city;

    private String postcode;

    private String motorbike;

    private String avatar;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(String motorbike) {
        this.motorbike = motorbike;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public UserDetails(Long id) {
        this.setUserId(id);
    }

    public UserDetails() {

    }
}


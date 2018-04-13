package pl.motoevent.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min= 4)
    @Column(unique = true)
    private String username;

    @NotEmpty
    @Size(min=4)
    private String password;

    private String email;

    private boolean isActive;

    @OneToOne
    private UserDetails userDetails = new UserDetails();

    @OneToOne
    private UserModDetails userModDetails = new UserModDetails();

    @OneToOne
    private UserRole userRole = new UserRole();

    @ManyToMany(mappedBy = "users")
    private List<Event> events = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userProfile) {
        this.userDetails = userProfile;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }


    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserModDetails getUserModDetails() {
        return userModDetails;
    }

    public void setUserModDetails(UserModDetails userModDetails) {
        this.userModDetails = userModDetails;
    }

    public User() {
        this.isActive = true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userDetails=" + userDetails +
                ", userRole=" + userRole +
                ", events=" + events +
                '}';
    }
}

package pl.motoevent.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_mod_details")
public class UserModDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String firstName;

    private String lastName;

    private String companyName;

    private String companyAddress;

    private String companyPostcode;

    private String companyCity;

    private String NIP;

}

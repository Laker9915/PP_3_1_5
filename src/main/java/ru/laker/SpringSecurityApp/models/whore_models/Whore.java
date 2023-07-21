package ru.laker.SpringSecurityApp.models.whore_models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "whore")
public class Whore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "whore_address",
            joinColumns = @JoinColumn(name = "whore_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addressList;

    @ManyToMany
    @JoinTable(
            name = "whore_phone",
            joinColumns = @JoinColumn(name = "whore_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id")
    )
    private List<Phone> phones;

     // Конструкторы, геттеры и сеттеры

    public Whore() {
    }

    public Whore(String firstName, String lastName, List<Address> addressList, List<Phone> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressList = addressList;
        this.phones = phones;
    }

    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String lastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addresses) {
        this.addressList = addresses;
    }

    public List<Phone> phones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}


package ru.laker.SpringSecurityApp.models.whore_models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salon")
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salon_name")
    private String salonName;

    @ManyToMany
    @JoinTable(name = "salon_address", joinColumns = @JoinColumn(name = "salon_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addressList;

    @ManyToMany
    @JoinTable(name = "phones_list", joinColumns = @JoinColumn(name = "salon_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id"))
    private List<Phone> phonesList;

    public Salon() {
    }

    public Salon(String salonName, List<Address> addressList, List<Phone> phonesList) {
        this.salonName = salonName;
        this.addressList = addressList;
        this.phonesList = phonesList;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Phone> getPhonesList() {
        return phonesList;
    }

    public void setPhonesList(List<Phone> phonesList) {
        this.phonesList = phonesList;
    }
}

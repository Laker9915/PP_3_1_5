package ru.laker.SpringSecurityApp.models.whore_models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_street")
    private String addressStreet;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @ManyToMany(mappedBy = "addressList")
    private List<Salon> salonList;

    @ManyToMany(mappedBy = "addressList")
    private List<Whore> whoreList;

    // Конструкторы, геттеры и сеттеры

    public Address() {
    }

    public Address(String addressStreet, String city, String region, String postalCode, List<Salon> salonList, List<Whore> whoreList) {
        this.addressStreet = addressStreet;
        this.city = city;
        this.region = region;
        this.salonList = salonList;
        this.whoreList = whoreList;
    }

    public String addressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String city() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String region() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Salon> salonList() {
        return salonList;
    }

    public void setSalonList(List<Salon> salonList) {
        this.salonList = salonList;
    }

    public List<Whore> whoreList() {
        return whoreList;
    }

    public void setWhoreList(List<Whore> whoreList) {
        this.whoreList = whoreList;
    }
}

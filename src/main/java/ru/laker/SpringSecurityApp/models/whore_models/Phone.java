package ru.laker.SpringSecurityApp.models.whore_models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(mappedBy = "phones")
    private List<Salon> salonList;

    @ManyToMany(mappedBy = "phones")
    private List<Whore> whoreList;

    public Phone() {
    }

    public Phone(String phoneNumber, List<Salon> salonList, List<Whore> whoreList) {
        this.phoneNumber = phoneNumber;
        this.salonList = salonList;
        this.whoreList = whoreList;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    // Конструкторы, геттеры и сеттеры
}

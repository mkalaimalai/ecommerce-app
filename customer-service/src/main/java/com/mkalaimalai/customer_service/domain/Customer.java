package com.mkalaimalai.customer_service.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "Customer")
public class Customer {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID customerId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Address> addresses = new ArrayList<Address>();

    public void addAddress(Address address){
        address.setCustomer(this);
    }


    public void addAddresses(List<Address> addresses) {
        addresses.forEach(address -> address.setCustomer(this));
        this.setAddresses(addresses);
    }

    @Override
    public String toString() {
        return "Customer {" +
                "customerId=" + customerId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }



}

package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firtsName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private LocalDate registrationDate;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String firtsName, String lastName, String email, LocalDate dateOfBirth, String phoneNumber, LocalDate registrationDate) {
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    
    public String getFirstName() {
        return this.firtsName;
    }

    public void setFirstName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLasttName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean equals(Object obj) {
        Customer customer = (Customer)obj;
        return (this.getFirstName().equals(customer.getFirstName()) &&
                this.getLasttName().equals(customer.getLasttName()) && 
                this.getEmail().equals(customer.getEmail()) &&
                this.getPhoneNumber().equals(customer.getPhoneNumber()));
   }

    public int hashCode() {
        return this.getEmail().hashCode() + this.getPhoneNumber().hashCode()
                + this.getFirstName().hashCode() + this.getLasttName().hashCode();
     }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Customer");
        sb.append("{id=").append(id);
        sb.append(", first name='").append(firtsName);
        sb.append(", last name='").append(lastName);
        sb.append(", email='").append(email);
        sb.append(", phone number='").append(phoneNumber);
        sb.append("}\n");
        return sb.toString();
    }
}